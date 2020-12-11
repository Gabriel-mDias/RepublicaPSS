package br.ufes.republica.view.feedback.state;

import br.ufes.republica.enums.TipoFeedback;
import br.ufes.republica.models.Feedback;
import br.ufes.republica.view.feedback.FeedbackPresenter;
import javax.swing.JButton;

public abstract class FeedbackPresenterState {

    protected FeedbackPresenter presenter;

    public FeedbackPresenterState(FeedbackPresenter presenter) {
        if (presenter == null) {
            throw new RuntimeException("Presenter nao informada");
        }
        this.presenter = presenter;
        var view = this.presenter.getView();
        removerActionListeners(view.getBtnFechar());
        removerActionListeners(view.getBtnRegistrar());
        removerActionListeners(view.getBtnVerTodas());
    }

    public void salvar() {
    }

    public void editar() {
    }

    public void excluir() {
    }

    public void cancelar() {
        this.presenter.getView().setVisible(false);
        this.presenter.getView().dispose();
    }

    protected Feedback getDados() {
        var view = presenter.getView();
        Feedback feedback = new Feedback();
        feedback.setTipo(TipoFeedback.valueOf(view.getCmbFeedback().getSelectedItem().toString()));
        feedback.setDescricao(view.getTxtDescricao().getText());
        return feedback;
    }

    protected void setDados(Feedback feedback) {
        var view = presenter.getView();
        view.getCmbFeedback().setSelectedItem(feedback.getTipo().getTipo());
        view.getTxtDescricao().setText(feedback.getDescricao());
    }

    protected void disableCampos() {
        var view = presenter.getView();
        view.getCmbFeedback().setEditable(false);
        view.getTxtDescricao().setEditable(false);
    }

    protected void enableCampos() {
        var view = presenter.getView();
        view.getCmbFeedback().setEditable(true);
        view.getTxtDescricao().setEditable(true);
    }

    private void removerActionListeners(JButton btn) {
        for (var action : btn.getActionListeners()) {
            btn.removeActionListener(action);
        }
    }

}
