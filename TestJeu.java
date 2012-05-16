/*
Auteur : ZIANE-CHERIF Mohammed-El-Amine
Date de Creation 12/05/2012 : 16:32
Date de DerniÃšre modification 12/05/2012 : 18:54
*/

public class TestJeu {

	
	public static void main(String[] args) {
		
		Table table = new Table();
		Moteur moteur = new Moteur(table);
		Jeu monJeu = new Jeu(moteur,2);
		
		System.out.println("j'ai initialise mon paquet melange");
		monJeu.moteur.table.paquet.afficherPaquetConsole();
		
		monJeu.initialiser();
		System.out.println("apres destribution le paquet dois être vide :");
		if(monJeu.moteur.table.paquet.estVide())
			System.out.println("VRAI");
		else
			System.out.println("FAUX");
		
		System.out.println("j'affiche la première main");
		monJeu.moteur.table.main1.afficherMainConsole();
		
		System.out.println("j'affiche la deusième main");
		monJeu.moteur.table.main2.afficherMainConsole();
		
		System.out.println("j'affiche les 6 piles de 5 cartes :");
		for(int i=0;i<6;i++)
		{
			System.out.println("j'affiche la pile num " + i);
			monJeu.moteur.table.piles.get(i).afficherPileConsole();
		}
		
		

	}

}
