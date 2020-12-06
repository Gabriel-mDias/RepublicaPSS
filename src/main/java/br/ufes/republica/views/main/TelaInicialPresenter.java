/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.republica.views.main;

import br.ufes.republica.view.moradores.ListaMoradoresPresenter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;

/**
 *
 * @author gabriel
 */
public class TelaInicialPresenter {
    
    private TelaInicialView view;

    public TelaInicialPresenter() {
        this.view = new TelaInicialView();
        
        this.view.getItemManterMorador().addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListaMoradoresPresenter listM = new ListaMoradoresPresenter();
                addContainer(listM.getView());
            }
        });
        
        
        
        this.view.setVisible(true);
    }
    
    
    public void addContainer(JInternalFrame janela){
        view.add(janela);
    }
    
    
}
