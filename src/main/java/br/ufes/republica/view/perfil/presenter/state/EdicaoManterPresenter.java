package br.ufes.republica.view.perfil.presenter.state;

import br.ufes.republica.models.Usuario;
import br.ufes.republica.view.perfil.presenter.ManterPerfilPresenter;
import javax.swing.JOptionPane;

public class EdicaoManterPresenter extends ManterPresenterState {

    public EdicaoManterPresenter(ManterPerfilPresenter presenter) {
        super(presenter);
        init();
    }

    private void init() {
        var view = presenter.getView();
        view.getBtnExcluir().setVisible(false);
        view.getBtnHistorico().setVisible(false);
        view.getBtnSalvar().setVisible(true);
        view.getBtnSalvar().setText("Salvar");
        view.getTxtLogin().setEditable(false);

        view.getBtnSalvar().addActionListener((ae) -> {
            salvar();
        });
    }

    @Override
    public void salvar() {
        if (senhasConferem()) {
            try {
                Usuario usuario = getDados();
                pessoaService.update(usuario.getPessoa());
                if (usuario.getSenha() != null && !usuario.getSenha().isBlank()) {
                    usuarioService.update(usuario);
                }
                JOptionPane.showMessageDialog(null, "Pessoa cadastrada!", "Cadastro de Pessoa", JOptionPane.OK_OPTION);
                fechar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Senhas não conferem", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}
