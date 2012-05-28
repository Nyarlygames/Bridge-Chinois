/* 
Auteur : ZIANE-CHERIF Mohammed-El-Amine
Date de Creation 14/05/2012 : 03:21
Date de Dernière modification 23/05/2012 : 14:25
 */

import java.util.ArrayList;
import java.util.Random;

public class Jeu {

    // -------------------------------------Attributs-----------------------------------------
    Moteur moteur;
    Joueur joueur1, joueur2;
    int joueurCourant;
    int type;
    int max;

    // -------------------------------------Constructeur-------------------------------------
    /* le mode indique le nombre de joueur humain :
    0 : PC vs PC
    1 : Hum vs PC
    2 : Hum vs Humm 
    
    le type indique si la partie se termine suivant un nombre de point designe par la variable max :
    0 : matche a jouer
    1 : score a inteindre max 
    2 : aventure
     */
	Jeu(Moteur m, int mode, int type, int max, int difficulte) {
        Random rand = new Random();


        joueurCourant = rand.nextInt(2);
        joueurCourant++;
        moteur = m;
        switch (mode) {
            case 0:
                this.joueur1 = new PC(this, 1, moteur.getTable().getMain1(), moteur.getTable().getCarte2());
                this.joueur2 = new PC(this, 2, moteur.getTable().getMain2(), moteur.getTable().getCarte1());
                break;

            case 1:
                this.joueur1 = new Humain(this, 1);
                switch (difficulte) {
                    case 0:
                        this.joueur2 = new PC(this, 2, moteur.getTable().getMain2(), moteur.getTable().getCarte1());

                    case 1:
                        this.joueur2 = new PC2(this, 2, moteur.getTable().getMain2(), moteur.getTable().getCarte1());

                    case 2:
                        this.joueur2 = new PC3(this, 2, moteur.getTable().getMain2(), moteur.getTable().getCarte1());

                    case 3:
                        this.joueur2 = new PC4(this, 2, moteur.getTable().getMain2(), moteur.getTable().getCarte1());


                }
                this.joueur2 = new PC(this, 2, moteur.getTable().getMain2(), moteur.getTable().getCarte1());
                break;
            case 2:
                this.joueur1 = new Humain(this, 1);
                this.joueur2 = new Humain(this, 2);
                break;

        }
        this.type = type;
        this.max = max;

    }

    Jeu(Moteur m) {
        type = 2;
    }

    // -------------------------------------Accesseurs-------------------------------------
    public Moteur getMoteur() {
        return moteur;
    }

    public void setMoteur(Moteur moteur) {
        this.moteur = moteur;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public Joueur getJoueur1() {
        return joueur1;
    }

    public void setJoueur1(Joueur joueur1) {
        this.joueur1 = joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }

    public void setJoueur2(Joueur joueur2) {
        this.joueur2 = joueur2;
    }


    public int getJoueurCourant() {
        return joueurCourant;
    }


    public void setJoueurCourant(int joueurCourant) {
        this.joueurCourant = joueurCourant;
    }

    // Retourne le joueur adverse
    public int getJoueurAdverse(int joueur) {
        if (joueur == 1)
	    return 2;
	else if (joueur == 2)
	    return 1;
	else return 0;
    }

    // Retourne la carte adverse du joueur
    public Carte getCarteAdverse(int joueur) {
	if (joueur == 1)
	    return (moteur.table.carte2);
	else if (joueur == 2)
	    return (moteur.table.carte1);
	else
	    return (null);
    }

    // Retourne la main du joueur
    public Main getMainJoueur (int joueur) {
	if (joueur == 1)
	    return moteur.table.main1;
	else if (joueur == 2)
	    return moteur.table.main2;
	else
	    return (null);
    }

    // -------------------------------------Methodes-----------------------------------------
    // distribue les cartes entre les joueurs et séparation du reste en 6 piles
    public void initialiser() {
        for (int i = 0; i < 11; i++) {
            moteur.table.main1.add(moteur.table.paquet.piocher());
            moteur.table.main2.add(moteur.table.paquet.piocher());
        }

        ArrayList<Carte> tas1 = new ArrayList<Carte>(5);
        ArrayList<Carte> tas2 = new ArrayList<Carte>(5);
        ArrayList<Carte> tas3 = new ArrayList<Carte>(5);
        ArrayList<Carte> tas4 = new ArrayList<Carte>(5);
        ArrayList<Carte> tas5 = new ArrayList<Carte>(5);
        ArrayList<Carte> tas6 = new ArrayList<Carte>(5);

        for (int i = 0; i < 5; i++) {
            tas1.add(moteur.table.paquet.piocher());
            tas2.add(moteur.table.paquet.piocher());
            tas3.add(moteur.table.paquet.piocher());
            tas4.add(moteur.table.paquet.piocher());
            tas5.add(moteur.table.paquet.piocher());
            tas6.add(moteur.table.paquet.piocher());
        }

        Pile pile = new Pile(1, tas1);
        moteur.table.addPile(pile);

        pile = new Pile(2, tas2);
        moteur.table.addPile(pile);

        pile = new Pile(3, tas3);
        moteur.table.addPile(pile);

        pile = new Pile(4, tas4);
        moteur.table.addPile(pile);

        pile = new Pile(5, tas5);
        moteur.table.addPile(pile);

        pile = new Pile(6, tas6);
        moteur.table.addPile(pile);

        Carte max = carteRangFort(this.getMoteur().getTable().getPiles());
        if (max.rangSupDix()) {
            moteur.getTable().setAtout(max.getCouleur());
        }

    }

    // renvoie la carte la plus forte parmis les cartes dévoilées au dessus des 6 piles. cette méthode est utilisé
    // pour choisir l'atout 
    private Carte carteRangFort(ArrayList<Pile> piles) {
        Carte carteCourante, resultat = null;
        resultat = piles.get(0).getPile().get(4);
        for (int i = 1; i < 6; i++) {
            carteCourante = piles.get(i).getPile().get(4);
            if (carteCourante.memeRang(resultat)) {
                if (carteCourante.couleurPlusForte(resultat)) {
                    resultat = carteCourante;
                }
            } else {
                if (carteCourante.rangPlusFort(resultat)) {
                    resultat = carteCourante;
                }
            }
        }
        return resultat;
    }

    // L'Arbitre : déroulement d'une partie entre 2 joueurs 
    public void jouer() {
    	
    	
    	Carte c1, c2 = null;
        int nbMatche = 0;
	    c1 = null;
	    c2 = null;
    	while( (type==0 && nbMatche != max) || (type == 1 && (joueur1.getScore()<max || joueur2.getScore()<max) ) 
    		   || (type ==2 && nbMatche<4))
    	{
    		if(type==2)
    	   	{
    			switch(nbMatche){
	    			case 0:
	                	this.joueur2 = new PC(this, 2, moteur.getTable().getMain2(), moteur.getTable().getCarte1());
	                	
	                case 1 :
	                	this.joueur2 = new PC2(this, 2, moteur.getTable().getMain2(), moteur.getTable().getCarte1());
	                	
	                case 2 :
	                	this.joueur2 = new PC3(this, 2, moteur.getTable().getMain2(), moteur.getTable().getCarte1());

	                case 3 :
	                	this.joueur2 = new PC4(this, 2, moteur.getTable().getMain2(), moteur.getTable().getCarte1());	
    		   }
    	   	}
    	   	initialiser();
		   	while (moteur.getTable().getMain1().getSize() != 0 && moteur.getTable().getMain2().getSize() != 0) {

				intVersJoueur().jouer();
				switcher();
				intVersJoueur().jouer();
				    if (joueurCourant == 1) {
					// (carteJouable(moteur.getTable().getCarte2(), 1) == true) && (carteJouable(moteur.getTable().getCarte1(), 2) == true)
					// test la jouabilité des deux cartes
					c1 = moteur.getTable().getCarte2();
					c2 = moteur.getTable().getCarte1();
				    }
				    else
					//(carteJouable(moteur.getTable().getCarte1(), 2) == true) && (carteJouable(moteur.getTable().getCarte2(), 2) == true)
					// test la jouabilité des deux cartes
					c1 = moteur.getTable().getCarte1();
					c2 = moteur.getTable().getCarte2();
				    // Attente avant de ramasser
					try{
					    Thread.currentThread().sleep(1000);
					}
					catch(InterruptedException ie){
					    System.out.println("Echec de l'attente");
					}
					System.out.println(c1.toString() + c2.toString());
				moteur.getTable().setCarte1(null);
				moteur.getTable().setCarte2(null);
				if (c1.gagne(c2, moteur.getTable().getAtout())) {
				    switcher();
				    intVersJoueur().setNbPlis(intVersJoueur().getNbPlis() + 1);
					if (!moteur.getTable().pilesVides()){
					    intVersJoueur().choisir();
					    switcher();
					    intVersJoueur().choisir();
					    switcher();
					}
				} else {
				    intVersJoueur().setNbPlis(intVersJoueur().getNbPlis() + 1);
					if (!moteur.getTable().pilesVides()){
					    intVersJoueur().choisir();
					    switcher();
					    intVersJoueur().choisir();
					    switcher();
					}
				}
				joueur1.setaJoue(false);
				joueur1.setaChoisi(false);
				joueur2.setaJoue(false);
				joueur2.setaChoisi(false);
				
				
				
		   	}
    	   	nbMatche++;
    	   	joueur1.setScore(joueur1.getScore() + joueur1.getNbPlis());
    	   	joueur2.setScore(joueur2.getScore() + joueur2.getNbPlis());
    	   	joueur1.setNbPlis(0);
    	   	joueur2.setNbPlis(0);
    	   	
    	   	if(type == 2)
    	   	{
    	   		if(joueur1.getScore() > joueur2.getScore())
    	   		{
    	   			//gagne on passe au niveau suivant
    	   		}
    	   		else{
    	   			if(joueur1.getScore() == joueur2.getScore())
    	   			{
    	   				//
    	   			}
    	   			else
    	   			{
    	   				//perdu
    	   			}
    	   		}
    	   	}
       }

    }

    // renvoi le joueur courant
    public Joueur intVersJoueur() {
        if (joueurCourant == 1) {
            return joueur1;
        } else {
            return joueur2;
        }
    }

    // switch le joueur courant
    public void switcher() {
        if (joueurCourant == 1) {
            this.joueurCourant = 2;
        } else {
            this.joueurCourant = 1;
        }
    }

    //renvoie les cartes inconnues du joueur courant (dans la main de l'autre ou sous les piles)
    public ArrayList<Carte> getCartesInconnues() {
        ArrayList<Carte> inconnues = new ArrayList<Carte>();

        if (joueurCourant == 1) {
            inconnues.addAll(moteur.getTable().getMain2().getMain());
        } else {
            inconnues.addAll(moteur.getTable().getMain1().getMain());

        }
        for (Pile p : moteur.getTable().getPiles()) {
            inconnues.addAll(p.getPile());
            if (p.getPile().size() >= 1) {
                inconnues.remove(p.getAPiocher());
            }
        }
        return inconnues;
    }

    //renvoie les cartes de l'adversaire du joueur courant (time to cheat)
    public ArrayList<Carte> getCartesAdversaire() {
        ArrayList<Carte> adversaire = new ArrayList<Carte>();

        if (joueurCourant == 1) {
            adversaire.addAll(moteur.getTable().getMain2().getMain());
        } else {
            adversaire.addAll(moteur.getTable().getMain1().getMain());

        }
        return adversaire;
    }

    // Determiner si une carte est jouable
	public boolean carteJouable(Carte c, int joueur){
	    // A l'adversaire de jouer
	    if (joueur != joueurCourant)
		return (false);
	    // A nous de jouer en premier
	    if (getCarteAdverse(joueur) == null)
		return (true);

	    else {
		// Si il y a de l'atout
		if (moteur.table.atout != null) {
		    // A nous de jouer en deuxieme
		    Carte carteadv = getCarteAdverse(joueur);
		    Main mainjoueur = getMainJoueur(joueur);
		    // Si il a joué un atout
		    if (carteadv.couleur == moteur.table.atout)
			{
			    boolean atout = false;

			for (int i = 0; i < mainjoueur.getSize(); i++){
			    if (mainjoueur.getCarte(i).couleur == moteur.table.atout)
				atout = true;
			}
			    // Pas d'atout dans la main
			    if (atout == false)
				return true;
			    // On veut jouer un atout
			    else if (c.couleur == moteur.table.atout)
				return true;
			    else
				return false;
			}
		    // Pas d'atout
		    else {
			boolean atout = false;
			boolean defausse = true;
			for (int i = 0; i < mainjoueur.getSize(); i++){
			    if (mainjoueur.getCarte(i).couleur == moteur.table.atout)
				atout = true;
			    if (mainjoueur.getCarte(i).couleur == carteadv.couleur) {
				defausse = false;
			    }
			}
			// On ne peut pas fournir
			if (defausse == true) {
			    return true;
			}
			// On peut fournir
			else {
			    // Si on veut fournir
			    if (c.couleur == carteadv.couleur)
				return true;
			    //Si on veut se defausser
			    else
				return false;
			}
		    }
		}
		// Si il n'y a pas d'atout
		else {
		}
	    }
	    return false;
	}

}