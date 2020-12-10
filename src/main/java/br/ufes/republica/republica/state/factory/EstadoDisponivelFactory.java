package br.ufes.republica.republica.state.factory;

import br.ufes.republica.republica.state.EstadoDisponivel;
import br.ufes.republica.republica.state.IEstadoRepublica;

public class EstadoDisponivelFactory extends EstadoRepublicaFactory {
    
    public EstadoDisponivelFactory() {
        this.estadoFabricado = "EstadoDisponivel";
    }

    @Override
    public IEstadoRepublica cria() {
        return new EstadoDisponivel();
    }
    
}