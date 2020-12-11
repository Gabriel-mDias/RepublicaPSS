
package br.ufes.republica.business;

import br.ufes.republica.dao.interfaces.IPessoaDAO;
import br.ufes.republica.models.Pessoa;
import java.util.List;

public class PessoaBusiness {
    
    private IPessoaDAO pessoaDAO;

    public PessoaBusiness(IPessoaDAO pessoaDAO) {
        if(pessoaDAO == null) {
            throw new RuntimeException("DAO fornecida é inválida");
        }
        this.pessoaDAO = pessoaDAO;
    }
    
    
    public void insert(Pessoa p) throws Exception{
        if(p == null){
            throw new RuntimeException("Pessoa informada é inválida!");
        }else if(p.getId() == null){
            throw new RuntimeException("ID da Pessoa informada é inválida!");
        }
        
        pessoaDAO.insert(p);
    }
    
    public void update(Pessoa p) throws Exception{
        if(p == null){
            throw new RuntimeException("Pessoa informada é inválida!");
        }else if(p.getId() == null){
            throw new RuntimeException("ID da Pessoa informada é inválida!");
        }
        
        pessoaDAO.update(p);
    }
    
    public void updateRepublica(Pessoa p) throws Exception{
        if(p == null){
            throw new RuntimeException("Pessoa informada é inválida!");
        }else if(p.getId() == null){
            throw new RuntimeException("ID da Pessoa informada é inválida!");
        }
        
        pessoaDAO.updateRepublica(p);
    }
    
    public Pessoa getById(Long id) throws Exception{
        if(id == null){
            throw new RuntimeException("ID da Pessoa informada é inválida!");
        }
        
        return pessoaDAO.getById(id);
    }
    
    public List<Pessoa> getByIdRepublica(Long idRepublica) throws Exception{
        if(idRepublica == null){
            throw new RuntimeException("ID da República informada é inválida!");
        }
        
        return pessoaDAO.getByIdRepublica(idRepublica);
    }
}
