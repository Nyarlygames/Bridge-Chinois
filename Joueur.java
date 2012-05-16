/*
Auteur : ZIANE-CHERIF Mohammed-El-Amine
Date de Creation 14/05/2012 : 03:15
Date de Dernière modification 15/05/2012 : 18:21
*/

public abstract class Joueur {

	
	// -------------------------------------Atributs-------------------------------------
	
    Jeu j;
    int score, id;
    Boolean aPerdu,aJoue,aChoisi;

	// -------------------------------------Accesseurs-------------------------------------

    public int getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
    
	// -------------------------------------Constructeur-------------------------------------

    
    abstract Boolean jouer();
}
