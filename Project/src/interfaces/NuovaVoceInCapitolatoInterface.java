/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.EventQueue;
import javax.swing.JOptionPane;
import models.Computo;
import models.Voce;

/**
 *
 * @author Pepito
 */
public class NuovaVoceInCapitolatoInterface extends javax.swing.JFrame {

    private boolean flag = false;
    private Voce voceCliente;
    private Voce voceSubAppaltatori;

    /**
     * Creates new form NuovaVoceInCapitolatoInterface
     *
     */
    public NuovaVoceInCapitolatoInterface() {
        initComponents();
        nuovaVoceLabel.setText("Nuova voce cliente");
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

        jPanel1 = new javax.swing.JPanel();
        confermaButton = new javax.swing.JButton();
        indietroButton = new javax.swing.JButton();
        nuovaVoceLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        codiceTextField = new javax.swing.JTextField();
        misuraTextField = new javax.swing.JTextField();
        prezzoTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descrizioneTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("House Hub");
        setPreferredSize(new java.awt.Dimension(800, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(149, 165, 166));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        confermaButton.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        confermaButton.setText("Conferma");
        confermaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confermaButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        jPanel1.add(confermaButton, gridBagConstraints);

        indietroButton.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        indietroButton.setText("Indietro");
        indietroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indietroButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        jPanel1.add(indietroButton, gridBagConstraints);

        nuovaVoceLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        nuovaVoceLabel.setText("Nuova voce");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 11, 0);
        jPanel1.add(nuovaVoceLabel, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel1.setText("Codice");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel2.setText("Descrizione");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 7, 0);
        jPanel1.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel3.setText("Unità di misura");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 7, 2);
        jPanel1.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel4.setText("Prezzo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel1.add(jLabel4, gridBagConstraints);

        codiceTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 0);
        jPanel1.add(codiceTextField, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 7, 0);
        jPanel1.add(misuraTextField, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 0);
        jPanel1.add(prezzoTextField, gridBagConstraints);

        descrizioneTextArea.setColumns(20);
        descrizioneTextArea.setLineWrap(true);
        descrizioneTextArea.setRows(5);
        jScrollPane1.setViewportView(descrizioneTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 7, 0);
        jPanel1.add(jScrollPane1, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confermaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confermaButtonActionPerformed
        Double prezzo;
        if (codiceTextField.getText().equals("") || descrizioneTextArea.getText().equals("") || misuraTextField.getText().equals("")
                || prezzoTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Non hai riempito tutti i campi", "Avviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            prezzo = Double.parseDouble(prezzoTextField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Il prezzo non è corretto", "Avviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (flag == false) {
            int choice = JOptionPane.showConfirmDialog(this, "Sei sicuro di voler inserire la voce in capitolato clienti?");
            if (choice == JOptionPane.YES_OPTION) {

                voceCliente = new Voce(codiceTextField.getText(), descrizioneTextArea.getText(), misuraTextField.getText(),
                        prezzo);
                flag = true;
                codiceTextField.setEditable(false);
                misuraTextField.setEditable(false);
                nuovaVoceLabel.setText("Nuova voce sub-appaltatori");

            }

        } else {

            int choice = JOptionPane.showConfirmDialog(this, "Sei sicuro di voler inserire la voce in capitolato sub-appaltatori?");
            if (choice == JOptionPane.YES_OPTION) {
                voceSubAppaltatori = new Voce(codiceTextField.getText(), descrizioneTextArea.getText(), misuraTextField.getText(),
                        prezzo);
                EventQueue.invokeLater(() -> {
                    new CapitolatoInterface(voceCliente, voceSubAppaltatori).setVisible(true);
                    dispose();
                });
            }
        }
    }//GEN-LAST:event_confermaButtonActionPerformed

    private void indietroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indietroButtonActionPerformed
        EventQueue.invokeLater(() -> {
            new CapitolatoInterface().setVisible(true);
            dispose();
        });
    }//GEN-LAST:event_indietroButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        EventQueue.invokeLater(() -> {
            new CapitolatoInterface().setVisible(true);
            dispose();
        });
    }//GEN-LAST:event_formWindowClosing


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
            java.util.logging.Logger.getLogger(NuovaVoceInCapitolatoInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuovaVoceInCapitolatoInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuovaVoceInCapitolatoInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuovaVoceInCapitolatoInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuovaVoceInCapitolatoInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codiceTextField;
    private javax.swing.JButton confermaButton;
    private javax.swing.JTextArea descrizioneTextArea;
    private javax.swing.JButton indietroButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField misuraTextField;
    private javax.swing.JLabel nuovaVoceLabel;
    private javax.swing.JTextField prezzoTextField;
    // End of variables declaration//GEN-END:variables
}
