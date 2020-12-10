/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.republica.view.perfil.presenter;

import br.ufes.republica.models.Pessoa;
import br.ufes.republica.models.Usuario;
import br.ufes.republica.services.PessoaService;
import br.ufes.republica.view.perfil.ManterPerfilView;
import br.ufes.republica.view.perfil.presenter.state.ManterPresenterState;
import br.ufes.republica.view.perfil.presenter.state.VisualizacaoManterPresenter;
import javax.swing.JOptionPane;

/**
 *
 * @author gabriel
 */
public class ManterPerfilPresenter {

    private ManterPresenterState state;
    private ManterPerfilView view;
    private PessoaService pessoaService;
    private Usuario usuario;

    public ManterPerfilPresenter() {
        this.view = new ManterPerfilView();
        this.usuario = new Usuario();

        this.view.setVisible(true);
    }

    public ManterPerfilPresenter(Usuario usuario) {
        if (usuario == null || usuario.getId() == null) {
            throw new RuntimeException("Usuário não informada");
        }
        this.usuario = usuario;
        this.view = new ManterPerfilView();
        // this.usuarioService = new UsuarioService();

        try {
            // this.usuario = usuarioService.getByIdPessoa(idUsuario);
            this.setState(new VisualizacaoManterPresenter(this, this.usuario));
            this.view.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ManterPerfilPresenter(Pessoa pessoa) {
        if (pessoa == null || pessoa.getId() == null) {
            throw new RuntimeException("Usuário não informada");
        }
        this.usuario = usuario;
        this.view = new ManterPerfilView();
        // this.usuarioService = new UsuarioService();

        try {
            // this.usuario = usuarioService.getByIdPessoa(idUsuario);
            this.setState(new VisualizacaoManterPresenter(this, this.usuario));
            this.view.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }

    public ManterPerfilView getView() {
        return view;
    }
    
    public void setState(ManterPresenterState state) {
        this.state = state;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public Pessoa getPessoa() {
        return usuario.getPessoa();
    }

}
