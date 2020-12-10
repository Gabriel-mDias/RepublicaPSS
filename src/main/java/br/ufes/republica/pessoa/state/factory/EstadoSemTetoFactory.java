package br.ufes.republica.pessoa.state.factory;

import br.ufes.republica.pessoa.state.EstadoSemTeto;
import br.ufes.republica.pessoa.state.IEstadoPessoa;

public class EstadoSemTetoFactory extends EstadoPessoaFactory {
    
    public EstadoSemTetoFactory() {
        this.estadoFabricado = "EstadoRepresentante";
    }

    @Override
    public IEstadoPessoa cria() {
        return new EstadoSemTeto();
    }
    
}
