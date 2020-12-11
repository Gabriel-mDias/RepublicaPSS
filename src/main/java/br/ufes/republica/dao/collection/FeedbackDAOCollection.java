package br.ufes.republica.dao.collection;

import br.ufes.republica.dao.factory.FeedbackDAOFactory;
import br.ufes.republica.dao.factory.FeedbackDAOSqliteFactory;
import br.ufes.republica.dao.interfaces.IFeedbackDAO;
import java.util.ArrayList;
import java.util.List;

public final class FeedbackDAOCollection {
    
    private List<FeedbackDAOFactory> factories = new ArrayList<>();
    private static FeedbackDAOCollection instancia;
    
    private FeedbackDAOCollection() {
        addFactory(new FeedbackDAOSqliteFactory());
    }
    
    public static FeedbackDAOCollection getInstancia() {
        if (instancia == null) {
            instancia = new FeedbackDAOCollection();
        }
        
        return instancia;
    }
    
    public void addFactory(FeedbackDAOFactory factory) {
        if (factory == null) {
            throw new RuntimeException("Factory fornecida é inválida");
        }
        
        if(factories.stream().filter(f -> f.getClass().equals(factory.getClass())).findAny().isPresent()) {
            throw new RuntimeException("Esta factory já foi adicionada");
        }
        
        this.factories.add(factory);
    }
    
    public IFeedbackDAO cria(String banco) {
        if (banco == null || banco.isBlank()) {
            throw new RuntimeException("Banco fornecido é inválido");
        }
        
        for(FeedbackDAOFactory factory : factories) {
            if (factory.aceita(banco)) {
                return factory.cria();
            }
        }
        
        return null;
    }
    
}
