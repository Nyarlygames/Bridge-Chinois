
/**
 * @author Samy
 */
import java.util.ArrayList;
import java.util.HashMap;

public class PC4 extends Joueur {

    /**
     * @author Samy
     */
    // PC qui connait les cartes de l'adversaire
    public PC4(Table t, int id, Main main, Carte carteAdv) {
        this.table = t;
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
        System.out.println("caca1");
        if (id == 2) {
            carteAdv = table.getCarte1();
        } else {
            carteAdv = table.getCarte2();
        }
        ArrayList<Carte> jouables = getCartesJouables();
        ArrayList<Carte> gagnantes = new ArrayList<Carte>();
        Boolean prems;
        if (carteAdv != null) {
            prems = false;
            for (Carte ca : jouables) {
                if (carteAdv.gagne(ca, table.getAtout())) {
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
            ArrayList<Carte> adversaire = table.getCartesAdversaire(id);

            for (Carte c : main.getMain()) {
                chances.put(c, 0);
            }

            for (Carte c1 : main.getMain()) {
                for (Carte c2 : adversaire) {
                    if (c1.gagne(c2, table.getAtout())) {
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
            } else {//si on commence a jouer alors on cheat
                for (Carte c : chances.keySet()) {
                    if (chances.get(c) == 0) {
                        gagnantes.add(c);
                    }
                }

                if (gagnantes.isEmpty()) {//pas de gagnante donc on balance la carte ayant le plus de chance de se faire battre
                    Integer maxi = 0;
                    for (Carte c : chances.keySet()) {
                        if (chances.get(c) > maxi) {
                            maxi = chances.get(c);
                            meilleure = c;
                        }
                    }
                } else {
                    meilleure = gagnantes.get(0);
                    for (Carte ca : gagnantes) {
                        if (!ca.rangPlusFort(meilleure)) {
                            meilleure = ca;//on met la gagnante avec le rang le plus faible
                        }
                    }
                }
            }
        }
        if (id == 2) {
            table.setCarte2(meilleure);
            table.getMain2connue().getMain().remove(meilleure);

        } else {
            table.setCarte1(meilleure);
            table.getMain1connue().getMain().remove(meilleure);

        }
        main.getMain().remove(meilleure);
        aJoue = true;
    }

    @Override
    void choisir() {
        ArrayList<Pile> piochables = new ArrayList<Pile>();
        for (Pile p : table.getPiles()) {
            if (!p.estVide()) {
                piochables.add(p);
            }
        }
        Pile meilleure = null;
        if (!piochables.isEmpty()) {
            meilleure = piochables.get(0);
            HashMap<Pile, Integer> chances = new HashMap<Pile, Integer>();
            ArrayList<Carte> adversaire = table.getCartesAdversaire(id);
            for (Pile p : piochables) {
                chances.put(p, 0);
                for (Carte c2 : adversaire) {
                    if (p.getAPiocher().gagne(c2, table.getAtout())) {
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
                Carte c = meilleure.piocher();
                if (id == 2) {
                    table.getMain2connue().add(c);
                } else {
                    table.getMain1connue().add(c);
                }
                main.add(c);
            }
        }
        aChoisi = true;
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
