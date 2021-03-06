
import java.awt.Frame;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Val
 */
public class FinPartie extends javax.swing.JDialog {

    /**
     * Creates new form FinPartie
     */
    static boolean gagne = true;
    static boolean partieRestante = false;
    static Frame g;
    static Jeu jeu;
    
    public FinPartie(java.awt.Frame parent, boolean modal, boolean partieRestante, boolean gg) {
                
        super(parent, modal);
        gagne=gg;
        this.partieRestante = partieRestante;
        this.g=parent;
        initComponents();
        Son s;
        try {
            if (gagne)
                s = new Son("clap.wav");
            else    
                s = new Son("sfxboo.wav");
        } catch (Exception ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
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

        textFin = new javax.swing.JLabel();
        jButtonMenu = new javax.swing.JButton();
        jButtonPartieSuivante = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        if (gagne)
        {
            if (partieRestante)
            textFin.setText("Bravo, vous avez gagne. Appuiez sur Continuer pour continuer");
            else
            textFin.setText("Bravo, vous avez gagne. Appuiez sur Nouvelle Partie pour rejouer");
        }
        else{
            if (partieRestante)
            textFin.setText("Desole, vous avez perdu. Appuiez sur Continuer pour continuer");
            else
            textFin.setText("Desole, vous avez perdu. Appuiez sur Nouvelle Partie pour rejouer");
        }
        textFin.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        getContentPane().add(textFin);
        textFin.setBounds(16, 40, 380, 30);

        jButtonMenu.setText("Retour au Menu");
        jButtonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMenu);
        jButtonMenu.setBounds(22, 108, 130, 23);

        if (partieRestante)
        jButtonPartieSuivante.setText("Continuer");
        else
        jButtonPartieSuivante.setText("Nouvelle Partie");
        jButtonPartieSuivante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPartieSuivanteActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPartieSuivante);
        jButtonPartieSuivante.setBounds(259, 108, 115, 23);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/option_theme.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(5, 20, 390, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/options.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-10, -10, 640, 420);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-416)/2, (screenSize.height-207)/2, 416, 207);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuActionPerformed
        // TODO add your handling code here:
        this.setModal(false);
        g.dispose();
        this.dispose();
        Menu m = new Menu();
        m.setVisible(true);
        

    }//GEN-LAST:event_jButtonMenuActionPerformed

    private void jButtonPartieSuivanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPartieSuivanteActionPerformed
        // TODO add your handling code here:
        if (!partieRestante) {
            
            g.dispose();
            this.dispose();
            VSIA fenOp = new VSIA();
            fenOp.setVisible(true);

        } else {
            this.dispose();
        }
    }//GEN-LAST:event_jButtonPartieSuivanteActionPerformed

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
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FinPartie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FinPartie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FinPartie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FinPartie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                FinPartie dialog = new FinPartie(new javax.swing.JFrame(), true, partieRestante, gagne);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JButton jButtonPartieSuivante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel textFin;
    // End of variables declaration//GEN-END:variables
}
