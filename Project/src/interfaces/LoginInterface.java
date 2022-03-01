/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
;

import java.awt.EventQueue;
import javax.swing.JOptionPane;

/**
 *
 * @author Pepito
 */
public class LoginInterface extends javax.swing.JFrame {

    /**
     * Creates new form LoginInterface
     */
    public LoginInterface() {
        initComponents();
        passwordField.setText("admin");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panel = new javax.swing.JPanel();
        userLabel = new javax.swing.JLabel();
        userField = new javax.swing.JComboBox<>();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        roleComboBox = new javax.swing.JComboBox<>();
        loginButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HouseHub");
        setBackground(new java.awt.Color(8, 14, 44));
        setResizable(false);

        panel.setBackground(new java.awt.Color(192, 192, 192));
        panel.setLayout(new java.awt.GridLayout(3, 2, 10, 10));

        userLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        userLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        userLabel.setText("Nome utente");
        panel.add(userLabel);

        userField.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        userField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Antonio Pannullo", "Emanuele Sellitto" }));
        panel.add(userField);

        passwordLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        passwordLabel.setText("Password");
        panel.add(passwordLabel);

        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });
        panel.add(passwordField);

        roleComboBox.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        roleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Utente" }));
        roleComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleComboBoxActionPerformed(evt);
            }
        });
        panel.add(roleComboBox);

        loginButton.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        panel.add(loginButton);

        jPanel2.setBackground(new java.awt.Color(8, 14, 44));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/House_Hub_PDF.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        String role = (String) roleComboBox.getSelectedItem();

        if (role.equals("Admin")) {
            loginAsAdmin();
        } else {
            loginAsClient();
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        loginAsAdmin();
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void roleComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleComboBoxActionPerformed
        String role = (String) roleComboBox.getSelectedItem();

        if (role.equals("Admin")) {
            userField.setEnabled(true);
            passwordField.setEnabled(true);
        } else {
            userField.setEnabled(false);
            passwordField.setText("");
            passwordField.setEnabled(false);
        }
    }//GEN-LAST:event_roleComboBoxActionPerformed

    private void loginAsAdmin() {
        String user = (String) userField.getSelectedItem();
        if (passwordField.getText().equals("admin")) {
            EventQueue.invokeLater(() -> {
                new ProgettoInterface(user, false).setVisible(true);
                dispose();
            });
        } else {
            JOptionPane.showMessageDialog(this, "Password errata", "Avviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void loginAsClient() {
        EventQueue.invokeLater(() -> {
            new ProgettoInterface("NON_ADMIN", false).setVisible(true);
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
            java.util.logging.Logger.getLogger(LoginInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel panel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JComboBox<String> roleComboBox;
    private javax.swing.JComboBox<String> userField;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
