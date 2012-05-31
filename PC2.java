
import java.util.ArrayList;

/**
 * @author Samy
 */
public class PC2 extends Joueur {

	public PC2(){}
    public PC2(Table t, int id, Main main, Carte carteAdv) {
        this.table = t;
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
        if (id == 2) {
            carteAdv = table.getCarte1();
        } else {
            carteAdv = table.getCarte2();
        }
        ArrayList<Carte> jouables = getCartesJouables();
        ArrayList<Carte> gagnantes = new ArrayList<Carte>();
        Boolean prems;
        if (carteAdv != null) {
            prems = false;
            for (Carte ca : jouables) {
                if (carteAdv.gagne(ca, table.getAtout())) {
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

        } else {//pas de gagnante donc on balance une carte nulle
            if (!prems) {
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
    
    protected Joueur clone()
    {
    	Joueur j = new PC();
    	j.setTable(table);
    	j.setId(id);
    	j.setNbPlis(nbPlis);
        j.setScore(score);
        j.setaJoue(aJoue);
        j.setaChoisi(aChoisi);
        j.setPhaseChoisir(phaseChoisir);
        j.setPhaseJouer(phaseJouer);
        j.setCarteAdv(carteAdv);
        j.setMain(main);
    	return j;
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
