package br.ufes.republica.dao.sqlite.impl;

import br.ufes.republica.dao.interfaces.IFeedbackDAO;
import br.ufes.republica.dao.manager.SqliteManager;
import br.ufes.republica.enums.TipoFeedback;
import br.ufes.republica.models.Feedback;
import br.ufes.republica.models.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAOSQLite implements IFeedbackDAO {

    private SqliteManager manager;

    public FeedbackDAOSQLite(SqliteManager manager) {
        if (manager == null) {
            throw new RuntimeException("Manager fornecido é inválido");
        }

        this.manager = manager;
    }

    @Override
    public void insert(Feedback feedback, Pessoa pessoa) throws Exception {
        try {
            String SQL = "INSERT INTO Feedback(tipo, dataRealizado, dataSolucionado, descricao,"
                    + "excluido, id_autor, id_republica) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();

            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, feedback.getTipo().name());
            ps.setObject(2, LocalDate.now());
            ps.setObject(3, null);
            ps.setString(4, feedback.getDescricao());
            ps.setBoolean(5, false);
            ps.setLong(6, pessoa.getId());
            ps.setLong(7, pessoa.getRepublicaAtual().getId());
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
    public void update(Feedback feedback) throws Exception {
        try {
            String SQL = "UPDATE Feedback SET tipo = ?, descricao = ? WHERE id = ?";

            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();

            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, feedback.getTipo().getTipo());
            ps.setString(2, feedback.getDescricao());
            ps.setLong(3, feedback.getId());
            ps.executeUpdate();

            this.manager.fechaTransacao();
            this.manager.close();
        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao atualizar");
        }
    }

    @Override
    public Feedback getById(Long id) throws Exception {
        try {
            String SQL = "SELECT f.id, f.tipo, f.dataRealizado, f.dataSolucionado,"
                    + "f.descricao, f.excluido, f.id_autor FROM Feedback f WHERE id = ?";

            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();

            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            Feedback feedback = new Feedback();

            while (rs.next()) {
                feedback.setId(rs.getLong(1));
                feedback.setTipo(TipoFeedback.valueOf(rs.getString(2)));
                feedback.setDataRealizado(rs.getObject(3, LocalDate.class));
                feedback.setDataSolucionado(rs.getObject(4, LocalDate.class));
                feedback.setDescricao(rs.getString(5));
                feedback.setExcluido(rs.getBoolean(6));
                // TODO: preencher pessoa;
            }

            this.manager.fechaTransacao();
            this.manager.close();

            return feedback;
        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao buscar");
        }
    }

    @Override
    public List<Feedback> getByRepublica(Long idRepublica) throws Exception {
        try {
            String SQL = "SELECT f.id, f.tipo, f.dataRealizado, f.dataSolucionado,"
                    + "f.descricao, f.excluido, f.id_autor FROM Feedback f WHERE idRepublica = ?";

            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();

            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setLong(1, idRepublica);
            ResultSet rs = ps.executeQuery();

            List<Feedback> feedbacks = new ArrayList<>();

            while (rs.next()) {
                Feedback feedback = new Feedback();
                feedback.setId(rs.getLong(1));
                feedback.setTipo(TipoFeedback.valueOf(rs.getString(2)));
                feedback.setDataRealizado(rs.getObject(3, LocalDate.class));
                feedback.setDataSolucionado(rs.getObject(4, LocalDate.class));
                feedback.setDescricao(rs.getString(5));
                feedback.setExcluido(rs.getBoolean(6));
                // TODO: preencher pessoa;
                feedbacks.add(feedback);
            }

            this.manager.fechaTransacao();
            this.manager.close();

            return feedbacks;
        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao inserir");
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        try {
            String SQL = "UPDATE Feedback SET excluido = ? WHERE id = ?";

            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();

            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setBoolean(1, true);
            ps.setLong(2, id);
            ps.executeUpdate();

            this.manager.fechaTransacao();
            this.manager.close();
        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao excluir");
        }
    }

}
