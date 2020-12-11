package br.ufes.republica.business;

import br.ufes.republica.dao.collection.TarefaDAOCollection;
import br.ufes.republica.dao.interfaces.ITarefaDAO;
import br.ufes.republica.models.Tarefa;
import java.util.List;

public class TarefaBusiness {
    
    private ITarefaDAO tarefaDAO;

    public TarefaBusiness() {
        this.tarefaDAO = TarefaDAOCollection.getInstancia().cria(System.getProperty("db.name"));
    }
    
    public void insert(Tarefa tarefa) throws Exception {
        tarefaDAO.insert(tarefa);
    }
    
    public void update(Tarefa tarefa) throws Exception {
        tarefaDAO.update(tarefa);
    }
    
    public Tarefa getById(Long id) throws Exception {
        return tarefaDAO.getById(id);
    }
    
    public List<Tarefa> filter(Long idRepublica, String pessoa, String descricao) throws Exception {
        return tarefaDAO.filter(idRepublica, pessoa, descricao);
    }
    
    public void delete(Long id) throws Exception {
        tarefaDAO.delete(id);
    }
    
}
