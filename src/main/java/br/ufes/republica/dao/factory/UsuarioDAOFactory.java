package br.ufes.republica.dao.factory;

import br.ufes.republica.dao.interfaces.IUsuarioDAO;

public abstract class UsuarioDAOFactory {
    
    protected String bancoFabricado;
    
    public abstract IUsuarioDAO cria();
    
    public final boolean aceita(String banco) {
        return banco.equalsIgnoreCase(bancoFabricado);
    }
    
}
