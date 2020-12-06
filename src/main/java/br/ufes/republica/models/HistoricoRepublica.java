package br.ufes.republica.models;

public class HistoricoRepublica {
    
    private Long id;
    private String nomeRepublica;
    private String nomeRepresentante;
    private double mediaReputacao;
    private Pessoa pessoa;
    private Republica republica;

    public HistoricoRepublica(double mediaReputacao, Pessoa pessoa, Republica republica) {
        this.mediaReputacao = mediaReputacao;
        this.pessoa = pessoa;
        this.republica = republica;
        this.nomeRepresentante = republica.obterNomeRepresentante();
        this.nomeRepublica = republica.getNome();
    }
    
}
