/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.republica.view.republica.state;

import br.ufes.republica.models.Republica;
import br.ufes.republica.view.republica.ManterRepublicaPresenter;

/**
 *
 * @author gabriel
 */
public class EditarRepublicaPresenter extends ManterRepublicaState{
    
    public EditarRepublicaPresenter(Republica republica, ManterRepublicaPresenter controler){
        super(republica, controler);
        
    }

    @Override
    public void confirmarAction(Republica republica) throws Exception{
        this.service.update(republica);
    }
    
    
}
