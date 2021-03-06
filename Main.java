/*
Auteur : ZIANE-CHERIF Mohammed-El-Amine
Date de Creation 14/05/2012 : 03:21
Date de Dernière modification 15/05/2012 : 18:28
 */

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main implements java.io.Serializable, Cloneable {

    // -------------------------------------Attributs-------------------------------------
    ArrayList<Carte> main;

    // -------------------------------------Constructeur-------------------------------------
    // initialise la main avec une main vide
    Main() {
        main = new ArrayList<Carte>();
    }

    Main(ArrayList<Carte> main) {
        this.main = main;
    }

    // -------------------------------------Accesseurs-------------------------------------
    public int getSize() {
        return main.size();
    }

    public ArrayList<Carte> getMain() {
        return main;
    }

    public void setMain(ArrayList<Carte> main) {
        this.main = main;
    }

    public Carte getCarte(int index) {
        return main.get(index);
    }

    public boolean estVide() {
        return main.isEmpty();
    }

    // -------------------------------------Methodes-------------------------------------
    // affiche la main sur la console
    public void afficherMainConsole() {
        for (int i = 0; i < this.getSize(); i++) {
            Carte c = this.getCarte(i);

            System.out.println(c.toString());
        }

    }

    // ajoute la carte à la main, la main dois réster trié
    public void add(Carte c) {
        int i = 0;
        ArrayList<Carte> resultat = new ArrayList<Carte>();
        while (i < main.size() && c.plusForte(main.get(i))) {
            resultat.add(main.get(i));
            i++;
        }
        resultat.add(c);
        for (int j = i; j < main.size(); j++) {
            resultat.add(main.get(j));
        }

        main = resultat;
    }

    // trie une main selon la couleur et le rang
    public void trier() {
        main = trie_fusion(main);
    }

    // supprime une carte de la main
    public void supp(Carte c) {
        main.remove(c);
    }

    //renvoie vrai si la carte c est dans la main
    public boolean appartient(Carte c)
    {
    	return this.getMain().contains(c);
    }

    //renvoie vrai si il y a la couleur de la carte c dans la main
    public boolean aCouleur(Carte c) {
        boolean resultat = false;
        for (Carte ca : main) {
            if (ca.memeCouleur(c)) {
                resultat = true;
            }
        }
        return resultat;
    }

    // ------------------------------------Algo tri par fusion---------------------------
    public ArrayList<Carte> fusion(ArrayList<Carte> m1, ArrayList<Carte> m2) {

        int j = 0, k = 0;
        int n1 = m1.size();
        int n2 = m2.size();

        ArrayList<Carte> resultat = new ArrayList<Carte>(n1 + n2);

        for (int i = 0; i < (n1 + n2); i++) {
            if ((j < n1) && (k >= n2 || m2.get(k).plusForte(m1.get(j)))) {
                resultat.add(m1.get(j));
                j++;
            } else {
                resultat.add(m2.get(k));
                k++;
            }
        }

        return resultat;
    }

    public ArrayList<Carte> trie_fusion(ArrayList<Carte> main) {
        if (main.size() == 1) {
            return main;
        } else {
            int n1 = main.size() / 2;
            int n2 = main.size() - n1;
            ArrayList<Carte> t1 = new ArrayList<Carte>(n1);
            ArrayList<Carte> t2 = new ArrayList<Carte>(n2);

            for (int i = 0; i < n1; i++) {
                t1.add(main.get(i));
            }

            for (int i = n1; i < main.size(); i++) {
                t2.add(main.get(i));
            }

            t1 = trie_fusion(t1);
            t2 = trie_fusion(t2);

            return fusion(t1, t2);
        }

    }


    public Object clone() {
        Main m = null;
        try {
            m = (Main) super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        m.main = (ArrayList<Carte>) main.clone();

        return m;
    }
}
