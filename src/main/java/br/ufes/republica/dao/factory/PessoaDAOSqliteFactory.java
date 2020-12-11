package br.ufes.republica.dao.factory;

import br.ufes.republica.dao.interfaces.IPessoaDAO;
import br.ufes.republica.dao.manager.SqliteManager;
import br.ufes.republica.dao.sqlite.impl.PessoaDAOSQLite;

public class PessoaDAOSqliteFactory extends PessoaDAOFactory {
    
    public PessoaDAOSqliteFactory() {
        this.bancoFabricado = "SQLITE";
    }

    @Override
    public IPessoaDAO cria() {
        return new PessoaDAOSQLite(new SqliteManager());
    }   
    
}