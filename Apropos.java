/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Amine
 */
public class Apropos extends javax.swing.JDialog {

    /**
     * Creates new form Apropos
     */
    public Apropos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        jSeparator1 = new javax.swing.JSeparator();
        imageTitre = new javax.swing.JLabel();
        Copyright = new javax.swing.JLabel();
        SG = new javax.swing.JLabel();
        ZA = new javax.swing.JLabel();
        FP = new javax.swing.JLabel();
        SS = new javax.swing.JLabel();
        RV = new javax.swing.JLabel();
        CA = new javax.swing.JLabel();
        Bcancel = new javax.swing.JButton();
        imagePoker = new javax.swing.JLabel();
        imageFond = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("A propos du Bridge Chinois");
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(40, 90, 270, 2);

        imageTitre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/bridge.png"))); // NOI18N
        getContentPane().add(imageTitre);
        imageTitre.setBounds(40, 20, 260, 40);

        Copyright.setText("Copyright © - 2012. Tout droits résérvés.");
        getContentPane().add(Copyright);
        Copyright.setBounds(10, 290, 230, 14);

        SG.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        SG.setForeground(new java.awt.Color(0, 255, 255));
        SG.setText("Santos Gabriel");
        getContentPane().add(SG);
        SG.setBounds(50, 180, 140, 15);

        ZA.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ZA.setForeground(new java.awt.Color(0, 255, 255));
        ZA.setText("Ziane Cherif Amine");
        getContentPane().add(ZA);
        ZA.setBounds(50, 220, 140, 15);

        FP.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        FP.setForeground(new java.awt.Color(0, 255, 255));
        FP.setText("Fiat Paul");
        getContentPane().add(FP);
        FP.setBounds(50, 140, 140, 15);

        SS.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        SS.setForeground(new java.awt.Color(0, 255, 255));
        SS.setText("Sassi Samy");
        getContentPane().add(SS);
        SS.setBounds(50, 200, 140, 15);

        RV.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        RV.setForeground(new java.awt.Color(0, 255, 255));
        RV.setText("Robert Valentin");
        getContentPane().add(RV);
        RV.setBounds(50, 160, 140, 15);

        CA.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        CA.setForeground(new java.awt.Color(0, 255, 255));
        CA.setText("Chennaoui Amine");
        getContentPane().add(CA);
        CA.setBounds(50, 120, 140, 15);

        Bcancel.setText("Annuler");
        Bcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BcancelActionPerformed(evt);
            }
        });
        getContentPane().add(Bcancel);
        Bcancel.setBounds(250, 280, 80, 23);

        imagePoker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/jokerprop.jpg"))); // NOI18N
        getContentPane().add(imagePoker);
        imagePoker.setBounds(220, 110, 90, 120);

        imageFond.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/menu.jpg"))); // NOI18N
        getContentPane().add(imageFond);
        imageFond.setBounds(0, 0, 360, 330);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-356)/2, (screenSize.height-354)/2, 356, 354);
    }// </editor-fold>//GEN-END:initComponents

    private void BcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BcancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_BcancelActionPerformed

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
            java.util.logging.Logger.getLogger(Apropos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Apropos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Apropos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Apropos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                Apropos dialog = new Apropos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton Bcancel;
    private javax.swing.JLabel CA;
    private javax.swing.JLabel Copyright;
    private javax.swing.JLabel FP;
    private javax.swing.JLabel RV;
    private javax.swing.JLabel SG;
    private javax.swing.JLabel SS;
    private javax.swing.JLabel ZA;
    private javax.swing.JLabel imageFond;
    private javax.swing.JLabel imagePoker;
    private javax.swing.JLabel imageTitre;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
