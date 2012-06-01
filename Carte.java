
import java.util.logging.Level;
import java.util.logging.Logger;


public class Carte implements java.io.Serializable, Cloneable {

    // -------------------------------------Attribute-------------------------------------
    Couleur couleur;
    Rang rang;

    // -------------------------------------Constructor-------------------------------------
    Carte() {
        couleur = null;
        rang = null;
    }

    Carte(Couleur couleur, Rang rang) {
        this.couleur = couleur;
        this.rang = rang;
    }

    // -------------------------------------Accesseurs-------------------------------------
    // renvoie la couleur de la carte
    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public void setRang(Rang rang) {
        this.rang = rang;
    }

    // renvoie le rang de la carte
    public Rang getRang() {
        return rang;
    }

    // -------------------------------------Methodes-------------------------------------
    // renvoi vrai si la carte est de la meme couleur
    public boolean memeCouleur(Carte c) {
        return couleur == c.couleur;
    }

    // renvoi vrai si la carte est du meme rang
    public boolean memeRang(Carte c) {
        return rang == c.rang;
    }

    /*
     * renvoi vrai si la carte est plus forte que la carte c l'ordre pris en
     * compte dans cette méthode est le classement initial des cartes : Pique >
     * Coeur > Carreau > trêfle AS > Roi > ....> trois > deux cette methode est
     * utilisé pour le trie d'un paquet ou d'une main
     */
    public boolean plusForte(Carte c) {
        if (this.memeCouleur(c)) {
            return rang.getRang() > c.rang.getRang();
        } else {
            return c.couleur.getCouleur() < this.couleur.getCouleur();
        }

    }

    // renvoie vrai si la couleur de la carte est plus forte que la couleur de
    // la carte c :
    // pique > Coeur > Carreau > trêfle
    public boolean couleurPlusForte(Carte c) {
        return this.getCouleur().getCouleur() > c.getCouleur().getCouleur();
    }

    // renvoie vrai si le rang de la carte est plus fort que le rang de la carte
    // c :
    // AS > Roi > ....> trois > deux
    public boolean rangPlusFort(Carte c) {
        return this.getRang().getRang() > c.getRang().getRang();
    }

    // renvoie vrai si la carte est est un 10, un Valet, une Dame, un Roi ou un
    // AS
    public boolean rangSupDix() {
        return this.getRang().getRang() >= 10;
    }

    public String toString() {
        return this.rang + " de " + this.couleur;
    }

    // renvoie vrai si la carte gagne sur la carte c en connaissant l'atout
    // atout
    // cette fonction est utilisé dans le jeu pour comparer les deux cartes
    // posées par les joueurs
    public boolean gagne(Carte c, Couleur atout) {
        if (atout != null) {
            if (this.memeCouleur(c)) {
                return this.rangPlusFort(c);
            } else {
                if (c.couleur.getCouleur() == atout.getCouleur()) {
                    return false;
                } else {
                    return true;
                }
            }
        } else {
            if (this.memeCouleur(c)) {
                return this.rangPlusFort(c);
            } else {
                return true;
            }
        }
    }

    @Override
    public Object clone() {
        Carte c = null;
        try {
            c = (Carte) super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Carte.class.getName()).log(Level.SEVERE, null, ex);
        }

        return c;
    }

    public String toFileString() {
        if (this.rang.ordinal() + 2 < 10) {
            return this.couleur.toString().toLowerCase() + "_0"
                    + (this.rang.ordinal() + 2) + ".png";
        } else {
            return this.couleur.toString().toLowerCase() + "_"
                    + (this.rang.ordinal() + 2) + ".png";
        }
    }
}
