package br.ufes.republica.dao.sqlite.impl;

import br.ufes.republica.dao.interfaces.ITarefaDAO;
import br.ufes.republica.dao.manager.SqliteManager;
import br.ufes.republica.models.Tarefa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
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
    public List<Tarefa> getByRepublica(Long idRepublica) throws Exception {
        try {
            String SQL = "SELECTE t.id, t.dataAgendamento, t.descricao, t.dataTermino, t.finalizada FROM Tarefa t WHERE idRepublica = ?";

            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();

            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setLong(1, idRepublica);
            ResultSet rs = ps.executeQuery();

            List<Tarefa> tarefas = new ArrayList<>();

            while (rs.next()) {
                Tarefa tarefa = new Tarefa();
                tarefa.setId(rs.getLong(1));
                tarefa.setDataAgendamento(rs.getObject(2, LocalDate.class));
                tarefa.setDescricao(rs.getString(3));
                tarefa.setDataTermino(rs.getObject(4, LocalDate.class));
                tarefa.setFinalizada(rs.getBoolean(5));
                tarefas.add(tarefa);
            }

            this.manager.fechaTransacao();
            this.manager.close();

            return tarefas;
        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao inserir");
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        try {
            String SQL = "DELETE Tarefa WHERE id = ?";

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
