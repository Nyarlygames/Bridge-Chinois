/*!!!!!!!!!!!!!
Auteur : ZIANE-CHERIF Mohammed-El-Amine
Date de Creation 14/05/2012 : 17:11
Date de Dernière modification 15/05/2012 : 18:27
 */

import java.util.ArrayList;

public class Table implements java.io.Serializable, Cloneable {

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

    Table(Table t) {
        this.atout = t.getAtout();
        this.carte1 = t.getCarte1();
        this.carte2 = t.getCarte2();
        this.main1 = t.getMain1();
        this.main1connue = t.getMain1connue();
        this.main2 = t.getMain2();
        this.main2connue = t.getMain2connue();
        this.paquet = t.getPaquet();
        this.piles = t.getPiles();

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

        return empty;
    }

    @Override
    public Table clone() {
        Table table = null;
        try {
            // On récupère l'instance à renvoyer par l'appel de la 
            // méthode super.clone()
            table = (Table) super.clone();
        } catch (CloneNotSupportedException cnse) {
            // Ne devrait jamais arriver car nous implémentons 
            // l'interface Cloneable
            cnse.printStackTrace(System.err);
        }
        if (getCarte1() != null) {
            table.carte1 = (Carte) getCarte1().clone();
        }
        if (getCarte2() != null) {
            table.carte2 = (Carte) getCarte2().clone();
        }
        table.main1 = (Main) getMain1().clone();
        table.main1connue = (Main) getMain1connue().clone();
        table.main2 = (Main) getMain2().clone();
        table.main2connue = (Main) getMain2connue().clone();
        table.paquet = (Paquet) getPaquet().clone();
        table.piles = (ArrayList<Pile>) getPiles().clone();

        // on renvoie le clone
        return table;






    }


    public Carte getCarteAdverse(int joueur) {
        if (joueur == 1) {
            return (carte2);
        } else if (joueur == 2) {
            return (carte1);
        } else {
            return null;
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
