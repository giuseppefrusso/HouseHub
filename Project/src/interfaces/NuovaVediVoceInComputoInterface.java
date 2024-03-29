/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.EventQueue;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Computo;
import models.VoceComputo;

/**
 *
 * @author Pepito
 */
public class NuovaVediVoceInComputoInterface extends javax.swing.JFrame {

    private VoceComputo voce;
    private Computo computo;
    private String fileProgetto;
    private DefaultTableModel model;

    /**
     * Creates new form NuovaVoceInComputoInterface
     *
     * @param computo
     * @param fileProgetto
     */
    public NuovaVediVoceInComputoInterface(VoceComputo voce, Computo computo, String fileProgetto) {
        this.voce = voce;
        this.computo = computo;
        this.fileProgetto = fileProgetto;
        initComponents();
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        model = (DefaultTableModel) table.getModel();
        fillTableModel();
    }

    private void fillTableModel() {
        //rimuovere le voci gia presenti nel vedivoce
        for (Integer numProgr : computo.getVociComputo().keySet()) {
            VoceComputo v = computo.getVociComputo().get(numProgr);
            if (numProgr < voce.getNumeroProgressivo() && !voce.getVediVoce().contains(numProgr)) {
                Object[] rowData = {numProgr, v.getCodice(), v.getDescrizione(), v.getUnitaDiMisura(), v.getPrezzoUnitario(), false};
                model.addRow(rowData);
            }
        }

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

        jPanel2 = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        table.setDefaultRenderer(String.class, new MultiLineTableCellRenderer());
        jPanel3 = new javax.swing.JPanel();
        confermaButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("House Hub");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(149, 165, 166));
        jPanel2.setLayout(new java.awt.BorderLayout());

        table.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Codice", "Descrizione", "Unità di misura", "Quantità", "Scegli"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowSelectionAllowed(false);
        table.setShowHorizontalLines(true
        );
        table.setShowVerticalLines(true);
        scrollPane.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(50);
            table.getColumnModel().getColumn(0).setMaxWidth(50);
            table.getColumnModel().getColumn(5).setMinWidth(50);
            table.getColumnModel().getColumn(5).setPreferredWidth(50);
            table.getColumnModel().getColumn(5).setMaxWidth(50);
        }

        jPanel2.add(scrollPane, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(149, 165, 166));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        confermaButton.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        confermaButton.setText("Conferma");
        confermaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confermaButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel3.add(confermaButton, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confermaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confermaButtonActionPerformed
        for (int i = 0; i < model.getRowCount(); i++) {
            if ((Boolean) model.getValueAt(i, 5)) {
                int numProgr = (int) model.getValueAt(i, 0);
                voce.aggiungiVediVoce(numProgr, 0, 0, 0);
            }
        }

        try {
            computo.rimuoviVoce(voce.getNumeroProgressivo());
            computo.aggiungiVoce(voce);
            computo.salvaComputoInProgetto(fileProgetto);
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Errore", JOptionPane.ERROR_MESSAGE);
        }

        backToComputoInterface();
    }//GEN-LAST:event_confermaButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        backToComputoInterface();
    }//GEN-LAST:event_formWindowClosing

    private void backToComputoInterface() {
        EventQueue.invokeLater(() -> {
            new VoceComputoInterface().setVisible(true);
            dispose();
        });
    }

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
            java.util.logging.Logger.getLogger(NuovaVediVoceInComputoInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuovaVediVoceInComputoInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuovaVediVoceInComputoInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuovaVediVoceInComputoInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
 /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuovaVoceInComputoInterface(new Computo("computo"), "progetto.hhp").setVisible(true);
            }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
 /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuovaVoceInComputoInterface(new Computo("computo"), "progetto.hhp").setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confermaButton;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
