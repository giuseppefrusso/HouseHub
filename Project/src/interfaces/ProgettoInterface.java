/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import models.Computo;
import models.Progetto;

/**
 *
 * @author Pepito
 */
public class ProgettoInterface extends javax.swing.JFrame {

    private static String user;
    private static String fileProgetto;

    /**
     * Creates new form ProgettoInterface
     *
     * @param toEnable
     */
    public ProgettoInterface(boolean toEnable) {
        initComponents();
        controlloUtente();
        if (toEnable) {
            schermataProgetto();
        } else {
            schermataIniziale();
        }
    }

    public ProgettoInterface(String user, boolean toEnable) {
        ProgettoInterface.user = user;
        initComponents();
        controlloUtente();
        if (toEnable) {
            schermataProgetto();
        } else {
            schermataIniziale();
        }
    }

    private void controlloUtente() {
        if (ProgettoInterface.user.equals("NON_ADMIN")) {
            capitolatoButton.setEnabled(false);
        } else {
            capitolatoButton.setEnabled(true);
        }
    }

    private void schermataIniziale() {
        clienteButton.setEnabled(false);
        computoComboBox.setEnabled(false);
        computoLabel.setText("");
        visualizzaComputoButton.setEnabled(false);
        deleteComputoButton.setEnabled(false);
        createComputoButton.setEnabled(false);
    }

    private void schermataProgetto() {
        clienteButton.setEnabled(true);
        computoComboBox.setEnabled(true);
        visualizzaComputoButton.setEnabled(true);
        deleteComputoButton.setEnabled(true);
        createComputoButton.setEnabled(true);

        refreshComboBox();
        setComputoLabel();
    }

    private void setComputoLabel() {
        Computo selectedComputo = (Computo) computoComboBox.getSelectedItem();
        if (selectedComputo == null) {
            computoLabel.setText("");
        } else {
            computoLabel.setText("Data: " + selectedComputo.getData() + ", totale: " + selectedComputo.getTotale());
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

        panel = new javax.swing.JPanel();
        openProgettoButton = new javax.swing.JButton();
        computoComboBox = new javax.swing.JComboBox<>();
        computoComboBox1 = new javax.swing.JComboBox<>();
        computoLabel = new javax.swing.JLabel();
        createProgettoButton = new javax.swing.JButton();
        visualizzaComputoButton = new javax.swing.JButton();
        createComputoButton = new javax.swing.JButton();
        capitolatoButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        deleteComputoButton = new javax.swing.JButton();
        clienteButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HouseHub");
        setResizable(false);

        panel.setBackground(new java.awt.Color(149, 165, 166));
        panel.setLayout(new java.awt.GridBagLayout());

        openProgettoButton.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        openProgettoButton.setText("Apri progetto esistente");
        openProgettoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openProgettoButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 15, 0);
        panel.add(openProgettoButton, gridBagConstraints);

        computoComboBox.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        computoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                computoComboBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 15, 0);
        panel.add(computoComboBox, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panel.add(computoComboBox1, gridBagConstraints);

        computoLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        computoLabel.setText("DATA E TOTALE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 11;
        panel.add(computoLabel, gridBagConstraints);

        createProgettoButton.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        createProgettoButton.setText("Crea progetto");
        createProgettoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createProgettoButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        panel.add(createProgettoButton, gridBagConstraints);

        visualizzaComputoButton.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        visualizzaComputoButton.setText("Visualizza computo");
        visualizzaComputoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizzaComputoButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 15, 0);
        panel.add(visualizzaComputoButton, gridBagConstraints);

        createComputoButton.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        createComputoButton.setText("Crea nuovo computo");
        createComputoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createComputoButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 15, 0);
        panel.add(createComputoButton, gridBagConstraints);

        capitolatoButton.setBackground(new java.awt.Color(255, 51, 51));
        capitolatoButton.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        capitolatoButton.setText("Capitolato");
        capitolatoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capitolatoButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        panel.add(capitolatoButton, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel2.setText("Gestione progetto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 7, 0);
        panel.add(jLabel2, gridBagConstraints);

        deleteComputoButton.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        deleteComputoButton.setText("Elimina computo");
        deleteComputoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteComputoButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        panel.add(deleteComputoButton, gridBagConstraints);

        clienteButton.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        clienteButton.setText("Cliente");
        clienteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        panel.add(clienteButton, gridBagConstraints);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/portrait.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        panel.add(jLabel1, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openProgettoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openProgettoButtonActionPerformed
        //Scegli file da aprire
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Apri il file del progetto");
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileFilter filter = new FileNameExtensionFilter("Progetto HouseHub", "hhp");
        jfc.setFileFilter(filter);

        int returnValue = jfc.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (jfc.getSelectedFile().isFile()) {
                fileProgetto = jfc.getSelectedFile().toString();
                System.out.println("You selected the file: " + fileProgetto);
            } else {
                return;
            }
        } else {
            return;
        }

        schermataProgetto();
    }//GEN-LAST:event_openProgettoButtonActionPerformed

    private void refreshComboBox() {
        //visualizza il progetto corrente nella scheda Computo
        computoComboBox.removeAllItems();

        try {
            Progetto progetto = Progetto.caricaProgetto(fileProgetto);
            HashMap<String, Computo> computi = progetto.getListaComputi();
            for (Computo c : computi.values()) {
                computoComboBox.addItem(c);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Progetto non trovato", "Avviso", JOptionPane.WARNING_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Il file del progetto è corrotto", "Avviso", JOptionPane.WARNING_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createProgettoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createProgettoButtonActionPerformed
        //Scegli dove salvare file
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Salva il file del progetto");
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileFilter filter = new FileNameExtensionFilter("File HouseHub", "hhp");
        jfc.setFileFilter(filter);

        int returnValue = jfc.showSaveDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (jfc.getSelectedFile().isFile()) {
                int choice = JOptionPane.showConfirmDialog(this, "Sei sicuro di voler sovrascrivere il file?");
                if (choice != JOptionPane.YES_OPTION) {
                    return;
                }
            }
            fileProgetto = jfc.getSelectedFile().toString();
            if (!fileProgetto.endsWith(".hhp")) {
                fileProgetto = fileProgetto.concat(".hhp");
            }
            System.out.println("You selected the file: " + fileProgetto);
        } else {
            return;
        }

        //Apri finestra per inserire dati dell'utente
        EventQueue.invokeLater(() -> {
            new UtentePerProgettoInterface(user, fileProgetto).setVisible(true);
            dispose();
        });

        //Recupera il controllo e visualizza il progetto corrente nella scheda Computo
    }//GEN-LAST:event_createProgettoButtonActionPerformed

    private void createComputoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createComputoButtonActionPerformed
        String computoName = JOptionPane.showInputDialog(this, "Scegli il nome del computo", "Nuovo computo", JOptionPane.QUESTION_MESSAGE);
        if (computoName == null) {
            return;
        }

        Computo computo = new Computo(computoName);

        EventQueue.invokeLater(() -> {
            new ComputoInterface(computo, fileProgetto).setVisible(true);
            dispose();
        });

        //Recupera il controllo e visualizza il computo corrente
    }//GEN-LAST:event_createComputoButtonActionPerformed

    private void capitolatoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capitolatoButtonActionPerformed
        EventQueue.invokeLater(() -> {
            new CapitolatoInterface().setVisible(true);
            dispose();
        });
    }//GEN-LAST:event_capitolatoButtonActionPerformed

    private void computoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_computoComboBoxActionPerformed
        setComputoLabel();
    }//GEN-LAST:event_computoComboBoxActionPerformed

    private void visualizzaComputoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizzaComputoButtonActionPerformed
        Computo computo = (Computo) computoComboBox.getSelectedItem();

        if (computo == null) {
            JOptionPane.showMessageDialog(this, "Non è stato selezionato alcun computo", "Avviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        EventQueue.invokeLater(() -> {
            new ComputoInterface(computo, fileProgetto).setVisible(true);
            dispose();
        });
    }//GEN-LAST:event_visualizzaComputoButtonActionPerformed

    private void deleteComputoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteComputoButtonActionPerformed
        Computo computo = (Computo) computoComboBox.getSelectedItem();

        if (computo == null) {
            JOptionPane.showMessageDialog(this, "Non è stato selezionato alcun computo", "Avviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            Progetto p = Progetto.caricaProgetto(fileProgetto);
            p.rimuoviComputo(computo);
            p.salvaProgetto(fileProgetto);
            refreshComboBox();
            setComputoLabel();
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteComputoButtonActionPerformed

    private void clienteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteButtonActionPerformed
        try {
            Progetto p = Progetto.caricaProgetto(fileProgetto);
            JOptionPane.showMessageDialog(this, p.getUtente(), "Cliente", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_clienteButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ProgettoInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProgettoInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProgettoInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProgettoInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProgettoInterface("Emanuele Sellitto", false).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton capitolatoButton;
    private javax.swing.JButton clienteButton;
    private javax.swing.JComboBox<Computo> computoComboBox;
    private javax.swing.JComboBox<String> computoComboBox1;
    private javax.swing.JLabel computoLabel;
    private javax.swing.JButton createComputoButton;
    private javax.swing.JButton createProgettoButton;
    private javax.swing.JButton deleteComputoButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton openProgettoButton;
    private javax.swing.JPanel panel;
    private javax.swing.JButton visualizzaComputoButton;
    // End of variables declaration//GEN-END:variables
}
