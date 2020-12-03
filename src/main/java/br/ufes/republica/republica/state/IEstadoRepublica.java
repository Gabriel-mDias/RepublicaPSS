/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.republica.republica.state;

import br.ufes.republica.models.Pessoa;
import br.ufes.republica.models.Republica;
import java.util.List;

/**
 *
 * @author gabriel
 */
public interface IEstadoRepublica {
    
    public void adicionarMorador(Pessoa pessoa, List<Pessoa> moradores);
    public void removerMorador(Pessoa pessoa, List<Pessoa> moradores);
    public void extinguirRepublica(Republica republica);
    
}
