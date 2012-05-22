/*
Auteur : ZIANE-CHERIF Mohammed-El-Amine
Date de Creation 14/05/2012 : 03:15
Date de Dernière modification 16/05/2012 : 04:24
 */

public abstract class Joueur {

    // -------------------------------------Atributs-------------------------------------
    Jeu j;
    int nbPlis, score, id;
    Boolean aJoue, aChoisi;
    Carte carteAdv;
    Main main;

    // -------------------------------------Accesseurs-------------------------------------
    public int getNbPlis() {
        return nbPlis;
    }

    public void setNbPlis(int nbPlis) {
        this.nbPlis = nbPlis;
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

    // -------------------------------------Constructeur-------------------------------------
    abstract void jouer();

    abstract void choisir();
}
