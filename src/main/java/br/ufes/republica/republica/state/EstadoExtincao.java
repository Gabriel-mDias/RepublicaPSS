
package br.ufes.republica.republica.state;

import br.ufes.republica.models.Pessoa;
import br.ufes.republica.models.Republica;
import java.util.List;

public class EstadoExtincao implements IEstadoRepublica{

    @Override
    public void adicionarMorador(Pessoa pessoa, List<Pessoa> moradores) {
        throw new RuntimeException("ERRO: República já extinta");
    }

    @Override
    public void removerMorador(Pessoa pessoa, List<Pessoa> moradores) {
        throw new RuntimeException("ERRO: República já extinta");
    }

    @Override
    public void extinguirRepublica(Republica republica) {
        throw new RuntimeException("ERRO: República já extinta");
    }
    
}
