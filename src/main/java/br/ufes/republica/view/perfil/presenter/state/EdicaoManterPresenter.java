package br.ufes.republica.view.perfil.presenter.state;

import br.ufes.republica.models.Usuario;
import br.ufes.republica.view.perfil.presenter.ManterPerfilPresenter;

public class EdicaoManterPresenter extends ManterPresenterState {

    public EdicaoManterPresenter(ManterPerfilPresenter presenter) {
        super(presenter);
        init();
    }

    private void init() {
        var view = presenter.getView();
        view.getBtnExcluir().setVisible(false);
        view.getBtnHistorico().setVisible(false);
        view.getBtnSalvar().setVisible(true);
        view.getBtnSalvar().setText("Salvar");

        view.getBtnSalvar().addActionListener((ae) -> {
            salvar();
        });
    }

    @Override
    public void salvar() {
        Usuario usuario = getDados();
        /*presenter.setCommand(new EditarContatoCommand(contato, new ContatoService()));
        if (presenter.getCommand().executar()) {
            presenter.notifyObservers();
            presenter.setState(new VisualizacaoManterPresenter(presenter, contato));
        }*/
    }

}
