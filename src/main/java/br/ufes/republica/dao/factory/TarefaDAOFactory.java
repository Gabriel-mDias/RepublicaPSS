package br.ufes.republica.dao.factory;

import br.ufes.republica.dao.interfaces.ITarefaDAO;

public abstract class TarefaDAOFactory {
    
    protected String bancoFabricado;
    
    public abstract ITarefaDAO cria();
    
    public final boolean aceita(String banco) {
        return banco.equalsIgnoreCase(bancoFabricado);
    }
    
}
