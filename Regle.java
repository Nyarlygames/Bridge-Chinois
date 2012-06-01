/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Amine
 */
public class Regle extends javax.swing.JDialog {

    /**
     * Creates new form Regle
     */
    public Regle(java.awt.Frame parent, boolean modal) {
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

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Les règles du jeu");
        setResizable(false);
        getContentPane().setLayout(null);

        jButton1.setText("Annuler");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(460, 458, 79, 23);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("Les règles du Bridge Chinois :\n\nLe bridge chinois est un jeu de cartes à 2 joueurs.\nOn utilise un jeu de 52 cartes. L'ordre des cartes et des couleurs est le même \nqu'au bridge (as, roi, dame, valet, dix, ...deux, et pique, coeur, carreau, trèfle).\nLe donneur distribue 11 cartes à chacun des 2 joueurs, puis distribue les cartes \nrestantes en 6 piles de 5 cartes, face cachée. Puis il découvre les 6 cartes qui \nsont au sommet de chacune des 6 piles. Si toutes les cartes visibles ont une \nvaleur inférieure à 10, la manche est jouée sans atout. Sinon, l'atout est fixé \npar la carte découverte la plus forte.\n\nLe but du jeu est de réaliser un nombre de plis le plus grand possible \n(en particulier, plus que l'adversaire). Chaque pli va consister en 2 cartes, \nchacune posée sur le tapis par l'un des joueurs, choisie parmi les cartes \nqu'il a en main. Le pli est gagné et ramassé (faces cachées, sans possibilité de \nle consulter par la suite) par le joueur :\n     qui a posé la carte la plus forte, si les deux cartes sont de même couleur,\n     qui a coupé (joué un atout) si l'une des deux cartes est un atout,\n     qui a posé la première carte, si les deux cartes sont de couleur différente \n             et qu'aucune n'est un atout (on dit que le second joueur s'est défaussé).\n\nLe donneur a initialement la main.\nLe joueur qui gagne le pli prend (ou garde) la main.\nLe joueur qui a la main choisit une des cartes de sa main, et la pose sur le tapis.\nL'autre joueur, s'il le peut, doit fournir : jouer une carte de la même couleur.\nS'il ne peut pas fournir, il a le choix entre couper ou se défausser.\nDonc, on n'est pas obligé de couper.\nSi la manche se joue sans atout, le second joueur ne peut bien sûr que se \ndéfausser s'il ne peut fournir... dur !\nLe joueur qui a gagné le pli le ramasse. Puis il choisit l'une des cartes \ndécouvertes (s'il en reste... voir plus loin) et la place dans sa main. \nIl découvre ensuite la carte cachée qu'il a ainsi fait apparaître en sommet \nde pile (si la pile n'est pas vide). L'autre joueur choisit à son tour une carte \ndécouverte (il y en a au moins une, puisqu'il y a un nombre pair de cartes dans \nles piles sur la table : c'est un invariant de l'itération). \nPuis il découvre la carte cachée qu'il a ainsi fait apparaître en sommet de pile \n(si la pile n'est pas vide).\nDans la première phase de la manche, les 2 joueurs ont ainsi toujours\n11 cartes en main (encore un invariant).\n\nLorsque les piles sont épuisées, la manche continue selon les mêmes règles,\nen supprimant la phase de choix/découverte, bien sûr.\nCette seconde phase s'arrête, puisque le nombre de cartes que les joueurs ont \nen main décroît strictement à chaque levée. La manche se termine lorsque les\n2 joueurs n'ont plus de carte en main. S'il reste des cartes à l'un et pas à\nl'autre, c'est que l'un ou l'autre a triché, ou qu'il y a une erreur dans le\nprogramme.\n\nÀ la fin de la manche, on compte les plis de chacun (ou d'un seul des deux,\nles plus fûtés voient pourquoi) et chacun se voit attribuer par l'arbitre le\nnombre de points correspondant.\nEn général, l'arbitre est l'un des deux joueurs, l'autre surveille simplement\nles comptes.\nAu cours des manches successives, chaque joueur donne tour à tour.\nLa partie se joue en un nombre de points ou en un nombre de manches qui a été\nfixé à l'avance (par exemple 100 points, ou 12 manches). Dans le cas où le nombre\nde manches est fixé, il faut choisir un nombre pair, car le donneur a un certain\navantage. ");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setCaretPosition(0);
        jTextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextArea1.setFocusable(false);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 23, 529, 424);

        jLabel1.setBackground(new java.awt.Color(0, 102, 0));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 560, 510);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-565)/2, (screenSize.height-530)/2, 565, 530);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Regle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Regle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Regle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Regle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                Regle dialog = new Regle(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
