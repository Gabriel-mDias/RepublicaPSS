package br.ufes.republica.view.feedback.state;

import br.ufes.republica.models.Feedback;
import br.ufes.republica.view.feedback.FeedbackPresenter;

public class FeedbackPresenterVisualizacao extends FeedbackPresenterState {
    
    public FeedbackPresenterVisualizacao(FeedbackPresenter presenter, Feedback feedback) {
        super(presenter);
        init(feedback);
    }

    private void init(Feedback feedback) {
        setDados(feedback);
        disableCampos();
        var view = presenter.getView();
        view.getBtnFechar().setVisible(true);
        view.getBtnRegistrar().setVisible(true);
        view.getBtnVerTodas().setVisible(true);
    }
    
}
