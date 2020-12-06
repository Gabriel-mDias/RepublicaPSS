/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.republica.view.moradores;

import java.util.List;
import br.ufes.republica.models.Pessoa;
import br.ufes.republica.models.Republica;
import br.ufes.republica.services.MoradorService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;


public class ListaMoradoresPresenter {
    
    private ListaMoradoresView view;
    private List<Pessoa> moradores;
    private Republica republica;
    private MoradorService moradorService;

    public ListaMoradoresPresenter(Republica republica, JDesktopPane container) {
        this.moradores = new ArrayList<>();
        this.view = new ListaMoradoresView();
        this.republica = republica;
        
        
            //Ações dos botões
        view.getBtnEditar().addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Pessoa morador = null;  //Receber aquele selecionado da tabela
                container.add(new EditarMoradoresPresenter(morador).getView());
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
                container.add(new HistoricoMoradorPresenter(morador).getView() );
            }
        
        });
        
        
        view.setVisible(true);
    }

    public ListaMoradoresView getView() {
        return view;
    }

    public void setView(ListaMoradoresView view) {
        this.view = view;
    }
    
    
    
    
}
