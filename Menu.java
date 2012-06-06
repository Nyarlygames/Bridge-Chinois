
import java.applet.*;
import java.io.*;
import java.net.*;
import java.io.File;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author Val
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Bsolo = new javax.swing.JButton();
        Bmulti = new javax.swing.JButton();
        Bquitter = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        Bcharger = new javax.swing.JButton();
        Btuto = new javax.swing.JButton();
        imageTitre = new javax.swing.JLabel();
        imageFond = new javax.swing.JLabel();
        barMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuCharge = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Bridge Chinois");
        setBackground(new java.awt.Color(255, 204, 204));
        setBounds(new java.awt.Rectangle(200, 200, 0, 0));
        setForeground(new java.awt.Color(255, 204, 204));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        Bsolo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Bordi.png"))); // NOI18N
        Bsolo.setBorderPainted(false);
        Bsolo.setContentAreaFilled(false);
        Bsolo.setMaximumSize(new java.awt.Dimension(125, 23));
        Bsolo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Bordi_entered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Bsolo_exit(evt);
            }
        });
        Bsolo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BsoloActionPerformed(evt);
            }
        });
        getContentPane().add(Bsolo);
        Bsolo.setBounds(100, 110, 140, 40);

        Bmulti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Bligne.png"))); // NOI18N
        Bmulti.setBorderPainted(false);
        Bmulti.setContentAreaFilled(false);
        Bmulti.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Bligne_entered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Bligne_exited(evt);
            }
        });
        Bmulti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BmultiActionPerformed(evt);
            }
        });
        getContentPane().add(Bmulti);
        Bmulti.setBounds(100, 150, 140, 40);

        Bquitter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Bexit.png"))); // NOI18N
        Bquitter.setBorderPainted(false);
        Bquitter.setContentAreaFilled(false);
        Bquitter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Bexit_entered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Bexit_exited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                change_image(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                reset_image(evt);
            }
        });
        Bquitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BquitterActionPerformed(evt);
            }
        });
        getContentPane().add(Bquitter);
        Bquitter.setBounds(100, 310, 140, 40);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(80, 300, 185, 10);
        getContentPane().add(jSeparator4);
        jSeparator4.setBounds(80, 240, 185, 10);

        Bcharger.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Bcharger.png"))); // NOI18N
        Bcharger.setBorderPainted(false);
        Bcharger.setContentAreaFilled(false);
        Bcharger.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Bcharger_entered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Bcharger_exited(evt);
            }
        });
        Bcharger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BchargerActionPerformed(evt);
            }
        });
        getContentPane().add(Bcharger);
        Bcharger.setBounds(100, 190, 140, 50);

        Btuto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Btuto.png"))); // NOI18N
        Btuto.setBorderPainted(false);
        Btuto.setContentAreaFilled(false);
        Btuto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btuto_entered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btuto_exited(evt);
            }
        });
        Btuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtutoActionPerformed(evt);
            }
        });
        getContentPane().add(Btuto);
        Btuto.setBounds(100, 250, 140, 40);

        imageTitre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/bridge.png"))); // NOI18N
        getContentPane().add(imageTitre);
        imageTitre.setBounds(50, 10, 260, 40);

        imageFond.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/menu.jpg"))); // NOI18N
        getContentPane().add(imageFond);
        imageFond.setBounds(0, 0, 350, 390);

        jMenu1.setText("Menu");

        menuCharge.setText("Charger");
        menuCharge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuChargeActionPerformed(evt);
            }
        });
        jMenu1.add(menuCharge);

        jMenuItem5.setText("Options");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setMnemonic('Q');
        jMenuItem4.setText("Quitter");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        barMenu.add(jMenu1);

        jMenu2.setText("?");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem1.setText("Règles");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("A propos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        barMenu.add(jMenu2);

        setJMenuBar(barMenu);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-349)/2, (screenSize.height-432)/2, 349, 432);
    }// </editor-fold>//GEN-END:initComponents

    private void BsoloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BsoloActionPerformed
        // TODO add your handling code here:

        //Son au clique de souris sur le bouton
        try {
            Son s = new Son("Bcarte.wav");
        } catch (Exception ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }

        VSIA fenOp = new VSIA();
        fenOp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BsoloActionPerformed

    private void BquitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BquitterActionPerformed
        // TODO add your handling code here:
        //Son au clique de souris sur le bouton
        try {
            Son s = new Son("Bquitter.wav");
        } catch (Exception ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        Confirmation a = new Confirmation(this, true, "Voulez vous vraiment quitter ?");
        a.setVisible(true);

        if (a.getReturnStatus() == 1) {
            this.dispose();
            System.exit(0);
        }

    }//GEN-LAST:event_BquitterActionPerformed

    private void BmultiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BmultiActionPerformed
        // TODO add your handling code here:
        //Son au clique de souris sur le bouton
        try {
            Son s = new Son("Bcarte.wav");
        } catch (Exception ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        Multi mul = new Multi();
        mul.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BmultiActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Regle reg = new Regle(this, true);
        reg.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        Confirmation a = new Confirmation(this, true, "Voulez vous vraiment quitter ?");
        a.setVisible(true);

        if (a.getReturnStatus() == 1) {
            this.dispose();
            System.exit(0);
        }
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:

        Options opt = new Options(this, true);
        opt.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        Apropos propo = new Apropos(this, true);
        propo.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void menuChargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuChargeActionPerformed
        // TODO add your handling code here:
        JFileChooser choix = new JFileChooser();
        int result = choix.showOpenDialog(null);
        switch (result) {
            case JFileChooser.APPROVE_OPTION:
                System.out.println("ouvrir");
                break;
            case JFileChooser.CANCEL_OPTION:
                System.out.println("Annuler");
                break;
            case JFileChooser.ERROR_OPTION:
                System.out.println("Erreur");
                break;
        }
        //this.dispose();
    }//GEN-LAST:event_menuChargeActionPerformed

    private void BchargerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BchargerActionPerformed
        // TODO add your handling code here:
        //Son au clique de souris sur le bouton
        try {
            Son s = new Son("Bcarte.wav");
        } catch (Exception ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }

        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(null);
        switch (result) {
            case JFileChooser.APPROVE_OPTION:
                System.out.println("ouvrir");
                Sauvegarde.loadGame("saves/" + chooser.getName(chooser.getSelectedFile()), this);
                break;
            case JFileChooser.CANCEL_OPTION:
                System.out.println("Annuler");
                break;
            case JFileChooser.ERROR_OPTION:
                System.out.println("Erreur");
                break;
        }
        /*
         * Charge file = new Charge(this,true);
        file.setVisible(true);
         */
    }//GEN-LAST:event_BchargerActionPerformed

    private void change_image(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_change_image
        // TODO add your handling code here:
        Bquitter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Bexit_entered.png")));
    }//GEN-LAST:event_change_image

    private void reset_image(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reset_image
        // TODO add your handling code here:
        Bquitter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Bexit.png")));
    }//GEN-LAST:event_reset_image

    private void Bexit_entered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bexit_entered
        // TODO add your handling code here:
        Bquitter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Bexit_entered.png")));
    }//GEN-LAST:event_Bexit_entered

    private void Bexit_exited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bexit_exited
        // TODO add your handling code here:
        Bquitter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Bexit.png")));
    }//GEN-LAST:event_Bexit_exited

    private void Bordi_entered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bordi_entered
        // TODO add your handling code here:
        Bsolo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Bordi_entered.png")));
    }//GEN-LAST:event_Bordi_entered

    private void Bsolo_exit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bsolo_exit
        // TODO add your handling code here:
        Bsolo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Bordi.png")));
    }//GEN-LAST:event_Bsolo_exit

    private void Bligne_entered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bligne_entered
        // TODO add your handling code here:
        Bmulti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Bligne_entered.png")));
    }//GEN-LAST:event_Bligne_entered

    private void Bligne_exited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bligne_exited
        // TODO add your handling code here:
        Bmulti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Bligne.png")));
    }//GEN-LAST:event_Bligne_exited

    private void Bcharger_entered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bcharger_entered
        // TODO add your handling code here:
        Bcharger.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Bcharger_entered.png")));
    }//GEN-LAST:event_Bcharger_entered

    private void Btuto_entered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btuto_entered
        // TODO add your handling code here:
        Btuto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Btuto_entered.png")));
    }//GEN-LAST:event_Btuto_entered

    private void Btuto_exited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btuto_exited
        // TODO add your handling code here:
        Btuto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Btuto.png")));
    }//GEN-LAST:event_Btuto_exited

    private void Bcharger_exited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bcharger_exited
        // TODO add your handling code here:
        Bcharger.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Bcharger.png")));
    }//GEN-LAST:event_Bcharger_exited

    private void BtutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtutoActionPerformed
        // TODO add your handling code here:
        //Son au clique de souris sur le bouton
        try {
            Son s = new Son("Bcarte.wav");
        } catch (Exception ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }


        this.dispose();
        new Thread(new Runnable() {

            public void run() {

                Table table = new Table();
                Moteur moteur = new Moteur(table);

                Jeu monJeu = new Jeu(moteur, 0, 1, 1, 0, true);
                final Graphique gg = new Graphique(monJeu);
                // test
                monJeu.addObservateur(new Observateur() {

                    public void update(Jeu jeu) {
                        gg.getZoneDessin().repaint();
                        if (jeu.fin) {
                            System.out.println("gagné");
                            FinPartie f = new FinPartie(gg.frame, true, jeu.partieRestante, jeu.gg);
                            f.setVisible(true);
                        }
                    }
                });


            }
        }).start();



    }//GEN-LAST:event_BtutoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Confirmation a = new Confirmation(this, true, "Voulez vous vraiment quitter ?");
        a.setVisible(true);

        if (a.getReturnStatus() == 1) {
            this.dispose();
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bcharger;
    private javax.swing.JButton Bmulti;
    private javax.swing.JButton Bquitter;
    private javax.swing.JButton Bsolo;
    private javax.swing.JButton Btuto;
    private javax.swing.JMenuBar barMenu;
    private javax.swing.JLabel imageFond;
    private javax.swing.JLabel imageTitre;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JMenuItem menuCharge;
    // End of variables declaration//GEN-END:variables
}
