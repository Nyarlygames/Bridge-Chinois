
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
                    meilleure = ca;
                }
            }

        } else {//pas de gagnante donc on balance une carte nulle
            if (!prems) {
                meilleure = jouables.get(0);
                for (Carte ca : jouables) {
                    if (!ca.rangPlusFort(meilleure)) {
                        meilleure = ca;
                    }
                }
            } else {//si on commence a jouer alors on met la plus grosse carte possible
                meilleure = gagnantes.get(0);
                for (Carte ca : gagnantes) {
                    if (ca.rangPlusFort(meilleure)) {
                        meilleure = ca;
                    }
                }
            }
        }

        if (j.getJoueurCourant().equals(j.joueur2)) {
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
        Pile meilleure = piochables.get(0);
        for (Pile p : piochables) {
            if (meilleure.getPile().get(meilleure.getPile().size() - 1).getCouleur().equals(j.getMoteur().getTable().getAtout())) {
                if (p.getAPiocher().getCouleur().equals(j.getMoteur().getTable().getAtout()) && p.getAPiocher().rangPlusFort(meilleure.getPile().get(meilleure.getPile().size() - 1))) {
                    meilleure = p;
                }
            } else {
                if (p.getAPiocher().getCouleur().equals(j.getMoteur().getTable().getAtout()) || p.getAPiocher().rangPlusFort(meilleure.getPile().get(meilleure.getPile().size() - 1))) {
                    meilleure = p;
                }
            }
        }
        main.add(meilleure.piocher());
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
