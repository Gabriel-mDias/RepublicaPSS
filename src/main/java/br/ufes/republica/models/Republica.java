package br.ufes.republica.models;

import br.ufes.republica.republica.state.EstadoDisponivel;
import br.ufes.republica.republica.state.IEstadoRepublica;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Republica {

    private Long id;
    private String nome;
    private String vantagens;
    private String estatuto;
    private LocalDate dataFundacao;
    private LocalDate dataExtincao;
    private Endereco endereco;
    private double despesaMediaMorador;
    private int numeroTotalVagas;
    private Pessoa representante;
    private List<Pessoa> moradores;
    private List<HistoricoRepresentante> historicoRepresentantes;
    private List<Feedback> feedbacks;
    private IEstadoRepublica estado;

    public Republica(Pessoa representante, String nome, String vantagens, String estatuto, Endereco endereco, double despesaMediaMorador, int numeroTotalVagas) {
        this.nome = nome;
        this.vantagens = vantagens;
        this.estatuto = estatuto;
        this.endereco = endereco;
        this.despesaMediaMorador = despesaMediaMorador;
        this.numeroTotalVagas = numeroTotalVagas;
        this.dataFundacao = LocalDate.now();
        this.dataExtincao = null;
        this.moradores = new ArrayList<>();
        this.historicoRepresentantes = new ArrayList<>();
        this.alterarRepresentante(representante);
        if(numeroTotalVagas > 0){
            this.estado = new EstadoDisponivel();
        }else{
            throw new RuntimeException("ERRO: Número de vagas inválido!");
        }
        
    }

    public Republica() {
    }
    
    
    public void alterarRepresentante(Pessoa representante){
        if(!this.historicoRepresentantes.isEmpty()){
            this.historicoRepresentantes.get(this.historicoRepresentantes.size()-1).setDataFimMandato(LocalDate.now());
        }
        
        this.historicoRepresentantes.add(new HistoricoRepresentante(representante.getNome(), this));
    }
    
    public String obterNomeRepresentante() {
        return representante.getNome();
    }

    public double getVagasOcupadas() {
        return this.moradores.size();
    }

    public double getVagasDisponiveis() {
        return this.numeroTotalVagas - this.moradores.size();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVantagens() {
        return vantagens;
    }

    public void setVantagens(String vantagens) {
        this.vantagens = vantagens;
    }

    public String getEstatuto() {
        return estatuto;
    }

    public void setEstatuto(String estatuto) {
        this.estatuto = estatuto;
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public LocalDate getDataExtincao() {
        return dataExtincao;
    }

    public void setDataExtincao(LocalDate dataExtincao) {
        this.dataExtincao = dataExtincao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public double getDespesaMediaMorador() {
        return despesaMediaMorador;
    }

    public void setDespesaMediaMorador(double despesaMediaMorador) {
        this.despesaMediaMorador = despesaMediaMorador;
    }

    public int getNumeroTotalVagas() {
        return numeroTotalVagas;
    }

    public void setNumeroTotalVagas(int numeroTotalVagas) {
        this.numeroTotalVagas = numeroTotalVagas;
    }

    public Pessoa getRepresentante() {
        return representante;
    }

    public void setRepresentante(Pessoa representante) {
        this.representante = representante;
    }

    public List<Pessoa> getMoradores() {
        return moradores;
    }

    public void setMoradores(List<Pessoa> moradores) {
        this.moradores = moradores;
    }

    public List<HistoricoRepresentante> getHistoricoRepresentantes() {
        return historicoRepresentantes;
    }

    public void setHistoricoRepresentantes(List<HistoricoRepresentante> historicoRepresentantes) {
        this.historicoRepresentantes = historicoRepresentantes;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public IEstadoRepublica getEstado() {
        return estado;
    }

    public void setEstado(IEstadoRepublica estado) {
        this.estado = estado;
    }
    
    

}
