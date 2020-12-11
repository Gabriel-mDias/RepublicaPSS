package br.ufes.republica.dao.interfaces;

import br.ufes.republica.models.TarefaMorador;
import java.util.List;

public interface ITarefaMoradorDAO {

    public void insert(TarefaMorador tarefaMorador) throws Exception;

    public List<TarefaMorador> getByPessoa(Long idPessoa) throws Exception;

    public List<TarefaMorador> getByTarefa(Long idTarefa) throws Exception;

    public void deleteByTarefa(Long idTarefa) throws Exception;

    public void realizar(Long idTarefa, Long idPessoa) throws Exception;

}
