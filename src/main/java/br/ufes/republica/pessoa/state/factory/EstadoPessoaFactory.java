package br.ufes.republica.pessoa.state.factory;

import br.ufes.republica.pessoa.state.IEstadoPessoa;

public abstract class EstadoPessoaFactory {
    
    protected String estadoFabricado;
    
    public abstract IEstadoPessoa cria();
    
    public final boolean aceita(String estado) {
        return estado.equalsIgnoreCase(estadoFabricado);
    }
    
}
