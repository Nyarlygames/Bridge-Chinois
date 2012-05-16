
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Samy
 */
public class PC extends Joueur {

    public PC(Jeu j, int id) {
        this.j = j;
        this.id = id;



    }

    @Override
    Boolean jouer() {
        aPerdu = false;
        ArrayList<Carte> jouables = new ArrayList<Carte>();
        if (j.getJoueurCourant().equals(j.joueur2)) {
            Carte c = j.moteur.table.carte1;
            if (c != null) {
                for (Carte ca : j.moteur.table.main2.main) {
                    if (c.memeCouleur(ca)) {
                        jouables.add(ca);
                    }
                }
                if (jouables.isEmpty()) {//pas d'atouts non plus donc bah on met tout
                    for (Carte ca : j.moteur.table.main2.main) {
                        jouables.add(ca);
                    }
                }


                Random r = new Random();

                j.moteur.table.carte2 = jouables.get(r.nextInt(jouables.size()));


            } else {
                Random r = new Random();
                j.moteur.table.carte2 = j.moteur.table.main2.main.get(r.nextInt(jouables.size()));

            }
        } else {//pc est joueur 1
            Carte c = j.moteur.table.carte2;
            if (c != null) {
                for (Carte ca : j.moteur.table.main1.main) {
                    if (c.memeCouleur(ca)) {
                        jouables.add(ca);
                    }
                }
                if (jouables.isEmpty()) {//pas d'atouts non plus donc bah on met tout
                    for (Carte ca : j.moteur.table.main1.main) {
                        jouables.add(ca);
                    }
                }


                Random r = new Random();

                j.moteur.table.carte2 = jouables.get(r.nextInt(jouables.size()));


            } else {
                Random r = new Random();
                j.moteur.table.carte1 = j.moteur.table.main1.main.get(r.nextInt(jouables.size()));

            }





        }

        return aPerdu;
    }
<<<<<<< HEAD
=======

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
>>>>>>> b415317ed9940a382c9fedb3ca225a5d8bf4f423
}
