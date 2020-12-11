package br.ufes.republica.dao.factory;

import br.ufes.republica.dao.interfaces.ITarefaDAO;
import br.ufes.republica.dao.manager.SqliteManager;
import br.ufes.republica.dao.sqlite.impl.TarefaDAOSQLite;

public class TarefaDAOSqliteFactory extends TarefaDAOFactory {

    public TarefaDAOSqliteFactory() {
        this.bancoFabricado = "SQLITE";
    }
    
    @Override
    public ITarefaDAO cria() {
        return new TarefaDAOSQLite(new SqliteManager());
    }
    
}
