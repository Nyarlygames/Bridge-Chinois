/*
Auteur : ZIANE-CHERIF Mohammed-El-Amine
Date de Creation 15/05/2012 : 18:00
Date de Dernière modification 15/05/2012 : 18:31
 */

public class Moteur {

    Table table;

    Moteur(Table table) {
        this.table = table;
    }

    // -------------------------------------Accesseurs-------------------------------------
    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    // --------------------------------------Methodes-------------------------------------

    public boolean jouer(Carte c, int joueurCourant) {
        if (this.getTable().getCarte2() == null) {
            table.setCarte1(c);
            table.getMain1().getMain().remove(c);
            table.getMain1connue().getMain().remove(c);
            return true;
        } else {
            if (c.memeCouleur(this.getTable().getCarte2())) {
                table.setCarte1(c);
                table.getMain1().getMain().remove(c);
                table.getMain1connue().getMain().remove(c);
                return true;
            } else {
                if (!this.getTable().getMain1().aCouleur(this.getTable().getCarte2())) {
                    table.setCarte1(c);
                    table.getMain1().getMain().remove(c);
                    table.getMain1connue().getMain().remove(c);
                    return true;
                } else {
                    return false;
                }

            }

        }
    }


    public void choisir(Pile p, int joueurCourant) {
        Carte c = p.piocher();
        if (joueurCourant == 1) {
            table.getMain1().add(c);
            table.getMain1connue().add(c);

        } else {
            table.getMain2().add(c);
            table.getMain1connue().add(c);

        }
    }
}
