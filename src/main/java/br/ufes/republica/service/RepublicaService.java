
package br.ufes.republica.service;

import br.ufes.republica.business.PessoaBusiness;
import br.ufes.republica.business.RepublicaBusiness;
import br.ufes.republica.dao.manager.SqliteManager;
import br.ufes.republica.dao.sqlite.impl.RepublicaDAOSQLite;
import br.ufes.republica.models.Republica;


public class RepublicaService {
    
    private RepublicaBusiness republicaBusiness;
    private PessoaBusiness pessoaBusiness;

    public RepublicaService() {
        this.republicaBusiness = new RepublicaBusiness(new RepublicaDAOSQLite(new SqliteManager()));
    }
    
    public void insert(Republica republica) throws Exception{
        this.republicaBusiness.insert(republica);
    }
    
    public void update(Republica republica) throws Exception{
        this.republicaBusiness.update(republica);
    }
    
    public Republica getRepublicaUsuario(Long id) throws Exception{
        return this.republicaBusiness.getByIdMorador(id);
    }
    
}
