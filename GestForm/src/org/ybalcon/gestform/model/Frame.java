/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ybalcon.gestform.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.ybalcon.gestform.Dao.FormationDao;
import org.ybalcon.gestform.Dao.StagiaireDao;

/**
 *
 * @author ybalcon
 */
public class Frame extends javax.swing.JFrame {

    TblStagiaire tbls;
    TblFormation tblf;

    /**
     * Creates new form Frame
     */
    public Frame() {
        initComponents();

        List<Formation> formations = FormationDao.findAll();
        for (Formation f : formations) {
            comboAddStag.addItem(f);
        }
        btnDelForm.setEnabled(false);
        btnEditForm.setEnabled(false);
        btnEditStag.setEnabled(false);
        btnDelStag.setEnabled(false);
        AddStagPanel.setVisible(false);

        TableauFormation.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent evt) {

                btnEditForm.setEnabled(true);
                btnDelForm.setEnabled(true);

            }
        });
        TableauStagiaire.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent evt) {
                btnEditStag.setEnabled(true);
                btnDelStag.setEnabled(true);
            }

        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("java?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableauFormation = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        btnAddForm = new javax.swing.JButton();
        btnEditForm = new javax.swing.JButton();
        btnDelForm = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnAddStag = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableauStagiaire = new javax.swing.JTable();
        AddStagPanel = new javax.swing.JPanel();
        textFieldPrenom = new javax.swing.JTextField();
        textFieldNom = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboAddStag = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        AddStBtn = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        btnEditStag = new javax.swing.JButton();
        btnDelStag = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnAddEcf = new javax.swing.JButton();
        btnEditEcf = new javax.swing.JButton();
        btnDelEcf = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 356, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 356, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
        );

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GestForm 1.0.2");
        setName("Ma fenetre"); // NOI18N

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setName("GestForm 1.0.2"); // NOI18N

        jScrollPane1.setViewportView(TableauFormation);
        tblf = new TblFormation(FormationDao.findAll());
        TableauFormation.setModel(tblf);

        jPanel9.setLayout(new java.awt.GridLayout(1, 0));

        btnAddForm.setText("Ajouter");
        btnAddForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFormActionPerformed(evt);
            }
        });
        jPanel9.add(btnAddForm);

        btnEditForm.setText("Modifier");
        btnEditForm.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnEditForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditFormActionPerformed(evt);
            }
        });
        jPanel9.add(btnEditForm);

        btnDelForm.setText("Supprimer");
        btnDelForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelFormActionPerformed(evt);
            }
        });
        jPanel9.add(btnDelForm);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE))
                .addGap(382, 382, 382))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Formations", jPanel2);

        btnAddStag.setText("Ajouter un(e) stagiaire");
        btnAddStag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStagActionPerformed(evt);
            }
        });

        tbls = new TblStagiaire(StagiaireDao.findAll());
        jScrollPane2.setViewportView(TableauStagiaire);
        TableauStagiaire.setModel(tbls);

        textFieldPrenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPrenomActionPerformed(evt);
            }
        });

        textFieldNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNomActionPerformed(evt);
            }
        });

        jLabel1.setText("Prénom");

        jLabel2.setText("Nom");

        comboAddStag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAddStagActionPerformed(evt);
            }
        });

        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        AddStBtn.setText("Créer");
        AddStBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddStBtnActionPerformed(evt);
            }
        });
        jPanel7.add(AddStBtn);

        jButton5.setText("Effacer");
        jPanel7.add(jButton5);

        jButton6.setText("Quitter");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton6);

        javax.swing.GroupLayout AddStagPanelLayout = new javax.swing.GroupLayout(AddStagPanel);
        AddStagPanel.setLayout(AddStagPanelLayout);
        AddStagPanelLayout.setHorizontalGroup(
            AddStagPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddStagPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AddStagPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(106, 106, 106)
                .addGroup(AddStagPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboAddStag, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textFieldPrenom, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textFieldNom)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddStagPanelLayout.createSequentialGroup()
                        .addGap(0, 32, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        AddStagPanelLayout.setVerticalGroup(
            AddStagPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddStagPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(AddStagPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(AddStagPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(47, 47, 47)
                .addComponent(comboAddStag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jPanel10.setLayout(new java.awt.GridLayout(1, 0));

        btnEditStag.setText("Modifier");
        jPanel10.add(btnEditStag);

        btnDelStag.setText("Supprimer");
        btnDelStag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelStagActionPerformed(evt);
            }
        });
        jPanel10.add(btnDelStag);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddStagPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddStag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnAddStag)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AddStagPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(164, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Stagiaires", jPanel5);

        btnAddEcf.setText("Ajouter");

        btnEditEcf.setText("Modifier");

        btnDelEcf.setText("Supprimer");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(btnAddEcf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditEcf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelEcf)
                .addGap(0, 639, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddEcf)
                    .addComponent(btnEditEcf)
                    .addComponent(btnDelEcf))
                .addContainerGap(573, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ECF", jPanel6);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");

        jMenuItem1.setText("jMenuItem1");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Help");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddStagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStagActionPerformed
        AddStagPanel.setVisible(true);

    }//GEN-LAST:event_btnAddStagActionPerformed

    private void textFieldPrenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPrenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPrenomActionPerformed

    private void textFieldNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNomActionPerformed

    private void btnEditFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditFormActionPerformed
        JOptionPane editPane = new JOptionPane();
        JOptionPane confirmEdit = new JOptionPane();
        int ligne = TableauFormation.getSelectedRow();

        if (ligne > -1) {
            Formation f = tblf.getFormation(ligne);

            String n_nom = editPane.showInputDialog(null, "Modifier le nom de la formation", "Modifier une formation", JOptionPane.QUESTION_MESSAGE);
            try {
                
                Formation nf = new Formation(n_nom);
                FormationDao.update(f);

                confirmEdit.showMessageDialog(null, "Formation " + n_nom + " modifiée", "Modifier une formation", JOptionPane.PLAIN_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }//GEN-LAST:event_btnEditFormActionPerformed

    private void btnAddFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFormActionPerformed
        JOptionPane jp1 = new JOptionPane();
        JOptionPane jp2 = new JOptionPane();

        String n_nom = jp1.showInputDialog(null, "Veuillez saisir le nom de la formation", "Ajouter une formation", JOptionPane.QUESTION_MESSAGE);
        try {
            Formation f = new Formation(n_nom);
            FormationDao.create(f);

            tblf.addFormation(f);
            jp2.showMessageDialog(null, "Formation " + n_nom + " ajoutée", " Ajouter un stagiaire", JOptionPane.PLAIN_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_btnAddFormActionPerformed

    private void comboAddStagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAddStagActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboAddStagActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        AddStagPanel.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void AddStBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddStBtnActionPerformed
        String s_prenom = textFieldPrenom.getText();
        String s_nom = textFieldNom.getText();
        Object s_form = comboAddStag.getSelectedItem();
        Stagiaire s = new Stagiaire(0, s_nom, s_prenom, 0, (Formation) s_form);
        try {
            StagiaireDao.create(s);
            tbls.addStagiaire(s);
            textFieldPrenom.setText(null);
            textFieldNom.setText(null);

        } catch (Exception ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddStBtnActionPerformed

    private void btnDelFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelFormActionPerformed
        int ligne = TableauFormation.getSelectedRow();
        if (ligne > -1) {
            Formation f = tblf.getFormation(ligne);
            try {
                FormationDao.delete(f);
                tblf.delFormation(f);
                btnDelForm.setEnabled(false);
                btnEditForm.setEnabled(false);
            } catch (Exception ex) {
                Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_btnDelFormActionPerformed

    private void btnDelStagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelStagActionPerformed
        int ligne = TableauStagiaire.getSelectedRow();
        if (ligne > -1) {
            Stagiaire s = tbls.getStagiaire(ligne);
            try {
                StagiaireDao.delete(s);
                tbls.delStagiaire(s);
                btnEditStag.setEnabled(false);
                btnDelStag.setEnabled(false);
            } catch (Exception ex) {
                Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_btnDelStagActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddStBtn;
    private javax.swing.JPanel AddStagPanel;
    private javax.swing.JTable TableauFormation;
    private javax.swing.JTable TableauStagiaire;
    private javax.swing.JButton btnAddEcf;
    private javax.swing.JButton btnAddForm;
    private javax.swing.JButton btnAddStag;
    private javax.swing.JButton btnDelEcf;
    private javax.swing.JButton btnDelForm;
    private javax.swing.JButton btnDelStag;
    private javax.swing.JButton btnEditEcf;
    private javax.swing.JButton btnEditForm;
    private javax.swing.JButton btnEditStag;
    private javax.swing.JComboBox<Formation> comboAddStag;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField textFieldNom;
    private javax.swing.JTextField textFieldPrenom;
    // End of variables declaration//GEN-END:variables

}