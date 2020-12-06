/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.republica.view.republica;

import br.ufes.republica.models.Republica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author gabriel
 */
public class VisualizarRepublicaPresenter {
    
    private VisualizarRepublicaView view;
    private Republica republica;

    public VisualizarRepublicaPresenter(Republica republica) {
        this.republica = republica;
        this.view = new VisualizarRepublicaView();
        
        this.view.getBtnExcluir().addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(view, "República excluida!", "Excluir República", JOptionPane.OK_OPTION);
            }
        });
        
//        this.view.getBtnManterMoradores().
    }
    
    
    
}
