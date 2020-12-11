/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.republica.view.republica.state;

import br.ufes.republica.models.Pessoa;
import br.ufes.republica.models.Republica;
import br.ufes.republica.view.republica.ManterRepublicaPresenter;

/**
 *
 * @author gabriel
 */
public class NovaRepublicaPresenter extends ManterRepublicaState{
    
    
    
    public NovaRepublicaPresenter(ManterRepublicaPresenter controler) {
        super(controler);
    }

    @Override
    public void confirmarAction(Republica republica) throws Exception {
        this.service.insert(republica);
    }
    
}
