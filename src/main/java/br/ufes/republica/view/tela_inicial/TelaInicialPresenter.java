package br.ufes.republica.view.tela_inicial;

import br.ufes.republica.models.Pessoa;
import br.ufes.republica.models.Republica;
import br.ufes.republica.models.Usuario;
import br.ufes.republica.view.moradores.ListaMoradoresPresenter;
import br.ufes.republica.view.tarefas.ConclusaoTarefasPresenter;
import br.ufes.republica.view.tarefas.ListaTarefasPresenter;
import br.ufes.republica.view.perfil.presenter.ManterPerfilPresenter;
import br.ufes.republica.view.republica.VisualizarRepublicaPresenter;
import br.ufes.republica.view.tarefa.ListarFeedbackPresenter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;

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
                Usuario usuario = getUsuarioTeste();
                new ManterPerfilPresenter(view.getDesktop(), usuario);
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
    
    private Usuario getUsuarioTeste() {
        var usuario = new Usuario();
        usuario.setId(1L);
        usuario.setLogin("Bruno");
        usuario.setSenha("Bruno");
        var pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("Bruno");
        pessoa.setApelido("Brunin");
        pessoa.setTelefone("28999004644");
        pessoa.setCPF("11111111111");
        pessoa.setLinkRedeSocial("@asdf");
        pessoa.setTelefoneResponsavel1("28999564397");
        pessoa.setTelefoneResponsavel2("28999556683");
        usuario.setPessoa(pessoa);
        return usuario;
    }
    
    
}
