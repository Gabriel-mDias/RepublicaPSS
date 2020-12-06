package br.ufes.republica.models;

import br.ufes.republica.enums.TipoFeedback;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Feedback {

    private TipoFeedback tipo;
    private LocalDate dataRealizado;
    private LocalDate dataSolucionado;
    private String descricao;
    private boolean excluido;
    private Pessoa autor;
    private List<Pessoa> moradores;

    public Feedback(Pessoa autor, TipoFeedback tipo, String descricao, List<Pessoa> moradoresEnvolvidos) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.excluido = false;
        this.dataRealizado = LocalDate.now();
        this.dataSolucionado = null;
        this.moradores = new ArrayList<>();
        this.moradores.addAll(moradoresEnvolvidos);
        this.autor = autor;
    }

    public Feedback(TipoFeedback tipo, String descricao, List<Pessoa> moradoresEnvolvidos) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.excluido = false;
        this.dataRealizado = LocalDate.now();
        this.dataSolucionado = null;
        this.moradores = new ArrayList<>();
        this.moradores.addAll(moradoresEnvolvidos);
        this.autor = null;  //Anônimo
    }

    public Feedback(Pessoa autor, TipoFeedback tipo, String descricao) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.excluido = false;
        this.dataRealizado = LocalDate.now();
        this.dataSolucionado = null;
        this.moradores = new ArrayList<>(); //Sem envolvimento de outros moradores
        this.autor = autor;
    }

    public Feedback(TipoFeedback tipo, String descricao) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.excluido = false;
        this.dataRealizado = LocalDate.now();
        this.dataSolucionado = null;
        this.moradores = new ArrayList<>(); //Sem envolvimento de outros moradores
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

    public List<Pessoa> getMoradores() {
        return moradores;
    }

    
}
