package br.ufes.republica.models;

import br.ufes.republica.enums.Periodicidade;
import br.ufes.republica.enums.TipoLancamento;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Lancamento {

    private Long id;
    private String descricao;
    private TipoLancamento tipoLancamento;
    private LocalDate dataVencimento;
    private Periodicidade periodicidade;
    private double valor;
    private boolean aprovado;
    private List<Rateio> rateios;

    public Lancamento(Long id, String descricao, TipoLancamento tipoLancamento, LocalDate dataVencimento, Periodicidade periodicidade, double valor, boolean aprovado) {
        this.id = id;
        this.descricao = descricao;
        this.tipoLancamento = tipoLancamento;
        this.dataVencimento = dataVencimento;
        this.periodicidade = periodicidade;
        this.valor = valor;
        this.aprovado = aprovado;
        this.rateios = new ArrayList<>();
    }

    public Lancamento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoLancamento getTipoLancamento() {
        return tipoLancamento;
    }

    public void setTipoLancamento(TipoLancamento tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Periodicidade getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(Periodicidade periodicidade) {
        this.periodicidade = periodicidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    public List<Rateio> getRateios() {
        return rateios;
    }

    public void setRateios(List<Rateio> rateios) {
        this.rateios = rateios;
    }
    
    

}
