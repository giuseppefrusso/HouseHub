/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Computo;
import models.Progetto;
import models.Voce;
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
        titleLabel.setText("Computo metrico: " + computo.getNome());
    }

    private DefaultTableModel initTableModel() {
        DefaultTableModel tm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                switch (column) {
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public Class getColumnClass(int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return Integer.class;
                    case 1:
                    case 2:
                    case 3:
                        return String.class;
                    default:
                        return Double.class;
                }
            }
        };
        tm.addColumn("N.");
        tm.addColumn("Codice");
        tm.addColumn("Descrizione");
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

        for (VoceComputo voce : computo.getVociComputo()) {
            double pu = voce.getDimensioni()[0], lung = voce.getDimensioni()[1],
                    larg = voce.getDimensioni()[2], h = voce.getDimensioni()[3];

            Object[] row = {voce.getNumeroProgressivo(), voce.getVoceBase().getCodice(), voce.getVoceBase().getDescrizione(),
                voce.getVoceBase().getUnitaDiMisura(), pu, lung, larg, h, voce.getQuantita(),
                voce.getVoceBase().getPrezzoUnitario(), voce.getPrezzoComplessivo()};

            model.addRow(row);
        }
    }

    private void save() {
        computo.svuotaVociComputo();
        for (int i = 0; i < model.getRowCount(); i++) {
            int numProg = (int) model.getValueAt(i, 0);
            String codice = (String) model.getValueAt(i, 1);
            String desc = (String) model.getValueAt(i, 2);
            String unita = (String) model.getValueAt(i, 3);
            double pu = (Double) model.getValueAt(i, 4);
            double lung = (Double) model.getValueAt(i, 5);
            double larg = (Double) model.getValueAt(i, 6);
            double h = (Double) model.getValueAt(i, 7);
            double quant = (Double) model.getValueAt(i, 8);
            double prezzoU = (Double) model.getValueAt(i, 9);
            double prezzoC = (Double) model.getValueAt(i, 10);

            double[] dimensioni = {pu, lung, larg, h};

            computo.aggiungiVoce(new VoceComputo(numProg, new Voce(codice, desc, unita, prezzoU), dimensioni));
        }

        Progetto p;
        try {
            p = Progetto.caricaProgetto(fileProgetto);
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Errore", JOptionPane.ERROR_MESSAGE);
            return;
        }

        refreshTable();

        //sicuro che basti questo a salvare tutto sul file progetto?
        p.rimuoviComputo(computo);
        p.aggiungiComputo(computo);
        try {
            p.salvaProgetto(fileProgetto);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
        //
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        aggiungiButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("House Hub");
        setBackground(new java.awt.Color(255, 255, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBackground(new java.awt.Color(240, 245, 58));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jTable2.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        jTable2.setModel(model);
        jScrollPane2.setViewportView(jTable2);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        aggiungiButton.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        aggiungiButton.setText("Aggiungi nuova voce");
        aggiungiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aggiungiButtonActionPerformed(evt);
            }
        });
        jPanel2.add(aggiungiButton, java.awt.BorderLayout.PAGE_END);

        titleLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Computo metrico");
        jPanel2.add(titleLabel, java.awt.BorderLayout.PAGE_START);

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
        // TODO add your handling code here:
        EventQueue.invokeLater(() -> {
            new NuovaVoceInComputoInterface(computo).setVisible(true);
            dispose();
        });
    }//GEN-LAST:event_aggiungiButtonActionPerformed

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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
