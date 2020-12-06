/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.republica.view.republica;

import br.ufes.republica.models.Republica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author gabriel
 */
public class EditarRepublicaPresenter {
    
    private EditarRepublicaView view;
    private Republica republica;
    
    public EditarRepublicaPresenter(Republica republica){
        this.republica = republica;
        this.view = new EditarRepublicaView();
        
        this.view.getBtnConfirmar().addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Alterar as informações da república
            }
        });
        
        this.view.setVisible(true);
    }

    public EditarRepublicaView getView() {
        return view;
    }
    
    
}
