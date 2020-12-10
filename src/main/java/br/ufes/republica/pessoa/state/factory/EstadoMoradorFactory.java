package br.ufes.republica.pessoa.state.factory;

import br.ufes.republica.pessoa.state.EstadoMorador;
import br.ufes.republica.pessoa.state.IEstadoPessoa;

public class EstadoMoradorFactory extends EstadoPessoaFactory {

    public EstadoMoradorFactory() {
        this.estadoFabricado = "EstadoMorador";
    }
    
    @Override
    public IEstadoPessoa cria() {
        return new EstadoMorador();
    }
    
}
