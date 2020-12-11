package br.ufes.republica.dao.sqlite.impl;

import br.ufes.republica.collection.EstadoPessoaCollection;
import br.ufes.republica.dao.interfaces.IUsuarioDAO;
import br.ufes.republica.dao.manager.SqliteManager;
import br.ufes.republica.models.Pessoa;
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
            String SQL = "INSERT INTO Usuario(login, senha, id_pessoa, excluido) VALUES(?, ?, ?, 0);";

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
            System.out.println(ex.getMessage());
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
            String SQL = "SELECT u.id, u.login, u.excluido, "
                    + "p.id, p.nome, p.apelido, p.telefone, p.cpf, p.linkRedeSocial, p.telefoneResponsavel1, p.telefoneResponsavel2, p.estado "
                    + "FROM Usuario u INNER JOIN Pessoa p ON p.id = u.id_pessoa WHERE u.id = ?;";

            Connection conn = this.manager.conectar();
            this.manager.abreTransacao();

            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            Usuario usuario = new Usuario();
            Pessoa pessoa = new Pessoa();

            while (rs.next()) {
                usuario.setId(rs.getLong(1));
                usuario.setLogin(rs.getString(2));
                usuario.setExcluido(rs.getLong(3) == 1L);
                pessoa.setId(rs.getLong(4));
                pessoa.setNome(rs.getString(5));
                pessoa.setApelido(rs.getString(6));
                pessoa.setTelefone(rs.getString(7));
                pessoa.setCPF(rs.getString(8));
                pessoa.setLinkRedeSocial(rs.getString(9));
                pessoa.setTelefoneResponsavel1(rs.getString(10));
                pessoa.setTelefoneResponsavel2(rs.getString(11));
                pessoa.setEstado(EstadoPessoaCollection.getInstancia().cria(rs.getString(12)));
                usuario.setPessoa(pessoa);
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
    public Usuario getByLogin(String login, String senha) throws Exception {
        try {
            String SQL = "SELECT id, login, senha FROM Usuario WHERE login = ? AND senha = ? AND excluido = 0;";

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
                usuario.setSenha(rs.getString(3));
            }

            this.manager.fechaTransacao();
            this.manager.close();

            return usuario;
        } catch (Exception ex) {
            this.manager.desfazTransacao();
            this.manager.close();
            System.out.println(ex.getMessage());
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
            ps.setLong(1, 1);
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

    @Override
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

}
