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

    public boolean jouer(Carte c) {

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
                    table.getInfoAdv1().hasCouleur(c.couleur);
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

    public boolean etapeSetCarte(Carte c, boolean croupier, int mode) {
        if((mode == 2 && croupier) || mode != 2)
        {
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
         else //(mode == 2 && !croupier)
         {
            if (this.getTable().getCarte1() == null) {
                table.setCarte2(c);
                table.getMain2().getMain().remove(c);
                table.getMain2connue().getMain().remove(c);
                return true;
            } else {
                if (c.memeCouleur(this.getTable().getCarte1())) {
                    table.setCarte2(c);
                    table.getMain2().getMain().remove(c);
                    table.getMain2connue().getMain().remove(c);
                    return true;
                } else {
                    if (!this.getTable().getMain1().aCouleur(this.getTable().getCarte1())) {
                        table.setCarte2(c);
                        table.getMain2().getMain().remove(c);
                        table.getMain2connue().getMain().remove(c);
                        return true;
                    } else {
                        return false;
                    }

                }
            }
         }
    
    }
    
    public void choisir(Pile p, int joueurCourant) {
        Carte c = p.piocher();
        table.getMain1().add(c);
        table.getMain1connue().add(c);
        table.getInfoAdv1().hasntCouleur(c.couleur);
        
    }
}
