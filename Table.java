/*!!!!!!!!!!!!!
Auteur : ZIANE-CHERIF Mohammed-El-Amine
Date de Creation 14/05/2012 : 17:11
Date de Dernière modification 15/05/2012 : 18:27
 */

import java.util.ArrayList;
import java.io.*;

public class Table implements java.io.Serializable{

    // -------------------------------------Attributs-------------------------------------
    Main main1, main2, main1connue, main2connue;
    Carte carte1, carte2;
    ArrayList<Pile> piles;
    Paquet paquet;
    Couleur atout;
    // -------------------------------------Constructeur-------------------------------------

    Table() {
        main1 = new Main();
        main2 = new Main();
        main1connue = new Main();
        main2connue = new Main();
        carte1 = null;
        carte2 = null;
        piles = new ArrayList<Pile>(6);
        paquet = null;
        //paquet.melanger();
        atout = null;
    }

    // -------------------------------------Accesseurs-------------------------------------
    public Main getMain1() {
        return main1;
    }

    public void setMain1(Main main1) {
        this.main1 = main1;
    }

    public Main getMain2() {
        return main2;
    }

    public void setMain2(Main main2) {
        this.main2 = main2;
    }

    public Carte getCarte1() {
        return carte1;
    }

    public void setCarte1(Carte carte1) {
        this.carte1 = carte1;
    }

    public Carte getCarte2() {
        return carte2;
    }

    public void setCarte2(Carte carte2) {
        this.carte2 = carte2;
    }

    public ArrayList<Pile> getPiles() {
        return piles;
    }

    public void setPiles(ArrayList<Pile> piles) {
        this.piles = piles;
    }

    public Paquet getPaquet() {
        return paquet;
    }

    public void setPaquet(Paquet paquet) {
        this.paquet = paquet;
    }

    public Couleur getAtout() {
        return atout;
    }

    public void setAtout(Couleur atout) {
        this.atout = atout;
    }

    public Main getMain1connue() {
        return main1connue;
    }

    public Main getMain2connue() {
        return main2connue;
    }

    public void setMain1connue(Main main1connue) {
        this.main1connue = main1connue;
    }

    public void setMain2connue(Main main2connue) {
        this.main2connue = main2connue;
    }

    // -------------------------------------Methodes-------------------------------------
    // ajoute une pile 
    /*public void addPile(Pile pile) {
        piles.add(pile);
    }*/

    public boolean pilesVides() {
        boolean empty = true;
        for (int i = 0; i < 6; i++) {
            if (!piles.get(i).estVide()) {
                empty = false;
            }
        }
        return (empty);
    }
    
    public Table clone()
    {
    	Table t = new Table();
    	t.setMain1(main1.clone());
    	t.setMain2(main2.clone());
    	t.setMain1connue(main1connue.clone());
    	t.setMain2connue(main2connue.clone());
    	t.setCarte1(carte1.clone());
    	t.setCarte2(carte2.clone());
    	ArrayList<Pile> p = new ArrayList<Pile>(6);
    	for(int i=0; i<p.size(); i++)
    	{
    		p.set(i, piles.get(i).clone());
    	}
      	return t;  	
    }
    
        public Carte getCarteAdverse(int joueur) {
        if (joueur == 1) {
            return (carte2);
        } else if (joueur == 2) {
            return (carte1);
        } else {
            return (null);
        }
    }
        
        
           //renvoie les cartes inconnues du joueur courant (dans la main de l'autre ou sous les piles)
    public ArrayList<Carte> getCartesInconnues(Integer joueurCourant) {
        ArrayList<Carte> inconnues = new ArrayList<Carte>();

        if (joueurCourant == 1) {
            inconnues.addAll(getMain2().getMain());
        } else {
            inconnues.addAll(getMain1().getMain());

        }
        for (Pile p : getPiles()) {
            inconnues.addAll(p.getPile());
            if (p.getPile().size() >= 1) {
                inconnues.remove(p.getAPiocher());
            }
        }
        return inconnues;
    }

    //renvoie les cartes de l'adversaire du joueur courant (time to cheat)
    public ArrayList<Carte> getCartesAdversaire(Integer joueurCourant) {
        ArrayList<Carte> adversaire = new ArrayList<Carte>();

        if (joueurCourant == 1) {
            adversaire.addAll(getMain2().getMain());
        } else {
            adversaire.addAll(getMain1().getMain());

        }
        return adversaire;
    }

    //renvoie les cartes connues de l'adversaire du joueur courant
    public ArrayList<Carte> getCartesConnuesAdversaire(Integer joueurCourant) {
        ArrayList<Carte> adversaire = new ArrayList<Carte>();

        if (joueurCourant == 1) {
            adversaire.addAll(getMain2connue().getMain());
        } else {
            adversaire.addAll(getMain1connue().getMain());

        }
        return adversaire;
    }
}
