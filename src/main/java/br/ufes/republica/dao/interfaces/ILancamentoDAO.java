package br.ufes.republica.dao.interfaces;

import br.ufes.republica.models.Lancamento;
import java.util.List;

public interface ILancamentoDAO {
    
    public void insert(Lancamento lancamento, Long idRepublica) throws Exception;
    public void update(Lancamento lancamento) throws Exception;
    public List<Lancamento> getByIdRepublica(Long idRepublica) throws Exception;
    public Lancamento getById(Long id) throws Exception;
}