/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.HashMap;
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
        //model = initTableModel();
        ComputoInterface.fileProgetto = fileProgetto;
        initComponents();
        model = (DefaultTableModel) table.getModel();
        refreshTable();
        titleLabel.setText("Computo metrico: " + computo.getNome());
    }

    public ComputoInterface() {
        //model = initTableModel();
        initComponents();
        model = (DefaultTableModel) table.getModel();
        refreshTable();
        titleLabel.setText("Computo metrico: " + computo.getNome());
    }

    /*private DefaultTableModel initTableModel() {
        
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
    }*/
    private void refreshTable() {
        model.setRowCount(0);

        for (VoceComputo voce : computo.getVociComputo().values()) {
            Object[] row = {voce.getNumeroProgressivo(), voce.getCodice(), voce.getDescrizione(), voce.vediVoceToString(),
                voce.getUnitaDiMisura(), voce.partiUgualiToString(), voce.lunghezzeToString(), voce.larghezzeToString(),
                voce.altezzePesiToString(), voce.getQuantita(), voce.getPrezzoUnitario(), voce.getPrezzoComplessivo()};
            
            model.addRow(row);
        }
    }

    private void save() {
        HashMap<Integer, VoceComputo> voci = computo.getVociComputo();
        for (int i = 0; i < model.getRowCount(); i++) {
            int numProg = (int) model.getValueAt(i, 0);

            VoceComputo curr = voci.get(numProg);
            computo.rimuoviVoce(curr);

            int vediVoceNum = (Integer) model.getValueAt(i, 3);
            double pu = (Double) model.getValueAt(i, 5);
            double lung = (Double) model.getValueAt(i, 6);
            double larg = (Double) model.getValueAt(i, 7);
            double h = (Double) model.getValueAt(i, 8);

            VoceComputo vediVoce;
            if (vediVoceNum == 0) {
                vediVoce = null;
            } else {
                vediVoce = computo.getVociComputo().get(vediVoceNum);
            }

            double[] dimensioni = {pu, lung, larg, h};

            computo.aggiungiVoce(curr);
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
        titleLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        aggiungiButton = new javax.swing.JButton();
        gestisciVoceButton = new javax.swing.JButton();
        exportForSub = new javax.swing.JButton();
        exportForClient = new javax.swing.JButton();
        progettoButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("House Hub");
        setBackground(new java.awt.Color(255, 255, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBackground(new java.awt.Color(240, 245, 58));
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
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(69, 52, 0, 0);
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
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(51, 52, 86, 0);
        jPanel1.add(gestisciVoceButton, gridBagConstraints);

        exportForSub.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        exportForSub.setText("Esporta per sub-appaltatori");
        exportForSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportForSubActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(69, 60, 0, 28);
        jPanel1.add(exportForSub, gridBagConstraints);

        exportForClient.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        exportForClient.setText("Esporta per cliente");
        exportForClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportForClientActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(51, 60, 86, 0);
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
        gridBagConstraints.insets = new java.awt.Insets(69, 91, 0, 0);
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
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.insets = new java.awt.Insets(10, 40, 15, 5);
        jPanel1.add(deleteButton, gridBagConstraints);

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
            new NuovaVoceInComputoInterface(computo).setVisible(true);
            dispose();
        });
    }//GEN-LAST:event_aggiungiButtonActionPerformed

    private void gestisciVoceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestisciVoceButtonActionPerformed
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleziona una voce del computo", "Avviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

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

        if (filePdf == null) {
            return;
        }
    }//GEN-LAST:event_exportForClientActionPerformed

    private void exportForSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportForSubActionPerformed
        String filePdf = chooseFileToSave("sub-appaltatori");

        if (filePdf == null) {
            return;
        }
    }//GEN-LAST:event_exportForSubActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonActionPerformed

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
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton exportForClient;
    private javax.swing.JButton exportForSub;
    private javax.swing.JButton gestisciVoceButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton progettoButton;
    private javax.swing.JTable table;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
