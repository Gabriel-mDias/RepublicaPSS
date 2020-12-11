/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.republica.view.login;

import br.ufes.republica.view.tela_inicial.TelaInicialPresenter;
import br.ufes.republica.view.perfil.presenter.CadastroPerfilPresenter;

/**
 *
 * @author bruno
 */
public class LoginPresenter {

    private LoginView view;
    private CadastroPerfilPresenter cadastro;

    public LoginPresenter() {
        this.view = new LoginView();
        
        this.view.getBtnLogin().addActionListener((e) -> {
            new TelaInicialPresenter();
            view.setVisible(false);
            view.dispose();
        });

        this.view.getBtnCadastrar().addActionListener((e) -> {
            if(cadastro != null) {
                cadastro.getView().dispose();
                cadastro = null;
            }
            cadastro = new CadastroPerfilPresenter();
        });

        this.view.setVisible(true);
    }

}
