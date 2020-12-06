/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.republica.view.republica;

import br.ufes.republica.models.Republica;
import br.ufes.republica.view.moradores.ListaMoradoresPresenter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author gabriel
 */
public class VisualizarRepublicaPresenter {
    
    private VisualizarRepublicaView view;
    private Republica republica;

    public VisualizarRepublicaPresenter(Republica republica, JDesktopPane container) {
        this.republica = republica;
        this.view = new VisualizarRepublicaView();
        
        this.view.getBtnExcluir().addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(view, "República excluida!", "Excluir República", JOptionPane.OK_OPTION);
            }
        });
        
        this.view.getBtnManterMoradores().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                container.add(new ListaMoradoresPresenter(republica, container).getView());
            }
        });
        
        this.view.getBtnEditar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                container.add(new EditarRepublicaPresenter(republica).getView() );
                view.setVisible(false);
            }
        });
        
        
        this.view.setVisible(true);
    }

    public VisualizarRepublicaView getView() {
        return view;
    }
    
    
    
}
