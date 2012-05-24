
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Samy
 */
public class Humain extends Joueur {

    public Humain(Jeu j, int id) {
        this.j = j;
        this.id = id;
        aJoue = false;


    }

    @Override
    void jouer() {

        aJoue = false;



        while (!aJoue) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Humain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    void choisir() {
        while (!aChoisi) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Humain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
