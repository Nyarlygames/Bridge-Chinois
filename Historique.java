
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Val
 */
public class Historique {
    ArrayList<EntreeHistorique> hist = new ArrayList<EntreeHistorique>();
    int position = -1;

    public Historique() {
    }
    
    public EntreeHistorique getCourant(){
        
        return hist.get(position);
    }
    

    
        //Decale la position d'un vers la gauche
    void annuler() {
        System.out.println("taille" + hist.size());
        if (position > 0) {
            position -= 1;
        }

    }
    
       //Decale la position d'un vers la droite
    void refaire() {
        if (position < hist.size() - 2) {
            position += 1;
        }
    }
    
    
        //Ajoute la gaufre g apres la position courante de l'historique. Supprime les eventuelles gaufres apres la position actuelle
    void addEntree(EntreeHistorique eg) {
        if (position < hist.size() - 1) {
            ArrayList<EntreeHistorique> resultat = new ArrayList<EntreeHistorique>();
            for (int i = 0; i <= position; i++) {
                resultat.add(hist.get(i));
            }
            hist = resultat;
        }
        hist.add(eg);
        position++;
    }
}
