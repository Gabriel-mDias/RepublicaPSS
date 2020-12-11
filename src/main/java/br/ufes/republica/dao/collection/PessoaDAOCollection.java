package br.ufes.republica.dao.collection;

import br.ufes.republica.dao.factory.PessoaDAOFactory;
import br.ufes.republica.dao.factory.PessoaDAOSqliteFactory;
import br.ufes.republica.dao.interfaces.IPessoaDAO;
import java.util.ArrayList;
import java.util.List;

public final class PessoaDAOCollection {
    
    private List<PessoaDAOFactory> factories = new ArrayList<>();
    private static PessoaDAOCollection instancia;
    
    private PessoaDAOCollection() {
        addFactory(new PessoaDAOSqliteFactory());
    }
    
    public static PessoaDAOCollection getInstancia() {
        if (instancia == null) {
            instancia = new PessoaDAOCollection();
        }
        
        return instancia;
    }
    
    public void addFactory(PessoaDAOFactory factory) {
        if (factory == null) {
            throw new RuntimeException("Factory fornecida é inválida");
        }
        
        if(factories.stream().filter(f -> f.getClass().equals(factory.getClass())).findAny().isPresent()) {
            throw new RuntimeException("Esta factory já foi adicionada");
        }
        
        this.factories.add(factory);
    }
    
    public IPessoaDAO cria(String banco) {
        if (banco == null || banco.isBlank()) {
            throw new RuntimeException("Banco fornecido é inválido");
        }
        
        for(PessoaDAOFactory factory : factories) {
            if (factory.aceita(banco)) {
                return factory.cria();
            }
        }
        
        return null;
    }
    
}
