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
import models.Capitolato;
import models.Voce;

/**
 *
 * @author Pepito
 */
public class CapitolatoInterface extends javax.swing.JFrame {

    protected DefaultTableModel clientiModel, subModel;
    private Capitolato capitolato;
    private final String FILEPATH = System.getProperty("user.dir") + "/capitolato.hhc";
    private static boolean saved = true;

    /**
     * Creates new form UserInterface
     */
    public CapitolatoInterface() {
        clientiModel = initTableModel();
        subModel = initTableModel();
        initCapitolati();
        refreshTables();
        initComponents();
    }

    public CapitolatoInterface(Voce voceCliente, Voce voceSubappaltatore) {
        clientiModel = initTableModel();
        subModel = initTableModel();
        initCapitolati();
        capitolato.addVoceCliente(voceCliente);
        capitolato.addVoceSubappaltori(voceSubappaltatore);
        refreshTables();
        initComponents();
    }

    private void refreshTables() {
        clientiModel.setRowCount(0);
        subModel.setRowCount(0);
        
        for(String codice : capitolato.getCapitolatoClienti().keySet()) {
            Voce voce = capitolato.getVoceCliente(codice);
            Object[] row = {codice, voce.getDescrizione(), voce.getUnitaDiMisura(), voce.getPrezzoUnitario()};
            clientiModel.addRow(row);
        }
        
        for(String codice : capitolato.getCapitolatoSubappaltatori().keySet()) {
            Voce voce = capitolato.getVoceSubappaltatore(codice);
            Object[] row = {codice, voce.getDescrizione(), voce.getUnitaDiMisura(), voce.getPrezzoUnitario()};
            subModel.addRow(row);
        }
    }
    
    private void initCapitolati() {
        try {
            capitolato = Capitolato.caricaCapitolato(FILEPATH);
            return;
        } catch (IOException ex) {
            capitolato = new Capitolato();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Errore", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            capitolato.salvaCapitolato(FILEPATH);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

    private DefaultTableModel initTableModel() {
        DefaultTableModel tm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tm.addColumn("Codice");
        tm.addColumn("Descrizione");
        tm.addColumn("Unità di misura");
        tm.addColumn("Prezzo unitario");

        return tm;
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
        clientiTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        subTable = new javax.swing.JTable();
        addVoceButton = new javax.swing.JButton();
        deleteVoceButton = new javax.swing.JButton();
        salvaCapitolatoButton = new javax.swing.JButton();
        progettoButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("HouseHub");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

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

        clientiTable.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        clientiTable.setModel(clientiModel);
        clientiTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clientiTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(clientiTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        capitolatoPanel.add(jScrollPane1, gridBagConstraints);

        subTable.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        subTable.setModel(subModel);
        subTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(subTable);

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

        salvaCapitolatoButton.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        salvaCapitolatoButton.setText("Salva");
        salvaCapitolatoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvaCapitolatoButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        capitolatoPanel.add(salvaCapitolatoButton, gridBagConstraints);

        progettoButton.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
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

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
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
            .addComponent(capitolatoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 941, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(capitolatoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salvaCapitolatoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvaCapitolatoButtonActionPerformed
        salva();
    }//GEN-LAST:event_salvaCapitolatoButtonActionPerformed

    private void salva() {
        try {
            capitolato.salvaCapitolato(FILEPATH);
            saved = true;
            capitolato = Capitolato.caricaCapitolato(FILEPATH);
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void deleteVoceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteVoceButtonActionPerformed
        //Bisogna prima aver selezionato la voce
        String selectedCodice;
        int selectedRow = clientiTable.getSelectedRow();
        if (selectedRow == -1) {
            selectedRow = subTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Nessuna voce selezionata", "Avviso", JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                //Seleziona da subTable
                selectedCodice = (String) subModel.getValueAt(selectedRow, 0);
            }
        } else {
            //Seleziona da clientiTable
            selectedCodice = (String) clientiModel.getValueAt(selectedRow, 0);
        }

        capitolato.removeVoceCliente(selectedCodice);
        capitolato.removeVoceSubappaltatori(selectedCodice);
        saved = false;
        refreshTables();
    }//GEN-LAST:event_deleteVoceButtonActionPerformed

    private void addVoceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVoceButtonActionPerformed
        //Nuova interfaccia per inserire la nuova voce
        saved = false;
        EventQueue.invokeLater(() -> {
            new NuovaVoceInCapitolatoInterface().setVisible(true);
            dispose();
        });

        //Recupera il controllo e visualizza le voci
    }//GEN-LAST:event_addVoceButtonActionPerformed

    private void progettoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progettoButtonActionPerformed
        if(saved == false) {
            int choice = JOptionPane.showConfirmDialog(this, "Vuoi salvare prima di passare ai progetti?");
            if(choice == JOptionPane.YES_OPTION)
                salva();
            else if(choice == JOptionPane.CANCEL_OPTION) 
                return;
        }   
        
        EventQueue.invokeLater(() -> {
            new ProgettoInterface(false).setVisible(true);
            dispose();
        });
    }//GEN-LAST:event_progettoButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(saved == false) {
            int choice = JOptionPane.showConfirmDialog(this, "Vuoi salvare prima di chiudere?");
            if(choice == JOptionPane.YES_OPTION)
                salva();
            else if(choice == JOptionPane.CANCEL_OPTION) 
                return;
        }
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void clientiTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientiTableMouseClicked
        subTable.clearSelection();
    }//GEN-LAST:event_clientiTableMouseClicked

    private void subTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subTableMouseClicked
        clientiTable.clearSelection();
    }//GEN-LAST:event_subTableMouseClicked

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
                new CapitolatoInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addVoceButton;
    private javax.swing.JPanel capitolatoPanel;
    private javax.swing.JTable clientiTable;
    private javax.swing.JButton deleteVoceButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton progettoButton;
    private javax.swing.JButton salvaCapitolatoButton;
    private javax.swing.JTable subTable;
    // End of variables declaration//GEN-END:variables
}
