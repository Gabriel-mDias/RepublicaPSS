package br.ufes.republica.factory;

import br.ufes.republica.pessoa.state.EstadoSemTeto;
import br.ufes.republica.pessoa.state.IEstadoPessoa;

public class EstadoSemTetoFactory extends EstadoPessoaFactory {
    
    public EstadoSemTetoFactory() {
        this.estadoFabricado = "EstadoRepresentante";
    }

    @Override
    public IEstadoPessoa cria(String estado) {
        if (aceita(estado)) {
            return new EstadoSemTeto();
        } else if (sucessor != null) {
            return sucessor.cria(estado);
        }
        
        return null;
    }
    
}
