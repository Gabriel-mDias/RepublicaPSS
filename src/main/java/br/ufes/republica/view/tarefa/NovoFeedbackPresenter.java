/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.republica.view.tarefa;

import br.ufes.republica.models.Feedback;
import br.ufes.republica.view.tarefa.state.EstadoCadastro;
import br.ufes.republica.view.tarefa.state.EstadoEditar;
import br.ufes.republica.view.tarefa.state.IFeedbackPresenter;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author gabriel
 */
public class NovoFeedbackPresenter {
    
    private NovoFeedbackView view;
    private Feedback feedback;
    private IFeedbackPresenter estado; 

    public NovoFeedbackPresenter(Feedback feedback) {   //Para edição
        this.feedback = feedback;
        this.view = new NovoFeedbackView();
        this.estado = new EstadoCadastro();
        //método para preencher a tela
        
        this.view.getBtnConfirmar().addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Editar um feedback
                estado.concluirTela(feedback);
            }
        });
        
        
        this.view.setVisible(true);
    }
    
    public NovoFeedbackPresenter(){ //Para cadastro
//        this.feedback = new Feedback();
        this.view = new NovoFeedbackView();
        this.estado = new EstadoEditar();
        
        this.view.getBtnConfirmar().addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Preenche um feedback com a entrada na tela
                //TODO: Cadastrar um feedback
                estado.concluirTela(feedback);
            }
        });
        
        
        this.view.setVisible(true);
    }

    public NovoFeedbackView getView() {
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
