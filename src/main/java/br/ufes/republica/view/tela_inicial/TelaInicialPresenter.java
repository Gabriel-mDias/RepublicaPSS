package br.ufes.republica.view.tela_inicial;

import br.ufes.republica.exception.BusinessException;
import br.ufes.republica.models.Republica;
import br.ufes.republica.models.Usuario;
import br.ufes.republica.view.moradores.ListaMoradoresPresenter;
import br.ufes.republica.view.tarefas.ConclusaoTarefasPresenter;
import br.ufes.republica.view.tarefas.ListaTarefasPresenter;
import br.ufes.republica.view.perfil.presenter.ManterPerfilPresenter;
import br.ufes.republica.view.republica.VisualizarRepublicaPresenter;
import br.ufes.republica.view.tarefa.ListarFeedbackPresenter;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class TelaInicialPresenter {
    
    private TelaInicialView view;

    public TelaInicialPresenter(Usuario usuarioLogado) throws BusinessException {
        var telaInicial = this;
        this.view = new TelaInicialView();
        if(usuarioLogado == null || usuarioLogado.getId() == null) {
            this.view.setVisible(false);
            this.view.dispose();
            throw new BusinessException("Login Inválido");
        }
        System.setProperty("idUsuarioLogado", usuarioLogado.getId().toString());
        
        this.view.setState(JFrame.ICONIFIED);
        this.view.setLocationRelativeTo(this.view.getParent());
        this.view.setExtendedState(MAXIMIZED_BOTH);
        
        this.view.getItemManterMorador().addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Republica republica = null;
                ListaMoradoresPresenter listM = new ListaMoradoresPresenter(republica, view.getDesktop());
                addContainer(listM.getView());
            }
        });
        
        this.view.getItemTarefa().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListaTarefasPresenter(view.getDesktop());
            }
        });
        
        this.view.getItemConclusaoTarefa().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConclusaoTarefasPresenter(view.getDesktop());
            }
        });
        
         this.view.getItemManterPerfil().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManterPerfilPresenter(telaInicial, view.getDesktop(), usuarioLogado);
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
        
        this.view.getItemSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        });
        
        this.view.setVisible(true);
    }
    
    
    public void addContainer(JInternalFrame janela){
        view.getDesktop().add(janela);
    }
    
    public void sair() {
        view.setVisible(false);
        view.dispose();
    }
    
    
}
