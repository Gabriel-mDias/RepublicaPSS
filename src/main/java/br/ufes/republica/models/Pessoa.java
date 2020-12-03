package br.ufes.republica.models;

import br.ufes.republica.pessoa.state.IEstadoPessoa;
import java.util.ArrayList;
import java.util.List;

public class Pessoa {

    private final Long id;
    private String nome;
    private String apelido;
    private String telefone;
    private String CPF;
    private String linkRedeSocial;
    private String telefoneResponsavel1;
    private String telefoneResponsavel2;
    private List<HistoricoRepublica> historicoRepublicas;
    private List<Rateio> rateios;
    private Republica republicaAtual;

    private IEstadoPessoa estado;

    public Pessoa(Long id, String nome, String apelido, String telefone, String CPF, String linkRedeSocial, String telefoneResponsavel1, String telefoneResponsavel2, List<HistoricoRepublica> historicoRepublicas, IEstadoPessoa estado) {
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
        this.telefone = telefone;
        this.CPF = CPF;
        this.linkRedeSocial = linkRedeSocial;
        this.telefoneResponsavel1 = telefoneResponsavel1;
        this.telefoneResponsavel2 = telefoneResponsavel2;
        this.historicoRepublicas = historicoRepublicas;
        this.estado = estado;
        this.rateios = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getLinkRedeSocial() {
        return linkRedeSocial;
    }

    public void setLinkRedeSocial(String linkRedeSocial) {
        this.linkRedeSocial = linkRedeSocial;
    }

    public String getTelefoneResponsavel1() {
        return telefoneResponsavel1;
    }

    public void setTelefoneResponsavel1(String telefoneResponsavel1) {
        this.telefoneResponsavel1 = telefoneResponsavel1;
    }

    public String getTelefoneResponsavel2() {
        return telefoneResponsavel2;
    }

    public void setTelefoneResponsavel2(String telefoneResponsavel2) {
        this.telefoneResponsavel2 = telefoneResponsavel2;
    }

    public List<HistoricoRepublica> getHistoricoRepublicas() {
        return historicoRepublicas;
    }

    public void setHistoricoRepublicas(List<HistoricoRepublica> historicoRepublicas) {
        this.historicoRepublicas = historicoRepublicas;
    }

    public IEstadoPessoa getEstado() {
        return estado;
    }

    public void setEstado(IEstadoPessoa estado) {
        this.estado = estado;
    }

    public List<Rateio> getRateios() {
        return rateios;
    }

    public void setRateios(List<Rateio> rateios) {
        this.rateios = rateios;
    }

    public Republica getRepublicaAtual() {
        return republicaAtual;
    }

    public void setRepublicaAtual(Republica republicaAtual) {
        this.republicaAtual = republicaAtual;
    }

    
}
