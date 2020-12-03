
package br.ufes.republica.models;


public class Rateio {
    
    private Pessoa pessoa;
    private Lancamento lancamento;
    private double Valor;

    public Rateio(Pessoa pessoa, Lancamento lancamento, double Valor) {
        this.pessoa = pessoa;
        this.lancamento = lancamento;
        this.Valor = Valor;
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
    
    
}
