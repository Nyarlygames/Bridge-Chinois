import java.awt.*;
import javax.swing.*;

public class Graphique implements Runnable {
    
    public int LARGEUR_FEN = 400;
    public int HAUTEUR_FEN = 500;
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
        
        frame = new JFrame("Bridge chinois");
       
        zoneDessin = new ZoneDessin(j.moteur.table);
        
        // Link les JComponents a leurs ecouteurs respectifs
        zoneDessin.addMouseListener(new EcouteurDeSouris(this, jeu));
        
        frame.add(zoneDessin);
        
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
        
    }
}
