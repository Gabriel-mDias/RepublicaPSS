/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enumeracoes;

/**
 *
 * @author gabriel
 */
public enum TipoFeedback {
    
    RECLAMACAO("reclamação"), SUGESTAO("sugestão");
    
    private final String tipo;
    
    private TipoFeedback(String tipo){
        this.tipo = tipo;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
}
