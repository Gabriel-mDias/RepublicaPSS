/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.republica.view.main;

import br.ufes.republica.models.Pessoa;
import br.ufes.republica.models.Republica;
import br.ufes.republica.view.moradores.ListaMoradoresPresenter;
import br.ufes.republica.view.perfil.VisualizarPerfilPresenter;
import br.ufes.republica.view.republica.VisualizarRepublicaPresenter;
import br.ufes.republica.view.tarefa.ListarFeedbackPresenter;
import br.ufes.republica.view.tarefa.ListarFeedbackView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;

/**
 *
 * @author gabriel
 */
public class TelaInicialPresenter {
    
    private TelaInicialView view;

    public TelaInicialPresenter() {
        this.view = new TelaInicialView();
        
        this.view.getItemManterMorador().addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Republica republica = null;
                ListaMoradoresPresenter listM = new ListaMoradoresPresenter(republica, view.getDesktop());
                addContainer(listM.getView());
            }
        });
        
        this.view.getItemManterPerfil().addActionListener( new ActionListener() {
           
            @Override
            public void actionPerformed(ActionEvent e) {
                Pessoa pessoa = null;
                addContainer(new VisualizarPerfilPresenter(pessoa, view.getDesktop()).getView());
            }
        });
        
        this.view.getItemManterRepublica().addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Republica republica = null;
                addContainer(new VisualizarRepublicaPresenter(republica, view.getDesktop()).getView());
            }
        });
        
        this.view.getItemManterReclamacao().addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Republica republica = null;
                addContainer(new ListarFeedbackPresenter(republica, view.getDesktop()).getView());
            }
        });
        
        this.view.setVisible(true);
    }
    
    
    public void addContainer(JInternalFrame janela){
        view.getDesktop().add(janela);
    }
    
    
}
