/*
Auteur : ZIANE-CHERIF Mohammed-El-Amine
Date de Creation 14/05/2012 : 03:21
Date de Dernière modification 16/05/2012 : 04:24
 */

import java.util.ArrayList;
import java.util.Random;

public class Jeu {

    // -------------------------------------Attributs-----------------------------------------
    Moteur moteur;
    Joueur joueur1, joueur2;
    int joueurCourant;

    // -------------------------------------Constructeur-------------------------------------
    Jeu(Moteur m, int mode) {
        Random rand = new Random();

        joueurCourant = rand.nextInt(2);
        joueurCourant++;
        switch (mode) {
            case 0:
                this.joueur1 = new PC(this, 1, moteur.getTable().getMain1(), moteur.getTable().getCarte2());
                this.joueur2 = new PC(this, 2, moteur.getTable().getMain2(), moteur.getTable().getCarte1());
                break;

            case 1:
                this.joueur1 = new Humain(this, 1);
                this.joueur2 = new PC(this, 2, moteur.getTable().getMain2(), moteur.getTable().getCarte1());
                break;
            case 2:
                this.joueur1 = new Humain(this, 1);
                this.joueur2 = new Humain(this, 2);
                break;

        }
        moteur = m;

    }

    // -------------------------------------Accesseurs-----------------------------------------
    public Moteur getMoteur() {
        return moteur;
    }

    public void setMoteur(Moteur moteur) {
        this.moteur = moteur;
    }

    public Joueur getJoueur1() {
        return joueur1;
    }

    public void setJoueur1(Joueur joueur1) {
        this.joueur1 = joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }

    public void setJoueur2(Joueur joueur2) {
        this.joueur2 = joueur2;
    }

    public void setJoueurCourant(int joueurCourant) {
        this.joueurCourant = joueurCourant;
    }

    //renvoie le joueur courant
    public Joueur getJoueurCourant() {
        if (joueurCourant == 1) {
            return this.joueur1;
        } else {
            return this.joueur2;
        }
    }

    // -------------------------------------Methodes-----------------------------------------
    // distribue les cartes entre les joueurs et séparation du reste en 6 piles
    public void initialiser() {
        for (int i = 0; i < 11; i++) {
            moteur.table.main1.add(moteur.table.paquet.piocher());
            moteur.table.main2.add(moteur.table.paquet.piocher());
        }

        ArrayList<Carte> tas1 = new ArrayList<Carte>(5);
        ArrayList<Carte> tas2 = new ArrayList<Carte>(5);
        ArrayList<Carte> tas3 = new ArrayList<Carte>(5);
        ArrayList<Carte> tas4 = new ArrayList<Carte>(5);
        ArrayList<Carte> tas5 = new ArrayList<Carte>(5);
        ArrayList<Carte> tas6 = new ArrayList<Carte>(5);

        for (int i = 0; i < 5; i++) {
            tas1.add(moteur.table.paquet.piocher());
            tas2.add(moteur.table.paquet.piocher());
            tas3.add(moteur.table.paquet.piocher());
            tas4.add(moteur.table.paquet.piocher());
            tas5.add(moteur.table.paquet.piocher());
            tas6.add(moteur.table.paquet.piocher());
        }

        Pile pile = new Pile(1, tas1);
        moteur.table.addPile(pile);

        pile = new Pile(2, tas2);
        moteur.table.addPile(pile);

        pile = new Pile(3, tas3);
        moteur.table.addPile(pile);

        pile = new Pile(4, tas4);
        moteur.table.addPile(pile);

        pile = new Pile(5, tas5);
        moteur.table.addPile(pile);

        pile = new Pile(6, tas6);
        moteur.table.addPile(pile);

        Carte max = carteRangFort(this.getMoteur().getTable().getPiles());
        if (max.rangSupDix()) {
            moteur.getTable().setAtout(max.getCouleur());
        }


    }

    private Carte carteRangFort(ArrayList<Pile> piles) {
        Carte carteCourante, resultat = null;

        carteCourante = piles.get(0).getPile().get(5);
        resultat = carteCourante;
        for (int i = 1; i < 6; i++) {
            carteCourante = piles.get(i).getPile().get(5);
            if (carteCourante.memeRang(resultat)) {
                if (carteCourante.couleurPlusForte(resultat)) {
                    resultat = carteCourante;
                }
            } else {
                if (carteCourante.rangPlusFort(resultat)) {
                    resultat = carteCourante;
                }
            }
        }

        return resultat;
    }

    // lance le jeu;
    public void jouer() {
        Carte c1, c2 = null;

        while (moteur.getTable().getMain1().getSize() != 0 && moteur.getTable().getMain2().getSize() != 0) {
            getJoueurCourant().jouer();
            switcher();
            getJoueurCourant().jouer();
            if (joueurCourant == 1) {
                c1 = moteur.getTable().getCarte1();
                c2 = moteur.getTable().getCarte2();
            } else {
                c1 = moteur.getTable().getCarte2();
                c2 = moteur.getTable().getCarte1();
            }
            if (c1.plusForte(c2)) {
                switcher();
                getJoueurCourant().setNbPlis(getJoueurCourant().getNbPlis() + 1);
                getJoueurCourant().choisir();
                switcher();
                getJoueurCourant().choisir();
                switcher();
            } else {
                getJoueurCourant().setNbPlis(getJoueurCourant().getNbPlis() + 1);
                getJoueurCourant().choisir();
                switcher();
                getJoueurCourant().choisir();
                switcher();
            }
        }
    }

    public void switcher() {
        if (joueurCourant == 1) {
            this.joueurCourant = 2;
        } else {
            this.joueurCourant = 1;
        }
    }
}
