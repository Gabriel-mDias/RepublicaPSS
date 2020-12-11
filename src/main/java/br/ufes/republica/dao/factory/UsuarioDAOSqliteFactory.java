package br.ufes.republica.dao.factory;

import br.ufes.republica.dao.interfaces.IUsuarioDAO;
import br.ufes.republica.dao.manager.SqliteManager;
import br.ufes.republica.dao.sqlite.impl.UsuarioDAOSQLite;

public class UsuarioDAOSqliteFactory extends UsuarioDAOFactory {
    
    public UsuarioDAOSqliteFactory() {
        this.bancoFabricado = "SQLITE";
    }

    @Override
    public IUsuarioDAO cria() {
        return new UsuarioDAOSQLite(new SqliteManager());
    }   
    
}