package br.ufes.republica.dao.factory;

import br.ufes.republica.dao.interfaces.ILancamentoDAO;
import br.ufes.republica.dao.manager.SqliteManager;
import br.ufes.republica.dao.sqlite.impl.LancamentoDAOSQLite;

public class LancamentoDAOSqliteFactory extends LancamentoDAOFactory {

    public LancamentoDAOSqliteFactory() {
        this.bancoFabricado = "SQLITE";
    }
    
    @Override
    public ILancamentoDAO cria() {
        return new LancamentoDAOSQLite(new SqliteManager());
    }
    
}
