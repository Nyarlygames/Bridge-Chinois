/* 
Auteur : ZIANE-CHERIF Mohammed-El-Amine
Date de Creation 14/05/2012 : 03:21
Date de Dernière modification 23/05/2012 : 14:25
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.*;
import java.net.*;

public class Jeu implements Observable {

    // -------------------------------------Attributs-----------------------------------------
    Moteur moteur;
    Joueur joueur1, joueur2;
    int joueurCourant;
    int type;
    int max;
    Historique hist = new Historique();
    // liste des observateurs
    private ArrayList<Observateur> listObservateur = new ArrayList<Observateur>();
    int mode = -1;
    // Attributs réseau
    boolean croupier;
    int port = -1;
    String ip;
    ObjectOutputStream out;
    ObjectInputStream in;

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
        this.mode = mode;

        joueurCourant = rand.nextInt(2);
        joueurCourant++;
        moteur = m;
        switch (mode) {
            /* Mode IA vs IA */
            case 0:
                this.joueur1 = new PC(moteur.getTable(), 1, moteur.getTable().getMain1(), moteur.getTable().getCarte2());
                this.joueur2 = new PC(moteur.getTable(), 2, moteur.getTable().getMain2(), moteur.getTable().getCarte1());
                break;
            /* Mode Humain vs PC */
            case 1:
                this.joueur1 = new Humain(moteur.getTable(), 1);
                switch (difficulte) {
                    case 1:
                        this.joueur2 = new PC(moteur.getTable(), 2, moteur.getTable().getMain2(), moteur.getTable().getCarte1());
                        break;
                    case 2:
                        this.joueur2 = new PC2(moteur.getTable(), 2, moteur.getTable().getMain2(), moteur.getTable().getCarte1());
                        break;
                    case 3:
                        this.joueur2 = new PC3(moteur.getTable(), 2, moteur.getTable().getMain2(), moteur.getTable().getCarte1());
                        break;
                    case 4:
                        this.joueur2 = new PC4(moteur.getTable(), 2, moteur.getTable().getMain2(), moteur.getTable().getCarte1());
                        break;

                }
                break;
            /* Mode Réseau */
            case 2:

                this.joueur1 = new Humain(moteur.getTable(), 1);
                this.joueur2 = new Humain(moteur.getTable(), 2);
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

    public Historique getHist() {
        return this.hist;
    }

    public void setMoteur(Moteur moteur) {
        this.moteur = moteur;
    }

    public int getType() {
        return type;
    }

    public int getMode() {
        return mode;
    }

    public boolean getIsCroupier() {
        return croupier;
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

    public void setHist(Historique his) {
        this.hist = his;
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


        if (joueur == 1) {
            return 2;
        } else if (joueur == 2) {
            return 1;
        } else {
            return 0;
        }

    }

    // Retourne la carte adverse du joueur
    public Carte getCarteAdverse(int joueur) {

        if (joueur == 1) {
            return (moteur.getTable().carte2);
        } else if (joueur == 2) {
            return (moteur.getTable().carte1);
        } else {
            return (null);
        }
    }

    // Retourne la main du joueur
    public Main getMainJoueur(int joueur) {
        if (joueur == 1) {
            return moteur.getTable().getMain1();
        } else if (joueur == 2) {
            return moteur.getTable().getMain2();
        } else {
            return (null);
        }

    }

    // --------------------------------- Methodes MODE RESEAU --------------------------------
    public void attachDistantPlayer(String ip, boolean croupier) {
        this.ip = ip;
        this.croupier = croupier;
        this.port = 4242;
        if (croupier == true) {
            attenteConnexion();
        } else {
            attenteJeuDistant();
        }
    }

    /* Herbergement d'une partie et attente client */
    public void attenteConnexion() {
        String message = "";
        try {
            ServerSocket socketjeu = new ServerSocket(port);
            System.out.println("Attente d'une connexion ...");
            Socket connexion = socketjeu.accept();
            this.out = new ObjectOutputStream(connexion.getOutputStream());
            this.in = new ObjectInputStream(connexion.getInputStream());
            System.out.println("Connexion du Joueur Distant...");
        } catch (Exception e) {
            System.out.println("Echec attente de connexion");
        }
        /* Envoi de la table */
        try {
            System.out.println("Envoi de la table");
            /* Initialisation de la table */
            initialiser();

            this.out.writeObject(moteur.getTable());
            System.out.println("Table envoyée");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Echec de l'envoi de la table");
        }

    }

    /* Rejoindre la partie et attente de la Table par le croupier */
    public void attenteJeuDistant() {
        String message = "";
        try {
            Socket socketjeu = new Socket(InetAddress.getByName(this.ip), this.port);
            System.out.println("Connexion ...");
            this.out = new ObjectOutputStream(socketjeu.getOutputStream());
            this.in = new ObjectInputStream(socketjeu.getInputStream());
            System.out.println("Connexion réussie");
        } catch (Exception e) {
            System.out.println("Echec connexion");
        }
        /* Reception de la table */
        try {
            System.out.println("reception table ...");

            // on recoit la table et on la swap
            this.moteur.setTable(
                    swapTableRecueReseau((Table) this.in.readObject()));

            System.out.println("Table recue");
            System.out.println("Initialisation Terminée");
        } catch (Exception e) {
            System.out.println("Echec reception de la table");
        }

    }

    // -------------------------------------Methodes-----------------------------------------
    // distribue les cartes entre les joueurs et séparation du reste en 6 piles
    public void initialiser() {

        //Paquet monPaquet = new Paquet();

        // on ne melange si on est pas en mode reseau,
        if (mode != 2) {
            Paquet monPaquet = new Paquet();
            monPaquet.melanger();
            moteur.getTable().setPaquet(monPaquet);
        }

        // on melange ou si on est en mode reseau ET qu'on est le croupier
        // de la partie
        if (mode == 2 && croupier) {
            Paquet monPaquet = new Paquet();
            monPaquet.melanger();
            moteur.getTable().setPaquet(monPaquet);
        }

        // si on est en mode reseau et qu'on est pas croupier, on fait rien...
        if (mode == 2 && !croupier) {
            return;
        }


        for (int i = 0; i < 11; i++) {
            moteur.getTable().main1.add(moteur.getTable().getPaquet().piocher());
            moteur.getTable().main2.add(moteur.getTable().getPaquet().piocher());
        }

        ArrayList<Carte> tas1 = new ArrayList<Carte>(5);
        ArrayList<Carte> tas2 = new ArrayList<Carte>(5);
        ArrayList<Carte> tas3 = new ArrayList<Carte>(5);
        ArrayList<Carte> tas4 = new ArrayList<Carte>(5);
        ArrayList<Carte> tas5 = new ArrayList<Carte>(5);
        ArrayList<Carte> tas6 = new ArrayList<Carte>(5);

        for (int i = 0; i < 5; i++) {
            tas1.add(moteur.getTable().getPaquet().piocher());
            tas2.add(moteur.getTable().getPaquet().piocher());
            tas3.add(moteur.getTable().getPaquet().piocher());
            tas4.add(moteur.getTable().getPaquet().piocher());
            tas5.add(moteur.getTable().getPaquet().piocher());
            tas6.add(moteur.getTable().getPaquet().piocher());
        }
        ArrayList<Pile> piles = new ArrayList<Pile>(6);
        Pile pile = new Pile(1, tas1);
        piles.add(pile);

        pile = new Pile(2, tas2);
        piles.add(pile);

        pile = new Pile(3, tas3);
        piles.add(pile);

        pile = new Pile(4, tas4);
        piles.add(pile);

        pile = new Pile(5, tas5);
        piles.add(pile);

        pile = new Pile(6, tas6);
        piles.add(pile);

        moteur.getTable().setPiles(piles);
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
        while ((type == 0 && nbMatche != max) || (type == 1 && (joueur1.getScore() < max || joueur2.getScore() < max))
                || (type == 2 && nbMatche < 4)) {

            if (type == 2) {
                switch (nbMatche) {
                    case 0:
                        this.joueur2 = new PC(moteur.getTable(), 2, moteur.getTable().getMain2(), moteur.getTable().getCarte1());

                    case 1:
                        this.joueur2 = new PC2(moteur.getTable(), 2, moteur.getTable().getMain2(), moteur.getTable().getCarte1());

                    case 2:
                        this.joueur2 = new PC3(moteur.getTable(), 2, moteur.getTable().getMain2(), moteur.getTable().getCarte1());

                    case 3:
                        this.joueur2 = new PC4(moteur.getTable(), 2, moteur.getTable().getMain2(), moteur.getTable().getCarte1());
                }
            }


            // si on est en mode reseau on init pas ici, mais avant ( a la negociation de la connexion )
            if (mode != 2) {
                initialiser();
            }


            this.updateObservateur();
            if (joueurCourant == 2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Humain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            while (moteur.getTable().getMain1().getSize() != 0 && moteur.getTable().getMain2().getSize() != 0) {

                etapeJouer();
                this.updateObservateur();
                switcher();
                this.updateObservateur();
                etapeJouer();
                this.updateObservateur();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Humain.class.getName()).log(Level.SEVERE, null, ex);
                }


                // c1 représente la premiere carte qui a été posée et c2 la deuxieme

                if (joueurCourant == 1) {
                    c1 = moteur.getTable().getCarte2();
                    c2 = moteur.getTable().getCarte1();

                } else {
                    c1 = moteur.getTable().getCarte1();
                    c2 = moteur.getTable().getCarte2();
                }
                moteur.getTable().setCarte1(null);
                moteur.getTable().setCarte2(null);
                this.updateObservateur();
                if (c1.gagne(c2, moteur.getTable().getAtout())) {
                    switcher();
                    intVersJoueur().setNbPlis(intVersJoueur().getNbPlis() + 1);
                    this.updateObservateur();
                    if (!moteur.getTable().pilesVides()) {
                        etapeChoisir();
                        this.updateObservateur();
                        switcher();
                        etapeChoisir();
                        this.updateObservateur();
                        switcher();
                    }
                } else {
                    intVersJoueur().setNbPlis(intVersJoueur().getNbPlis() + 1);
                    this.updateObservateur();
                    if (!moteur.getTable().pilesVides()) {
                        etapeChoisir();
                        this.updateObservateur();
                        switcher();
                        this.updateObservateur();

                        etapeChoisir();
                        this.updateObservateur();
                        switcher();
                        this.updateObservateur();
                    }
                }
                joueur1.setaJoue(false);
                joueur1.setaChoisi(false);
                joueur2.setaJoue(false);
                joueur2.setaChoisi(false);

                this.updateObservateur();

            }

            nbMatche++;
            joueur1.setScore(joueur1.getScore() + joueur1.getNbPlis());
            joueur2.setScore(joueur2.getScore() + joueur2.getNbPlis());
            joueur1.setNbPlis(0);
            joueur2.setNbPlis(0);

            if (type == 2) {
                if (joueur1.getScore() > joueur2.getScore()) {
                    //gagne on passe au niveau suivant
                } else {
                    if (joueur1.getScore() == joueur2.getScore()) {
                        //
                    } else {
                        //perdu
                    }
                }
            }
        }

    }

    public void etapeJouer() {
        try {

        
       		if (mode == 2 && getJoueurCourant() == 1)
       		{
           		intVersJoueur().jouer();
           		
           		//envoi de la table
           		this.out.writeObject((Table) moteur.getTable());
           		System.out.println("TABLE ENVOYEE (JOUER)");
           		if (this.moteur.getTable().getCarte1() != null)
           			System.out.println("Carte1 : " + this.moteur.getTable().getCarte1().toString());
           		if (this.moteur.getTable().getCarte2() != null)
       				System.out.println("Carte2 : " + this.moteur.getTable().getCarte2().toString());
           		
       		}
       		if (mode == 2 && getJoueurCourant() == 2)
       		{
       			System.out.println("ON S'APPRETE A RECEVOIR");
       		    // on attend de recevoir la table
       		    this.moteur.setTable(
       		    	swapTableRecueReseau( (Table) this.in.readObject() )
       		    );
       			System.out.println("TABLE RECUE ET SWAPEE (JOUER)");
       			
       			if (this.moteur.getTable().getCarte1() != null)
       				System.out.println("Carte1 : " + this.moteur.getTable().getCarte1().toString());
       			
       			if (this.moteur.getTable().getCarte2() != null)
       				System.out.println("Carte2 : " + this.moteur.getTable().getCarte2().toString());
       		}
       		if (mode != 2)
       		{
           if (getJoueurCourant() == 1) {
           EntreeHistorique ent= new EntreeHistorique(this.getJoueur1().clone(),this.getJoueur2().clone(),this.getJoueur2().getTable().clone());
           this.getHist().addEntree(ent);
            System.out.println("nouvel hist");
                   }
                    
       			intVersJoueur().jouer();
       		}
       	} catch (Exception e) {
       	    System.out.println("SOUCI DANS ETAPE JOUER");
       	    e.printStackTrace();
       	}

    }

    public void etapeChoisir() {

        try {
            if (mode == 2 && getJoueurCourant() == 1) {
                intVersJoueur().choisir();

                //envoi de la table
                this.out.writeObject((Table) moteur.getTable());
                System.out.println("TABLE ENVOYEE (CHOISIR)");

            }
            if (mode == 2 && getJoueurCourant() == 2) {
                // on attend de recevoir la table,
                // et on la switch
                this.moteur.setTable(
                        swapTableRecueReseau((Table) this.in.readObject()));
                System.out.println("TABLE RECUE ET SWAPEE (CHOISIR)");
            }
            if (mode != 2) {
                intVersJoueur().choisir();
            }
        } catch (Exception e) {
            System.out.println("SOUCI DANS ETAPE CHOISIR");
            e.printStackTrace();
        }
    }

    public Table swapTableRecueReseau(Table table) {

        Table t = table;
        Main m = t.getMain1().clone();
        t.setMain1(t.getMain2().clone());
        t.setMain2(m);
        m = table.getMain1connue().clone();
        t.setMain1connue(table.getMain2connue().clone());
        t.setMain2connue(m);

        Carte c = t.getCarte1();
        if (table.getCarte2() != null) {
            t.setCarte1(table.getCarte2().clone());

        }
        if (c != null) {
            t.setCarte2(c.clone());
        }

        return t;
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

    //renvoie les cartes connues de l'adversaire du joueur courant
    public ArrayList<Carte> getCartesConnuesAdversaire() {
        ArrayList<Carte> adversaire = new ArrayList<Carte>();

        if (joueurCourant == 1) {
            adversaire.addAll(moteur.getTable().getMain2connue().getMain());
        } else {
            adversaire.addAll(moteur.getTable().getMain1connue().getMain());

        }
        return adversaire;
    }
    // Determiner si une carte est jouable

    public boolean carteJouable(Carte c, int joueur) {
        // A l'adversaire de jouer
        if (joueur != joueurCourant) {
            return (false);
        }
        // A nous de jouer en premier
        if (getCarteAdverse(joueur) == null) {
            return (true);
        } else {
            // Si il y a de l'atout
            if (moteur.getTable().atout != null) {
                // A nous de jouer en deuxieme
                Carte carteadv = getCarteAdverse(joueur);
                Main mainjoueur = getMainJoueur(joueur);
                // Si il a joué un atout
                if (carteadv.couleur == moteur.getTable().atout) {
                    boolean atout = false;

                    for (int i = 0; i < mainjoueur.getSize(); i++) {
                        if (mainjoueur.getCarte(i).couleur == moteur.getTable().atout) {
                            atout = true;
                        }
                    }
                    // Pas d'atout dans la main
                    if (atout == false) {
                        return true;
                    } // On veut jouer un atout
                    else if (c.couleur == moteur.getTable().atout) {
                        return true;
                    } else {
                        return false;
                    }
                } // Pas d'atout
                else {
                    boolean atout = false;
                    boolean defausse = true;
                    for (int i = 0; i < mainjoueur.getSize(); i++) {
                        if (mainjoueur.getCarte(i).couleur == moteur.getTable().atout) {
                            atout = true;
                        }
                        if (mainjoueur.getCarte(i).couleur == carteadv.couleur) {
                            defausse = false;
                        }
                    }
                    // On ne peut pas fournir
                    if (defausse == true) {
                        return true;
                    } // On peut fournir
                    else {
                        // Si on veut fournir
                        if (c.couleur == carteadv.couleur) {
                            return true;
                        } //Si on veut se defausser
                        else {
                            return false;
                        }
                    }
                }
            } // Si il n'y a pas d'atout
            else {
            }
        }
        return false;
    }

    // ajoute un observateur
    public void addObservateur(Observateur obs) {
        this.listObservateur.add(obs);
    }

    // supprime un observateur
    public void delObservateur() {
        this.listObservateur = new ArrayList<Observateur>();
    }

    public void updateObservateur() {
        for (Observateur obs : this.listObservateur) {
            obs.update(this);
        }
    }
}
