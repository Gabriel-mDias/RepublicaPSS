package br.ufes.republica.dao.interfaces;

import br.ufes.republica.models.Feedback;
import br.ufes.republica.models.Pessoa;
import java.util.List;

public interface IFeedbackDAO {

    public void insert(Feedback feedback, Pessoa pessoa) throws Exception;

    public void update(Feedback feedback) throws Exception;

    public Feedback getById(Long id) throws Exception;

    public List<Feedback> getByRepublica(Long idRepublica) throws Exception;

    public void delete(Long id) throws Exception;

}
