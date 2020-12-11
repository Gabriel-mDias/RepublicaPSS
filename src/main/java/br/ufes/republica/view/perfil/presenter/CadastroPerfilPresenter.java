/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.republica.view.perfil.presenter;

import br.ufes.republica.models.Pessoa;
import br.ufes.republica.models.Usuario;
import br.ufes.republica.service.UsuarioService;
import br.ufes.republica.view.perfil.CadastroPerfilView;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class CadastroPerfilPresenter {

    private CadastroPerfilView view;
    private UsuarioService usuarioService;

    public CadastroPerfilPresenter() {
        this.view = new CadastroPerfilView();
        this.usuarioService = new UsuarioService();
        init();
        for (var action : view.getBtnSalvar().getActionListeners()) {
            view.getBtnSalvar().removeActionListener(action);
        }
        view.getBtnSalvar().addActionListener((e) -> {
            salvar();
        });
        this.view.setVisible(true);
    }

    private void init() {
        view.getBtnSalvar().setVisible(true);
        view.getBtnSalvar().setText("Salvar");

        view.getBtnSalvar().addActionListener((ae) -> {
            salvar();
        });
    }

    public void salvar() {
        Usuario usuario = getDados();
        if (!senhasConferem()) {
            JOptionPane.showMessageDialog(view, "As senhas não conferem!", "Erro", JOptionPane.OK_OPTION);
        } else {
            try {
                usuarioService.insertWithPessoa(usuario);
                JOptionPane.showMessageDialog(view, "Pessoa cadastrada!", "Cadastro de Pessoa", JOptionPane.OK_OPTION);
                fechar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(view, e.getMessage(), "Erro", JOptionPane.OK_OPTION);
            }
        }
    }

    protected Usuario getDados() {
        var usuario = new Usuario();
        var pessoa = new Pessoa();
        pessoa.setNome(view.getTxtNome().getText());
        pessoa.setApelido(view.getTxtApelido().getText());
        pessoa.setCPF(view.getTxtCpf().getText());
        pessoa.setLinkRedeSocial(view.getTxtRedeSocial().getText());
        pessoa.setTelefone(view.getTxtTelefone().getText());
        pessoa.setTelefoneResponsavel1(view.getTxtTelefoneResponsavel1().getText());
        pessoa.setTelefoneResponsavel2(view.getTxtTelefoneResponsavel2().getText());
        usuario.setLogin(view.getTxtLogin().getText());
        usuario.setSenha(new String(view.getTxtSenha().getPassword()));
        usuario.setPessoa(pessoa);
        return usuario;
    }

    public CadastroPerfilView getView() {
        return view;
    }

    private boolean senhasConferem() {
        var senha = Arrays.toString(view.getTxtSenha().getPassword());
        var senhaNovamente = Arrays.toString(view.getTxtSenhaNovamente().getPassword());
        return senha != null && senhaNovamente != null ? senha.equals(senhaNovamente) : false;
    }
    
    private void fechar() {
        view.setVisible(false);
        view.dispose();
    }

}
