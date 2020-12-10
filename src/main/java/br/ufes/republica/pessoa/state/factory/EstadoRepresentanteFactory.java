package br.ufes.republica.pessoa.state.factory;

import br.ufes.republica.pessoa.state.EstadoRepresentante;
import br.ufes.republica.pessoa.state.IEstadoPessoa;

public class EstadoRepresentanteFactory extends EstadoPessoaFactory {

    public EstadoRepresentanteFactory() {
        this.estadoFabricado = "EstadoRepresentante";
    }

    @Override
    public IEstadoPessoa cria() {
        return new EstadoRepresentante();
    }
    
}
