
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Samy
 */
public class PC3 extends PC implements java.io.Serializable{

    public PC3() {
    }

    public PC3(Table t, int id) {
        this.table = t;
        this.id = id;
        nbPlis = 0;
        score = 0;
        aJoue = false;
        aChoisi = false;
         phaseChoisir = true;
        phaseJouer = true;
    }

    @Override
    void jouer() {
        Main main;
        Carte carteAdv;
        if (id == 2) {
            carteAdv = table.getCarte1();
            main = table.getMain2();
        } else {
            carteAdv = table.getCarte2();
            main = table.getMain1();
        }

        ArrayList<Carte> jouables = getCartesJouables();
        ArrayList<Carte> gagnantes = new ArrayList<Carte>();
        Boolean prems;

        if (carteAdv != null) {
            prems = false;
            for (Carte ca : jouables) {
                if (ca.gagne(carteAdv, table.getAtout())) {
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
            ArrayList<Carte> inconnues = table.getCartesInconnues(id);
            inconnues.removeAll(table.getCartesConnuesAdversaire(id));
            ArrayList<Carte> testables = new ArrayList<Carte>();
            testables.addAll(jouables);
            if (prems) {
                for (Carte c1 : jouables) {
                    for (Carte c2 : getCartesJouables(table.getCartesConnuesAdversaire(id), c1)) {
                        if (!c1.gagne(c2, table.getAtout())) {
                            testables.remove(c1);
                        }
                    }
                }
            }

            if (testables.isEmpty())//c'est la loose on a pas de pli assuré
            {
                testables.addAll(jouables);
            }

            for (Carte c : testables) {
                chances.put(c, 0);
            }

            for (Carte c1 : testables) {
                for (Carte c2 : inconnues) {
                    if (c1.gagne(c2, table.getAtout())) {
                        chances.put(c1, chances.get(c1) + 1);
                    }
                }
            }
            //chances contient le nombre de cartes pouvant battre chacune des cartes de la main

            if (!prems) {//pas de gagnante donc on balance la carte ayant le plus de chance de se faire battre
                Integer mini = 52;
                for (Carte c : chances.keySet()) {
                    if (chances.get(c) < mini) {
                        mini = chances.get(c);
                        meilleure = c;
                    }
                }
            } else {//si on commence a jouer alors on met la carte ayant le plus de chance de gagner

                Integer maxi = 0;
                for (Carte c : chances.keySet()) {
                    if (chances.get(c) > maxi) {
                        maxi = chances.get(c);
                        meilleure = c;
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
        Main main;
        if (id == 2) {
            main = table.getMain2();
        } else {
            main = table.getMain1();
        }
        for (Pile p : table.getPiles()) {
            if (!p.estVide()) {
                piochables.add(p);
            }
        }
        Pile meilleure = null;
        if (!piochables.isEmpty()) {
            meilleure = piochables.get(0);
            HashMap<Pile, Integer> chances = new HashMap<Pile, Integer>();
            ArrayList<Carte> inconnues = table.getCartesInconnues(id);
            inconnues.removeAll(table.getCartesConnuesAdversaire(id));
            for (Pile p : piochables) {
                chances.put(p, 0);
                for (Carte c2 : inconnues) {
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


    public Joueur clone() {
        Joueur j = new PC3();
        j.setTable(table);
        j.setId(id);
        j.setNbPlis(nbPlis);
        j.setScore(score);
        j.setaJoue(aJoue);
        j.setaChoisi(aChoisi);
        j.setPhaseChoisir(phaseChoisir);
        j.setPhaseJouer(phaseJouer);
        return j;
    }
}
