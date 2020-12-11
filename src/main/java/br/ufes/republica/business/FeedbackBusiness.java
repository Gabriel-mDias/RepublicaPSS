package br.ufes.republica.business;

import br.ufes.republica.dao.interfaces.IFeedbackDAO;
import br.ufes.republica.models.Feedback;
import br.ufes.republica.models.Pessoa;
import java.util.List;

public class FeedbackBusiness {

    private IFeedbackDAO feedbackDAO;

    public FeedbackBusiness(IFeedbackDAO feedbackDAO) {
        if (feedbackDAO == null) {
            throw new RuntimeException("DAO fornecida é inválida");
        }
        this.feedbackDAO = feedbackDAO;
    }

    public void insert(Feedback feedback, Pessoa pessoa) throws Exception {
        if (feedback == null) {
            throw new RuntimeException("Feedback fornecido é invalido!");
        } else if (pessoa == null) {
            throw new RuntimeException("Pessoa fornecida é invalida!");
        }

        feedbackDAO.insert(feedback, pessoa);
    }

    public void update(Feedback feedback) throws Exception {
        if (feedback == null) {
            throw new RuntimeException("Feedback fornecido é invalido!");
        }

        feedbackDAO.update(feedback);
    }

    public Feedback getById(Long id) throws Exception {
        if (id == null) {
            throw new RuntimeException("Id fornecido é invalido!");
        }

        return feedbackDAO.getById(id);
    }

    public List<Feedback> getByRepublica(Long idRepublica) throws Exception {
        if (idRepublica == null) {
            throw new RuntimeException("Id fornecido é invalido!");
        }

        return feedbackDAO.getByRepublica(idRepublica);
    }

    public void delete(Long id) throws Exception {
        if (id == null) {
            throw new RuntimeException("Id fornecido é invalido!");
        }

        feedbackDAO.delete(id);
    }

}
