import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Graphique implements Runnable {
    
    public int LARGEUR_FEN = 800;
    public int HAUTEUR_FEN = 650;
    public int tailleFenetreX;
    public int tailleFenetreY;
    Jeu jeu;
    JFrame frame;
    ZoneDessin zoneDessin;   
    
    public ZoneDessin getZoneDessin() {
        return zoneDessin;
    }
    
    
    public Graphique(Jeu j) {
        jeu = j;
	    this.frame = frame;
	    this.zoneDessin = zoneDessin;
	    
        frame = new JFrame("Bridge chinois");

	    // Zone du jeu
        zoneDessin = new ZoneDessin(j.moteur.table);
        zoneDessin.addMouseListener(new EcouteurDeSouris(this, jeu));

	// Haut et bas
	JLabel menu = new JLabel("Menu ");
	JLabel info = new JLabel("Infos");

	// Panel principal
	JPanel panel = new JPanel();
	BorderLayout layout = new BorderLayout();
	panel.setLayout(layout);

	panel.add("North", menu);
	panel.add("Center", zoneDessin);
	panel.add("South", info);

	frame.setPreferredSize(new Dimension(LARGEUR_FEN, HAUTEUR_FEN));
	frame.setContentPane(panel);

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
