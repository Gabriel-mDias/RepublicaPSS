/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.republica.view.perfil;

import br.ufes.republica.models.Pessoa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author gabriel
 */
public class EditarPerfilPresenter {
    
    private EditarPerfilView view;
    private Pessoa pessoa;

    public EditarPerfilPresenter(Pessoa pessoa) {
        this.pessoa = pessoa;
        this.view = new EditarPerfilView();
        
        this.view.getBtnConfirmar().addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Edição de um usuário
            }
        });
        
        this.view.setVisible(true);
    }
    
    
}
