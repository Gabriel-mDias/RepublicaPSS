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

    public Feedback() {
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoFeedback getTipo() {
        return tipo;
    }

    public void setTipo(TipoFeedback tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataRealizado() {
        return dataRealizado;
    }

    public void setDataRealizado(LocalDate dataRealizado) {
        this.dataRealizado = dataRealizado;
    }

    public LocalDate getDataSolucionado() {
        return dataSolucionado;
    }

    public void setDataSolucionado(LocalDate dataSolucionado) {
        this.dataSolucionado = dataSolucionado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isExcluido() {
        return excluido;
    }

    public void setExcluido(boolean excluido) {
        this.excluido = excluido;
    }

    public Pessoa getAutor() {
        return autor;
    }

    public void setAutor(Pessoa autor) {
        this.autor = autor;
    }

    public Republica getRepublica() {
        return republica;
    }

    public void setRepublica(Republica republica) {
        this.republica = republica;
    }

    public List<FeedbackMorador> getFeedbacksMoradores() {
        return feedbacksMoradores;
    }

    public void setFeedbacksMoradores(List<FeedbackMorador> feedbacksMoradores) {
        this.feedbacksMoradores = feedbacksMoradores;
    }

    

}
