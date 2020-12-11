package br.ufes.republica.dao.factory;

import br.ufes.republica.dao.interfaces.IPessoaDAO;

public abstract class PessoaDAOFactory {
    
    protected String bancoFabricado;
    
    public abstract IPessoaDAO cria();
    
    public final boolean aceita(String banco) {
        return banco.equalsIgnoreCase(bancoFabricado);
    }
    
}
