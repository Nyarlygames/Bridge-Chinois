
import java.util.ArrayList;
/**
 * @author Samy
 */
public class PC2 extends Joueur {

    public PC2(Jeu j, int id, Main main, Carte carteAdv) {
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
        ArrayList<Carte> jouables = new ArrayList<Carte>();
        ArrayList<Carte> gagnantes = new ArrayList<Carte>();
        Boolean prems;
        if (carteAdv != null) {
            prems = false;
            for (Carte ca : main.getMain()) {
                if (carteAdv.memeCouleur(ca)) {
                    jouables.add(ca);
                    if (ca.gagne(carteAdv, j.getMoteur().getTable().getAtout())) {
                        gagnantes.add(ca);
                    }
                }
            }

            if (jouables.isEmpty()) {//pas la bonne couleur donc bah on met tout
                for (Carte ca : main.getMain()) {
                    jouables.add(ca);
                    if (ca.gagne(carteAdv, j.getMoteur().getTable().getAtout())) {
                        gagnantes.add(ca);
                    }
                }
            }

        } else {
            prems = true;
            for (Carte ca : main.getMain()) {
                gagnantes.add(ca);
            }
        }

        Carte meilleure = null;
        if (!gagnantes.isEmpty()) {
            if (!prems) {
                meilleure = gagnantes.get(0);
                for (Carte ca : gagnantes) {
                    if (!ca.rangPlusFort(carteAdv)) {
                        meilleure = ca;
                    }
                }
            } else {//si on commence a jouer alors on met la plus grosse carte possible
                meilleure = gagnantes.get(0);
                for (Carte ca : gagnantes) {
                    if (ca.rangPlusFort(carteAdv)) {
                        meilleure = ca;
                    }
                }
            }
        } else {//pas de gagnante donc on balance une carte nulle
            meilleure = jouables.get(0);
            for (Carte ca : jouables) {
                if (!ca.rangPlusFort(carteAdv)) {
                    meilleure = ca;
                }
            }
        }

        if (j.getJoueurCourant().equals(j.joueur2)) {
            j.getMoteur().getTable().setCarte2(meilleure);
        } else {
            j.getMoteur().getTable().setCarte1(meilleure);
        }
    }

    @Override
    void choisir() {
        ArrayList<Pile> piochables = new ArrayList<Pile>();
        for (Pile p : j.moteur.table.piles) {
            if (!p.estVide()) {

                piochables.add(p);
            }
        }
        Pile meilleure = piochables.get(0);
        for (Pile p : piochables) {
            if (meilleure.getPile().get(meilleure.getPile().size() - 1).getCouleur().equals(j.getMoteur().getTable().getAtout())) {
                if (p.getPile().get(p.getPile().size() - 1).getCouleur().equals(j.getMoteur().getTable().getAtout()) && p.getPile().get(p.getPile().size() - 1).rangPlusFort(meilleure.getPile().get(meilleure.getPile().size() - 1))) {
                    meilleure = p;
                }
            } else {
                if (p.getPile().get(p.getPile().size() - 1).getCouleur().equals(j.getMoteur().getTable().getAtout()) || p.getPile().get(p.getPile().size() - 1).rangPlusFort(meilleure.getPile().get(meilleure.getPile().size() - 1))) {
                    meilleure = p;
                }
            }
        }
        main.add(meilleure.piocher());
    }
}
