package br.ufes.republica.models;

import java.time.LocalDate;

public class HistoricoRepresentante {

    private Long id;
    private String nomeRepresentante;
    private LocalDate dataInicioMandato;
    private LocalDate dataFimMandato;

    public HistoricoRepresentante(String nomeRepresentante) {
        this.nomeRepresentante = nomeRepresentante;
        this.dataInicioMandato = LocalDate.now();
    }

    public String getNomeRepresentante() {
        return nomeRepresentante;
    }

    public void setNomeRepresentante(String nomeRepresentante) {
        this.nomeRepresentante = nomeRepresentante;
    }

    public LocalDate getDataInicioMandato() {
        return dataInicioMandato;
    }

    public void setDataInicioMandato(LocalDate dataInicioMandato) {
        this.dataInicioMandato = dataInicioMandato;
    }

    public LocalDate getDataFimMandato() {
        return dataFimMandato;
    }

    public void setDataFimMandato(LocalDate dataFimMandato) {
        this.dataFimMandato = dataFimMandato;
    }

}
