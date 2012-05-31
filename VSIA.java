/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingUtilities;

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
        lbDif = new javax.swing.JLabel();
        Launch = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        nbParties = new javax.swing.JComboBox();
        mode = new javax.swing.JComboBox();
        jSlider1 = new javax.swing.JSlider();
        facile = new javax.swing.JLabel();
        moyen = new javax.swing.JLabel();
        difficile = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Jouer");
        setResizable(false);
        getContentPane().setLayout(null);

        lbDif.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbDif.setForeground(new java.awt.Color(0, 255, 255));
        lbDif.setText("Difficulté :");
        getContentPane().add(lbDif);
        lbDif.setBounds(27, 107, 56, 14);

        Launch.setText("Démarrer");
        Launch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LaunchActionPerformed(evt);
            }
        });
        getContentPane().add(Launch);
        Launch.setBounds(211, 208, 100, 23);

        Cancel.setText("Annuler");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });
        getContentPane().add(Cancel);
        Cancel.setBounds(46, 208, 80, 23);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setOpaque(false);

        nbParties.setEditable(true);
        nbParties.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "3", "5", "10" }));
        nbParties.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nbPartiesFocusLost(evt);
            }
        });

        mode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre de Donnes", "Nombre de Plis", "Aventure" }));
        mode.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                modeItemStateChanged(evt);
            }
        });
        mode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nbParties, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nbParties, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(50, 40, 240, 42);

        jSlider1.setMaximum(3);
        jSlider1.setMinimum(1);
        jSlider1.setMinorTickSpacing(1);
        jSlider1.setSnapToTicks(true);
        jSlider1.setToolTipText("");
        jSlider1.setValue(2);
        jSlider1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jSlider1);
        jSlider1.setBounds(46, 139, 273, 18);

        facile.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        facile.setForeground(new java.awt.Color(0, 255, 255));
        facile.setText("Facile");
        getContentPane().add(facile);
        facile.setBounds(46, 168, 59, 14);

        moyen.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        moyen.setForeground(new java.awt.Color(0, 255, 255));
        moyen.setText("Moyen");
        getContentPane().add(moyen);
        moyen.setBounds(169, 168, 59, 14);

        difficile.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        difficile.setForeground(new java.awt.Color(0, 255, 255));
        difficile.setText("Difficile");
        getContentPane().add(difficile);
        difficile.setBounds(285, 168, 50, 14);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/menu.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 350, 260);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-354)/2, (screenSize.height-284)/2, 354, 284);
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
            jSlider1.setEnabled(false);
        } else {
            facile.setEnabled(true);
            moyen.setEnabled(true);
            difficile.setEnabled(true);
            nbParties.setEnabled(true);
            lbDif.setEnabled(true);
            jSlider1.setEnabled(true);
        }
    }//GEN-LAST:event_modeItemStateChanged

    private void nbPartiesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nbPartiesFocusLost
        // TODO add your handling code here:
        if (nbParties.getSelectedItem() instanceof Integer) {
            nbParties.setBackground(Color.white);


        } else {
            nbParties.setBackground(Color.red);


        }
    }//GEN-LAST:event_nbPartiesFocusLost

    private void LaunchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LaunchActionPerformed
        // TODO add your handling code here:
        // on ferme la fenetre de menu
        this.dispose();
        new Thread(new Runnable() {
        	public void run() {
              
		        Table table = new Table();
		        Moteur moteur = new Moteur(table);
		        //Jeu monJeu = new Jeu(moteur, 1,0,1,0);      
                        System.out.println("jslider" + jSlider1.getValue());
		        Jeu monJeu = new Jeu(moteur, 1,mode.getSelectedIndex() , Integer.parseInt((String)nbParties.getSelectedItem()), jSlider1.getValue());
		        
		        final Graphique gg = new Graphique(monJeu, 1);
		        // test
		        monJeu.addObservateur(new Observateur() {
					public void update(Jeu jeu) {
						gg.getZoneDessin().repaint();					
					}
				});
		        SwingUtilities.invokeLater(gg);
		        monJeu.jouer();
		        /*monJeu.moteur.table.paquet.afficherPaquetConsole();
		        /*System.out.println("apres destribution le paquet dois etre vide :");
		        if (monJeu.moteur.table.paquet.estVide()) {
		            System.out.println("VRAI");
		        } else {
		            System.out.println("FAUX");
		        }
		
		        System.out.println("j'affiche la premiere main");
		        monJeu.moteur.table.main1.afficherMainConsole();
		
		        System.out.println("j'affiche la deusiÃ¨me main");
		        monJeu.moteur.table.main2.afficherMainConsole();
		
		        System.out.println("j'affiche les 6 piles de 5 cartes :");
		        for (int i = 0; i < 6; i++) {
		            System.out.println("j'affiche la pile num " + i);
		            monJeu.moteur.table.piles.get(i).afficherPileConsole();
		        }*/
		        //System.out.println(monJeu.getMoteur().getTable().getAtout());
		        
		      }
        }).start();


    }//GEN-LAST:event_LaunchActionPerformed

    private void modeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modeActionPerformed

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
    private javax.swing.JLabel difficile;
    private javax.swing.JLabel facile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JLabel lbDif;
    private javax.swing.JComboBox mode;
    private javax.swing.JLabel moyen;
    private javax.swing.JComboBox nbParties;
    // End of variables declaration//GEN-END:variables
}
