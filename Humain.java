
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Samy
 */
public class Humain extends Joueur {

    public Humain() {
    }

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


    public Joueur clone() {
        Joueur j = new Humain();
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
        phaseJouer = true;
        while (!this.getaJoue()) {
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

    public Carte hintJouer() {
        Carte carteAdv;
        if (id == 2) {
            carteAdv = table.getCarte1();
        } else {
            carteAdv = table.getCarte2();
        }

        Carte c = null;
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

        if (!gagnantes.isEmpty()) {
            c = gagnantes.get(0);
            for (Carte ca : gagnantes) {
                if (!ca.rangPlusFort(c)) {
                    c = ca;
                }
            }
        } else {
            if (!prems) {//pas de gagnante donc on balance une carte nulle
		if (jouables.size() > 0) {
		    c = jouables.get(0);
		    for (Carte ca : jouables) {
			if (!ca.rangPlusFort(c)) {
			    c = ca;
			}
		    }
		}
            } else {//si on commence a jouer alors on met la plus grosse carte possible
                if (jouables.size() >0) {
		    c = jouables.get(0);
		    for (Carte ca : jouables) {
			if (ca.rangPlusFort(c)) {
			    c = ca;
			}
		    }
		}
	    }
        }

        return c;
    }

    public Integer hintChoisir() {
        ArrayList<Pile> piochables = new ArrayList<Pile>();

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
	    return meilleure.getNumero();
        }
	else
	    return(-1);

    }

    ArrayList<Carte> getCartesJouables() {
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
    

}
