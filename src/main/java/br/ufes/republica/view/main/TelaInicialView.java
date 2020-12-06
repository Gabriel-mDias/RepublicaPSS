/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.republica.view.main;

import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


/**
 *
 * @author bruno
 */
public class TelaInicialView extends javax.swing.JFrame {

    /**
     * Creates new form TelaInicial
     */
    public TelaInicialView() {
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

        Desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuRepublica = new javax.swing.JMenu();
        itemManterRepublica = new javax.swing.JMenuItem();
        itemManterMorador = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        itemManterReclamacao = new javax.swing.JMenuItem();
        menuMorador = new javax.swing.JMenu();
        itemManterPerfil = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuRepublica.setText("República");

        itemManterRepublica.setText("Manter república");
        itemManterRepublica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemManterRepublicaActionPerformed(evt);
            }
        });
        menuRepublica.add(itemManterRepublica);

        itemManterMorador.setText("Manter moradores");
        itemManterMorador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemManterMoradorActionPerformed(evt);
            }
        });
        menuRepublica.add(itemManterMorador);

        jMenuItem3.setText("Confirmar solução de reclamações / sugestões");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuRepublica.add(jMenuItem3);

        jMenuItem4.setText("Convidar moradores/ Aceitar convite");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menuRepublica.add(jMenuItem4);

        jMenuItem5.setText("Criar república");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menuRepublica.add(jMenuItem5);

        jMenuItem6.setText("Buscar vagas");
        menuRepublica.add(jMenuItem6);

        jMenuItem7.setText("Consultar resultado mensal");
        menuRepublica.add(jMenuItem7);

        itemManterReclamacao.setText("Manter reclamações / sugestões");
        menuRepublica.add(itemManterReclamacao);

        jMenuBar1.add(menuRepublica);

        menuMorador.setText("Morador");

        itemManterPerfil.setText("Manter perfil");
        itemManterPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemManterPerfilActionPerformed(evt);
            }
        });
        menuMorador.add(itemManterPerfil);

        jMenuItem10.setText("Aceitar convite");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        menuMorador.add(jMenuItem10);

        jMenuBar1.add(menuMorador);

        jMenu3.setText("Tarefas");

        jMenuItem11.setText("Manter tarefas");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem11);

        jMenuItem12.setText("Registrar conclusão da tarefa");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem12);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Lançamentos");

        jMenuItem13.setText("Manter receitas e despesas");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem13);

        jMenuItem14.setText("Fazer estorno de lançamentos");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem14);

        jMenuItem15.setText("Consultar minhas receitas e despesas");
        jMenu4.add(jMenuItem15);

        jMenuItem16.setText("Registrar pagamento de receita ou despesas");
        jMenu4.add(jMenuItem16);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Sair");
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop, javax.swing.GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void itemManterRepublicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemManterRepublicaActionPerformed
        
    }//GEN-LAST:event_itemManterRepublicaActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void itemManterMoradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemManterMoradorActionPerformed
    
    }//GEN-LAST:event_itemManterMoradorActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void itemManterPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemManterPerfilActionPerformed
        
    }//GEN-LAST:event_itemManterPerfilActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    public JDesktopPane getDesktop() {
        return Desktop;
    }

    public JMenuItem getItemManterMorador() {
        return itemManterMorador;
    }

    public JMenu getMenuRepublica() {
        return menuRepublica;
    }

    public JMenuItem getItemManterPerfil() {
        return itemManterPerfil;
    }

    public JMenuItem getItemManterRepublica() {
        return itemManterRepublica;
    }

    public JMenuItem getItemManterReclamacao() {
        return itemManterReclamacao;
    }


    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane Desktop;
    private javax.swing.JMenuItem itemManterMorador;
    private javax.swing.JMenuItem itemManterPerfil;
    private javax.swing.JMenuItem itemManterReclamacao;
    private javax.swing.JMenuItem itemManterRepublica;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenu menuMorador;
    private javax.swing.JMenu menuRepublica;
    // End of variables declaration//GEN-END:variables
}