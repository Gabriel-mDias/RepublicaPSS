package br.ufes.republica.dao.interfaces;

import br.ufes.republica.models.Usuario;

public interface IUsuarioDAO {
    
    public void insert(Usuario usuario, Long idPessoa) throws Exception;
    public void update(Usuario usuario) throws Exception;
    public Usuario getById(Long id) throws Exception;
    public Usuario getByLogin(String login) throws Exception;
    public Usuario getByIdPessoa(Long idPessoa) throws Exception;
    public void delete(Long id) throws Exception;
    public boolean loginExists(String login) throws Exception;
    
}
