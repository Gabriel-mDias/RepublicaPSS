package br.ufes.republica.service;

import br.ufes.republica.business.PessoaBusiness;
import br.ufes.republica.business.UsuarioBusiness;
import br.ufes.republica.models.Pessoa;
import br.ufes.republica.models.Usuario;
import br.ufes.republica.pessoa.state.EstadoSemTeto;

public class UsuarioService {
    
    private UsuarioBusiness usuarioBusiness;
    private PessoaBusiness pessoaBusiness;
    
    public UsuarioService() {
        this.usuarioBusiness = new UsuarioBusiness();
        this.pessoaBusiness = new PessoaBusiness();
    }
    
    public Usuario getById(Long id) throws Exception {
        return usuarioBusiness.getById(id);
    }
    
    public void update(Usuario usuario) throws Exception {
        usuarioBusiness.update(usuario);
    }
    
    public Usuario getByLogin(String login, String senha) throws Exception {
        return usuarioBusiness.getByLogin(login, senha);
    }
    
    public void insertWithPessoa(Usuario usuario) throws Exception {
        usuario.getPessoa().setEstado(new EstadoSemTeto());
        Pessoa pessoa = pessoaBusiness.insert(usuario.getPessoa());
        usuarioBusiness.insert(usuario, pessoa.getId());
    }
    
    public void delete(Long id) throws Exception {
        usuarioBusiness.delete(id);
    }
    
}
