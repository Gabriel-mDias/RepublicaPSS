/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.republica.view.tarefa;

import br.ufes.republica.models.Feedback;
import javax.swing.DefaultListModel;

/**
 *
 * @author gabriel
 */
public class VisualizarFeedbackPresenter {
    
    private VisualizarFeedbackView view;
    private Feedback feedback;
    
    public VisualizarFeedbackPresenter(Feedback feedback){
        this.feedback = feedback;
        this.view = new VisualizarFeedbackView();
        
        this.view.setVisible(true);
    }

    public VisualizarFeedbackView getView() {
        return view;
    }
    
    
    private void preencheTela(Feedback f){
        this.view.getTxtDescricao().setText(f.getDescricao());
        this.view.getTxtDataRealizada().setText(f.getDataRealizado().toString());
        boolean reclamacao = f.getTipo().getTipo().equals("reclamação") ? true : false;
        this.view.getRbReclamacao().setEnabled(reclamacao);
        this.view.getRbSugestao().setEnabled(!reclamacao);
        //preencher o JLIST
    }
}
