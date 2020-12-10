package br.ufes.republica.business;

import br.ufes.republica.dao.interfaces.IRepublicaDAO;
import br.ufes.republica.models.Republica;
import java.util.List;

public class RepublicaBusiness {
    
    private IRepublicaDAO republicaDAO;

    public RepublicaBusiness(IRepublicaDAO republicaDAO) {
        if(republicaDAO == null) {
            throw new RuntimeException("DAO fornecida é inválida");
        }
        this.republicaDAO = republicaDAO;
    }
    
    public void insert(Republica republica) throws Exception{
        if(republica == null){
            throw new RuntimeException("Republica fornecida é invalda!");
        }else if(republica.getId() == null){
            throw new RuntimeException("ID da Republica fornecida é invaldo!");
        }
        
        this.republicaDAO.insert(republica);
    }
    
    public void update(Republica republica) throws Exception{
        if(republica == null){
            throw new RuntimeException("Republica fornecida é invalda!");
        }else if(republica.getId() == null){
            throw new RuntimeException("ID da Republica fornecida é invaldo!");
        }
        
        this.republicaDAO.update(republica);
    }
    
    public void delete(Long id) throws Exception{
        if(id == null){
            throw new RuntimeException("ID da Republica fornecida é invaldo!");
        }
        
        this.republicaDAO.delete(id);
    }
    
    public Republica getById(Long id) throws Exception{
        if(id == null){
            throw new RuntimeException("ID da Republica fornecida é invaldo!");
        }
        
        return this.republicaDAO.getById(id);
    }
    
    public Republica getByIdMorador(Long id) throws Exception{
        if(id == null){
            throw new RuntimeException("ID do Morador fornecido é invaldo!");
        }
        
        return this.republicaDAO.getByIdMorador(id);
    }
    
    public List<Republica> getByVagasDisponiveis() throws Exception{
        return this.republicaDAO.getByVagasDisponiveis();
    }
    
}
