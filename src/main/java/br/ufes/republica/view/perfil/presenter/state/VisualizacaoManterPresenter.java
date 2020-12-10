package br.ufes.republica.view.perfil.presenter.state;

import br.ufes.republica.models.Usuario;
import br.ufes.republica.view.perfil.presenter.ManterPerfilPresenter;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class VisualizacaoManterPresenter extends ManterPresenterState {
    
    public VisualizacaoManterPresenter(ManterPerfilPresenter presenter, Usuario usuario) {
        super(presenter);
        init(usuario);
    }
    
    private void init(Usuario usuario) {
        setDados(pessoa);
        disableCampos();
        var view = presenter.getView();
        view.getBtnSalvar().setText("Habilitar Edição");
        view.getBtnExcluir().setVisible(true);
        
        JButton btnSalvar = view.getBtnSalvar();
        JButton btnExcluir = view.getBtnExcluir();
        JButton btnHistorico = view.getBtnHistorico();
        
        for(ActionListener ae : btnSalvar.getActionListeners()) {
            btnSalvar.removeActionListener(ae);
        }
        
        for(ActionListener ae : btnExcluir.getActionListeners()) {
            btnExcluir.removeActionListener(ae);
        }
        
        for(ActionListener ae : btnHistorico.getActionListeners()) {
            btnHistorico.removeActionListener(ae);
        }
        
        view.getBtnSalvar().addActionListener((ae) -> {
            editar();
        });
        
        view.getBtnExcluir().addActionListener((ae) -> {
            excluir();
        });
        
        view.getBtnHistorico().addActionListener((ae) -> {
            cancelar();
        });
    }
    
    @Override
    public void excluir() {
        var pessoa = getDados();
        // Excluir
    }
    
    @Override
    public void editar() {
        enableCampos();
        presenter.setState(new EdicaoManterPresenter(presenter));
    }
    
}
