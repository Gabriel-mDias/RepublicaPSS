/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.republica.view.moradores;

import java.util.List;
import br.ufes.republica.models.Pessoa;
import br.ufes.republica.services.MoradorService;
import br.ufes.republica.views.main.TelaInicialView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ListaMoradoresPresenter {
    
    private ListaMoradoresView view;
    private List<Pessoa> moradores;
    private MoradorService moradorService;

    public ListaMoradoresPresenter() {
        moradores = new ArrayList<>();
        view = new ListaMoradoresView();
        
        
            //Ações dos botões
        view.getBtnEditar().addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Pessoa morador = null;  //Receber aquele selecionado da tabela
                new EditarMoradoresPresenter(morador);
            }
        
        });
        
        view.getBtnRemover().addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Pessoa morador = null;  //Receber aquele selecionado da tabela
                //TODO: Remover morador
                JOptionPane.showMessageDialog(view, "Morador retirado da república!", "Excluir Morador", JOptionPane.OK_OPTION);
            }
        
        });
        
        view.getBtnHistorico().addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Pessoa morador = null;  //Receber aquele selecionado da tabela
                new EditarMoradoresPresenter(morador);
            }
        
        });
        
        
        view.setVisible(true);
        //TelaInicialView.Desktop.add(view);
    }

    public ListaMoradoresView getView() {
        return view;
    }

    public void setView(ListaMoradoresView view) {
        this.view = view;
    }
    
    
    
    
}
