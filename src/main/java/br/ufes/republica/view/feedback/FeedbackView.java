package br.ufes.republica.view.feedback;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FeedbackView extends javax.swing.JInternalFrame
{

    public FeedbackView()
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        lblDescricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        btnFechar = new javax.swing.JButton();
        btnVerTodas = new javax.swing.JButton();
        cmbFeedback = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        lblNome.setText("Nome:");

        btnRegistrar.setText("Registrar");

        lblDescricao.setText("Reclamação / Sugestão:");

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane1.setViewportView(txtDescricao);

        btnFechar.setText("Fechar");

        btnVerTodas.setText("Ver todas");

        cmbFeedback.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Reclamaçao", "Sugestao" }));

        jLabel1.setText("Tipo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVerTodas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFechar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblDescricao)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(lblDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnFechar)
                    .addComponent(btnVerTodas))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtnFechar()
    {
        return btnFechar;
    }

    public void setBtnFechar(JButton btnFechar)
    {
        this.btnFechar = btnFechar;
    }

    public JButton getBtnRegistrar()
    {
        return btnRegistrar;
    }

    public void setBtnRegistrar(JButton btnRegistrar)
    {
        this.btnRegistrar = btnRegistrar;
    }

    public JButton getBtnVerTodas()
    {
        return btnVerTodas;
    }

    public void setBtnVerTodas(JButton btnVerTodas)
    {
        this.btnVerTodas = btnVerTodas;
    }

    public JTextArea getTxtDescricao()
    {
        return txtDescricao;
    }

    public void setTxtDescricao(JTextArea txtDescricao)
    {
        this.txtDescricao = txtDescricao;
    }

    public JTextField getTxtNome()
    {
        return txtNome;
    }

    public void setTxtNome(JTextField txtNome)
    {
        this.txtNome = txtNome;
    }

    public JComboBox<String> getCmbFeedback()
    {
        return cmbFeedback;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVerTodas;
    private javax.swing.JComboBox<String> cmbFeedback;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
