/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amine
 */
public class Options extends javax.swing.JDialog {

    /**
     * Creates new form Options
     */
    public Options(java.awt.Frame parent, boolean modal) {
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

        buttonGroupTheme = new javax.swing.ButtonGroup();
        buttonGroupCartes = new javax.swing.ButtonGroup();
        conf = new Config();
        jButtonAnnuler = new javax.swing.JButton();
        jCheckBoxSon = new javax.swing.JCheckBox();
        jButtonOK = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jCheckBoxAnciensPlis = new javax.swing.JCheckBox();
        jCheckBoxCartesAdv = new javax.swing.JCheckBox();
        jLabelCheat = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jRadioButtonTheme1 = new javax.swing.JRadioButton();
        jRadioButtonTheme2 = new javax.swing.JRadioButton();
        jLabelTheme = new javax.swing.JLabel();
        jRadioButtonTheme3 = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabelCartes = new javax.swing.JLabel();
        jRadioButtonCartes1 = new javax.swing.JRadioButton();
        jRadioButtonCartes2 = new javax.swing.JRadioButton();
        jRadioButtonCartes3 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jButtonAnnuler.setText("Annuler");
        jButtonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnulerActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAnnuler);
        jButtonAnnuler.setBounds(20, 510, 78, 25);

        jCheckBoxSon.setText("Son");
        jCheckBoxSon.setSelected(conf.isSon());
        getContentPane().add(jCheckBoxSon);
        jCheckBoxSon.setBounds(180, 300, 51, 25);

        jButtonOK.setText("OK");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonOK);
        jButtonOK.setBounds(370, 510, 49, 25);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jCheckBoxAnciensPlis.setText("Voir anciens plis");
        jCheckBoxAnciensPlis.setSelected(conf.isVoitPlis());

        jCheckBoxCartesAdv.setText("Voir cartes adversaire");
        jCheckBoxCartesAdv.setSelected(conf.isVoitCartes());

        jLabelCheat.setText("Triche:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxCartesAdv)
                    .addComponent(jCheckBoxAnciensPlis))
                .addGap(22, 22, 22))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCheat)
                .addContainerGap(215, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCheat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jCheckBoxCartesAdv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBoxAnciensPlis)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(50, 380, 270, 110);

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        buttonGroupTheme.add(jRadioButtonTheme1);
        jRadioButtonTheme1.setText("Vert");
        if (conf.getStyle() == 1)
        jRadioButtonTheme1.setSelected(true);

        buttonGroupTheme.add(jRadioButtonTheme2);
        jRadioButtonTheme2.setText("Bleu");
        if (conf.getStyle() == 2)
        jRadioButtonTheme2.setSelected(true);

        jLabelTheme.setText("Theme");

        buttonGroupTheme.add(jRadioButtonTheme3);
        if (conf.getStyle() == 3)
        jRadioButtonTheme3.setSelected(true);
        jRadioButtonTheme3.setText("Metal");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelTheme))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jRadioButtonTheme1)
                        .addGap(30, 30, 30)
                        .addComponent(jRadioButtonTheme2)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonTheme3)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTheme)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jRadioButtonTheme1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButtonTheme2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButtonTheme3)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(40, 40, 300, 90);

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabelCartes.setText("Cartes");

        buttonGroupCartes.add(jRadioButtonCartes1);
        jRadioButtonCartes1.setText("Anciennes");
        if (conf.getDeck() == 2)
        jRadioButtonCartes1.setSelected(true);

        buttonGroupCartes.add(jRadioButtonCartes2);
        jRadioButtonCartes2.setText("Nouvelles");
        if (conf.getDeck() == 1)
        jRadioButtonCartes2.setSelected(true);

        buttonGroupCartes.add(jRadioButtonCartes3);
        jRadioButtonCartes3.setText("Chats!");
        if (conf.getDeck() == 3)
        jRadioButtonCartes3.setSelected(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jRadioButtonCartes1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonCartes2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonCartes3))
                    .addComponent(jLabelCartes))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCartes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonCartes3)
                    .addComponent(jRadioButtonCartes2)
                    .addComponent(jRadioButtonCartes1))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(40, 150, 300, 100);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-472)/2, (screenSize.height-598)/2, 472, 598);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnulerActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonAnnulerActionPerformed
    
    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        // TODO add your handling code here:
        if (jRadioButtonCartes1.isSelected()) {
            conf.setDeck(2);
        } else if (jRadioButtonCartes2.isSelected()) {
            conf.setDeck(1);
        } else if (jRadioButtonCartes3.isSelected()) {
            conf.setDeck(3);
        }
        if (jRadioButtonTheme1.isSelected()) {
            conf.setStyle(1);
        } else if (jRadioButtonTheme2.isSelected()) {
            conf.setStyle(2);
        } else if (jRadioButtonTheme3.isSelected()) {
            conf.setStyle(3);
        }
        conf.setVoitCartes(jCheckBoxCartesAdv.isSelected());
        conf.setVoitPlis(jCheckBoxAnciensPlis.isSelected());
        conf.setSon(jCheckBoxSon.isSelected());
        conf.saveConfigs();
        this.dispose();
        
    }//GEN-LAST:event_jButtonOKActionPerformed

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
            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                Options dialog = new Options(new javax.swing.JFrame(), true);
                conf = new Config();
                
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
    private static Config conf;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupCartes;
    private javax.swing.ButtonGroup buttonGroupTheme;
    private javax.swing.JButton jButtonAnnuler;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JCheckBox jCheckBoxAnciensPlis;
    private javax.swing.JCheckBox jCheckBoxCartesAdv;
    private javax.swing.JCheckBox jCheckBoxSon;
    private javax.swing.JLabel jLabelCartes;
    private javax.swing.JLabel jLabelCheat;
    private javax.swing.JLabel jLabelTheme;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButtonCartes1;
    private javax.swing.JRadioButton jRadioButtonCartes2;
    private javax.swing.JRadioButton jRadioButtonCartes3;
    private javax.swing.JRadioButton jRadioButtonTheme1;
    private javax.swing.JRadioButton jRadioButtonTheme2;
    private javax.swing.JRadioButton jRadioButtonTheme3;
    // End of variables declaration//GEN-END:variables
}
