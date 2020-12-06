/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.republica.view.tarefa;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;


/**
 *
 * @author bruno
 */
public class ListarFeedbackView extends javax.swing.JInternalFrame {

    /**
     * Creates new form ManterTarefa
     */
    public ListarFeedbackView() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblFeedback = new javax.swing.JTable();
        cbBuscar = new javax.swing.JComboBox<>();
        btnNovoFeedback = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnConcluirFeedback = new javax.swing.JButton();
        btnVisualizar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Listar Sugestão/Reclamação");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblFeedback.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Data", "Tipo", "Autor", "Descriçã́o", "Envolvidos", "Finalizada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFeedback.setRowHeight(25);
        jScrollPane1.setViewportView(tblFeedback);
        if (tblFeedback.getColumnModel().getColumnCount() > 0) {
            tblFeedback.getColumnModel().getColumn(2).setMaxWidth(70);
            tblFeedback.getColumnModel().getColumn(3).setMinWidth(300);
            tblFeedback.getColumnModel().getColumn(4).setMinWidth(100);
            tblFeedback.getColumnModel().getColumn(5).setMinWidth(30);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 53, 870, 204));

        cbBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pessoa", "Descrição" }));
        getContentPane().add(cbBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 123, -1));

        btnNovoFeedback.setText("Cadastrar Nova Sugestão / Reclamação");
        btnNovoFeedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoFeedbackActionPerformed(evt);
            }
        });
        getContentPane().add(btnNovoFeedback, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 260, -1));

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 10, 640, -1));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, 88, -1));

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 270, 88, -1));

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 270, 88, -1));

        btnConcluirFeedback.setText("Confirmar Solução");
        btnConcluirFeedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConcluirFeedbackActionPerformed(evt);
            }
        });
        getContentPane().add(btnConcluirFeedback, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, -1, -1));

        btnVisualizar.setText("Ver Informações");
        getContentPane().add(btnVisualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 270, -1, -1));

        setBounds(0, 0, 898, 356);
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnNovoFeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoFeedbackActionPerformed

    }//GEN-LAST:event_btnNovoFeedbackActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnConcluirFeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConcluirFeedbackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConcluirFeedbackActionPerformed

    public JButton getBtnConcluirFeedback() {
        return btnConcluirFeedback;
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }

    public JButton getBtnExcluir() {
        return btnExcluir;
    }

    public JButton getBtnNovoFeedback() {
        return btnNovoFeedback;
    }

    public JButton getBtnVisualizar() {
        return btnVisualizar;
    }

    public JTable getTblFeedback() {
        return tblFeedback;
    }

    public void setTblFeedback(JTable tblFeedback) {
        this.tblFeedback = tblFeedback;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public JComboBox<String> getCbBuscar() {
        return cbBuscar;
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnConcluirFeedback;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovoFeedback;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JComboBox<String> cbBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFeedback;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}