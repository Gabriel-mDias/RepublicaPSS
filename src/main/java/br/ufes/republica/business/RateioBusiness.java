
package br.ufes.republica.business;

import br.ufes.republica.dao.interfaces.IRateioDAO;
import br.ufes.republica.models.Rateio;
import java.util.List;


public class RateioBusiness {
    
    private IRateioDAO rateioDAO;
    
    public void insert(Rateio rateio) throws Exception{
        if(rateio==null){
            throw new RuntimeException("Rateio fornecido é inválido!");
        }else if(rateio.getId() == null){
            throw new RuntimeException("ID de Rateio fornecido é inválido!");
        }
        
        rateioDAO.insert(rateio);
    }
    
    public void update(Rateio rateio) throws Exception{
        if(rateio==null){
            throw new RuntimeException("Rateio fornecido é inválido!");
        }else if(rateio.getId() == null){
            throw new RuntimeException("ID de Rateio fornecido é inválido!");
        }
        
        rateioDAO.update(rateio);
    }
    
    public Rateio getById(Long id) throws Exception{
        if(id == null){
            throw new RuntimeException("ID de Rateio fornecido é inválido!");
        }
        
        return rateioDAO.getById(id);
    }
    
    public List<Rateio> getByLancamento(Long idLancamento) throws Exception{
        if(idLancamento == null){
            throw new RuntimeException("ID de Lançamento fornecido é inválido!");
        }
        
        return rateioDAO.getByLancamento(idLancamento);
    }
    
    public List<Rateio> getByModador(Long idMorador) throws Exception{
        if(idMorador == null){
            throw new RuntimeException("ID de Rateio fornecido é inválido!");
        }
        
        return rateioDAO.getByModador(idMorador);
    }
}
