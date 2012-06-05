
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Samy
 */
public class PCRandom extends PC {

    public PCRandom() {
    }

    public PCRandom(Table t, int id) {
        this.table = t;
        this.id = id;
        nbPlis = 0;
        score = 0;
        aJoue = false;
        aChoisi = false;
        phaseChoisir = false;
        phaseJouer = false;
    }

    public Joueur clone() {
        Joueur j = new PCRandom();
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

    @Override
    void jouer() {

        ArrayList<Carte> jouables = getCartesJouables();

        Random r = new Random();
        Integer i = r.nextInt(jouables.size());
        if (id == 2) {
            table.setCarte2(jouables.get(i));
            table.getMain2connue().getMain().remove(jouables.get(i));
            table.getMain2().getMain().remove(jouables.get(i));
        } else {
            table.setCarte1(jouables.get(i));
            table.getMain1connue().getMain().remove(jouables.get(i));
            table.getMain1().getMain().remove(jouables.get(i));
        }

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

        if (id == 2) {
            table.getMain2().add(c);
            table.getMain2connue().add(c);
        } else {
            table.getMain1().add(c);
            table.getMain1connue().add(c);
        }

        aChoisi = true;
    }
}
