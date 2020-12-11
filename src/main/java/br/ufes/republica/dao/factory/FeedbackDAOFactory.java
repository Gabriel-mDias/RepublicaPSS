package br.ufes.republica.dao.factory;

import br.ufes.republica.dao.interfaces.IFeedbackDAO;

public abstract class FeedbackDAOFactory {
    
    protected String bancoFabricado;
    
    public abstract IFeedbackDAO cria();
    
    public final boolean aceita(String banco) {
        return banco.equalsIgnoreCase(bancoFabricado);
    }
    
}
