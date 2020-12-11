package br.ufes.republica.models;

import java.time.LocalDate;
import java.util.List;

public class Tarefa {

    private Long id;
    private LocalDate dataAgendamento;
    private String descricao;
    private LocalDate dataTermino;
    private boolean finalizada;
    private List<TarefaMorador> tarefasMoradores;
    private String moradores;
    private Republica republica;

    public Tarefa(Long id, LocalDate dataAgendamento, String descricao, LocalDate dataTermino, boolean finalizada, String moradores, Republica republica) {
        this.id = id;
        this.dataAgendamento = dataAgendamento;
        this.descricao = descricao;
        this.dataTermino = dataTermino;
        this.finalizada = finalizada;
        this.moradores = moradores;
        this.republica = republica;
    }

    public Tarefa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public String getMoradores() {
        return moradores;
    }

    public void setMoradores(String moradores) {
        this.moradores = moradores;
    }

    public Republica getRepublica() {
        return republica;
    }

    public void setRepublica(Republica republica) {
        this.republica = republica;
    }

    public List<TarefaMorador> getTarefasMoradores() {
        return tarefasMoradores;
    }

    public void setTarefasMoradores(List<TarefaMorador> tarefasMoradores) {
        this.tarefasMoradores = tarefasMoradores;
    }

}
