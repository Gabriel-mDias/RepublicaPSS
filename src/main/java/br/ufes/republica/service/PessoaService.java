package br.ufes.republica.service;

import br.ufes.republica.business.PessoaBusiness;
import br.ufes.republica.models.Pessoa;
import java.util.List;

public class PessoaService {
    private PessoaBusiness pessoaBusiness;
    
    public PessoaService() {
        this.pessoaBusiness = new PessoaBusiness();
    }
    
     public void insert(Pessoa p) throws Exception{ 
        pessoaBusiness.insert(p);
    }
    
    public void update(Pessoa p) throws Exception{        
        pessoaBusiness.update(p);
    }
    
    public void updateRepublica(Pessoa p) throws Exception{        
        pessoaBusiness.updateRepublica(p);
    }
    
    public Pessoa getById(Long id) throws Exception{        
        return pessoaBusiness.getById(id);
    }
    
    public List<Pessoa> getByIdRepublica(Long idRepublica) throws Exception{        
        return pessoaBusiness.getByIdRepublica(idRepublica);
    }
    
    public void delete(Long id) throws Exception {
        pessoaBusiness.delete(id);
    }
}
