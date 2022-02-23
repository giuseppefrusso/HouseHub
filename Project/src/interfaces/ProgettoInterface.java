/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Pepito
 */
public class ProgettoInterface extends javax.swing.JFrame {

    private final String user;
    private File progettoDirectory;

    /**
     * Creates new form ProgettoInterface
     */
    public ProgettoInterface() {
        this.user = "NON_ADMIN";
        initComponents();
        capitolatoButton.setEnabled(false);
        schermataIniziale();
    }

    public ProgettoInterface(String user) {
        this.user = user;
        initComponents();
        schermataIniziale();
    }

    private void schermataIniziale() {
        computoComboBox.setEnabled(false);
        computoLabel.setText("");
        visualizzaComputoButton.setEnabled(false);
        createComputoButton.setEnabled(false);
    }

    public ProgettoInterface(String user, File progettoDirectory) {
        this.user = user;
        this.progettoDirectory = progettoDirectory;
        initComponents();
        schermataProgetto();
        computoLabel.setText("");
    }

    private void schermataProgetto() {
        computoComboBox.setEnabled(true);
        visualizzaComputoButton.setEnabled(true);
        createComputoButton.setEnabled(true);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HouseHub");
        setResizable(false);

        panel.setBackground(new java.awt.Color(240, 245, 58));
        panel.setLayout(new java.awt.GridBagLayout());

        openProgettoButton.setText("Apri progetto");
        openProgettoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openProgettoButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panel.add(openProgettoButton, gridBagConstraints);

        computoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                computoComboBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panel.add(computoComboBox, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panel.add(computoComboBox1, gridBagConstraints);

        computoLabel.setText("DATA E TOTALE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 11;
        panel.add(computoLabel, gridBagConstraints);

        createProgettoButton.setText("Crea progetto");
        createProgettoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createProgettoButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panel.add(createProgettoButton, gridBagConstraints);

        visualizzaComputoButton.setText("Visualizza");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panel.add(visualizzaComputoButton, gridBagConstraints);

        createComputoButton.setText("Crea nuovo computo");
        createComputoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createComputoButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        panel.add(createComputoButton, gridBagConstraints);

        capitolatoButton.setBackground(new java.awt.Color(255, 51, 51));
        capitolatoButton.setText("Capitolato");
        capitolatoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capitolatoButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panel.add(capitolatoButton, gridBagConstraints);

        jLabel2.setText("Progetto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 12;
        panel.add(jLabel2, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openProgettoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openProgettoButtonActionPerformed
        //Scegli cartella da aprire
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Apri la cartella del progetto: ");
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);


        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (jfc.getSelectedFile().isDirectory()) {
                progettoDirectory = jfc.getSelectedFile();
                System.out.println("You selected the directory: " + progettoDirectory);
            } else {
                JOptionPane.showMessageDialog(this, "Non hai selezionato una cartella", "Avviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } else {
            return;
        }

        //visualizza il progetto corrente nella scheda Computo
        schermataProgetto();
        for (File entry : progettoDirectory.listFiles((File dir, String name) -> {
            return name.startsWith("computo") && name.endsWith(".csv");
        })) {
            computoComboBox.addItem(entry.toString());
        }
    }//GEN-LAST:event_openProgettoButtonActionPerformed

    private void createProgettoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createProgettoButtonActionPerformed
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Scegli la cartella dove salvare il progetto: ");
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        File createdProgettoDirectory;

        int returnValue = jfc.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (jfc.getSelectedFile().isDirectory()) {
                createdProgettoDirectory = jfc.getSelectedFile();
                System.out.println("You selected the directory: " + createdProgettoDirectory);
            } else {
                JOptionPane.showMessageDialog(this, "Non hai selezionato una cartella", "Avviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } else {
            return;
        }

        File recapFile = new File(createdProgettoDirectory.toString() + "/recap.csv");
        try {
            if (!recapFile.createNewFile()) {
                JOptionPane.showMessageDialog(this, "Questa cartella contiene già un progetto", "Avviso",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (IOException ex) {
            Logger.getLogger(ProgettoInterface.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        //Apri finestra per inserire dati dell'utente
        EventQueue.invokeLater(() -> {
            new UtentePerProgettoInterface(user, jfc.getSelectedFile()).setVisible(true);
            dispose();
        });

        //Recupera il controllo e visualizza il progetto corrente nella scheda Computo
    }//GEN-LAST:event_createProgettoButtonActionPerformed
    
    private void createComputoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createComputoButtonActionPerformed
        String computoName = JOptionPane.showInputDialog(this, "Scegli il nome del computo (il nome del file sarà computo_***.csv)");
        
        //Creazione del nuovo file di computo e controllo che non esista già un computo col nome scelto
        File computoFile = new File(progettoDirectory.toString() + "/computo_"+computoName+".csv");
        try {
            if (!computoFile.createNewFile()) {
                JOptionPane.showMessageDialog(this, "Questo computo esiste già", "Avviso",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Errore",
                        JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //Scrittura del nuovo computo su file di recap (senza totale)
        try {
            BufferedWriter csvWriter = new BufferedWriter(new FileWriter(progettoDirectory.toString() + "/recap.csv"));
            csvWriter.append(computoFile.getName()+","+LocalDate.now()+","+0.0);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
        
        
        EventQueue.invokeLater(() -> {
            new ComputoInterface().setVisible(true);
            dispose();
        });

        //Recupera il controllo e visualizza il computo corrente
    }//GEN-LAST:event_createComputoButtonActionPerformed

    private void capitolatoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capitolatoButtonActionPerformed
        EventQueue.invokeLater(() -> {
            new CapitolatoInterface(user).setVisible(true);
            dispose();
        });
    }//GEN-LAST:event_capitolatoButtonActionPerformed

    private void computoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_computoComboBoxActionPerformed
        String selectedComputo = (String) computoComboBox.getSelectedItem();

        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(progettoDirectory.toString() + "/recap.csv"));
            String row;
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                if (data[0].equals(selectedComputo)) {
                    computoLabel.setText("DATA: " + data[1] + ", TOTALE: " + data[2]);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_computoComboBoxActionPerformed

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
                new ProgettoInterface("Emanuele").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton capitolatoButton;
    private javax.swing.JComboBox<String> computoComboBox;
    private javax.swing.JComboBox<String> computoComboBox1;
    private javax.swing.JLabel computoLabel;
    private javax.swing.JButton createComputoButton;
    private javax.swing.JButton createProgettoButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton openProgettoButton;
    private javax.swing.JPanel panel;
    private javax.swing.JButton visualizzaComputoButton;
    // End of variables declaration//GEN-END:variables
}
