
import java.awt.event.*;

class EcouteurDeSouris implements MouseListener {

    // Atributs
    Graphique g;
    Jeu jeu;

    public EcouteurDeSouris(Graphique gg, Jeu j) {
        this.g = gg;
        this.jeu = j;
    }

    // Lors d'une pression de bouton, on change de message
    public void mousePressed(MouseEvent e) {
        
        g.getZoneDessin().i = e.getX();
        g.getZoneDessin().j = e.getY();
        
        // si on clique dans la zone du deuxieme titre, on va en mode JEU
        if ( (e.getX() > ((g.getZoneDessin().getSize().height % g.getZoneDessin().opt) + 2*100)) 
                && (e.getX() < ((g.getZoneDessin().getSize().height % g.getZoneDessin().opt) + 3*100)) ) {
          g.getZoneDessin().mode = 2;
        }
        g.getZoneDessin().repaint();

    }

    // Il faut aussi une implementation pour les autres methodes de l'interface
    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
        g.getZoneDessin().repaint();

    }
}
