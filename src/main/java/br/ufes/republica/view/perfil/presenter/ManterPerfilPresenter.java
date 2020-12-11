/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.republica.view.perfil.presenter;

import br.ufes.republica.models.Pessoa;
import br.ufes.republica.models.Usuario;
import br.ufes.republica.view.perfil.ManterPerfilView;
import br.ufes.republica.view.perfil.presenter.state.ManterPresenterState;
import br.ufes.republica.view.perfil.presenter.state.VisualizacaoManterPresenter;
import br.ufes.republica.view.presenter.BaseInternalFramePresenter;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author gabriel
 */
public class ManterPerfilPresenter extends BaseInternalFramePresenter<ManterPerfilView>{

    private ManterPresenterState state;
    // private PessoaService pessoaService;
    private Usuario usuario;
    private Pessoa pessoa;

    public ManterPerfilPresenter(JDesktopPane container, Usuario usuario) {
        super(container, new ManterPerfilView());
        if (usuario == null || usuario.getId() == null) {
            throw new RuntimeException("Usuário não informada");
        }
        this.usuario = usuario;
        // this.usuarioService = new UsuarioService();

        try {
            // this.usuario = usuarioService.get(usuario);
            this.setState(new VisualizacaoManterPresenter(this, this.usuario));
            getView().setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ManterPerfilPresenter(JDesktopPane container, Pessoa pessoa) {
        super(container, new ManterPerfilView());
        if (pessoa == null || pessoa.getId() == null) {
            throw new RuntimeException("Usuário não informada");
        }
        this.pessoa = pessoa;
        // this.usuarioService = new UsuarioService();

        try {
            // this.pessoa = pessoaService.get(pessoa.getId));
            this.setState(new VisualizacaoManterPresenter(this, this.pessoa));
            getView().setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

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
