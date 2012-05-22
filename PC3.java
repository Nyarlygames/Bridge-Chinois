
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Samy
 */
public class PC3 extends Joueur {

    public PC3(Jeu j, int id, Main main, Carte carteAdv) {
        this.j = j;
        this.id = id;
        nbPlis = 0;
        score = 0;
        aJoue = false;
        aChoisi = false;
        this.carteAdv = carteAdv;
        this.main = main;
    }

    @Override
    void jouer() {
        ArrayList<Carte> jouables = getCartesJouables();
        ArrayList<Carte> gagnantes = new ArrayList<Carte>();
        Boolean prems;
        if (carteAdv != null) {
            prems = false;
            for (Carte ca : jouables) {
                if (ca.gagne(carteAdv, j.getMoteur().getTable().getAtout())) {
                    gagnantes.add(ca);
                }
            }
        } else {
            prems = true;
        }

        Carte meilleure = null;
        if (!gagnantes.isEmpty()) {
            meilleure = gagnantes.get(0);
            for (Carte ca : gagnantes) {
                if (!ca.rangPlusFort(meilleure)) {
                    meilleure = ca;//on met la gagnante avec le rang le plus faible
                }
            }
        } else {
            HashMap<Carte, Integer> chances = new HashMap<Carte, Integer>();
            ArrayList<Carte> inconnues = j.getCartesInconnues();

            for (Carte c : main.getMain()) {
                chances.put(c, 0);
            }

            for (Carte c1 : main.getMain()) {
                for (Carte c2 : inconnues) {
                    if (c1.gagne(c2)) {
                        chances.put(c1, chances.get(c1) + 1);
                    }
                }
            }
            //chances contient le nombre de cartes pouvant battre chacune des cartes de la main

            if (!prems) {//pas de gagnante donc on balance la carte ayant le plus de chance de se faire battre
                Integer maxi = 0;
                for (Carte c : chances.keySet()) {
                    if (chances.get(c) > maxi) {
                        maxi = chances.get(c);
                        meilleure = c;
                    }
                }
            } else {//si on commence a jouer alors on met la carte ayant le plus de chance de gagner


                Integer mini = 52;
                for (Carte c : chances.keySet()) {
                    if (chances.get(c) < mini) {
                        mini = chances.get(c);
                        meilleure = c;
                    }
                }
            }
        }

        if (j.getJoueurCourant().equals(j.getJoueur2())) {
            j.getMoteur().getTable().setCarte2(meilleure);
        } else {
            j.getMoteur().getTable().setCarte1(meilleure);
        }
        main.getMain().remove(meilleure);
    }

    @Override
    void choisir() {
        ArrayList<Pile> piochables = new ArrayList<Pile>();
        for (Pile p : j.getMoteur().getTable().getPiles()) {
            if (!p.estVide()) {
                piochables.add(p);
            }
        }
        Pile meilleure = null;
        if (!piochables.isEmpty()) {
            meilleure = piochables.get(0);
            HashMap<Pile, Integer> chances = new HashMap<Pile, Integer>();
            ArrayList<Carte> inconnues = j.getCartesInconnues();
            for (Pile p : piochables) {
                chances.put(p, 0);
                for (Carte c2 : inconnues) {
                    if (p.getAPiocher().gagne(c2)) {
                        chances.put(p, chances.get(p) + 1);
                    }
                }
            }
            Integer mini = 52;
            for (Pile c : chances.keySet()) {
                if (chances.get(c) < mini) {
                    mini = chances.get(c);
                    meilleure = c;
                }
            }
            if (!meilleure.estVide()) {
                main.add(meilleure.piocher());
            }
        }
    }

    ArrayList<Carte> getCartesJouables() {
        ArrayList<Carte> jouables = new ArrayList<Carte>();
        if (carteAdv != null) {
            for (Carte ca : main.getMain()) {
                if (carteAdv.memeCouleur(ca)) {
                    jouables.add(ca);
                }
            }
            if (jouables.isEmpty()) {//pas la bonne couleur donc bah on met tout
                for (Carte ca : main.getMain()) {
                    jouables.add(ca);
                }
            }
        } else {
            if (jouables.isEmpty()) {//on commence donc bah on met tout
                for (Carte ca : main.getMain()) {
                    jouables.add(ca);
                }
            }
        }
        return jouables;
    }
}
