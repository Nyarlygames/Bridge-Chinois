/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;

/**
 *
 * @author Val
 */
public class VSIA extends javax.swing.JFrame {

    /**
     * Creates new form VSIA
     */
    public VSIA() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        facile = new javax.swing.JRadioButton();
        moyen = new javax.swing.JRadioButton();
        difficile = new javax.swing.JRadioButton();
        lbDif = new javax.swing.JLabel();
        Launch = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        nbParties = new javax.swing.JComboBox();
        mode = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonGroup1.add(facile);
        facile.setText("Facile");

        buttonGroup1.add(moyen);
        moyen.setSelected(true);
        moyen.setText("Moyen");

        buttonGroup1.add(difficile);
        difficile.setText("Difficile");

        lbDif.setText("Difficulté :");

        Launch.setText("Démarrer");

        Cancel.setText("Annuler");
        Cancel.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        nbParties.setEditable(true);
        nbParties.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"1", "3", "5", "10"}));
        nbParties.addFocusListener(new java.awt.event.FocusAdapter() {

            public void focusLost(java.awt.event.FocusEvent evt) {
                nbPartiesFocusLost(evt);
            }
        });

        mode.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Nombre de Donnes", "Nombre de Plis", "Aventure"}));
        mode.addItemListener(new java.awt.event.ItemListener() {

            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                modeItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(mode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(nbParties, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(mode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(nbParties, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(28, 28, 28)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(lbDif).addGap(41, 41, 41).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(difficile).addComponent(moyen, javax.swing.GroupLayout.Alignment.LEADING).addComponent(facile, javax.swing.GroupLayout.Alignment.LEADING)).addGap(101, 101, 101)).addGroup(layout.createSequentialGroup().addGap(46, 46, 46).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addGroup(layout.createSequentialGroup().addComponent(Cancel).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(Launch)).addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addContainerGap(68, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(26, 26, 26).addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(39, 39, 39).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(facile).addComponent(lbDif)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(moyen).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(difficile).addGap(32, 32, 32).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(Launch).addComponent(Cancel)).addContainerGap(26, Short.MAX_VALUE)));

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - 372) / 2, (screenSize.height - 295) / 2, 372, 295);
    }// </editor-fold>//GEN-END:initComponents

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        // TODO add your handling code here:
        //   Confirmation a = new Confirmation(this, true, "Revenir au menu ?");
        //   a.setVisible(true);

        //     if (a.getReturnStatus() == 1) {
        Menu m = new Menu();
        m.setVisible(true);
        this.dispose();
        //  }
    }//GEN-LAST:event_CancelActionPerformed

    private void modeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_modeItemStateChanged
        // TODO add your handling code here:

        if (mode.getSelectedItem() == "Aventure") {
            facile.setEnabled(false);
            moyen.setEnabled(false);
            difficile.setEnabled(false);
            nbParties.setEnabled(false);
            lbDif.setEnabled(false);
        } else {
            facile.setEnabled(true);
            moyen.setEnabled(true);
            difficile.setEnabled(true);
            nbParties.setEnabled(true);
            lbDif.setEnabled(true);
        }
    }//GEN-LAST:event_modeItemStateChanged

    private void nbPartiesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nbPartiesFocusLost
        // TODO add your handling code here:
        System.out.println("protu");
        if (nbParties.getSelectedItem() instanceof Integer) {
            nbParties.setBackground(Color.white);


        } else {
            nbParties.setBackground(Color.red);


        }
    }//GEN-LAST:event_nbPartiesFocusLost

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
            java.util.logging.Logger.getLogger(VSIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VSIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VSIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VSIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new VSIA().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel;
    private javax.swing.JButton Launch;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton difficile;
    private javax.swing.JRadioButton facile;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbDif;
    private javax.swing.JComboBox mode;
    private javax.swing.JRadioButton moyen;
    private javax.swing.JComboBox nbParties;
    // End of variables declaration//GEN-END:variables
}
