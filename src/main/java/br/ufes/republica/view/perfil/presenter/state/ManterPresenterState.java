package br.ufes.republica.view.perfil.presenter.state;

import br.ufes.republica.models.Pessoa;
import br.ufes.republica.models.Usuario;
import br.ufes.republica.service.PessoaService;
import br.ufes.republica.service.UsuarioService;
import br.ufes.republica.view.perfil.presenter.ManterPerfilPresenter;
import java.util.Arrays;
import javax.swing.JButton;

public abstract class ManterPresenterState {

    protected ManterPerfilPresenter presenter;
    protected UsuarioService usuarioService;
    protected PessoaService pessoaService;

    public ManterPresenterState(ManterPerfilPresenter presenter) {
        if (presenter == null) {
            throw new RuntimeException("Presenter nao informada");
        }
        this.presenter = presenter;
        var view = this.presenter.getView();
        removerActionListeners(view.getBtnExcluir());
        removerActionListeners(view.getBtnHistorico());
        removerActionListeners(view.getBtnSalvar());
        this.usuarioService = new UsuarioService();
        this.pessoaService = new PessoaService();
    }

    public void fechar() {
        presenter.getView().setVisible(false);
        presenter.getView().dispose();
    }

    public void salvar() {

    }

    public void editar() {

    }

    public void excluir() {

    }

    public void cancelar() {
        presenter.getView().setVisible(false);
        presenter.getView().dispose();
    }

    protected Usuario getDados() {
        var view = presenter.getView();
        var usuario = presenter.getUsuario();
        var pessoa = usuario.getPessoa() != null ? usuario.getPessoa() : new Pessoa();
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

    protected void setDados(Usuario usuario) {
        var view = presenter.getView();
        var pessoa = usuario.getPessoa() != null ? usuario.getPessoa() : new Pessoa();
        view.getTxtNome().setText(pessoa.getNome());
        view.getTxtApelido().setText(pessoa.getApelido());
        view.getTxtCpf().setText(pessoa.getCPF());
        view.getTxtRedeSocial().setText(pessoa.getLinkRedeSocial());
        view.getTxtTelefone().setText(pessoa.getTelefone());
        view.getTxtTelefoneResponsavel1().setText(pessoa.getTelefoneResponsavel1());
        view.getTxtTelefoneResponsavel2().setText(pessoa.getTelefoneResponsavel2());
        view.getTxtLogin().setText(usuario.getLogin());
    }

    protected void setDados(Pessoa pessoa) {
        var view = presenter.getView();
        view.getTxtNome().setText(pessoa.getNome());
        view.getTxtApelido().setText(pessoa.getApelido());
        view.getTxtCpf().setText(pessoa.getCPF());
        view.getTxtRedeSocial().setText(pessoa.getLinkRedeSocial());
        view.getTxtTelefone().setText(pessoa.getTelefone());
        view.getTxtTelefoneResponsavel1().setText(pessoa.getTelefoneResponsavel1());
        view.getTxtTelefoneResponsavel2().setText(pessoa.getTelefoneResponsavel2());
    }

    protected void disableCampos() {
        var view = presenter.getView();
        view.getTxtNome().setEditable(false);
        view.getTxtApelido().setEditable(false);
        view.getTxtCpf().setEditable(false);
        view.getTxtRedeSocial().setEditable(false);
        view.getTxtTelefone().setEditable(false);
        view.getTxtTelefoneResponsavel1().setEditable(false);
        view.getTxtTelefoneResponsavel2().setEditable(false);
        view.getTxtLogin().setEditable(false);
        view.getTxtSenha().setEditable(false);
        view.getTxtSenhaNovamente().setEditable(false);
    }

    protected void enableCampos() {
        var view = presenter.getView();
        view.getTxtNome().setEditable(true);
        view.getTxtApelido().setEditable(true);
        view.getTxtCpf().setEditable(true);
        view.getTxtRedeSocial().setEditable(true);
        view.getTxtTelefone().setEditable(true);
        view.getTxtTelefoneResponsavel1().setEditable(true);
        view.getTxtTelefoneResponsavel2().setEditable(true);
        view.getTxtLogin().setEditable(true);
        view.getTxtSenha().setEditable(true);
        view.getTxtSenhaNovamente().setEditable(true);
    }

    protected boolean senhasConferem() {
        var senha = Arrays.toString(presenter.getView().getTxtSenha().getPassword());
        var senhaNovamente = Arrays.toString(presenter.getView().getTxtSenhaNovamente().getPassword());
        return senha != null && senhaNovamente != null ? senha.equals(senhaNovamente) : false;
    }

    private void removerActionListeners(JButton btn) {
        for (var action : btn.getActionListeners()) {
            btn.removeActionListener(action);
        }
    }
}
