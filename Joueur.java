/*
Auteur : ZIANE-CHERIF Mohammed-El-Amine
Date de Creation 14/05/2012 : 03:15
Date de Dernière modification 15/05/2012 : 18:21
 */

public abstract class Joueur {

    // -------------------------------------Atributs-------------------------------------
    Jeu j;
    int nbPlis,score, id;
    Boolean aPerdu, aJoue, aChoisi;

    // -------------------------------------Accesseurs-------------------------------------

    
    public Jeu getJ() {
		return j;
	}

	public void setJ(Jeu j) {
		this.j = j;
	}

	public int getNbPlis() {
		return nbPlis;
	}

	public void setNbPlis(int nbPlis) {
		this.nbPlis = nbPlis;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getaPerdu() {
		return aPerdu;
	}

	public void setaPerdu(Boolean aPerdu) {
		this.aPerdu = aPerdu;
	}

	public Boolean getaJoue() {
		return aJoue;
	}

	public void setaJoue(Boolean aJoue) {
		this.aJoue = aJoue;
	}

	public Boolean getaChoisi() {
		return aChoisi;
	}

	public void setaChoisi(Boolean aChoisi) {
		this.aChoisi = aChoisi;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    // -------------------------------------Constructeur-------------------------------------
    abstract Boolean jouer();

    abstract void choisir();
}
