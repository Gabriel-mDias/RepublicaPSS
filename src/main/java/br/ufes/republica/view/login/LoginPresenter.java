/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.republica.view.login;

import br.ufes.republica.service.UsuarioService;
import br.ufes.republica.view.tela_inicial.TelaInicialPresenter;
import br.ufes.republica.view.perfil.presenter.CadastroPerfilPresenter;
import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class LoginPresenter {

    private LoginView view;
    private CadastroPerfilPresenter cadastro;
    private UsuarioService usuarioService;

    public LoginPresenter() {
        this.view = new LoginView();
        this.usuarioService = new UsuarioService();
        this.view.getBtnLogin().addActionListener((e) -> {
            logar();
        });

        this.view.getBtnCadastrar().addActionListener((e) -> {
            if (cadastro != null) {
                cadastro.getView().dispose();
                cadastro = null;
            }
            cadastro = new CadastroPerfilPresenter();
        });

        this.view.setVisible(true);
    }

    private void logar() {
        var login = view.getTxtLogin().getText();
        var senha = new String(view.getTxtSenha().getPassword());

        try {
            var usuario = usuarioService.getByLogin(login, senha);
            if (usuario != null && usuario.getId() != null) {
                new TelaInicialPresenter(usuario);
                view.setVisible(false);
                view.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Login Inválido", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }

}
