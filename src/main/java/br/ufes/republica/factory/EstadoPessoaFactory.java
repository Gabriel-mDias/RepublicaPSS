package br.ufes.republica.factory;

import br.ufes.republica.pessoa.state.IEstadoPessoa;

public abstract class EstadoPessoaFactory {
    
    protected String estadoFabricado;
    protected EstadoPessoaFactory sucessor;
    
    public abstract IEstadoPessoa cria(String estado);
    
    public final boolean aceita(String estado) {
        return estado.toLowerCase().equals(estadoFabricado.toLowerCase());
    }
    
    public final void setSucessor(EstadoPessoaFactory sucessor) {
        this.sucessor = sucessor;
    }
    
}
