/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.republica.view.perfil;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author bruno
 */
public class ManterPerfilView extends javax.swing.JInternalFrame {

    /**
     * Creates new form CadNovaTarefa
     */
    public ManterPerfilView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        txtApelido = new javax.swing.JTextField();
        lblApelido = new javax.swing.JLabel();
        txtRedeSocial = new javax.swing.JTextField();
        lblRedeSocial = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        lblTelefoneResponsavel1 = new javax.swing.JLabel();
        lblTelefoneResponsavel2 = new javax.swing.JLabel();
        btnHistorico = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        txtTelefoneResponsavel2 = new javax.swing.JFormattedTextField();
        txtTelefone = new javax.swing.JFormattedTextField();
        txtTelefoneResponsavel1 = new javax.swing.JFormattedTextField();
        lblCpf = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        pnUsuario = new javax.swing.JPanel();
        lblLogin = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        lblSenhaNovamente = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        txtSenhaNovamente = new javax.swing.JPasswordField();

        setClosable(true);
        setTitle("Perfil");

        lblNome.setText("Nome:");

        btnSalvar.setText("Salvar");

        lblApelido.setText("Apelido:");

        lblRedeSocial.setText("Link da Rede Social:");

        lblTelefone.setText("Telefone:");

        lblTelefoneResponsavel1.setText("Telefone do Responsável 1:");

        lblTelefoneResponsavel2.setText("Telefone do Responsável 2:");

        btnHistorico.setText("Ver Histórico de Repúblicas");

        btnExcluir.setText("Excluir Conta");

        try {
            txtTelefoneResponsavel2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtTelefoneResponsavel1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblCpf.setText("CPF:");

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        pnUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuário"));
        pnUsuario.setToolTipText("Usuário");

        lblLogin.setText("Login:");

        lblSenha.setText("Senha:");

        lblSenhaNovamente.setText("Digite a senha novamente:");

        javax.swing.GroupLayout pnUsuarioLayout = new javax.swing.GroupLayout(pnUsuario);
        pnUsuario.setLayout(pnUsuarioLayout);
        pnUsuarioLayout.setHorizontalGroup(
            pnUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLogin)
                    .addComponent(txtSenha)
                    .addGroup(pnUsuarioLayout.createSequentialGroup()
                        .addGroup(pnUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLogin)
                            .addComponent(lblSenha)
                            .addComponent(lblSenhaNovamente))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtSenhaNovamente))
                .addContainerGap())
        );
        pnUsuarioLayout.setVerticalGroup(
            pnUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnUsuarioLayout.createSequentialGroup()
                .addComponent(lblLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(lblSenhaNovamente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenhaNovamente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCpf))
                    .addComponent(txtApelido, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNome)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHistorico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtRedeSocial)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTelefone)
                                .addGap(115, 115, 115)
                                .addComponent(lblCpf))
                            .addComponent(lblApelido)
                            .addComponent(lblRedeSocial)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTelefoneResponsavel1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                                    .addComponent(lblTelefoneResponsavel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTelefoneResponsavel2)
                                    .addComponent(txtTelefoneResponsavel2, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))))
                        .addGap(3, 3, 3))
                    .addComponent(pnUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblApelido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefone)
                    .addComponent(lblCpf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRedeSocial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRedeSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefoneResponsavel1)
                    .addComponent(lblTelefoneResponsavel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefoneResponsavel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefoneResponsavel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir)
                    .addComponent(btnHistorico))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtnSalvar() {
        return btnSalvar;
    }

    public JButton getBtnExcluir() {
        return btnExcluir;
    }

    public JButton getBtnHistorico() {
        return btnHistorico;
    }

    public JLabel getLblApelido() {
        return lblApelido;
    }

    public JLabel getLblNome() {
        return lblNome;
    }

    public JLabel getLblRedeSocial() {
        return lblRedeSocial;
    }

    public JLabel getLblTelefone() {
        return lblTelefone;
    }

    public JLabel getLblTelefoneResponsavel1() {
        return lblTelefoneResponsavel1;
    }

    public JLabel getLblTelefoneResponsavel2() {
        return lblTelefoneResponsavel2;
    }

    public JTextField getTxtApelido() {
        return txtApelido;
    }

    public JTextField getTxtNome() {
        return txtNome;
    }

    public JTextField getTxtRedeSocial() {
        return txtRedeSocial;
    }

    public JFormattedTextField getTxtTelefone() {
        return txtTelefone;
    }

    public JFormattedTextField getTxtTelefoneResponsavel1() {
        return txtTelefoneResponsavel1;
    }

    public JFormattedTextField getTxtTelefoneResponsavel2() {
        return txtTelefoneResponsavel2;
    }

    public JLabel getLblCpf() {
        return lblCpf;
    }

    public JFormattedTextField getTxtCpf() {
        return txtCpf;
    }

    public JLabel getLblLogin() {
        return lblLogin;
    }

    public JLabel getLblSenha() {
        return lblSenha;
    }

    public JLabel getLblSenhaNovamente() {
        return lblSenhaNovamente;
    }

    public JPanel getPnUsuario() {
        return pnUsuario;
    }

    public JTextField getTxtLogin() {
        return txtLogin;
    }

    public JPasswordField getTxtSenha() {
        return txtSenha;
    }

    public JPasswordField getTxtSenhaNovamente() {
        return txtSenhaNovamente;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnHistorico;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblApelido;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblRedeSocial;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblSenhaNovamente;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTelefoneResponsavel1;
    private javax.swing.JLabel lblTelefoneResponsavel2;
    private javax.swing.JPanel pnUsuario;
    private javax.swing.JTextField txtApelido;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtRedeSocial;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JPasswordField txtSenhaNovamente;
    private javax.swing.JFormattedTextField txtTelefone;
    private javax.swing.JFormattedTextField txtTelefoneResponsavel1;
    private javax.swing.JFormattedTextField txtTelefoneResponsavel2;
    // End of variables declaration//GEN-END:variables
}
