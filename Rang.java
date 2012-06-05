/*
Auteur : ZIANE-CHERIF Mohammed-El-Amine
Date de Creation 12/05/2012 : 00:01
Date de Dernière modification 12/05/2012 : 18:54
 */

 

enum Rang implements java.io.Serializable {


    DEUX(2), TROIS(3), QUATRE(4), CINQ(5), SIX(6), SEPT(7), HUIT(8),
    NEUF(9), DIX(10), VALET(11), DAME(12), ROI(13), AS(14);
    // -------------------------------------Attribute-------------------------------------
    int rang;

    // -------------------------------------Constructor-------------------------------------
    Rang(int i) {
        rang = i;
    }

    // -------------------------------------Accesseur-------------------------------------
    public int getRang() {
        return rang;
    }
}
