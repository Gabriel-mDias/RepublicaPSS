
package br.ufes.republica.republica.state;

import br.ufes.republica.models.Pessoa;
import br.ufes.republica.models.Republica;
import java.util.List;


public class EstadoDisponivel implements IEstadoRepublica{

    @Override
    public void adicionarMorador(Pessoa pessoa, List<Pessoa> moradores) {
        moradores.add(pessoa);
    }

    @Override
    public void removerMorador(Pessoa pessoa, List<Pessoa> moradores) {
        if(!moradores.remove(pessoa)){
            throw new RuntimeException("ERRO: Morador não encontrado para remoção!");
        }
    }

    @Override
    public void extinguirRepublica(Republica republica) {
        republica.setEstado(new EstadoExtincao()); //TODO: Limpar a lista de moradores
    }
    
}
