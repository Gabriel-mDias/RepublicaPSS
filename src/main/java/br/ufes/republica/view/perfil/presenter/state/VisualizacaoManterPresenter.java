package br.ufes.republica.view.perfil.presenter.state;

import br.ufes.republica.models.Pessoa;
import br.ufes.republica.models.Usuario;
import br.ufes.republica.view.perfil.presenter.ManterPerfilPresenter;
import javax.swing.JOptionPane;

public class VisualizacaoManterPresenter extends ManterPresenterState {

    private Long idUsuario;
    private Long idPessoa;

    public VisualizacaoManterPresenter(ManterPerfilPresenter presenter, Usuario usuario) {
        super(presenter);
        if (usuario != null && usuario.getId() != null) {
            idUsuario = usuario.getId();
            if (usuario.getPessoa() != null && usuario.getPessoa().getId() != null) {
                idPessoa = usuario.getPessoa().getId();
            }
        }
        init(usuario);
    }

    public VisualizacaoManterPresenter(ManterPerfilPresenter presenter, Pessoa pessoa) {
        super(presenter);
        init(pessoa);
    }

    private void init(Usuario usuario) {
        setDados(usuario);
        disableCampos();
        var view = presenter.getView();
        view.getBtnExcluir().setVisible(true);
        view.getBtnHistorico().setVisible(true);
        view.getBtnSalvar().setVisible(true);
        view.getBtnSalvar().setText("Habilitar Edição");

        view.getBtnSalvar().addActionListener((ae) -> {
            editar();
        });

        view.getBtnExcluir().addActionListener((ae) -> {
            excluir();
        });

        view.getBtnHistorico().addActionListener((ae) -> {
            historico();
        });
    }

    private void init(Pessoa pessoa) {
        setDados(pessoa);
        disableCampos();
        var view = presenter.getView();
        view.getBtnExcluir().setVisible(false);
        view.getBtnHistorico().setVisible(true);
        view.getBtnSalvar().setVisible(false);

        view.getBtnSalvar().addActionListener((ae) -> {
            editar();
        });

        view.getBtnExcluir().addActionListener((ae) -> {
            excluir();
        });

        view.getBtnHistorico().addActionListener((ae) -> {
            historico();
        });
    }

    @Override
    public void excluir() {
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir?", "", JOptionPane.YES_NO_OPTION);
        if (opcao == 0) {
            try {
                if (idUsuario != null) {
                    usuarioService.delete(idUsuario);
                    if (idPessoa != null) {
                        pessoaService.delete(idPessoa);
                    }
                    JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso, saindo da aplicação!", "", JOptionPane.OK_OPTION);
                    presenter.getView().setVisible(false);
                    presenter.getView().dispose();
                    presenter.sair();
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public void editar() {
        enableCampos();
        presenter.setState(new EdicaoManterPresenter(presenter));
    }

    public void historico() {
        // exibir tela de historico
    }
}
