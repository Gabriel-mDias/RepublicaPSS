package br.ufes.republica.models;

import java.time.LocalDate;
import java.util.List;

public class Tarefa {

    private Long id;
    private LocalDate dataAgendamento;
    private String descricao;
    private LocalDate dataTermino;
    private boolean finalizada;
    private List<Pessoa> moradores;

    public Tarefa(Long id, LocalDate dataAgendamento, String descricao, LocalDate dataTermino, boolean finalizada, List<Pessoa> moradores) {
        this.id = id;
        this.dataAgendamento = dataAgendamento;
        this.descricao = descricao;
        this.dataTermino = dataTermino;
        this.finalizada = finalizada;
        this.moradores = moradores;
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

    public List<Pessoa> getMoradores() {
        return moradores;
    }

    public void setMoradores(List<Pessoa> moradores) {
        this.moradores = moradores;
    }

}
