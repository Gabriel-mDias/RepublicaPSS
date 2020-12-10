package br.ufes.republica.republica.state.factory;

import br.ufes.republica.republica.state.EstadoCheia;
import br.ufes.republica.republica.state.IEstadoRepublica;

public class EstadoCheiaFactory extends EstadoRepublicaFactory {
    
    public EstadoCheiaFactory() {
        this.estadoFabricado = "EstadoCheia";
    }

    @Override
    public IEstadoRepublica cria() {
        return new EstadoCheia();
    }
    
}
