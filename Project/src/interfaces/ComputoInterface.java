/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;

import pdfgenerator.PDFGenerator;

import models.Computo;
import models.VoceComputo;

/**
 *
 * @author Pepito
 */
public class ComputoInterface extends javax.swing.JFrame {

    private static Computo computo;
    private static String fileProgetto;
    protected DefaultTableModel model;

    /**
     * Creates new form ComputoInterface
     *
     * @param computo
     * @param fileProgetto
     */
    public ComputoInterface(Computo computo, String fileProgetto) {
        ComputoInterface.computo = computo;
        ComputoInterface.fileProgetto = fileProgetto;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        model = (DefaultTableModel) table.getModel();
        refreshTable();
        titleLabel.setText("Computo metrico: " + computo.getNome());
    }

    public ComputoInterface() {
        try {
            ComputoInterface.computo = Computo.caricaComputoDaProgetto(fileProgetto, computo.getNome());
            if (computo == null) {
                EventQueue.invokeLater(() -> {
                    new CapitolatoInterface().setVisible(true);
                    dispose();
                });
                return;
            }
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        model = (DefaultTableModel) table.getModel();
        refreshTable();
        titleLabel.setText("Computo metrico: " + computo.getNome());
    }

    private void refreshTable() {
        model.setRowCount(0);

        for (VoceComputo voce : computo.getVociComputo().values()) {
            Object[] row = {voce.getNumeroProgressivo(), voce.getCodice(), voce.getDescrizione(), voce.vediVoceToString(),
                voce.getUnitaDiMisura(), voce.partiUgualiToString(), voce.lunghezzeToString(), voce.larghezzeToString(),
                voce.altezzePesiToString(), voce.getQuantita(computo), voce.getPrezzoUnitario(), voce.getPrezzoComplessivo(computo)};

            model.addRow(row);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        table.setDefaultRenderer(String.class, new MultiLineTableCellRenderer());
        titleLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        aggiungiButton = new javax.swing.JButton();
        gestisciVoceButton = new javax.swing.JButton();
        exportForSub = new javax.swing.JButton();
        exportForClient = new javax.swing.JButton();
        progettoButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        upButton = new javax.swing.JButton();
        downButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("House Hub");
        setBackground(new java.awt.Color(255, 255, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
                "N°", "Codice", "Descrizione", "Vedi voce", "Unità di misura", "Parti uguali", "Lunghezza", "Larghezza", "Altezza/peso", "Quantità", "Prezzo unitario", "Prezzo complessivo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(50);
            table.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        titleLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Computo metrico");
        jPanel2.add(titleLabel, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(149, 165, 166));
        jPanel1.setMaximumSize(new java.awt.Dimension(686, 195));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 150));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        aggiungiButton.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        aggiungiButton.setText("Aggiungi nuova voce");
        aggiungiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aggiungiButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(69, 37, 0, 10);
        jPanel1.add(aggiungiButton, gridBagConstraints);

        gestisciVoceButton.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        gestisciVoceButton.setText("Gestisci voce");
        gestisciVoceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestisciVoceButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(21, 37, 111, 0);
        jPanel1.add(gestisciVoceButton, gridBagConstraints);

        exportForSub.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        exportForSub.setText("Esporta per sub-appaltatori");
        exportForSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportForSubActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 52, 15, 28);
        jPanel1.add(exportForSub, gridBagConstraints);

        exportForClient.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        exportForClient.setText("Esporta per cliente");
        exportForClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportForClientActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 53, 106, 0);
        jPanel1.add(exportForClient, gridBagConstraints);

        progettoButton.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        progettoButton.setText("Progetto");
        progettoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progettoButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(73, 51, 0, 0);
        jPanel1.add(progettoButton, gridBagConstraints);

        deleteButton.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        deleteButton.setText("Elimina voce");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(25, 0, 10, 20);
        jPanel1.add(deleteButton, gridBagConstraints);

        upButton.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        upButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/up.png"))); // NOI18N
        upButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(70, 25, 0, 0);
        jPanel1.add(upButton, gridBagConstraints);

        downButton.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        downButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/down.png"))); // NOI18N
        downButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 25, 0, 0);
        jPanel1.add(downButton, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aggiungiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aggiungiButtonActionPerformed
        EventQueue.invokeLater(() -> {
            new NuovaVoceInComputoInterface(computo, fileProgetto).setVisible(true);
            dispose();
        });
    }//GEN-LAST:event_aggiungiButtonActionPerformed

    private void gestisciVoce() {
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleziona una voce del computo", "Avviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int selectedNumProgr = (int) model.getValueAt(selectedRow, 0);
        VoceComputo selectedVoce = computo.getVociComputo().get(selectedNumProgr);

        EventQueue.invokeLater(() -> {
            new VoceComputoInterface(selectedVoce, computo, fileProgetto).setVisible(true);
            //dispose();
        });
    }

    private void gestisciVoceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestisciVoceButtonActionPerformed
        gestisciVoce();
    }//GEN-LAST:event_gestisciVoceButtonActionPerformed

    private void progettoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progettoButtonActionPerformed
        EventQueue.invokeLater(() -> {
            new ProgettoInterface(true).setVisible(true);
            dispose();
        });
    }//GEN-LAST:event_progettoButtonActionPerformed

    private String chooseFileToSave(String dest) {
        //Scegli dove salvare file
        File homeDirectory = FileSystemView.getFileSystemView().getHomeDirectory();
        JFileChooser jfc = new JFileChooser(homeDirectory);
        jfc.setDialogTitle("Salva il computo per " + dest);
        jfc.setSelectedFile(new File(homeDirectory.toString() + "\\" + computo.getNome() + "_" + dest + ".pdf"));
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileFilter filter = new FileNameExtensionFilter("File PDF", "pdf");
        jfc.setFileFilter(filter);

        int returnValue = jfc.showSaveDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            String filepath = selectedFile.toString();
            if (!filepath.endsWith(".pdf")) {
                filepath = filepath.concat(".pdf");
                selectedFile = new File(filepath);
            }
            if (selectedFile.isFile()) {
                int choice = JOptionPane.showConfirmDialog(this, "Sei sicuro di voler sovrascrivere il file?");
                if (choice != JOptionPane.YES_OPTION) {
                    return null;
                }
            }
            System.out.println("You selected the file: " + filepath);
            return filepath;
        } else {
            return null;
        }
    }

    private void exportForClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportForClientActionPerformed
        String filePdf = chooseFileToSave("cliente");

        if (filePdf == null) {
            return;
        }

        try {
            PDFGenerator.generatePDF(fileProgetto, computo, filePdf, true);
        } catch (IOException | ClassNotFoundException | NullPointerException ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_exportForClientActionPerformed

    private void exportForSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportForSubActionPerformed
        String filePdf = chooseFileToSave("sub-appaltatori");

        if (filePdf == null) {
            return;
        }

        try {
            PDFGenerator.generatePDF(fileProgetto, computo, filePdf, false);
        } catch (IOException | ClassNotFoundException | NullPointerException ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_exportForSubActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleziona una voce del computo", "Avviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int selectedNumProgr = (int) model.getValueAt(selectedRow, 0);
        
        int choice = JOptionPane.showConfirmDialog(this, "Sei sicuro di voler eliminare la voce "+selectedNumProgr+"?");
        if(choice == JOptionPane.NO_OPTION || choice == JOptionPane.CANCEL_OPTION)
            return;

        for (VoceComputo c : computo.getVociComputo().values()) {
            if (selectedNumProgr >= c.getNumeroProgressivo()) {
                continue;
            }
            for (int numProg : c.getVediVoce()) {
                if (numProg == selectedNumProgr) {
                    JOptionPane.showMessageDialog(this, "La voce " + c.getNumeroProgressivo() + " contiene un riferimento a questa voce", "Avviso", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        }

        VoceComputo selectedVoce = computo.getVociComputo().get(selectedNumProgr);

        computo.rimuoviVoce(selectedVoce.getNumeroProgressivo());
        computo.shiftVoci(selectedNumProgr);
        try {
            computo.salvaComputoInProgetto(fileProgetto);
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
        refreshTable();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void upButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upButtonActionPerformed
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleziona una voce del computo", "Avviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int selectedNumProgr = (int) model.getValueAt(selectedRow, 0);

        if (selectedNumProgr <= 1) {
            JOptionPane.showMessageDialog(this, "Non puoi spostare in alto la prima voce", "Avviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        for (VoceComputo c : computo.getVociComputo().values()) {
            if (selectedNumProgr - 1 >= c.getNumeroProgressivo()) {
                continue;
            }
            for (int numProg : c.getVediVoce()) {

                if (numProg == selectedNumProgr) {
                    JOptionPane.showMessageDialog(this, "La voce " + c.getNumeroProgressivo() + " contiene un riferimento a questa voce", "Avviso", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (numProg == selectedNumProgr - 1) {
                    JOptionPane.showMessageDialog(this, "La voce " + c.getNumeroProgressivo() + " contiene un riferimento alla voce " + numProg, "Avviso", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        }

        VoceComputo selectedVoce = computo.getVociComputo().get(selectedNumProgr);

        VoceComputo swappedVoce = computo.getVociComputo().get(selectedNumProgr - 1);

        computo.rimuoviVoce(selectedVoce.getNumeroProgressivo());
        computo.rimuoviVoce(swappedVoce.getNumeroProgressivo());

        selectedVoce.setNumeroProgressivo(selectedNumProgr - 1);
        swappedVoce.setNumeroProgressivo(selectedNumProgr);

        computo.aggiungiVoce(selectedVoce);
        computo.aggiungiVoce(swappedVoce);

        try {
            computo.salvaComputoInProgetto(fileProgetto);
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
        refreshTable();
        table.addRowSelectionInterval(selectedRow - 1, selectedRow - 1);
    }//GEN-LAST:event_upButtonActionPerformed

    private void downButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downButtonActionPerformed
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleziona una voce del computo", "Avviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int selectedNumProgr = (int) model.getValueAt(selectedRow, 0);

        if (selectedNumProgr >= computo.getVociComputo().size()) {
            JOptionPane.showMessageDialog(this, "Non puoi spostare in basso l'ultima voce", "Avviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        for (VoceComputo c : computo.getVociComputo().values()) {
            if (selectedNumProgr >= c.getNumeroProgressivo()) {
                continue;
            }
            for (int numProg : c.getVediVoce()) {
                if (numProg == selectedNumProgr + 1) {
                    JOptionPane.showMessageDialog(this, "La voce " + c.getNumeroProgressivo() + " contiene un riferimento alla voce " + numProg, "Avviso", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (numProg == selectedNumProgr) {
                    JOptionPane.showMessageDialog(this, "La voce " + c.getNumeroProgressivo() + " contiene un riferimento a questa voce", "Avviso", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        }

        VoceComputo selectedVoce = computo.getVociComputo().get(selectedNumProgr);
        VoceComputo swappedVoce = computo.getVociComputo().get(selectedNumProgr + 1);

        computo.rimuoviVoce(selectedVoce.getNumeroProgressivo());
        computo.rimuoviVoce(swappedVoce.getNumeroProgressivo());

        selectedVoce.setNumeroProgressivo(selectedNumProgr + 1);
        swappedVoce.setNumeroProgressivo(selectedNumProgr);

        computo.aggiungiVoce(selectedVoce);
        computo.aggiungiVoce(swappedVoce);

        try {
            computo.salvaComputoInProgetto(fileProgetto);
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
        refreshTable();
        table.addRowSelectionInterval(selectedRow + 1, selectedRow + 1);
    }//GEN-LAST:event_downButtonActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            gestisciVoce();
        }
    }//GEN-LAST:event_tableMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        EventQueue.invokeLater(() -> {
            new ProgettoInterface(true).setVisible(true);
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
            java.util.logging.Logger.getLogger(ComputoInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComputoInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComputoInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComputoInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ComputoInterface(new Computo("computo"), "C:\\Users\\Pepito\\Desktop\\progetto.hhp").setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aggiungiButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton downButton;
    private javax.swing.JButton exportForClient;
    private javax.swing.JButton exportForSub;
    private javax.swing.JButton gestisciVoceButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton progettoButton;
    private javax.swing.JTable table;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton upButton;
    // End of variables declaration//GEN-END:variables
}
