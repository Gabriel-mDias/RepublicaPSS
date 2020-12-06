package br.ufes.republica.pessoa.state;

import br.ufes.republica.models.HistoricoRepublica;
import br.ufes.republica.models.Pessoa;
import br.ufes.republica.models.Republica;

public class EstadoSemTeto implements IEstadoPessoa {

    @Override
    public void entrarRepublica(Pessoa pessoa, Republica republica) {
        pessoa.setRepublicaAtual(republica);
        pessoa.getHistoricoRepublicas().add(new HistoricoRepublica(0, pessoa, republica)); //TODO: Media de Reputação
    }

    @Override
    public void sairRepublica(Pessoa pessoa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "EstadoSemTeto";
    }
    
}
