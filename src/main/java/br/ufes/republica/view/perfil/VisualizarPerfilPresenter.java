/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.republica.view.perfil;

import br.ufes.republica.models.Pessoa;
import br.ufes.republica.view.moradores.HistoricoMoradorPresenter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author gabriel
 */
public class VisualizarPerfilPresenter {
    
    private VisualizarPerfilView view;
    private Pessoa pessoa;

    public VisualizarPerfilPresenter(Pessoa pessoa, JDesktopPane container) {
        this.pessoa = pessoa;
        this.view = new VisualizarPerfilView();
        
        this.view.getBtnExcluir().addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Estado removido para um usuario
                JOptionPane.showMessageDialog(view, "Usuário desativado!", "Desativar Usuário", JOptionPane.OK_OPTION);
            }
        });
        
        this.view.getBtnEditar().addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                container.add(new EditarPerfilPresenter(pessoa).getView());
            }
        });
        
        this.view.getBtnHistorico().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                container.add(new HistoricoMoradorPresenter(pessoa).getView());
            }
        });
        
        this.view.setVisible(true);
    }

    public VisualizarPerfilView getView() {
        return view;
    }
    
    
}
