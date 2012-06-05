/*
Auteur : ZIANE-CHERIF Mohammed-El-Amine
Date de Creation 14/05/2012 : 03:15
Date de Derniere modification 16/05/2012 : 04:24
 */

public abstract class Joueur {

    // -------------------------------------Attributs-------------------------------------
    Table table;
    int nbPlis, score, id;
    Boolean aJoue, aChoisi, phaseJouer, phaseChoisir;

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

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
    
       public void setNouveauJoueur(Table table, int nbPlis, boolean aJoue, boolean aChoisi, boolean phaseChoisir, boolean phaseJouer){
           System.out.println("a Joue" + aJoue);
           System.out.println("a aChoisi" + aChoisi);
           System.out.println("a phaseChoisir" + phaseChoisir);
           System.out.println("a phaseJouer" + phaseJouer);
        this.setTable(table);
        this.setNbPlis(nbPlis);
        this.setaJoue(aJoue);
        this.setaChoisi(aChoisi);
        this.setPhaseChoisir(phaseChoisir);
        this.setPhaseJouer(phaseJouer);

    }

    // -------------------------------------Méthodes-------------------------------------
    
   /* public Joueur clone()
    {
    	
    }*/
    public abstract Joueur clone();    
    abstract void jouer();
    abstract void choisir();
}
