/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.republica.view.perfil;

import br.ufes.republica.models.Pessoa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author gabriel
 */
public class VisualizarPerfilPresenter {
    
    private VisualizarPerfilView view;
    private Pessoa pessoa;

    public VisualizarPerfilPresenter(Pessoa pessoa) {
        this.pessoa = pessoa;
        
        this.view.getBtnExcluir().addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Estado removido para um usuario
                JOptionPane.showMessageDialog(view, "Morador retirado da república!", "Excluir Morador", JOptionPane.OK_OPTION);
            }
        });
    }
    
    
}
