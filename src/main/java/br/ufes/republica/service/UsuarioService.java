package br.ufes.republica.service;

import br.ufes.republica.business.UsuarioBusiness;
import br.ufes.republica.dao.manager.SqliteManager;
import br.ufes.republica.dao.sqlite.impl.UsuarioDAOSQLite;

public class UsuarioService {
    
    private UsuarioBusiness usuarioBusiness;
    
    public UsuarioService() {
        // TODO: Substituir por uma factory
        this.usuarioBusiness = new UsuarioBusiness(new UsuarioDAOSQLite(new SqliteManager()));
    }
    
}
