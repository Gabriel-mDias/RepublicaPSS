package br.ufes.republica.dao.sqlite.impl;

import br.ufes.republica.dao.interfaces.ITarefaMoradorDAO;
import br.ufes.republica.dao.manager.SqliteManager;
import br.ufes.republica.models.TarefaMorador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TarefaMoradorDAOSQLite implements ITarefaMoradorDAO {

    private SqliteManager manager;

    public TarefaMoradorDAOSQLite(SqliteManager manager) {
        if (manager == null) {
            throw new RuntimeException("Manager fornecido é inválido");
        }
        this.manager = manager;
    }

    @Override
    public void insert(TarefaMorador tarefaMorador) throws Exception {
        try {
            String SQL = "INSERT INTO TarefaMorador(id_tarefa, id_morador, realizada) VALUES(?, ?, ?);";

            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();

            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setLong(1, tarefaMorador.getTarefa().getId());
            ps.setLong(2, tarefaMorador.getMorador().getId());
            ps.setBoolean(3, false);
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
    public List<TarefaMorador> getByPessoa(Long idPessoa) throws Exception {
        try {
            String SQL = "SELECT tm.id_tarefa, tm.id_pessoa, tm.realizada FROM TarefaMorador tm WHERE id_pessoa = ?";

            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();

            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setLong(1, idPessoa);
            ResultSet rs = ps.executeQuery();

            List<TarefaMorador> tarefasMorador = new ArrayList<>();

            while (rs.next()) {
//                TarefaMorador tarefaMorador = new TarefaMorador();
//                tarefaMorador.setTarefa(rs.getLong(1));
//                tarefaMorador.setMorador(rs.getLong(2)));
//                tarefaMorador.setRealizada(rs.getBoolean(6));
//                tarefasMorador.add(tarefaMorador);
            }

            this.manager.fechaTransacao();
            this.manager.close();

            return tarefasMorador;
        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao inserir");
        }
    }

    @Override
    public List<TarefaMorador> getByTarefa(Long idTarefa) throws Exception {
        try {
            String SQL = "SELECT tm.id_tarefa, tm.id_pessoa, tm.realizada FROM TarefaMorador tm WHERE id_tarefa = ?";

            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();

            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setLong(1, idTarefa);
            ResultSet rs = ps.executeQuery();

            List<TarefaMorador> tarefasMorador = new ArrayList<>();

            while (rs.next()) {
//                TarefaMorador tarefaMorador = new TarefaMorador();
//                tarefaMorador.setTarefa(rs.getLong(1));
//                tarefaMorador.setMorador(rs.getLong(2)));
//                tarefaMorador.setRealizada(rs.getBoolean(6));
//                tarefasMorador.add(tarefaMorador);
            }

            this.manager.fechaTransacao();
            this.manager.close();

            return tarefasMorador;
        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao inserir");
        }
    }

    @Override
    public void deleteByTarefa(Long idTarefa) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void realizar(Long idTarefa, Long idPessoa) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
