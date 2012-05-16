<<<<<<< HEAD

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Samy
 */
public class Humain extends Joueur {

    private boolean aJoue;

    public Humain(Jeu j, int id) {
        this.j = j;
        this.id = id;
        aJoue = false;


    }

    @Override
    Boolean jouer() {

        aJoue = false;



        while (!aJoue) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Humain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return aPerdu;




    }
}
=======

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Samy
 */
public class Humain extends Joueur {

    private boolean aJoue;

    public Humain(Jeu j, int id) {
        this.j = j;
        this.id = id;
        aJoue = false;


    }

    @Override
    Boolean jouer() {

        aJoue = false;



        while (!aJoue) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Humain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return aPerdu;




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
>>>>>>> b415317ed9940a382c9fedb3ca225a5d8bf4f423
