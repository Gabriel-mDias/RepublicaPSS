/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.republica.view.moradores;

import br.ufes.republica.models.Pessoa;
import br.ufes.republica.services.MoradorService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author gabriel
 */
public class EditarMoradoresPresenter {
    
    private Pessoa morador;
    private MoradorService moradorService;
    private EditarMoradoresView view;

    public EditarMoradoresPresenter(Pessoa morador) {
        this.morador = morador;
        this.view = new EditarMoradoresView();
        this.view.setVisible(true);
        
        this.view.getBtnSalvar().addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Service para dar um update, recebendo os valores do campo
            }
        });
    }

    public EditarMoradoresView getView() {
        return view;
    }
    
    
}
