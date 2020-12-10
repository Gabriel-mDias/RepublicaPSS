package br.ufes.republica.pessoa.state.factory;

import br.ufes.republica.pessoa.state.EstadoSemTeto;
import br.ufes.republica.pessoa.state.IEstadoPessoa;

public class EstadoMoradorFactory extends EstadoPessoaFactory {

    public EstadoMoradorFactory() {
        this.estadoFabricado = "EstadoMorador";
    }
    
    @Override
    public IEstadoPessoa cria() {
        return new EstadoSemTeto();
    }
    
}
