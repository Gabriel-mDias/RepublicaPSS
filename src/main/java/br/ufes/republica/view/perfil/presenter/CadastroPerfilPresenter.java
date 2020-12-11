/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.republica.view.perfil.presenter;

import br.ufes.republica.models.Pessoa;
import br.ufes.republica.models.Usuario;
import br.ufes.republica.view.perfil.CadastroPerfilView;
import java.util.Arrays;

/**
 *
 * @author bruno
 */
public class CadastroPerfilPresenter {
    
    private CadastroPerfilView view;
    
    public CadastroPerfilPresenter() {
        this.view = new CadastroPerfilView();
        init();
        for(var action : view.getBtnSalvar().getActionListeners()) {
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
        /*presenter.setCommand(new IncluirContatoCommand(contato, new ContatoService()));
        if (presenter.getCommand().executar()) {
            presenter.notifyObservers();
            cancelar();
        }*/
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
        usuario.setSenha(Arrays.toString(view.getTxtSenha().getPassword()));
        usuario.setPessoa(pessoa);
        return usuario;
    }

    public CadastroPerfilView getView() {
        return view;
    }

}
