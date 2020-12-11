/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.republica.view.tarefas;

import br.ufes.republica.models.Tarefa;
import br.ufes.republica.service.TarefaService;
import br.ufes.republica.view.presenter.BaseInternalFramePresenter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDesktopPane;

/**
 *
 * @author bruno
 */
public class ListaTarefasPresenter extends BaseInternalFramePresenter<ListaTarefasView> {

    private List<Tarefa> tarefas;
    private TarefaService tarefaService;

    public ListaTarefasPresenter(JDesktopPane container) {
        super(container, new ListaTarefasView());
        tarefas = new ArrayList<>();
        ListaTarefasView view = getView();

        view.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(view.getTxtBusca().getText());
            }
        });

        view.getBtnCadastrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });

        view.getBtnEditar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });

        view.setVisible(true);
    }

}
