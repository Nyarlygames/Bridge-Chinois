/*
Auteur : ZIANE-CHERIF Mohammed-El-Amine
Date de Creation 14/05/2012 : 03:15
Date de Derniere modification 16/05/2012 : 04:24
 */

public abstract class Joueur {

    // -------------------------------------Atributs-------------------------------------
    Jeu j;
    int nbPlis, score, id;
    Boolean aJoue, aChoisi, phaseJouer, phaseChoisir;
    Carte carteAdv;
    Main main;

    // -------------------------------------Accesseurs-------------------------------------
    public int getNbPlis() {
        return nbPlis;
    }

    public void setNbPlis(int nbPlis) {
        this.nbPlis = nbPlis;
    }
    
    

    public Boolean getPhaseJouer() {
		return phaseJouer;
	}

	public void setPhaseJouer(Boolean phaseJouer) {
		this.phaseJouer = phaseJouer;
	}

	public Boolean getPhaseChoisir() {
		return phaseChoisir;
	}

	public void setPhaseChoisir(Boolean phaseChoisir) {
		this.phaseChoisir = phaseChoisir;
	}

	public Carte getCarteAdv() {
		return carteAdv;
	}

	public void setCarteAdv(Carte carteAdv) {
		this.carteAdv = carteAdv;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public Jeu getJ() {
        return j;
    }

    public void setJ(Jeu j) {
        this.j = j;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    // -------------------------------------Méthodes-------------------------------------
    abstract void jouer();

    abstract void choisir();
}