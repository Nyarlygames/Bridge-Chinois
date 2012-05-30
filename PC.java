
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Samy
 */
public class PC extends Joueur {

    public PC(Table t, int id, Main main, Carte carteAdv) {
        this.table = t;
        this.id = id;
        nbPlis = 0;
        score = 0;
        aJoue = false;
        aChoisi = false;
        phaseChoisir = false;
        phaseJouer = false;
        this.carteAdv = carteAdv;
        this.main = main;
    }

    @Override
    void jouer() {
        ArrayList<Carte> jouables = getCartesJouables();

        Random r = new Random();
        Integer i = r.nextInt(jouables.size());
        if (id == 2) {
            table.setCarte2(jouables.get(i));
            table.getMain2connue().getMain().remove(jouables.get(i));
        } else {
            table.setCarte1(jouables.get(i));
            table.getMain1connue().getMain().remove(jouables.get(i));
        }
        main.getMain().remove(jouables.get(i));
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

        Random r = new Random();
        Carte c = piochables.get(r.nextInt(piochables.size())).piocher();
        main.add(c);
        if (id == 2) {
            table.getMain2connue().add(c);
        } else {
            table.getMain1connue().add(c);
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
