/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.republica.view.tarefa;

import br.ufes.republica.models.Feedback;
import br.ufes.republica.models.Republica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gabriel
 */
public class ListarFeedbackPresenter {
    
    private ListarFeedbackView view;
    private List<Feedback> feedbacks;
    private Republica republica;

    public ListarFeedbackPresenter(Republica republica, JDesktopPane container) {
        this.republica = republica;
        this.view = new ListarFeedbackView();
        
        
        this.view.getBtnNovoFeedback().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                container.add(new NovoFeedbackPresenter().getView());
            }
        });
        
        this.view.getBtnEditar().addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Feedback feedback = null; //TODO: Selecionar o da tabela
                container.add(new NovoFeedbackPresenter(feedback).getView());
            }
        });
        
        this.view.getBtnVisualizar().addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Feedback feedback = null; //TODO: Selecionar o da tabela
                container.add(new VisualizarFeedbackPresenter(feedback).getView());
            }
        });
        
        
        
        //preencheTabela();
        this.view.setVisible(true);
    }
    
    private void preencheTabela(){
        DefaultTableModel tabela = (DefaultTableModel)this.view.getTblFeedback().getModel();
        tabela.setNumRows(0);
        for(Feedback f : feedbacks){
            tabela.addRow(new Object[]{
                f.getDataRealizado(),
                f.getTipo().getTipo(),
                f.getAutor(),
                "Envolvidos não implementado",
                f.getDataSolucionado() != null ? "Sim" : "Não"
            });
        }
        
    }

    public ListarFeedbackView getView() {
        return view;
    }
    
}
