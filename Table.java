/*!!!!!!!!!!!!!
Auteur : ZIANE-CHERIF Mohammed-El-Amine
Date de Creation 14/05/2012 : 17:11
Date de Dernière modification 15/05/2012 : 18:27
 */

import java.util.ArrayList;

public class Table {

    // -------------------------------------Attributs-------------------------------------
    Main main1, main2;
    Carte carte1, carte2;
    ArrayList<Pile> piles;
    Paquet paquet;
    Couleur atout;

    // -------------------------------------Constructeur-------------------------------------
    Table() {
        main1 = new Main();
        main2 = new Main();
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

    // -------------------------------------Methodes-------------------------------------
    // ajoute une pile 
    /*public void addPile(Pile pile) {
        piles.add(pile);
    }*/

    public boolean pilesVides(){
	boolean empty = true;
	for (int i = 0; i < 6; i++){
	    if (!piles.get(i).estVide())
		empty = false;
	}
	return (empty);
    }
}
