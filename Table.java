/*!!!!!!!!!!!!!
Auteur : ZIANE-CHERIF Mohammed-El-Amine
Date de Creation 14/05/2012 : 17:11
Date de Dernière modification 15/05/2012 : 18:27
*/

import java.util.ArrayList;

public class Table {
	
	// -------------------------------------Atributs-------------------------------------

	Main main1, main2;
	Carte carte1, carte2;
	ArrayList<Pile> piles;
	Paquet paquet;
	
	
	// -------------------------------------Constructeur-------------------------------------

	Table()
	{
		main1 = new Main();
		main2 = new Main();
		carte1 = null;
		carte2 = null;
		piles = new ArrayList<Pile>();		
		paquet = new Paquet();
		paquet.melanger();
	}
	
	// -------------------------------------Accesseurs-------------------------------------

	// A COMPLETER
	// -------------------------------------Methodes-------------------------------------

	// ajoute une pile 
	public void addPile(Pile pile)
	{
		piles.add(pile);
	}
}
