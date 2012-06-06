
import java.util.ArrayList;

/**
 * @author Samy
 */
public class PC2 extends PC implements java.io.Serializable{

    public PC2() {
    }

    public PC2(Table t, int id) {
        this.table = t;
        this.id = id;
        nbPlis = 0;
        score = 0;
        aJoue = false;
        aChoisi = false;
        phaseChoisir = true;
        phaseJouer = true;
    }
    
    

       
    @Override
    void jouer() {
        Main main;
        Carte carteAdv;
        if (id == 2) {
            carteAdv = table.getCarte1();
            main = table.getMain2();
        } else {
            carteAdv = table.getCarte2();
            main = table.getMain1();
        }
        ArrayList<Carte> jouables = getCartesJouables();
        ArrayList<Carte> gagnantes = new ArrayList<Carte>();
        Boolean prems;
        if (carteAdv != null) {
            prems = false;
            for (Carte ca : jouables) {
                if (ca.gagne(carteAdv, table.getAtout())) {
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
        } else {
            if (!prems) {//pas de gagnante donc on balance une carte nulle
                meilleure = jouables.get(0);
                for (Carte ca : jouables) {
                    if (!ca.rangPlusFort(meilleure)) {
                        meilleure = ca;
                    }
                }
            } else {//si on commence a jouer alors on met la plus grosse carte possible
                meilleure = jouables.get(0);
                for (Carte ca : jouables) {
                    if (ca.rangPlusFort(meilleure)) {
                        meilleure = ca;
                    }
                }
            }
        }

        if (id == 2) {
            table.setCarte2(meilleure);
            table.getMain2connue().getMain().remove(meilleure);
        } else {
            table.setCarte1(meilleure);
            table.getMain1connue().getMain().remove(meilleure);
        }
        main.getMain().remove(meilleure);
        aJoue = true;
    }

    @Override
    void choisir() {
        ArrayList<Pile> piochables = new ArrayList<Pile>();

        Main main;
        if (id == 2) {
            main = table.getMain2();
        } else {
            main = table.getMain1();
        }
        for (Pile p : table.getPiles()) {
            if (!p.estVide()) {
                piochables.add(p);
            }
        }
        Pile meilleure = null;
        if (!piochables.isEmpty()) {
            meilleure = piochables.get(0);
            for (Pile p : piochables) {
                if (meilleure.getPile().get(meilleure.getPile().size() - 1).getCouleur().equals(table.getAtout())) {
                    if (p.getAPiocher().getCouleur().equals(table.getAtout()) && p.getAPiocher().rangPlusFort(meilleure.getPile().get(meilleure.getPile().size() - 1))) {
                        meilleure = p;
                    }
                } else {
                    if (p.getAPiocher().getCouleur().equals(table.getAtout()) || p.getAPiocher().rangPlusFort(meilleure.getPile().get(meilleure.getPile().size() - 1))) {
                        meilleure = p;
                    }
                }
            }
            Carte c = meilleure.piocher();
            main.add(c);
            if (id == 2) {
                table.getMain2connue().add(c);
            } else {
                table.getMain1connue().add(c);
            }
        }

        aChoisi = true;
    }
    
    public Joueur clone() {
        Joueur j = new PC2();
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
}
