package br.ufes.republica.republica.state.factory;

import br.ufes.republica.republica.state.EstadoExtincao;
import br.ufes.republica.republica.state.IEstadoRepublica;

public class EstadoExtincaoFactory extends EstadoRepublicaFactory {
    
    public EstadoExtincaoFactory() {
        this.estadoFabricado = "EstadoExtincao";
    }

    @Override
    public IEstadoRepublica cria() {
        return new EstadoExtincao();
    }
    
}