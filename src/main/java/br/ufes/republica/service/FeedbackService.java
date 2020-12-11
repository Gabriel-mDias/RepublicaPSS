package br.ufes.republica.service;

import br.ufes.republica.business.FeedbackBusiness;
import br.ufes.republica.dao.manager.SqliteManager;
import br.ufes.republica.dao.sqlite.impl.FeedbackDAOSQLite;

public class FeedbackService {

    private FeedbackBusiness feedbackBusiness;

    public FeedbackService() {
        this.feedbackBusiness = new FeedbackBusiness(new FeedbackDAOSQLite(new SqliteManager()));
    }

}
