package br.ufes.republica.pessoa.state;

import br.ufes.republica.models.Pessoa;
import br.ufes.republica.models.Republica;

public interface IEstadoPessoa {
    
    public void entrarRepublica(Pessoa pessoa, Republica republica);
    public void sairRepublica(Pessoa pessoa);

}
