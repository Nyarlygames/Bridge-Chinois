/*
Auteur : ZIANE-CHERIF Mohammed-El-Amine
Date de Creation 12/05/2012 : 04:20
Date de Dernière modification 23/05/2012 : 14:32
 */

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pile implements java.io.Serializable, Cloneable {

    // -------------------------------------Attribute-------------------------------------
    int numero;
    ArrayList<Carte> pile;

    // -------------------------------------Constructor-------------------------------------
    Pile(int num) {
        numero = num;
        pile = new ArrayList<Carte>();
    }

    Pile(int num, ArrayList<Carte> p) {
        numero = num;
        pile = new ArrayList<Carte>(6);
        pile.addAll(p);
    }
    // -------------------------------------Accesseur-------------------------------------

    public int getSize() {
        return pile.size();
    }

    // renvoie le numero de la pile
    public int getNumero() {
        return numero;
    }

    public Carte getCarte(int index) {
        return this.pile.get(index);
    }

    // renvoie le contenue de la pile
    public ArrayList<Carte> getPile() {
        return pile;
    }

    // -------------------------------------Methode-------------------------------------
    // renvoie vrai si la pile est vide
    public boolean estVide() {
        return pile.isEmpty();
    }

    // ajoute un tas dans la pile
    public void ajouterTas(ArrayList<Carte> tas) {
        pile.addAll(tas);
    }

    // renvoie la carte qui est au dessus de la pile (l'indice le plus grand)  et la retire de la pile
    public Carte piocher() {
        if (!pile.isEmpty()) {
            return pile.remove(pile.size() - 1);
        } else {
            return null;
        }
    }

    //renvoie la carte a piocher sans la retirer
    public Carte getAPiocher() {
        if (!pile.isEmpty()) {
            return pile.get(pile.size() - 1);
        } else {
            return null;
        }
    }

    public void afficherPileConsole() {

        for (int i = 0; i < pile.size(); i++) {
            System.out.println(pile.get(i).toString());
        }
    }
    

    public Object clone() {

        Pile p = null;
        try {
            p = (Pile) super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Pile.class.getName()).log(Level.SEVERE, null, ex);
        } 
        p.pile = (ArrayList<Carte>) pile.clone();

        return p;
    }
}
