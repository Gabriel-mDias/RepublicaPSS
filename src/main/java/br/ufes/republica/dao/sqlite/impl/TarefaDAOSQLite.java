package br.ufes.republica.dao.sqlite.impl;

import br.ufes.republica.dao.interfaces.ITarefaDAO;
import br.ufes.republica.dao.manager.SqliteManager;
import br.ufes.republica.models.Republica;
import br.ufes.republica.models.Tarefa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAOSQLite implements ITarefaDAO {

    private SqliteManager manager;

    public TarefaDAOSQLite(SqliteManager manager) {
        if (manager == null) {
            throw new RuntimeException("Manager fornecido é inválido");
        }

        this.manager = manager;
    }

    @Override
    public void insert(Tarefa tarefa) throws Exception {
        try {
            String SQL = "INSERT INTO Tarefa(dataAgendamento, descricao, dataTermino, finalizada)"
                    + "VALUES (?, ?, ?, ?)";

            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();

            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setObject(1, LocalDate.now());
            ps.setString(2, tarefa.getDescricao());
            ps.setObject(3, tarefa.getDataTermino());
            ps.setBoolean(4, false);
            ps.executeUpdate();

            this.manager.fechaTransacao();
            this.manager.close();
        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao inserir");
        }
    }

    @Override
    public void update(Tarefa tarefa) throws Exception {
        try {
            String SQL = "UPDATE Tarefa SET descricao = ?, SET dataTermino = ?) WHERE id = ?";

            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();

            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, tarefa.getDescricao());
            ps.setObject(2, tarefa.getDataTermino());
            ps.executeUpdate();

            this.manager.fechaTransacao();
            this.manager.close();
        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao inserir");
        }
    }

    @Override
    public Tarefa getById(Long id) throws Exception {
        try {
            String SQL = "SELECTE t.id, t.dataAgendamento, t.descricao, t.dataTermino, t.finalizada FROM Tarefa t WHERE id = ?";

            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();

            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            Tarefa tarefa = new Tarefa();

            while (rs.next()) {
                tarefa.setId(rs.getLong(1));
                tarefa.setDataAgendamento(rs.getObject(2, LocalDate.class));
                tarefa.setDescricao(rs.getString(3));
                tarefa.setDataTermino(rs.getObject(4, LocalDate.class));
                tarefa.setFinalizada(rs.getBoolean(5));
            }

            this.manager.fechaTransacao();
            this.manager.close();

            return tarefa;
        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao inserir");
        }
    }

    @Override
    public List<Tarefa> filter(Long idRepublica, String pessoa, String descricao) throws Exception {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append( " select " );
            sql.append( " 	t.id, " );
            sql.append( " 	t.dataAgendamento, " );
            sql.append( " 	t.descricao, " );
            sql.append( " 	t.dataTermino, " );
            sql.append( " 	t.finalizada, " );
            sql.append( " 	t.id_republica, " );
            sql.append( " 	( " );
            sql.append( " 	select " );
            sql.append( " 		GROUP_CONCAT(p.nome, ', ') " );
            sql.append( " 	from " );
            sql.append( " 		TarefaMorador tm " );
            sql.append( " 	inner join Pessoa p on " );
            sql.append( " 		p.id = tm.id_morador " );
            sql.append( " 	where " );
            sql.append( " 		tm.id_tarefa = t.id ) as moradores " );
            sql.append( " from " );
            sql.append( " 	Tarefa t " );
            sql.append( " where 1=1 " );
            if (idRepublica != null) {
                sql.append( " 	AND t.id_republica = ? " );
            }
            if (descricao != null && !descricao.isBlank()) {
                sql.append( " 	AND LOWER(t.descricao) like LOWER('%'||?||'%') " );
            }
            sql.append( " 	AND t.id in ( " );
            sql.append( " 		select " );
            sql.append( " 			distinct tm.id_tarefa " );
            sql.append( " 		from " );
            sql.append( " 			TarefaMorador tm " );
            sql.append( " 		inner join Pessoa p on " );
            sql.append( " 			tm.id_morador = p.id " );
            sql.append( " 		where 1=1 " );
            if (pessoa != null && !pessoa.isBlank()) {
                sql.append( " 			AND LOWER(p.nome) like LOWER('%'||?||'%') " );
            }
            sql.append( " ); " );

            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();

            PreparedStatement ps = conn.prepareStatement(sql.toString());
            
            int argAtual = 1;
            
            if (idRepublica != null) {
                ps.setLong(argAtual, idRepublica);
                ++argAtual;
            }
            
            if (descricao != null && !descricao.isBlank()) {
                ps.setString(argAtual, descricao);
                ++argAtual;
            }
            
            if (pessoa != null && !pessoa.isBlank()) {
                ps.setString(argAtual, pessoa);
                ++argAtual;
            }
            
            ResultSet rs = ps.executeQuery();

            List<Tarefa> tarefas = new ArrayList<>();

            while (rs.next()) {
                Tarefa tarefa = new Tarefa();
                Republica republica = new Republica();
                
                tarefa.setId(rs.getLong(1));
                if(rs.getString(2) != null && !rs.getString(2).isBlank()) {
                    tarefa.setDataAgendamento(LocalDate.parse(rs.getString(2)));
                }
                
                tarefa.setDescricao(rs.getString(3));
                
                if(rs.getString(4) != null && !rs.getString(4).isBlank()) {
                    tarefa.setDataTermino(LocalDate.parse(rs.getString(4)));
                }
                
                tarefa.setFinalizada(rs.getBoolean(5));
                republica.setId(rs.getLong(6));
                tarefa.setMoradores(rs.getString(7));
                tarefa.setRepublica(republica);
                
                tarefas.add(tarefa);
            }

            this.manager.fechaTransacao();
            this.manager.close();

            return tarefas;
        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao buscar");
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        try {
            String SQL = "DELETE FROM Tarefa WHERE id = ?";

            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();

            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setLong(1, id);
            ps.executeUpdate();

            this.manager.fechaTransacao();
            this.manager.close();
        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao inserir");
        }
    }

}
