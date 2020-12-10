/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.republica.view;

/**
 *
 * @author bruno
 */
public class LoginPresenter {

    private LoginView view;

    public LoginPresenter() {
        this.view = new LoginView();
        
        this.view.getBtnLogin().addActionListener((e) -> {
            new TelaInicialPresenter();
            view.setVisible(false);
            view.dispose();
        });

        this.view.getBtnCadastrar().addActionListener((e) -> {
        });

        this.view.setVisible(true);
    }

}
