package br.ufes.republica.factory;

import br.ufes.republica.pessoa.state.IEstadoPessoa;

public final class EstadoPessoaProcessor {
    
    private static EstadoPessoaProcessor instancia;
    private EstadoPessoaFactory primeiro;
    private EstadoPessoaFactory ultimo;
    
    private EstadoPessoaProcessor() {
        addFactory(new EstadoSemTetoFactory());
        addFactory(new EstadoMoradorFactory());
        addFactory(new EstadoRepresentanteFactory());
    }
    
    public static EstadoPessoaProcessor getInstancia() {
        if (instancia == null) {
            instancia = new EstadoPessoaProcessor();
        }
        
        return instancia;
    }
    
    public void addFactory(EstadoPessoaFactory factory) {
        if (factory == null) {
            throw new RuntimeException("Factory fornecida é inválida");
        }
        
        if (primeiro == null && ultimo == null) {
            primeiro = ultimo = factory;
        }
        
        ultimo.setSucessor(factory);
        ultimo = factory;
    }
    
    public IEstadoPessoa cria(String estado) {
        if (estado == null || estado.isBlank()) {
            throw new RuntimeException("Estado fornecido é inválido");
        }
        
        return primeiro.cria(estado);
    }
    
}
