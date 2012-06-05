import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import javax.swing.SwingUtilities;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Val
 */
public class Multi extends javax.swing.JFrame {

    String ip;
    String host;
    // PORT int port;

    /**
     * Creates new form NewJFrame
     */
    public Multi() {
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

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        IP = new javax.swing.JTextField();
        Start = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        Rejoindre = new javax.swing.JTabbedPane();
        jPanelHeberger = new javax.swing.JPanel();
        jLabelVotreIP = new javax.swing.JLabel();
        IPJoueur = new javax.swing.JFormattedTextField();
        copierIP = new javax.swing.JButton();
        jPanelRejoindre = new javax.swing.JPanel();
        jLabelIPDistante = new javax.swing.JLabel();
        IPDistante = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        jLabel1.setText("IP distante :");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        Start.setText("Jouer");
        Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartActionPerformed(evt);
            }
        });
        getContentPane().add(Start);
        Start.setBounds(230, 160, 80, 23);

        Cancel.setText("Annuler");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });
        getContentPane().add(Cancel);
        Cancel.setBounds(10, 160, 80, 23);

        jPanelHeberger.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelHeberger.setOpaque(false);

        jLabelVotreIP.setText("Votre IP : ");

        IPJoueur.setFocusable(false);
        try{
            URL whatismyip = new URL("http://api.externalip.net/ip/");
            BufferedReader in = new BufferedReader(new InputStreamReader(
                whatismyip.openStream()));

        IPJoueur.setValue(in.readLine()); //you get the IP as a String
    }catch(Exception e)
    {
    }

    copierIP.setText("Copier l'IP");
    copierIP.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            copierIPActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanelHebergerLayout = new javax.swing.GroupLayout(jPanelHeberger);
    jPanelHeberger.setLayout(jPanelHebergerLayout);
    jPanelHebergerLayout.setHorizontalGroup(
        jPanelHebergerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelHebergerLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(copierIP)
            .addGap(110, 110, 110))
        .addGroup(jPanelHebergerLayout.createSequentialGroup()
            .addGroup(jPanelHebergerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelHebergerLayout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jLabelVotreIP, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelHebergerLayout.createSequentialGroup()
                    .addGap(71, 71, 71)
                    .addComponent(IPJoueur, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(73, Short.MAX_VALUE))
    );
    jPanelHebergerLayout.setVerticalGroup(
        jPanelHebergerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelHebergerLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelVotreIP)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(IPJoueur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(copierIP)
            .addGap(0, 15, Short.MAX_VALUE))
    );

    Rejoindre.addTab("Heberger", jPanelHeberger);

    jPanelRejoindre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jPanelRejoindre.setOpaque(false);

    jLabelIPDistante.setText("IP Distante : ");

    IPDistante.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###:###:###:###"))));

    javax.swing.GroupLayout jPanelRejoindreLayout = new javax.swing.GroupLayout(jPanelRejoindre);
    jPanelRejoindre.setLayout(jPanelRejoindreLayout);
    jPanelRejoindreLayout.setHorizontalGroup(
        jPanelRejoindreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelRejoindreLayout.createSequentialGroup()
            .addGroup(jPanelRejoindreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelRejoindreLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabelIPDistante, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelRejoindreLayout.createSequentialGroup()
                    .addGap(71, 71, 71)
                    .addComponent(IPDistante, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(73, Short.MAX_VALUE))
    );
    jPanelRejoindreLayout.setVerticalGroup(
        jPanelRejoindreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelRejoindreLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelIPDistante)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(IPDistante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(49, Short.MAX_VALUE))
    );

    Rejoindre.addTab("Rejoindre", jPanelRejoindre);

    getContentPane().add(Rejoindre);
    Rejoindre.setBounds(10, 11, 300, 130);

    jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/menu.jpg"))); // NOI18N
    getContentPane().add(jLabel2);
    jLabel2.setBounds(0, 0, 370, 210);

    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((screenSize.width-353)/2, (screenSize.height-238)/2, 353, 238);
    }// </editor-fold>//GEN-END:initComponents

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        // TODO add your handling code here:
        
     
            Menu m = new Menu();
            m.setVisible(true);
            this.dispose();

    }//GEN-LAST:event_CancelActionPerformed

    private void StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartActionPerformed
        // TODO add your handling code here:

	    if (Rejoindre.getTitleAt(Rejoindre.getSelectedIndex()).equals("Heberger")) {
	        VSPlayer fenOp = new VSPlayer(this.ip, this.host);
	        fenOp.setVisible(true);
	    }
	    else if (Rejoindre.getTitleAt(Rejoindre.getSelectedIndex()).equals("Rejoindre")) {
            this.dispose();
            new Thread(new Runnable() {
                	public void run() {
                    Table t = new Table();
                    Moteur moteur = new Moteur(t);
	                Jeu monJeu = new Jeu(moteur, 2, 0, 1, 0, false);
	                monJeu.attachDistantPlayer(ip, false);
                    final Graphique gg = new Graphique(monJeu);
                    // test
                    monJeu.addObservateur(new Observateur() {
			            public void update(Jeu jeu) {
				            gg.getZoneDessin().repaint();					
			            }
		            });
                    SwingUtilities.invokeLater(gg);
                    monJeu.jouer();
                }
            }).start();
	    }

        this.dispose();
    }//GEN-LAST:event_StartActionPerformed

    private void copierIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copierIPActionPerformed
        // TODO add your handling code here:
        StringSelection contents = new StringSelection(IPJoueur.getValue().toString());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(contents, null);
    }//GEN-LAST:event_copierIPActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        // Confirmation a = new Confirmation(this, true, "Revenir au menu ?");
        // a.setVisible(true);

        // if (a.getReturnStatus() == 1) {
        Menu m = new Menu();
        m.setVisible(true);
        this.dispose();
        //}
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
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Multi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Multi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Multi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Multi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Multi().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel;
    private javax.swing.JTextField IP;
    private javax.swing.JFormattedTextField IPDistante;
    private javax.swing.JFormattedTextField IPJoueur;
    private javax.swing.JTabbedPane Rejoindre;
    private javax.swing.JButton Start;
    private javax.swing.JButton copierIP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelIPDistante;
    private javax.swing.JLabel jLabelVotreIP;
    private javax.swing.JPanel jPanelHeberger;
    private javax.swing.JPanel jPanelRejoindre;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    static boolean isInternetIP(String str){
        System.out.println("isInternetIP");
	    boolean internet = true;
	    int i = 0;
	    String str2 = str.substring(0,4);

	    if (!str2.equals("127.") && !str2.equals("192.") && !str2.equals("168.")) {
	        for (i = 0; i < str.length() - 1; i++){
		    char c = str.charAt(i);
		    if (c == ':')
		        internet = false;
	        }
	    }
	    else {
	        internet = false;
	    }
	    
	    return internet;
    }

    static boolean isLANIP(String str){
        System.out.println("isLANIP");
	    boolean internet = true;
	    int i = 0;
	    String str2 = str.substring(0,4);

	    if (str2.equals("192.")) {
	    
	        for (i = 0; i < str.length() - 1; i++) {
		        char c = str.charAt(i);
		        
		        if (c == ':')
		            internet = false;
            }
	    }
	    else {
	        internet = false;
	    }
	    
	    return internet;
    }
}

