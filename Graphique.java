
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
    FinPartie f ;
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
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        
        zoneDessin = new ZoneDessin(j, this.cfg);
        zoneDessin.addMouseListener(new EcouteurDeSouris(this, jeu));
        zoneDessin.addMouseMotionListener(new MouseMove(this, jeu));
        JMenuBar menuBar = new javax.swing.JMenuBar();
        JMenu fileMenu = new javax.swing.JMenu();
        JMenuItem openMenuItem = new javax.swing.JMenuItem();
        JMenuItem abandonnerMenuItem = new javax.swing.JMenuItem();
        JMenuItem saveAsMenuItem = new javax.swing.JMenuItem();
        JMenuItem loadMenuItem = new javax.swing.JMenuItem();
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


        //Son au clique de souris sur le bouton
        try {
	           Son s = new Son("Bdemarrer.wav");
	} catch (Exception ex) {
	    System.out.println("Fail son");
        }
        // on ferme la fenetre de menu
	frame.dispose();
        new Thread(new Runnable() {
        	public void run() {
                         
		        Table table = new Table();
		        Moteur moteur = new Moteur(table);
		        Jeu monJeu = new Jeu(moteur, jeu.mode, jeu.type, jeu.max, jeu.diff);
		        final Graphique gg = new Graphique(monJeu);
		        monJeu.addObservateur(new Observateur() {
					public void update(Jeu jeu) {
						gg.getZoneDessin().repaint();
                                                        if (jeu.fin)
                                                        {
                                                                f =new FinPartie(frame,true,jeu.fin,jeu.gg);
                                                                f.setVisible(true);
                                                        }
                                                
					}
				});
		        SwingUtilities.invokeLater(gg);
		        monJeu.jouer();
		      }
        }).start();
	    }});

        fileMenu.add(openMenuItem);

        abandonnerMenuItem.setMnemonic('a');
        abandonnerMenuItem.setText("Abandonner");
        abandonnerMenuItem.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Frame confirm = null;
                //demander confirmation
                Confirmation a = new Confirmation(confirm, true, "Voulez vous vraiment quitter ?");
                a.setVisible(true);
                if (a.getReturnStatus() == 1) {
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
                Sauvegarde.saveGame("saves/"+fileChooser.getName(fileChooser.getSelectedFile()), jeu);
            }
        });
        loadMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        loadMenuItem.setMnemonic('c');
        loadMenuItem.setText("Charger");

        loadMenuItem.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showOpenDialog(frame);
                Sauvegarde.loadGame(fileChooser.getName(fileChooser.getSelectedFile()), frame);

            }
        });
        fileMenu.add(abandonnerMenuItem);
        fileMenu.add(saveAsMenuItem);
        fileMenu.add(loadMenuItem);

        annulerMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        annulerMenuItem.setMnemonic('a');
        annulerMenuItem.setText("Annuler");

        annulerMenuItem.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                jeu.getHist().annuler();
                
                jeu.setJoueurCourant(1);
                
                jeu.getJoueur1().setNouveauJoueur(jeu.getHist().getCourant().getJoueur1().table, jeu.getHist().getCourant().getJoueur1().nbPlis, jeu.getHist().getCourant().getJoueur1().aJoue, jeu.getHist().getCourant().getJoueur1().aChoisi, jeu.getHist().getCourant().getJoueur1().phaseChoisir, true);
                System.out.println("nouveau joueur");
                if (jeu.getJoueur2()!=null)
                jeu.getJoueur2().setNouveauJoueur(jeu.getHist().getCourant().getJoueur2().table, jeu.getHist().getCourant().getJoueur2().nbPlis, jeu.getHist().getCourant().getJoueur2().aJoue, jeu.getHist().getCourant().getJoueur2().aChoisi, jeu.getHist().getCourant().getJoueur2().phaseChoisir, jeu.getHist().getCourant().getJoueur2().phaseJouer);
                
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
                Options opt = new Options(frame, true);
                opt.setVisible(true);
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
                Confirmation a = new Confirmation(confirm, true, "Voulez vous vraiment quitter ?");
                a.setVisible(true);
                if (a.getReturnStatus() == 1) {
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
                if (jeu.getJoueur1() instanceof Humain && jeu.getJoueur1().getaJoue() == false) {
                    jeu.setHintCarte(((Humain) jeu.getJoueur1()).hintJouer());
                    zoneDessin.repaint();
                    System.out.println("Hint Carte : " + jeu.getHintCarte());
                } else if (jeu.getJoueur1() instanceof Humain && jeu.getJoueur1().getaJoue() == true) {
                    jeu.setHintPile(((Humain) jeu.getJoueur1()).hintChoisir());
					zoneDessin.repaint();
					System.out.println("Hint Pile: " + jeu.getHintPile());
                }

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
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        // TODO add your handling code here:
        Confirmation a = new Confirmation(frame,true,"Voulez vous vraiment quitter ?");
        a.setVisible(true);
        
        if (a.getReturnStatus()==1)
            frame.dispose();
    }
    public void run() {

        // Un clic sur le bouton de fermeture clos l'application
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        tailleFenetreX = LARGEUR_FEN;
        tailleFenetreY = HAUTEUR_FEN;
        // On fixe la taille et on demarre
        frame.setSize(tailleFenetreX, tailleFenetreY);
        // frame.setResizable(false);
        frame.setVisible(true);
        frame.pack();

    }
}
