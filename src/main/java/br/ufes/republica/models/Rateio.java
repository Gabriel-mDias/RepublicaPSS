
package br.ufes.republica.models;


public class Rateio {
    
    private Long id;
    private double Valor;
    private boolean pago;
    private Pessoa pessoa;
    private Lancamento lancamento;

    public Rateio(Pessoa pessoa, Lancamento lancamento, double Valor) {
        this.pessoa = pessoa;
        this.lancamento = lancamento;
        this.Valor = Valor;
    }

    public Rateio() {
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Lancamento getLancamento() {
        return lancamento;
    }

    public void setLancamento(Lancamento lancamento) {
        this.lancamento = lancamento;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
    
    
}
