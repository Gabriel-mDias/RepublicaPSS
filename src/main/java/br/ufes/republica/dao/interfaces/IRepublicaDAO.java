package br.ufes.republica.dao.interfaces;

import br.ufes.republica.models.Republica;
import java.util.List;

public interface IRepublicaDAO {
    
    public void insert(Republica republica) throws Exception;
    public void update(Republica republica) throws Exception;
    public Republica getById(Long id) throws Exception;
    public Republica getByIdMorador(Long idPessoa) throws Exception;
    public List<Republica> getByVagasDisponiveis() throws Exception;
    public void delete(Long id) throws Exception; 
    
}
