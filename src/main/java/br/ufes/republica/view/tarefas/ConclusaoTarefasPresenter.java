/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.republica.view.tarefas;

import br.ufes.republica.view.presenter.BaseInternalFramePresenter;
import javax.swing.JDesktopPane;

/**
 *
 * @author bruno
 */
public class ConclusaoTarefasPresenter extends BaseInternalFramePresenter<ConclusaoTarefasView> {

    public ConclusaoTarefasPresenter(JDesktopPane container) {
        super(container, new ConclusaoTarefasView());
        ConclusaoTarefasView view = getView();
    
        view.setVisible(true);
    }
    
    
}
