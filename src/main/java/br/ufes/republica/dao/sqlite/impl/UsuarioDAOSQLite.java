package br.ufes.republica.dao.sqlite.impl;

import br.ufes.republica.dao.interfaces.IUsuarioDAO;
import br.ufes.republica.dao.manager.SqliteManager;
import br.ufes.republica.models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAOSQLite implements IUsuarioDAO {

    private SqliteManager manager;

    public UsuarioDAOSQLite(SqliteManager manager) {
        if (manager == null) {
            throw new RuntimeException("Manager fornecido é inválido");
        }

        this.manager = manager;
    }

    @Override
    public void insert(Usuario usuario, Long idPessoa) throws Exception {
        try {
            String SQL = "INSERT INTO Usuario(login, senha, id_pessoa) VALUES(?, ?, ?);";

            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();

            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());
            ps.setLong(3, idPessoa);
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
    public void update(Usuario usuario) throws Exception {
        try {
            String SQL = "UPDATE Usuario SET senha = ?;";

            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();

            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, usuario.getSenha());
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
    public Usuario getById(Long id) throws Exception {
        try {
            String SQL = "SELECT u.id, u.login, u.senha, u.excluido FROM Usuario u INNER JOIN Pessoa p ON p.id = u.id_pessoa WHERE login = ?;";

            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();

            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            Usuario usuario = new Usuario();

            while (rs.next()) {
                usuario.setId(rs.getLong(1));
                usuario.setLogin(rs.getString(2));
                usuario.setSenha(rs.getString(3));
            }

            this.manager.fechaTransacao();
            this.manager.close();

            return usuario;
        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao buscar");
        }
    }

    @Override
    public Usuario getByLogin(String login) throws Exception {
        try {
            String SQL = "SELECT id, login, senha FROM Usuario WHERE login = ?;";

            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();

            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();

            Usuario usuario = new Usuario();

            while (rs.next()) {
                usuario.setId(rs.getLong(1));
                usuario.setLogin(rs.getString(2));
                usuario.setSenha(rs.getString(3));
            }

            this.manager.fechaTransacao();
            this.manager.close();

            return usuario;
        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao buscar");
        }
    }

    @Override
    public Usuario getByIdPessoa(Long idPessoa) throws Exception {
        try {
            String SQL = "SELECT id, login, senha FROM Usuario WHERE id_pessoa = ? AND excluido = ?;";

            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();

            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setLong(1, idPessoa);
            ps.setBoolean(2, false);
            ResultSet rs = ps.executeQuery();

            Usuario usuario = new Usuario();

            while (rs.next()) {
                usuario.setId(rs.getLong(1));
                usuario.setLogin(rs.getString(2));
                usuario.setSenha(rs.getString(3));
            }

            this.manager.fechaTransacao();
            this.manager.close();

            return usuario;
        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao buscar");
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        try {
            String SQL = "UPDATE Usuario SET excluido = ? WHERE id = ?;";

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
            throw new Exception("Erro ao deletar");
        }
    }

    public boolean loginExists(String login) throws Exception {
        try {
            String SQL = "SELECT id FROM Usuario WHERE login = ?;";

            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();

            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();

            this.manager.fechaTransacao();
            this.manager.close();

            return rs.next();
        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao buscar");
        }
    }

    public Usuario login(String login, String senha) throws Exception {
        try {
            String SQL = "SELECT id, login FROM Usuario WHERE login = ?, senha = ?;";

            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();

            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, login);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();

            Usuario usuario = new Usuario();

            while (rs.next()) {
                usuario.setId(rs.getLong(1));
                usuario.setLogin(rs.getString(2));
            }

            this.manager.fechaTransacao();
            this.manager.close();

            return usuario;
        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            throw new Exception("Erro ao buscar");
        }
    }

}
