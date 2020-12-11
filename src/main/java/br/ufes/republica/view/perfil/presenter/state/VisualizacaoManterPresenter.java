package br.ufes.republica.view.perfil.presenter.state;

import br.ufes.republica.models.Pessoa;
import br.ufes.republica.models.Usuario;
import br.ufes.republica.view.perfil.presenter.ManterPerfilPresenter;

public class VisualizacaoManterPresenter extends ManterPresenterState {

    public VisualizacaoManterPresenter(ManterPerfilPresenter presenter, Usuario usuario) {
        super(presenter);
        init(usuario);
    }

    public VisualizacaoManterPresenter(ManterPerfilPresenter presenter, Pessoa pessoa) {
        super(presenter);
        init(pessoa);
    }

    private void init(Usuario usuario) {
        setDados(usuario);
        disableCampos();
        var view = presenter.getView();
        view.getBtnExcluir().setVisible(true);
        view.getBtnHistorico().setVisible(true);
        view.getBtnSalvar().setVisible(true);
        view.getBtnSalvar().setText("Habilitar Edição");

        view.getBtnSalvar().addActionListener((ae) -> {
            editar();
        });

        view.getBtnExcluir().addActionListener((ae) -> {
            excluir();
        });

        view.getBtnHistorico().addActionListener((ae) -> {
            historico();
        });
    }

    private void init(Pessoa pessoa) {
        setDados(pessoa);
        disableCampos();
        var view = presenter.getView();
        view.getBtnExcluir().setVisible(false);
        view.getBtnHistorico().setVisible(true);
        view.getBtnSalvar().setVisible(false);

        view.getBtnSalvar().addActionListener((ae) -> {
            editar();
        });

        view.getBtnExcluir().addActionListener((ae) -> {
            excluir();
        });

        view.getBtnHistorico().addActionListener((ae) -> {
            historico();
        });
    }

    @Override
    public void excluir() {
        // Excluir
    }

    @Override
    public void editar() {
        enableCampos();
        presenter.setState(new EdicaoManterPresenter(presenter));
    }

    public void historico() {
        // exibir tela de historico
    }

}
