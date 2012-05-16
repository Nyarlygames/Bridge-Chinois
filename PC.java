
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Samy
 */
public class PC extends Joueur {

    public PC(Jeu j, int id, Main main, Carte carteAdv) {
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
            for (Carte ca : main.getMain()) {
                jouables.add(ca);
            }
        }


        Random r = new Random();
        if (j.getJoueurCourant().equals(j.joueur2)) {
            j.getMoteur().getTable().setCarte2(jouables.get(r.nextInt(jouables.size())));
        } else {
            j.getMoteur().getTable().setCarte1(jouables.get(r.nextInt(jouables.size())));
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

        Random r = new Random();
        main.add(piochables.get(r.nextInt(piochables.size())).piocher());


    }
}