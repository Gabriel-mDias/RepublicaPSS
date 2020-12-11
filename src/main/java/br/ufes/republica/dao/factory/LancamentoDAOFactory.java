package br.ufes.republica.dao.factory;

import br.ufes.republica.dao.interfaces.ILancamentoDAO;

public abstract class LancamentoDAOFactory {
    
    protected String bancoFabricado;
    
    public abstract ILancamentoDAO cria();
    
    public final boolean aceita(String banco) {
        return banco.equalsIgnoreCase(bancoFabricado);
    }
    
}
