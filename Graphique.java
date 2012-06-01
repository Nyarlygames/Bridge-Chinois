import java.awt.*;
import javax.swing.*;
import javax.swing.JPopupMenu.Separator;

public class Graphique implements Runnable {

    public int LARGEUR_FEN = 800;
    public int HAUTEUR_FEN = 650;
    public int tailleFenetreX;
    public int tailleFenetreY;
    Config cfg;
    Jeu jeu;
    JFrame frame;
    ZoneDessin zoneDessin;

    public ZoneDessin getZoneDessin() {
        return zoneDessin;
    }

    public Graphique(Jeu j) {
	    this.cfg = new Config();
        jeu = j;
	    this.LARGEUR_FEN = Config.width;
	    this.HAUTEUR_FEN = Config.height;
	    this.zoneDessin = zoneDessin;

        frame = new JFrame("Bridge chinois");
	    frame.addComponentListener(new EcouteurDeFrame(frame));

	    zoneDessin = new ZoneDessin(j, this.cfg);
        zoneDessin.addMouseListener(new EcouteurDeSouris(this, jeu));
	    zoneDessin.addMouseMotionListener(new MouseMove(this, jeu));
        JMenuBar menuBar = new javax.swing.JMenuBar();
        JMenu fileMenu = new javax.swing.JMenu();
        JMenuItem openMenuItem = new javax.swing.JMenuItem();
        JMenuItem abandonnerMenuItem = new javax.swing.JMenuItem();
        JMenuItem saveAsMenuItem = new javax.swing.JMenuItem();
        JMenuItem annulerMenuItem = new javax.swing.JMenuItem();
        JMenuItem refaireMenuItem = new javax.swing.JMenuItem();
        Separator jSeparator1 = new javax.swing.JPopupMenu.Separator();
        JMenuItem jMenuItem1 = new javax.swing.JMenuItem();
        Separator jSeparator2 = new javax.swing.JPopupMenu.Separator();
        JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        JMenu helpMenu = new javax.swing.JMenu();
        JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        JMenuItem hintMenuItem = new javax.swing.JMenuItem();
        fileMenu.setMnemonic('p');
        fileMenu.setText("Partie");

        openMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        openMenuItem.setMnemonic('n');
        openMenuItem.setText("Nouvelle Partie");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        fileMenu.add(openMenuItem);

        abandonnerMenuItem.setMnemonic('a');
        abandonnerMenuItem.setText("Abandonner");
        abandonnerMenuItem.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Frame confirm = null;
                //demander confirmation
                Confirmation a = new Confirmation(confirm,true,"Voulez vous vraiment quitter ?");
                a.setVisible(true);
                if (a.getReturnStatus()==1)
                {
                    frame.dispose();
                    Menu m = new Menu();
                    m.setVisible(true);
                }
                //else a.setVisible(false);
                //dire au jeu qu'on abandonne la donne
                //-> il ferme la fenetre donc pas de sauvegarde ou autre => cette étape sert à rien
                //a griser si on joue sur le nombre de plis
            }
        });

        saveAsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveAsMenuItem.setMnemonic('s');
        saveAsMenuItem.setText("Sauvegarder");

        saveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showSaveDialog(frame);
            }
        });

        fileMenu.add(abandonnerMenuItem);
        fileMenu.add(saveAsMenuItem);


        annulerMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        annulerMenuItem.setMnemonic('a');
        annulerMenuItem.setText("Annuler");

        annulerMenuItem.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                jeu.getHist().annuler();
                jeu.setJoueur1(jeu.getHist().getCourant().getJoueur1());
                jeu.setJoueur2(jeu.getHist().getCourant().getJoueur2());
                jeu.getMoteur().setTable(jeu.getHist().getCourant().getTable());
                jeu.updateObservateur();


            }
        });

        fileMenu.add(annulerMenuItem);

        refaireMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        refaireMenuItem.setMnemonic('r');
        refaireMenuItem.setText("Refaire");

        refaireMenuItem.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jeu.getHist().refaire();
                jeu.setJoueur1(jeu.getHist().getCourant().getJoueur1());
                jeu.setJoueur2(jeu.getHist().getCourant().getJoueur2());
                jeu.getMoteur().setTable(jeu.getHist().getCourant().getTable());
                jeu.updateObservateur();
                
            }
        });

        fileMenu.add(refaireMenuItem);
        fileMenu.add(jSeparator1);

        jMenuItem1.setText("Options");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {


            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //Options opt = new Options(this,true;);
                //opt.setVisible(true);
            }
        });
        fileMenu.add(jMenuItem1);
        fileMenu.add(jSeparator2);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Quitter");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Frame confirm = null;
                //demander confirmation
                Confirmation a = new Confirmation(confirm,true,"Voulez vous vraiment quitter ?");
                a.setVisible(true);
                if (a.getReturnStatus()==1)
                {
                    frame.dispose();
                }
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Aide");

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("Règles");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Regle reg = new Regle(frame, true);
                reg.setVisible(true);
            }
        });
        hintMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, 0));
        hintMenuItem.setText("Indice");
        hintMenuItem.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //todo
            }
        });




        helpMenu.add(aboutMenuItem);
        helpMenu.add(hintMenuItem);
        menuBar.add(helpMenu);

        frame.setJMenuBar(menuBar);


        // Panel principal
        JPanel panel = new JPanel();
        BorderLayout layout = new BorderLayout();
        panel.setLayout(layout);

        panel.add(zoneDessin);

        frame.setPreferredSize(new Dimension(LARGEUR_FEN, HAUTEUR_FEN));
        frame.setContentPane(panel);
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds((screenSize.width - LARGEUR_FEN) / 2, (screenSize.height - HAUTEUR_FEN) / 2, LARGEUR_FEN, HAUTEUR_FEN);
    }

    public void run() {

        // Un clic sur le bouton de fermeture clos l'application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tailleFenetreX = LARGEUR_FEN;
        tailleFenetreY = HAUTEUR_FEN;
        // On fixe la taille et on demarre
        frame.setSize(tailleFenetreX, tailleFenetreY);
        // frame.setResizable(false);
        frame.setVisible(true);
        frame.pack();

    }
}

