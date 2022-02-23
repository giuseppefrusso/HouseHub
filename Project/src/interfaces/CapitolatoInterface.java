/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.EventQueue;

/**
 *
 * @author Pepito
 */
public class CapitolatoInterface extends javax.swing.JFrame {

    private final String user;
    
    /**
     * Creates new form UserInterface
     * @param user
     */
    public CapitolatoInterface(String user) {
        this.user = user;
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
        java.awt.GridBagConstraints gridBagConstraints;

        capitolatoPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        addVoceButton = new javax.swing.JButton();
        deleteVoceButton = new javax.swing.JButton();
        modifyVoceButton = new javax.swing.JButton();
        progettoButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HouseHub");

        capitolatoPanel.setBackground(new java.awt.Color(240, 245, 58));
        capitolatoPanel.setLayout(new java.awt.GridBagLayout());

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("CAPITOLATO CLIENTI");
        jLabel5.setMaximumSize(new java.awt.Dimension(100, 17));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        capitolatoPanel.add(jLabel5, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("CAPITOLATO SUB-APPALTATORI");
        jLabel6.setPreferredSize(new java.awt.Dimension(150, 17));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        capitolatoPanel.add(jLabel6, gridBagConstraints);

        jTable1.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codice", "Descrizione", "Unità di misura", "Prezzo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        capitolatoPanel.add(jScrollPane1, gridBagConstraints);

        jTable2.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codice", "Descrizione", "Unità di misura", "Prezzo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        capitolatoPanel.add(jScrollPane2, gridBagConstraints);

        addVoceButton.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        addVoceButton.setText("Aggiungi nuova voce");
        addVoceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVoceButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        capitolatoPanel.add(addVoceButton, gridBagConstraints);

        deleteVoceButton.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        deleteVoceButton.setText("Elimina voce");
        deleteVoceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteVoceButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        capitolatoPanel.add(deleteVoceButton, gridBagConstraints);

        modifyVoceButton.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        modifyVoceButton.setText("Apporta modifiche");
        modifyVoceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyVoceButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        capitolatoPanel.add(modifyVoceButton, gridBagConstraints);

        progettoButton.setText("Progetti");
        progettoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progettoButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        capitolatoPanel.add(progettoButton, gridBagConstraints);

        jLabel1.setText("Capitolato");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        capitolatoPanel.add(jLabel1, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(capitolatoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 929, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 15, Short.MAX_VALUE)
                .addComponent(capitolatoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modifyVoceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyVoceButtonActionPerformed
        // Salva su file con path e nome predefiniti
    }//GEN-LAST:event_modifyVoceButtonActionPerformed

    private void deleteVoceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteVoceButtonActionPerformed
        //Bisogna prima aver selezionato la voce
    }//GEN-LAST:event_deleteVoceButtonActionPerformed

    private void addVoceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVoceButtonActionPerformed
        //Nuova interfaccia per inserire la nuova voce

        //Recupera il controllo e visualizza le voci
    }//GEN-LAST:event_addVoceButtonActionPerformed

    private void progettoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progettoButtonActionPerformed
        EventQueue.invokeLater(() -> {
            new ProgettoInterface(user).setVisible(true);
            dispose();
        });
    }//GEN-LAST:event_progettoButtonActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CapitolatoInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CapitolatoInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CapitolatoInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CapitolatoInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CapitolatoInterface("Emanuele").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addVoceButton;
    private javax.swing.JPanel capitolatoPanel;
    private javax.swing.JButton deleteVoceButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton modifyVoceButton;
    private javax.swing.JButton progettoButton;
    // End of variables declaration//GEN-END:variables
}