/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.republica.view.moradores;

import br.ufes.republica.models.Pessoa;

/**
 *
 * @author gabriel
 */
public class HistoricoMoradorPresenter {
    
    private Pessoa pessoa;
    private HistoricoMoradorView view;

    public HistoricoMoradorPresenter(Pessoa pessoa) {
        this.pessoa = pessoa;
        this.view = new HistoricoMoradorView();
        
        this.view.setVisible(true);
    }

    public HistoricoMoradorView getView() {
        return view;
    }
    
    
    
}
