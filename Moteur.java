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
    public void jouer(Carte c, int joueurCourant) {
        if (joueurCourant == 1) {
        	table.setCarte1(c);
            table.getMain1().getMain().remove(c);
        } else {
            table.setCarte2(c);
            table.getMain2().getMain().remove(c);
        }
    }

    public void choisir(Pile p, int joueurCourant) {
    	if (joueurCourant == 1) {
            table.getMain1().add(p.piocher());
        } else {
            table.getMain2().add(p.piocher());
        }
    }
}
