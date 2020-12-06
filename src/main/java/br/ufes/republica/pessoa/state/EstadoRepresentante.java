package br.ufes.republica.pessoa.state;

import br.ufes.republica.models.Pessoa;
import br.ufes.republica.models.Republica;

public class EstadoRepresentante implements IEstadoPessoa {

    @Override
    public void entrarRepublica(Pessoa pessoa, Republica republica) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sairRepublica(Pessoa pessoa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "EstadoRepresentante";
    }
    
}
