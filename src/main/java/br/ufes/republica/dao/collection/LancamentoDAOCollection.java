package br.ufes.republica.dao.collection;

import br.ufes.republica.dao.factory.LancamentoDAOFactory;
import br.ufes.republica.dao.factory.LancamentoDAOSqliteFactory;
import br.ufes.republica.dao.interfaces.ILancamentoDAO;
import java.util.ArrayList;
import java.util.List;

public final class LancamentoDAOCollection {
    
    private List<LancamentoDAOFactory> factories = new ArrayList<>();
    private static LancamentoDAOCollection instancia;
    
    private LancamentoDAOCollection() {
        addFactory(new LancamentoDAOSqliteFactory());
    }
    
    public static LancamentoDAOCollection getInstancia() {
        if (instancia == null) {
            instancia = new LancamentoDAOCollection();
        }
        
        return instancia;
    }
    
    public void addFactory(LancamentoDAOFactory factory) {
        if (factory == null) {
            throw new RuntimeException("Factory fornecida é inválida");
        }
        
        if(factories.stream().filter(f -> f.getClass().equals(factory.getClass())).findAny().isPresent()) {
            throw new RuntimeException("Esta factory já foi adicionada");
        }
        
        this.factories.add(factory);
    }
    
    public ILancamentoDAO cria(String banco) {
        if (banco == null || banco.isBlank()) {
            throw new RuntimeException("Banco fornecido é inválido");
        }
        
        for(LancamentoDAOFactory factory : factories) {
            if (factory.aceita(banco)) {
                return factory.cria();
            }
        }
        
        return null;
    }
    
}
