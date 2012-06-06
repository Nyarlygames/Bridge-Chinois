import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

class MouseMove implements MouseMotionListener {

    //-----------------------------------Attributs---------------------/
    Graphique g;
    Jeu j;

    //-----------------------------------Constructeur------------------/

    public MouseMove(Graphique g, Jeu j) {
	    this.g = g;
	    this.j = j;
    }

    //-----------------------------------Methode-----------------------/

    public void mouseMoved(MouseEvent e) {
        if (j.getJoueurCourant() == 1 && !j.intVersJoueur().getaJoue() ) 
        {
            g.getZoneDessin().carteactive = getCarteMain(e.getX(), e.getY());
            g.getZoneDessin().bouton = getBouton(e.getX(), e.getY());
            g.getZoneDessin().repaint();
        }
    }

    public void mouseDragged(MouseEvent e) {
    }

    // Clic sur bouton
    public int getBouton(int x, int y) {
        int width = g.getZoneDessin().getSize().width;
        int height = g.getZoneDessin().getSize().height - 20;
        int cw = g.getZoneDessin().cw;
        int ch = g.getZoneDessin().ch;
        int bw = g.getZoneDessin().bw;
        int bh = g.getZoneDessin().bh;
        int aw = g.getZoneDessin().aw;
        int ah = g.getZoneDessin().ah;
        int rw = g.getZoneDessin().rw;
        int rh = g.getZoneDessin().rh;
        Table t = g.getZoneDessin().t;

        if ((x > bw) && (x < bw + aw)){
            // annuler
            if ((y >= height - bh - ah - rh) && (y <= height - bh - rh)) {
                return(0);
            }
            // refaire
            if ((y > height - bh - rh) && (y < height - bh)) {
                return(1);
            }
        }
        return (-1);
    }


    // Clic carte sur la main
    public Carte getCarteMain(int x, int y) {
        int width = g.getZoneDessin().getSize().width;
        int height = g.getZoneDessin().getSize().height - 20;
        int cw = g.getZoneDessin().cw;
        int ch = g.getZoneDessin().ch;
        int bw = g.getZoneDessin().bw;
        int bh = g.getZoneDessin().bh;
        Table t = g.getZoneDessin().t;

        // Pixel debut affichage carte
        double start = (double) ((width / 2) - (((t.main1.getSize() + 1) * (cw) / 2) * 0.5));

	if (t.main1.getSize() > 0) {
	    if ((y >= (height - ch - bh)) && (y <= (height - bh))) {
		// Indice de la carte cliquee
		double carte = (x - start) / ((cw / 2) + 0.5);

		// Clic en dehors
		if (carte < 0 || (int) carte > t.main1.getSize()) {
		    return (null);
		} // Deuxieme moitie derniere carte
		else if (((int) carte == t.main1.getSize()) && ((int) carte > 0))
                return t.main1.getCarte(t.main1.getSize() - 1);
		else if ((int) carte >= 0)
		    return t.main1.getCarte((int) carte);
		else
		    return (null);
	    }
	    else {
		return null;
	    }
	}
	else {
	    return null;
	}
    }
}
