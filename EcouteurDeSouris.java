/*
Auteur : ZIANE-CHERIF Mohammed-El-Amine
Date de Creation 16/05/2012 : 17:58
*/

import java.awt.event.*;

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

       
    /*  d'abord on vérifie si on est en attente d'un clique dans la zone ou a eu le clique

    il y a 3 zones où les clique sont permis :
    1 - clique sur la main1
    2 - clique sur la main2
    3 - clique sur une pile 

	on connais les conditions d'un clique attendu grace aux attribut aJoue et aChoisi de chaque joueurs
     */
    public void mousePressed(MouseEvent e) {
        
    	if( /*clike sur main1*/ true)
    	{
    	    Carte carte = getCarte(e.getX(), e.getY());
    	    System.out.println(carte);
    		if (jeu.intVersJoueur().equals(jeu.joueur1) && !jeu.joueur1.aJoue)
    		{

    			// dans ce cas le joueur courant est le J1 il n'as pas encore jouer et il a bien clik� sur sa main1
    			//en prend en compte son choix
    			/* = on recupere la carte sur la quel on a clique ;*/
    			jeu.moteur.jouer(carte, jeu.getJoueurCourant());
    		}
    	}
    	else if(true/*clike sur main2*/)
    	{
    	    Carte carte = getCarte(e.getX(), e.getY());
    	    System.out.println(carte);
    		if(jeu.intVersJoueur().equals(jeu.joueur2) && !jeu.joueur2.aJoue)
    		{
    			// dans ce cas le joueur courant est le J2 il n'as pas encore jouer et il a bien clik� sur sa main2

    			//en prend en compte son choix
    			jeu.getMoteur().getTable().getMain2().supp(carte);
    			jeu.getMoteur().getTable().setCarte2(carte);
    			jeu.intVersJoueur().setaJoue(true);
    		}
    	}
    	else if(true /*clike sur pile*/)
    	{
    		if(jeu.intVersJoueur().equals(jeu.joueur1) && jeu.getJoueur1().getaJoue() && !jeu.getJoueur1().getaChoisi())
    		{

    			// dans ce cas le joueur courant est le J1 il a deja joue et il a bien clik� sur un pli
    			//en prend en compte son choix
    			Pile pile = null/* = on recupere la pile sur la quel on a clique */;
    			jeu.getMoteur().getTable().getMain1().add(pile.piocher());
    			jeu.intVersJoueur().setaChoisi(true);
    		}
    		else if(jeu.intVersJoueur().equals(jeu.joueur2) && jeu.getJoueur2().getaJoue() && !jeu.getJoueur2().getaChoisi())
    		{
    			// dans ce cas le joueur courant est le J2 il a deja joue et il a bien clik� sur un pli
    			//en prend en compte son choix
    			Pile pile = null/* = on recupere la pile sur la quel on a clique */;
    			jeu.getMoteur().getTable().getMain2().add(pile.piocher());
    			jeu.intVersJoueur().setaChoisi(true);
    		}
    	}
    	
    }

    // Il faut aussi une implementation pour les autres methodes de l'interface
    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mouseClicked(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public Carte getCarte(int x, int y){
        int width = g.getZoneDessin().getSize().width;
        int height = g.getZoneDessin().getSize().height;
        int cw = g.getZoneDessin().cw;
        int ch = g.getZoneDessin().ch;
        Table t = g.getZoneDessin().t;
        
        double start = (double) ((width / 2) - (((t.main2.getSize() +1) * (cw) / 2) * 0.5));
        
        if (y > height - ch) {
            double carte = (x  - start) / ((cw/2) + 0.5);
            if (carte < 0 || (int) carte > 11 )  {
                return (null);
            }
            else if ((int) carte == 11) {
                return t.main2.getCarte(10);
                }
            else
                return t.main2.getCarte((int) carte);
        }
        else return null;
    }

}
