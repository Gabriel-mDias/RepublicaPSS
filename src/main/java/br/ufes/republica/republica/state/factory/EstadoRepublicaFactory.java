package br.ufes.republica.republica.state.factory;

import br.ufes.republica.republica.state.IEstadoRepublica;

public abstract class EstadoRepublicaFactory {
    
    protected String estadoFabricado;
    
    public abstract IEstadoRepublica cria();
    
    public final boolean aceita(String estado) {
        return estado.equalsIgnoreCase(estadoFabricado);
    }
    
}
