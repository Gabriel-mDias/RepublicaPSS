package br.ufes.republica.service;

import br.ufes.republica.business.TarefaBusiness;
import br.ufes.republica.models.Tarefa;
import java.util.List;

public class TarefaService {
    
    private TarefaBusiness tarefaBusiness;
    
    public TarefaService() {
        this.tarefaBusiness = new TarefaBusiness();
    }
    
    public void insert(Tarefa tarefa) throws Exception {
        tarefaBusiness.insert(tarefa);
    }
    
    public void update(Tarefa tarefa) throws Exception {
        tarefaBusiness.update(tarefa);
    }
    
    public Tarefa getById(Long id) throws Exception {
        return tarefaBusiness.getById(id);
    }
    
    public List<Tarefa> filter(Long idRepublica, String pessoa, String descricao) throws Exception {
        return tarefaBusiness.filter(idRepublica, pessoa, descricao);
    }
    
    public void delete(Long id) throws Exception {
        tarefaBusiness.delete(id);
    }
    
}
