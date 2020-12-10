package br.ufes.republica.dao.interfaces;

import br.ufes.republica.models.Rateio;
import java.util.List;

public interface IRateioDAO {
    
    public void insert(Rateio rateio) throws Exception;
    public void update(Rateio rateio) throws Exception;
    public void getById(Long id) throws Exception;
    public List<Rateio> getByLancamento(Long idLancamento) throws Exception;
    public List<Rateio> getByModador(Long idMorador) throws Exception;
    
}
