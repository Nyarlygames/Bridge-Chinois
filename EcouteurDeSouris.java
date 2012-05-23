/*
Auteur : ZIANE-CHERIF Mohammed-El-Amine
Date de Creation 16/05/2012 : 17:58
Date de Derni�re modification 16/05/2012 : 18:00
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
    		if(jeu.intVersJoueur().equals(jeu.joueur1) && !jeu.joueur1.aJoue)
    		{
    			// dans ce cas le joueur courant est le J1 il n'as pas encore jouer et il a bien clik� sur sa main1
    			//en prend en compte son choix
    			Carte carte =null/* = on recupere la carte sur la quel on a clique */;
    			jeu.moteur.jouer(carte, jeu.getJoueurCourant());
    		}
    	}
    	else if(true/*clike sur main2*/)
    	{
    		if(jeu.intVersJoueur().equals(jeu.joueur2) && !jeu.joueur2.aJoue)
    		{
    			// dans ce cas le joueur courant est le J2 il n'as pas encore jouer et il a bien clik� sur sa main2
    			//en prend en compte son choix
    			Carte carte = null/* = on recupere la carte sur la quel on a clique */;
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

}
