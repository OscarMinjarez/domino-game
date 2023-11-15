package org.itson.engine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import org.itson.player.Player;
import org.itson.player.PlayerController;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.util.Hashtable;
import org.itson.engine.JComboBoxRender;
/**
 *
 * @author arace
 */
public class FrmMainMenu extends javax.swing.JFrame {

    private static FrmMainMenu instance;
    private PlayerController playerController;
    Hashtable<Object, ImageIcon> mAvatar;
    int width = 40;
    int height = 40;
    private String amongUSRed = "/assets/other/avatar1.png";
    private String amongUSOrange = "/assets/other/avatar2.png";
    private String amongUSBlue = "/assets/other/avatar3.png";
    private String amongUSPink = "/assets/other/avatar4.png";

    /**
     * Creates new form FrmMainMenu
     */
    private FrmMainMenu() {
        initComponents();
        playerController = PlayerController.get();
        mAvatar = new Hashtable<>();
        this.setTitle("Among us Dominos");
        this.setSize(711, 400);
        this.setLocationRelativeTo(null);
        initCombo();
        
    }

    public static FrmMainMenu get() {
        if (FrmMainMenu.instance == null) {
            FrmMainMenu.instance = new FrmMainMenu();
        }

        return FrmMainMenu.instance;
    }

    private void hiddenWindow() {
        setVisible(false);
    }

    private void showFrmMainMenuPlayer() throws IOException {
        if (checkEmptyName()) {
            showAlert("Please, enter a name", "Empty name");
        } else {
            hiddenWindow();
            FrmMainMenuPlayer frmMainMenuPlayer = FrmMainMenuPlayer.get();
//            GameView frmGame = GameView.get();
            frmMainMenuPlayer.setPlayer(get().createPlayer(txtName.getText().trim()));
//            frmGame.setPlayer(get().createPlayer(txtName.getText().trim()));
            frmMainMenuPlayer.setVisible(true);
        }
    }

    private boolean checkEmptyName() {
        return txtName.getText().trim().isBlank();
    }

    private Player createPlayer(String name) {
        return get().playerController.createPlayer(name);
    }

    private void showAlert(String message, String title) {
        JOptionPane.showMessageDialog(
                get(),
                message,
                title,
                JOptionPane.ERROR_MESSAGE
        );
    }

    private void initCombo() {
        comboAvatar.addItem("Red");
        comboAvatar.addItem("Orange");
        comboAvatar.addItem("Blue");
        comboAvatar.addItem("Pink");
        mAvatar.put("Red", getIcono(amongUSRed));
        mAvatar.put("Orange", getIcono(amongUSOrange));
        mAvatar.put("Blue", getIcono(amongUSBlue));
        mAvatar.put("Pink", getIcono(amongUSPink));
        JComboBoxRender mRender = new JComboBoxRender(mAvatar);
        comboAvatar.setRenderer(mRender);
    }

    public ImageIcon getIcono(String path) {
        return new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
                .getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnHelp = new javax.swing.JButton();
        lblEnterYourName = new javax.swing.JLabel();
        comboAvatar = new javax.swing.JComboBox<>();
        lblTitle = new javax.swing.JLabel();
        lblSelectYourAvatar = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnEnter = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        lblbackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Domino Master");
        setMinimumSize(new java.awt.Dimension(711, 400));
        setPreferredSize(new java.awt.Dimension(711, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHelp.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        btnHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/other/help.png"))); // NOI18N
        btnHelp.setBorderPainted(false);
        btnHelp.setContentAreaFilled(false);
        getContentPane().add(btnHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 310, -1, -1));

        lblEnterYourName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/other/EnterYourName.png"))); // NOI18N
        getContentPane().add(lblEnterYourName, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, -1, -1));

        comboAvatar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAvatarActionPerformed(evt);
            }
        });
        getContentPane().add(comboAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 250, 50));

        lblTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/other/AmongUSDomino.png"))); // NOI18N
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        lblSelectYourAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/other/SelectYourAvatar.png"))); // NOI18N
        getContentPane().add(lblSelectYourAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, -1, -1));

        btnExit.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/other/Boton.png"))); // NOI18N
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        btnEnter.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        btnEnter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/other/btnStartGame.png"))); // NOI18N
        btnEnter.setBorderPainted(false);
        btnEnter.setContentAreaFilled(false);
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });
        getContentPane().add(btnEnter, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 100, 70));

        txtName.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 250, 50));

        lblbackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/other/fondo.jpg"))); // NOI18N
        getContentPane().add(lblbackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
        try {
            String playerName = txtName.getText().trim();
            String avatar = comboAvatar.getSelectedItem().toString();
            showFrmMainMenuPlayer();
        } catch (IOException ex) {
            Logger.getLogger(FrmMainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEnterActionPerformed

    private void comboAvatarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAvatarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboAvatarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnter;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHelp;
    private javax.swing.JComboBox<String> comboAvatar;
    private javax.swing.JLabel lblEnterYourName;
    private javax.swing.JLabel lblSelectYourAvatar;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblbackground;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
