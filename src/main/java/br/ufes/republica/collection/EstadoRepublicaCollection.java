package br.ufes.republica.collection;

import br.ufes.republica.republica.state.IEstadoRepublica;
import br.ufes.republica.republica.state.factory.EstadoCheiaFactory;
import br.ufes.republica.republica.state.factory.EstadoDisponivelFactory;
import br.ufes.republica.republica.state.factory.EstadoExtincaoFactory;
import br.ufes.republica.republica.state.factory.EstadoRepublicaFactory;
import java.util.ArrayList;
import java.util.List;

public class EstadoRepublicaCollection {
    
    private List<EstadoRepublicaFactory> factories = new ArrayList<>(); 
    private static EstadoRepublicaCollection instancia;
    
    private EstadoRepublicaCollection() {
        addFactory(new EstadoCheiaFactory());
        addFactory(new EstadoDisponivelFactory());
        addFactory(new EstadoExtincaoFactory());
    }
    
    public static EstadoRepublicaCollection getInstancia() {
        if (instancia == null) {
            instancia = new EstadoRepublicaCollection();
        }
        
        return instancia;
    }
    
    public void addFactory(EstadoRepublicaFactory factory) {
        if (factory == null) {
            throw new RuntimeException("Factory fornecida é inválida");
        }
        
        if(factories.stream().filter(f -> f.getClass().equals(factory.getClass())).findAny().isPresent()) {
            throw new RuntimeException("Esta factory já foi adicionada");
        }
        
        this.factories.add(factory);
    }
    
    public IEstadoRepublica cria(String estado) {
        if (estado == null || estado.isBlank()) {
            throw new RuntimeException("Estado fornecido é inválido");
        }
        
        for(EstadoRepublicaFactory factory : factories) {
            if (factory.aceita(estado)) {
                return factory.cria();
            }
        }
        
        return null;
    }
    
}
