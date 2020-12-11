/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.republica.business;

import br.ufes.republica.dao.interfaces.ILancamentoDAO;
import br.ufes.republica.models.Lancamento;

/**
 *
 * @author gabriel
 */
public class LancamentoBusiness {
    
    private ILancamentoDAO lancamentoDAO;

    public LancamentoBusiness(ILancamentoDAO lancamentoDAO) throws Exception{
        if(lancamentoDAO == null) {
            throw new RuntimeException("DAO fornecida é inválida");
        }
        this.lancamentoDAO = lancamentoDAO;
    }
    
    public void insert(Lancamento lancamento, Long idRepublica) throws Exception{
        if(lancamento == null){
            throw new RuntimeException("Lançamento fornecido é invalido!");
        }else if(idRepublica == null){
            throw new RuntimeException("ID da República fornecida é invalido!");
        }
        
        lancamentoDAO.insert(lancamento, idRepublica);
    }
    
    public void update(Lancamento lancamento) throws Exception{
        if(lancamento == null){
            throw new RuntimeException("Lancamento fornecido é invalido!");
        }
        
        lancamentoDAO.update(lancamento);
    }
    
    public void getByIdRepublica(Long idRepublica) throws Exception{
        if(idRepublica == null){
            throw new RuntimeException("ID da República fornecida é invalido!");
        }
        
        lancamentoDAO.getByIdRepublica(idRepublica);
    }
    
}
