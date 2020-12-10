package br.ufes.republica.dao.interfaces;

import br.ufes.republica.models.Tarefa;
import java.util.List;

public interface ITarefaDAO {
    
    public void insert(Tarefa tarefa) throws Exception;
    public void update(Tarefa tarefa) throws Exception;
    public Tarefa getById(Long id) throws Exception;
    public List<Tarefa> getByRepublica(Long idRepublica) throws Exception;
    public void delete(Long id) throws Exception;
    
}
