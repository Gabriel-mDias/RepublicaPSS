package br.ufes.republica.models;

public class HistoricoRepublica {
    
    private String nomeRepublica;
    private String nomeRepresentante;
    private double mediaReputacao;
    private Republica republica;

    public HistoricoRepublica(double mediaReputacao, Republica republica) {
        this.mediaReputacao = mediaReputacao;
        this.republica = republica;
        this.nomeRepresentante = republica.getRepresentante().getNome();
        this.nomeRepublica = republica.getNome();
    }
    
    
    
}
