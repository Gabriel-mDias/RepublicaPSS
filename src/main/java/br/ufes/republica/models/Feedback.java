package br.ufes.republica.models;

import br.ufes.republica.enums.TipoFeedback;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Feedback {

    private Long id;
    private TipoFeedback tipo;
    private LocalDate dataRealizado;
    private LocalDate dataSolucionado;
    private String descricao;
    private boolean excluido;
    private Pessoa autor;
    private Republica republica;
    private List<FeedbackMorador> feedbacksMoradores;

    public Feedback(Pessoa autor, TipoFeedback tipo, String descricao, List<FeedbackMorador> feedbacksMoradores) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.excluido = false;
        this.dataRealizado = LocalDate.now();
        this.dataSolucionado = null;
        this.feedbacksMoradores = new ArrayList<>();
        this.feedbacksMoradores.addAll(feedbacksMoradores);
        this.autor = autor;
    }

    public Feedback(TipoFeedback tipo, String descricao, List<FeedbackMorador> feedbacksMoradores) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.excluido = false;
        this.dataRealizado = LocalDate.now();
        this.dataSolucionado = null;
        this.feedbacksMoradores = new ArrayList<>();
        this.feedbacksMoradores.addAll(feedbacksMoradores);
        this.autor = null;  //Anônimo
    }

    public Feedback(Pessoa autor, TipoFeedback tipo, String descricao) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.excluido = false;
        this.dataRealizado = LocalDate.now();
        this.dataSolucionado = null;
        this.feedbacksMoradores = new ArrayList<>(); //Sem envolvimento de outros moradores
        this.autor = autor;
    }

    public Feedback(TipoFeedback tipo, String descricao) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.excluido = false;
        this.dataRealizado = LocalDate.now();
        this.dataSolucionado = null;
        this.feedbacksMoradores = new ArrayList<>(); //Sem envolvimento de outros moradores
        this.autor = null;  //Anônimo
    }

    public TipoFeedback getTipo() {
        return tipo;
    }

    public LocalDate getDataRealizado() {
        return dataRealizado;
    }

    public LocalDate getDataSolucionado() {
        return dataSolucionado;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isExcluido() {
        return excluido;
    }

    public Pessoa getAutor() {
        return autor;
    }

}
