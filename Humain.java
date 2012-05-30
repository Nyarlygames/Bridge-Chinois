
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Samy
 */
public class Humain extends Joueur {

    public Humain(Table t, int id) {
        this.table = t;
        this.id = id;
        nbPlis = 0;
        score = 0;
        aJoue = false;
        aChoisi = false;
        phaseChoisir = false;
        phaseJouer = false;
    }

    @Override
    void jouer() {
        phaseJouer = true;
        while (!aJoue) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Humain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        phaseJouer = false;

    }

    @Override
    void choisir() {
        phaseChoisir = true;
        while (!aChoisi) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Humain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        phaseChoisir = false;
    }
}
