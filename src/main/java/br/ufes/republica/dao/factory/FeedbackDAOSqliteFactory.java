package br.ufes.republica.dao.factory;

import br.ufes.republica.dao.interfaces.IFeedbackDAO;
import br.ufes.republica.dao.manager.SqliteManager;
import br.ufes.republica.dao.sqlite.impl.FeedbackDAOSQLite;

public class FeedbackDAOSqliteFactory extends FeedbackDAOFactory {
    
    public FeedbackDAOSqliteFactory() {
        this.bancoFabricado = "SQLITE";
    }

    @Override
    public IFeedbackDAO cria() {
        return new FeedbackDAOSQLite(new SqliteManager());
    }
    
}
