package br.ufes.republica.service;

import br.ufes.republica.business.UsuarioBusiness;
import br.ufes.republica.models.Usuario;

public class UsuarioService {
    
    private UsuarioBusiness usuarioBusiness;
    
    public UsuarioService() {
        this.usuarioBusiness = new UsuarioBusiness();
    }
    
    public Usuario getByLogin(String login) throws Exception {
        return usuarioBusiness.getByLogin(login);
    }
    
}
