
import java.util.ArrayList;

/**
 * @author Samy
 */
public abstract class PC extends Joueur {

    protected ArrayList<Carte> getCartesJouables() {
        ArrayList<Carte> jouables = new ArrayList<Carte>();
        Main main;
        Carte carteAdv;
        if (id == 2) {
            carteAdv = table.getCarte1();
            main = table.getMain2();
        } else {
            carteAdv = table.getCarte2();
            main = table.getMain1();
        }
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

    protected ArrayList<Carte> getCartesJouables(ArrayList<Carte> entree, Carte c) {//renvoie les cartes jouables parmi celles en entrée quand la carte C est posée en face
        ArrayList<Carte> jouables = new ArrayList<Carte>();

        if (c != null) {
            for (Carte ca : entree) {
                if (c.memeCouleur(ca)) {
                    jouables.add(ca);
                }
            }
            if (jouables.isEmpty()) {//pas la bonne couleur donc bah on met tout
                for (Carte ca : entree) {
                    jouables.add(ca);
                }
            }
        } else {
            if (jouables.isEmpty()) {//on commence donc bah on met tout
                for (Carte ca : entree) {
                    jouables.add(ca);
                }
            }
        }
        return jouables;
    }
}
