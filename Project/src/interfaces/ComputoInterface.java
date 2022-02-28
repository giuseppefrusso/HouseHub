/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.EventQueue;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import models.Computo;
import models.Progetto;
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
        model = initTableModel();
        refreshTable();
        ComputoInterface.fileProgetto = fileProgetto;
        initComponents();
        titleLabel.setText("Computo metrico: " + computo.getNome());
    }

    public ComputoInterface() {
        model = initTableModel();
        initComponents();
        refreshTable();
        titleLabel.setText("Computo metrico: " + computo.getNome());
    }

    private DefaultTableModel initTableModel() {
        DefaultTableModel tm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                switch (column) {
                    case 3:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        //case 9: //quantita
                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public Class getColumnClass(int columnIndex) {
                switch (columnIndex) {
                    case 0:
                    case 3:
                        return Integer.class;
                    case 1:
                    case 2:
                    case 4:
                        return String.class;
                    default:
                        return Double.class;
                }
            }
        };
        tm.addColumn("N.");
        tm.addColumn("Codice");
        tm.addColumn("Descrizione");
        tm.addColumn("Vedi voce");
        tm.addColumn("Unità di misura");
        tm.addColumn("Parti uguali");
        tm.addColumn("Lunghezza");
        tm.addColumn("Larghezza");
        tm.addColumn("Altezza/peso");
        tm.addColumn("Quantità");
        tm.addColumn("Prezzo unitario");
        tm.addColumn("Prezzo complessivo");

        return tm;
    }

    private void refreshTable() {
        model.setRowCount(0);

        for (VoceComputo voce : computo.getVociComputo().values()) {
            double pu = voce.getDimensioni()[0], lung = voce.getDimensioni()[1],
                    larg = voce.getDimensioni()[2], h = voce.getDimensioni()[3];

            Object[] row = {voce.getNumeroProgressivo(), voce.getCodice(), voce.getDescrizione(), voce.getUnitaDiMisura(),
                pu, lung, larg, h, voce.getQuantita(), voce.getPrezzoUnitario(), voce.getPrezzoComplessivo()};

            model.addRow(row);
        }
    }

    private void save() {
        //SALVARE COSI' NON E' IL MODO MIGLIORE, MEGLIO SETTARE DI VOLTA IN VOLTA OGNI ATTRIBUTO MODIFICATO
        //IN OGNI CASO, SALVARE A OGNI MODIFICA O METTERE UN BOTTONE DI SALVA? SE SI SALVA CON BOTTONE, METTERE FLAG "saved" COME IN UN'ALTRA INTERFACE 
        
        computo.svuotaVociComputo();
        for (int i = 0; i < model.getRowCount(); i++) {
            int numProg = (int) model.getValueAt(i, 0);
            String codice = (String) model.getValueAt(i, 1);
            String desc = (String) model.getValueAt(i, 2);
            int vediVoceNum = (Integer) model.getValueAt(i, 3);
            String unita = (String) model.getValueAt(i, 4);
            double pu = (Double) model.getValueAt(i, 5);
            double lung = (Double) model.getValueAt(i, 6);
            double larg = (Double) model.getValueAt(i, 7);
            double h = (Double) model.getValueAt(i, 8);
            double quant = (Double) model.getValueAt(i, 9);
            double prezzoU = (Double) model.getValueAt(i, 10);
            double prezzoC = (Double) model.getValueAt(i, 11);

            VoceComputo vediVoce;
            if (vediVoceNum == 0) {
                vediVoce = null;
            } else {
                vediVoce = computo.getVociComputo().get(vediVoceNum);
            }

            double[] dimensioni = {pu, lung, larg, h};

            computo.aggiungiVoce(new VoceComputo(numProg, codice, desc, vediVoce, unita, dimensioni, prezzoU));
        }

        
        //QUESTO E' UN PASSAGGIO COMPLETAMENTE DIVERSO DAL PRECEDENTE, SERVE A SALVARE IL COMPUTO AGGIORNATO SUL FILE DI PROGETTO
        Progetto p;
        try {
            p = Progetto.caricaProgetto(fileProgetto);
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Errore", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //sicuro che basti questo a salvare tutto sul file progetto?
        p.rimuoviComputo(computo);
        p.aggiungiComputo(computo);
        try {
            p.salvaProgetto(fileProgetto);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
        //
        
        refreshTable();
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
        aggiungiButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        gestisciVoceButton = new javax.swing.JButton();
        progettoButton = new javax.swing.JButton();
        exportForSub = new javax.swing.JButton();
        exportForClient = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("House Hub");
        setBackground(new java.awt.Color(255, 255, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBackground(new java.awt.Color(240, 245, 58));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        table.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        table.setModel(model);
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tableKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel2.add(jScrollPane2, gridBagConstraints);

        aggiungiButton.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        aggiungiButton.setText("Aggiungi nuova voce");
        aggiungiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aggiungiButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel2.add(aggiungiButton, gridBagConstraints);

        titleLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Computo metrico");
        jPanel2.add(titleLabel, new java.awt.GridBagConstraints());

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
        jPanel2.add(gestisciVoceButton, gridBagConstraints);

        progettoButton.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        progettoButton.setText("Progetto");
        progettoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progettoButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        jPanel2.add(progettoButton, gridBagConstraints);

        exportForSub.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        exportForSub.setText("Esporta per sub-appaltatori");
        exportForSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportForSubActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        jPanel2.add(exportForSub, gridBagConstraints);

        exportForClient.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        exportForClient.setText("Esporta per cliente");
        exportForClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportForClientActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        jPanel2.add(exportForClient, gridBagConstraints);

        saveButton.setText("Salva computo");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jPanel2.add(saveButton, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aggiungiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aggiungiButtonActionPerformed
        EventQueue.invokeLater(() -> {
            new NuovaVoceInComputoInterface(computo).setVisible(true);
            dispose();
        });
    }//GEN-LAST:event_aggiungiButtonActionPerformed

    private void gestisciVoceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestisciVoceButtonActionPerformed
        int selectedRow = table.getSelectedRow();
        int selectedNumProgr = (int) model.getValueAt(selectedRow, 0);
        VoceComputo selectedVoce = computo.getVociComputo().get(selectedNumProgr);

        EventQueue.invokeLater(() -> {
            new VoceComputoInterface(selectedVoce).setVisible(true);
            dispose();
        });
    }//GEN-LAST:event_gestisciVoceButtonActionPerformed

    private void progettoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progettoButtonActionPerformed
        EventQueue.invokeLater(() -> {
            new ProgettoInterface(true).setVisible(true);
            dispose();
        });
    }//GEN-LAST:event_progettoButtonActionPerformed

    private void tableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyTyped
        //BISOGNA GESTIRE IL CASO IN CUI SI SCRIVA UN NON-DOUBLE IN UNA COLONNA DOUBLE
        //-> si potrebbe fare così: cancella ultimo carattere e rifai conversione e cosi' via
        
        int selectedRow = table.getSelectedRow(), selectedColumn = table.getSelectedColumn();
        Object newValue = model.getValueAt(selectedRow, selectedColumn);
        System.out.println("You are writing '"+newValue+"' in cell ("+selectedRow+", "+selectedColumn+")");
        
        /*switch(selectedColumn) {
           //a seconda della colonna selezionata fare una set a un attributo diverso di VoceComputo 
           //il nuovo oggetto VoceComputo andrà aggiornato all'interno dell'oggetto computo. come?
        }*/
    }//GEN-LAST:event_tableKeyTyped

    private String chooseFileToSave(String dest) {
        //Scegli dove salvare file
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Salva il computo per " + dest);
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileFilter filter = new FileNameExtensionFilter("File PDF", "pdf");
        jfc.setFileFilter(filter);

        int returnValue = jfc.showSaveDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (jfc.getSelectedFile().isFile()) {
                int choice = JOptionPane.showConfirmDialog(this, "Sei sicuro di voler sovrascrivere il file?");
                if (choice != JOptionPane.YES_OPTION) {
                    return null;
                }
            }
            String filePdf = jfc.getSelectedFile().toString();
            if (!filePdf.endsWith(".pdf")) {
                filePdf = filePdf.concat(".pdf");
            }
            System.out.println("You selected the file: " + filePdf);
            return filePdf;
        } else {
            return null;
        }
    }
    
    private void exportForClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportForClientActionPerformed
       String filePdf = chooseFileToSave("cliente");
       
       if(filePdf == null)
           return;
    }//GEN-LAST:event_exportForClientActionPerformed

    private void exportForSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportForSubActionPerformed
        String filePdf = chooseFileToSave("sub-appaltatori");
        
        if(filePdf == null) 
            return;
    }//GEN-LAST:event_exportForSubActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButtonActionPerformed

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
            new ComputoInterface(new Computo("computo"), "C:\\Users\\gerar\\Desktop\\progetto.hhp").setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aggiungiButton;
    private javax.swing.JButton exportForClient;
    private javax.swing.JButton exportForSub;
    private javax.swing.JButton gestisciVoceButton;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton progettoButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTable table;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
