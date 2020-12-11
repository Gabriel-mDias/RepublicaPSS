package br.ufes.republica.view.feedback;

import br.ufes.republica.models.Feedback;
import br.ufes.republica.service.FeedbackService;
import br.ufes.republica.view.feedback.state.FeedbackPresenterInclusao;
import br.ufes.republica.view.feedback.state.FeedbackPresenterState;
import br.ufes.republica.view.feedback.state.FeedbackPresenterVisualizacao;
import br.ufes.republica.view.presenter.BaseInternalFramePresenter;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

public final class FeedbackPresenter extends BaseInternalFramePresenter<FeedbackView> {

    private FeedbackPresenterState estado;
    private FeedbackService feedbackService;
    private Feedback feedback;

    public FeedbackPresenter(JDesktopPane container, Feedback feedback) throws Exception {
        super(container, new FeedbackView());
        feedbackService = new FeedbackService();

        if (feedback == null) {
            //this.setEstado(new FeedbackPresenterInclusao(this, DAO, morador));
        }

        try {
            this.setEstado(new FeedbackPresenterVisualizacao(this, feedback));
            getView().setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }

    public FeedbackPresenterState getEstado() {
        return estado;
    }

    public void setEstado(FeedbackPresenterState estado) {
        this.estado = estado;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

}
