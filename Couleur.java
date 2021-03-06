/*
Auteur : ZIANE-CHERIF Mohammed-El-Amine
Date de Creation 12/05/2012 : 00:01
Date de Dernière modification 12/05/2012 : 18:54
 */

enum Couleur implements java.io.Serializable  {


    TREFLE(0), CARREAU(1), COEUR(2), PIQUE(3);
    // -------------------------------------Attribute-------------------------------------
    int couleur;

    // -------------------------------------Constructor------------------------------------- 
    Couleur(int i) {
        couleur = i;
    }

    // -------------------------------------Accesseur-------------------------------------
    public int getCouleur() {
        return couleur;
    }
        
    public static Couleur convert( int i ) {
    for ( Couleur current : values() ) {
        if ( current.ordinal() == i ) {
        return current;
        }
    }

    return null;
    }
}
