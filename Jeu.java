/*
Auteur : ZIANE-CHERIF Mohammed-El-Amine
Date de Creation 14/05/2012 : 03:21
Date de Dernière modification 15/05/2012 : 18:25
*/
import java.util.ArrayList;
import java.util.Random;

public class Jeu {
	
	// -------------------------------------Attributs-----------------------------------------
	Moteur moteur;
	Joueur joueur1,joueur2;
	int joueurCourant;

	// -------------------------------------Constructeur-------------------------------------
	Jeu(Moteur m, int mode )
	{
		Random rand = new Random();
		
		joueurCourant = rand.nextInt(2);
		joueurCourant++;
		switch (mode) {
			case 0:
	            this.joueur1 = new PC(this,1);
	            this.joueur2 = new PC(this,2);
	            break;
            
	        case 1:
	            this.joueur1 = new Humain(this,1);
	            this.joueur2 = new PC(this,2);
	            break;
	        case 2:
	            this.joueur1 = new Humain(this,1);
	            this.joueur2 = new Humain(this,2);
	            break;
	        
	    }
		moteur = m;
		
	}

	
	// -------------------------------------Methodes-----------------------------------------
	
	
	// distribue les cartes entre les joueurs et séparation du reste en 6 piles
	public void initialiser()
	{
		for(int i=0; i<11;i++)
		{
			moteur.table.main1.add(moteur.table.paquet.piocher());
			moteur.table.main2.add(moteur.table.paquet.piocher());
		}
		
		ArrayList<Carte> tas1 = new ArrayList<Carte>(5);
		ArrayList<Carte> tas2 = new ArrayList<Carte>(5);
		ArrayList<Carte> tas3 = new ArrayList<Carte>(5);
		ArrayList<Carte> tas4 = new ArrayList<Carte>(5);
		ArrayList<Carte> tas5 = new ArrayList<Carte>(5);
		ArrayList<Carte> tas6 = new ArrayList<Carte>(5);
		
		for(int i=0;i<5;i++)
		{
				tas1.add(moteur.table.paquet.piocher());
				tas2.add(moteur.table.paquet.piocher());
				tas3.add(moteur.table.paquet.piocher());
				tas4.add(moteur.table.paquet.piocher());
				tas5.add(moteur.table.paquet.piocher());
				tas6.add(moteur.table.paquet.piocher());			
		}

		Pile pile = new Pile(1,tas1);
		System.out.println("test :");
		for(int i=0; i<tas1.size();i++)
			System.out.println("le " + i +"eme du tas" + tas1.get(i));
		
		pile.afficherPileConsole();
		moteur.table.addPile(pile);
		
		pile = new Pile(2,tas2);
		moteur.table.addPile(pile);
		
		pile = new Pile(3,tas3);
		moteur.table.addPile(pile);
		
		pile = new Pile(4,tas4);
		moteur.table.addPile(pile);
		
		pile = new Pile(5,tas5);
		moteur.table.addPile(pile);
		
		pile = new Pile(6,tas6);
		moteur.table.addPile(pile);
		
	}
	
	//renvoie le joueur courant
	public Joueur getJoueurCourant()
	{
		if(joueurCourant == 1)
		{
			return joueur1;
		}
		else
		{
			return joueur2;
		}
	}

	
}


