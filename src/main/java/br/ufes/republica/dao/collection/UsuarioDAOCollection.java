package br.ufes.republica.dao.collection;

import br.ufes.republica.dao.factory.UsuarioDAOFactory;
import br.ufes.republica.dao.factory.UsuarioDAOSqliteFactory;
import br.ufes.republica.dao.interfaces.IUsuarioDAO;
import java.util.ArrayList;
import java.util.List;

public final class UsuarioDAOCollection {
    
    private List<UsuarioDAOFactory> factories = new ArrayList<>();
    private static UsuarioDAOCollection instancia;
    
    private UsuarioDAOCollection() {
        addFactory(new UsuarioDAOSqliteFactory());
    }
    
    public static UsuarioDAOCollection getInstancia() {
        if (instancia == null) {
            instancia = new UsuarioDAOCollection();
        }
        
        return instancia;
    }
    
    public void addFactory(UsuarioDAOFactory factory) {
        if (factory == null) {
            throw new RuntimeException("Factory fornecida é inválida");
        }
        
        if(factories.stream().filter(f -> f.getClass().equals(factory.getClass())).findAny().isPresent()) {
            throw new RuntimeException("Esta factory já foi adicionada");
        }
        
        this.factories.add(factory);
    }
    
    public IUsuarioDAO cria(String banco) {
        if (banco == null || banco.isBlank()) {
            throw new RuntimeException("Banco fornecido é inválido");
        }
        
        for(UsuarioDAOFactory factory : factories) {
            if (factory.aceita(banco)) {
                return factory.cria();
            }
        }
        
        return null;
    }
    
}
