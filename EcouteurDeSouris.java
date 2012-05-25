/*
Auteur : ZIANE-CHERIF Mohammed-El-Amine
Date de Creation 16/05/2012 : 17:58
Date de Derniere modification 16/05/2012 : 18:00
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

    
    
    /*  d'abord on verifie si on est en attente d'un clique dans la zone ou a eu le clique

    il y a 3 zones où les clique sont permis :
    1 - clique sur la main1
    2 - clique sur la main2
    3 - clique sur une pile 

	on connais les conditions d'un clique attendu grace aux attribut aJoue et aChoisi de chaque joueurs
     */
    public void mousePressed(MouseEvent e) {

        g.getZoneDessin().repaint();

        //Carte du clic sur la main
        Carte carte = getCarteMain(e.getX(), e.getY());
        //Carte du clic sur pile
        Pile clicpile = getCartePile(e.getX(), e.getY());
        //en prend en compte son choix

        if (carte != null) {
            if (jeu.intVersJoueur().equals(jeu.joueur1) && !jeu.joueur1.aJoue) {

                // dans ce cas le joueur courant est le J1 il n'as pas encore jouer et il a bien clikï¿½ sur sa main1
                //en prend en compte son choix
     			/* = on recupere la carte sur la quel on a clique ;*/
                {
                    jeu.moteur.jouer(carte, jeu.getJoueurCourant());
                    jeu.getJoueur1().setaJoue(Boolean.TRUE);
                }
            } else if (true) {
                if (jeu.intVersJoueur().equals(jeu.joueur1) && jeu.getJoueur1().getaJoue() && !jeu.getJoueur1().getaChoisi()) {
                    Pile pile = null;
                    // dans ce cas le joueur courant est le J1 il a deja joue et il a bien clike sur un pli
                    //en prend en compte son choix
                    jeu.getMoteur().getTable().getMain1().add(pile.piocher());
                    jeu.intVersJoueur().setaChoisi(true);
                } else if (jeu.intVersJoueur().equals(jeu.joueur2) && jeu.getJoueur2().getaJoue() && !jeu.getJoueur2().getaChoisi()) {
                    Pile pile = null;

                    // dans ce cas le joueur courant est le J2 il a deja joue et il a bien clike sur un pli
                    //en prend en compte son choix
                    jeu.getMoteur().getTable().getMain2().add(pile.piocher());
                    jeu.intVersJoueur().setaChoisi(true);
                }
            }

        }
    }

    // Il faut aussi une implementation pour les autres methodes de l'interface
    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mouseClicked(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}


// Clic carte sur pile
    public Pile getCartePile(int x, int y){
        int width = g.getZoneDessin().getSize().width;
        int height = g.getZoneDessin().getSize().height;
        int cw = g.getZoneDessin().cw;
        int ch = g.getZoneDessin().ch;
        Table t = g.getZoneDessin().t;
        
        
        // Pixel debut affichage pile
        double start = (double) ((width / 2) - ((6 * (cw) + 5 * 20 + 4 * 3) / 2));
         
        if ((y >= height/2 -ch/2) && (y <= height/2 + ch/2)) {
           
           
            // Indice du bloc de la pile
            double bloc = (x  - start) / (cw + 20) ;  
            
            // Indice interne au bloc de la pile
            double area = (x  - start) % (cw + 20) ;
           
           if ((bloc < 6) && (bloc >= 0)) {
            if ((area >= (t.piles.get((int) bloc).getSize() -1) * 3) && (area <= cw + (t.piles.get((int) bloc).getSize() -1) * 3))
            { 
                // Numero de la pile
               double pile = (x  - start) / (cw + 20) ;            
                   System.out.println((int) pile);
                return t.piles.get((int) pile);
            } 
            else return null;           
          }
          return null;  
        }
        else return null;
    }

// Clic carte sur la main
    public Carte getCarteMain(int x, int y){
        int width = g.getZoneDessin().getSize().width;
        int height = g.getZoneDessin().getSize().height;
        int cw = g.getZoneDessin().cw;
        int ch = g.getZoneDessin().ch;
        Table t = g.getZoneDessin().t;
        
        // Pixel debut affichage carte
        double start = (double) ((width / 2) - (((t.main1.getSize() +1) * (cw) / 2) * 0.5));
        
        if (y > height - ch) {
            // Indice de la carte cliquee
            double carte = (x  - start) / ((cw/2) + 0.5);
            
            // Clic en dehors
            if (carte < 0 || (int) carte > t.main1.getSize() )  {
                return (null);
            }
            // Deuxieme moitie derniere carte
            else if ((int) carte == t.main1.getSize()) {
                return t.main1.getCarte(t.main1.getSize() - 1);
                }
            else
                return t.main1.getCarte((int) carte);
        }
        else return null;
    }

}
