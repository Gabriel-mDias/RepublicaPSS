package br.ufes.republica.models;

/**
 *
 * @author rborges
 */
public class TarefaMorador {
    
    private Tarefa tarefa;
    private Pessoa morador;

    public TarefaMorador(Tarefa tarefa, Pessoa morador) {
        this.tarefa = tarefa;
        this.morador = morador;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public Pessoa getMorador() {
        return morador;
    }
    
}
