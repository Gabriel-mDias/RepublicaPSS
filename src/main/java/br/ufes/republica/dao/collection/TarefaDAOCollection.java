package br.ufes.republica.dao.collection;

import br.ufes.republica.dao.factory.TarefaDAOFactory;
import br.ufes.republica.dao.factory.TarefaDAOSqliteFactory;
import br.ufes.republica.dao.interfaces.ITarefaDAO;
import java.util.ArrayList;
import java.util.List;

public final class TarefaDAOCollection {
    
    private List<TarefaDAOFactory> factories = new ArrayList<>();
    private static TarefaDAOCollection instancia;
    
    private TarefaDAOCollection() {
        addFactory(new TarefaDAOSqliteFactory());
    }
    
    public static TarefaDAOCollection getInstancia() {
        if (instancia == null) {
            instancia = new TarefaDAOCollection();
        }
        
        return instancia;
    }
    
    public void addFactory(TarefaDAOFactory factory) {
        if (factory == null) {
            throw new RuntimeException("Factory fornecida é inválida");
        }
        
        if(factories.stream().filter(f -> f.getClass().equals(factory.getClass())).findAny().isPresent()) {
            throw new RuntimeException("Esta factory já foi adicionada");
        }
        
        this.factories.add(factory);
    }
    
    public ITarefaDAO cria(String banco) {
        if (banco == null || banco.isBlank()) {
            throw new RuntimeException("Banco fornecido é inválido");
        }
        
        for(TarefaDAOFactory factory : factories) {
            if (factory.aceita(banco)) {
                return factory.cria();
            }
        }
        
        return null;
    }
    
}
