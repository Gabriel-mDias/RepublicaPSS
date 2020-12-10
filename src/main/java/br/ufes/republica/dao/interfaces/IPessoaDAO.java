package br.ufes.republica.dao.interfaces;

import br.ufes.republica.models.Pessoa;
import java.util.List;

public interface IPessoaDAO {
    
    public void insert(Pessoa p) throws Exception;
    public void update(Pessoa p) throws Exception;
    public Pessoa getById(Long id) throws Exception;
    public List<Pessoa> getByIdRepublica(Long idRepublica) throws Exception;
}