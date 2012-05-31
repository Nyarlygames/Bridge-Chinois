/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Val
 */
public class EntreeHistorique {
    Joueur joueur1;
    Joueur joueur2;
    Table table;


    public EntreeHistorique(Joueur Joueur1, Joueur Joueur2, Table table) {
        this.joueur1 = Joueur1;
        this.joueur2 = Joueur2;
        this.table = table;
    }

    public Joueur getJoueur1() {
        return joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }

    public Table getTable() {
        return table;
    }
    
    
}
