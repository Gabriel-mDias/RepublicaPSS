package br.ufes.republica.factory;

import br.ufes.republica.pessoa.state.EstadoSemTeto;
import br.ufes.republica.pessoa.state.IEstadoPessoa;

public class EstadoMoradorFactory extends EstadoPessoaFactory {

    public EstadoMoradorFactory() {
        this.estadoFabricado = "EstadoMorador";
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
