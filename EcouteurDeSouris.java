/*
Auteur : ZIANE-CHERIF Mohammed-El-Amine
Date de Creation 16/05/2012 : 17:58
 */

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class EcouteurDeSouris implements MouseListener {

    // -------------------------------------Attribute-------------------------------------
    Graphique g;
    Jeu jeu;

    // -------------------------------------Constructor-------------------------------------
    public EcouteurDeSouris(Graphique gg, Jeu j) {
        this.g = gg;
        this.jeu = j;
    }

    // -------------------------------------Methodes-------------------------------------
    public void mousePressed(MouseEvent e) {
        //Carte du clic sur la main
        Carte carte = getCarteMain(e.getX(), e.getY());
        //Carte du clic sur pile
        Pile clicpile = getCartePile(e.getX(), e.getY());
        //en prend en compte son choix

	// Annuler
	if (getBouton(e.getX(), e.getY()) == 0) {

                jeu.getHist().annuler();
                jeu.setJoueurCourant(1);
                jeu.getJoueur1().setNouveauJoueur(jeu.getHist().getCourant().getJoueur1().table, jeu.getHist().getCourant().getJoueur1().nbPlis, jeu.getHist().getCourant().getJoueur1().aJoue, jeu.getHist().getCourant().getJoueur1().aChoisi, jeu.getHist().getCourant().getJoueur1().phaseChoisir, true);
                System.out.println("nouveau joueur");
                if (jeu.getJoueur2()!=null)
                jeu.getJoueur2().setNouveauJoueur(jeu.getHist().getCourant().getJoueur2().table, jeu.getHist().getCourant().getJoueur2().nbPlis, jeu.getHist().getCourant().getJoueur2().aJoue, jeu.getHist().getCourant().getJoueur2().aChoisi, jeu.getHist().getCourant().getJoueur2().phaseChoisir, jeu.getHist().getCourant().getJoueur2().phaseJouer);
                jeu.getMoteur().setTable(jeu.getHist().getCourant().getTable());
                jeu.updateObservateur();
	}
	// Refaire
	else if (getBouton(e.getX(), e.getY()) == 1) {
                jeu.getHist().refaire();
                jeu.setJoueur1(jeu.getHist().getCourant().getJoueur1());
                jeu.setJoueur2(jeu.getHist().getCourant().getJoueur2());
                jeu.getMoteur().setTable(jeu.getHist().getCourant().getTable());
                jeu.updateObservateur();
	}
        if (carte != null && jeu.intVersJoueur().equals(jeu.getJoueur1()) && jeu.getJoueur1().getPhaseJouer()) {
            // dans ce cas le joueur courant est l'humain il est en phase de jeu
            //en prend en compte son choix

            if (jeu.getMoteur().jouer(carte)) {

                System.out.println("j'ai choisi la carte " + carte.toString());
				// Animation de la carte jouee
				// g.getZoneDessin().jouerCarte(carte);
				// dans ce cas le joueur courant est l'humain il est en phase de jeu
                // en prend en compte son choix
                // jeu.getMoteur().jouer(carte);

                jeu.intVersJoueur().setaJoue(Boolean.TRUE);
            }
        }

        if (clicpile != null && jeu.intVersJoueur().equals(jeu.getJoueur1()) && jeu.getJoueur1().getPhaseChoisir()) {
            // dans ce cas le joueur est en phase de choix de carte a piocher
            //en prend en compte son choix

            //  EntreeHistorique ent= new EntreeHistorique(jeu.getJoueur1(),jeu.getJoueur2(),jeu.getMoteur().getTable().clone());
            //////////////////////!!!!!!!
            ///jeu.getHist().addEntree(ent);
            jeu.getMoteur().choisir(clicpile, jeu.getJoueurCourant());
            jeu.intVersJoueur().setaChoisi(Boolean.TRUE);
            //g.getZoneDessin().repaint();      

        }
    }

    // Il faut aussi une implementation pour les autres methodes de l'interface
    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
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

    // Clic carte sur pile
    public Pile getCartePile(int x, int y) {
        int width = g.getZoneDessin().getSize().width;
        int height = g.getZoneDessin().getSize().height - 20;
        int cw = g.getZoneDessin().cw;
        int ch = g.getZoneDessin().ch;
        Table t = g.getZoneDessin().t;



        // Pixel debut affichage pile
        double start = (double) ((width / 2) - ((6 * (cw) + 5 * 20 + 4 * 3) / 2));

        if ((y >= height / 2 - ch / 2) && (y <= height / 2 + ch / 2)) {


            // Indice du bloc de la pile
            double bloc = (x - start) / (cw + 20);

            // Indice interne au bloc de la pile
            double area = (x - start) % (cw + 20);


            if ((bloc < 6) && (bloc >= 0)) {
                if ((area >= (t.piles.get((int) bloc).getSize() - 1) * 3) && (area <= cw + (t.piles.get((int) bloc).getSize() - 1) * 3)) {
                    // Numero de la pile
                    double pile = (x - start) / (cw + 20);
                    // Cas pile vide
                    if (t.piles.get((int) pile).getSize() != 0) {
                        return t.piles.get((int) pile);
                    } else {
                        return null;
                    }
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } else {
            return null;
        }
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
                else if (((int) carte == t.main1.getSize()) && ((int) carte > 0)) {
                    return t.main1.getCarte(t.main1.getSize() - 1);
                } else if ((int) carte >= 0) {
                    return t.main1.getCarte((int) carte);
                } else {
                    return null;
                }
            } else {
                return null;
            }

        } else {
            return null;
        }
    }
}
