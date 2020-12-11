package br.ufes.republica.collection;

import br.ufes.republica.pessoa.state.factory.EstadoMoradorFactory;
import br.ufes.republica.pessoa.state.factory.EstadoPessoaFactory;
import br.ufes.republica.pessoa.state.factory.EstadoRepresentanteFactory;
import br.ufes.republica.pessoa.state.factory.EstadoSemTetoFactory;
import br.ufes.republica.pessoa.state.IEstadoPessoa;
import java.util.ArrayList;
import java.util.List;

public final class EstadoPessoaCollection {
    
    private List<EstadoPessoaFactory> factories = new ArrayList<>();
    private static EstadoPessoaCollection instancia;
    
    private EstadoPessoaCollection() {
        addFactory(new EstadoSemTetoFactory());
        addFactory(new EstadoMoradorFactory());
        addFactory(new EstadoRepresentanteFactory());
    }
    
    public static EstadoPessoaCollection getInstancia() {
        if (instancia == null) {
            instancia = new EstadoPessoaCollection();
        }
        
        return instancia;
    }
    
    public void addFactory(EstadoPessoaFactory factory) {
        if (factory == null) {
            throw new RuntimeException("Factory fornecida é inválida");
        }
        
        if(factories.stream().filter(f -> f.getClass().equals(factory.getClass())).findAny().isPresent()) {
            throw new RuntimeException("Esta factory já foi adicionada");
        }
        
        this.factories.add(factory);
    }
    
    public IEstadoPessoa cria(String estado) {
        if (estado == null || estado.isBlank()) {
            throw new RuntimeException("Estado fornecido é inválido");
        }
        
        for( EstadoPessoaFactory factory : factories ) {
            if (factory.aceita(estado)) {
                return factory.cria();
            }
        }
        
        return null;
    }
    
}
