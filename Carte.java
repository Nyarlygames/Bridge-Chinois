/*
Auteur : ZIANE-CHERIF Mohammed-El-Amine
Date de Creation 12/05/2012 : 00:01
Date de Dernière modification 14/05/2012 : 04:08
*/
public class Carte {
	
	// -------------------------------------Attribute-------------------------------------
	Couleur couleur;
	Rang rang;
	
	// -------------------------------------Constructor-------------------------------------
	Carte(Couleur couleur, Rang rang)
	{
		this.couleur = couleur;
		this.rang = rang;
	}
	
	// -------------------------------------Accesseurs-------------------------------------
	
	// renvoie la couleur de la carte
	public Couleur getCouleur(){
		return couleur;
	}
	
	//renvoie le rang de la carte
	public Rang getRang(){
		return rang;
	}
	
	// -------------------------------------Methodes-------------------------------------
	
	// renvoi vrai si la carte est de la même couleur 
	public boolean memeCouleur(Carte c){
		return couleur == c.couleur;
	}
	
	// renvoi vrai si la carte est du même rang
	public boolean memeRang(Carte c){
			return rang == c.rang;
	}

	// renvoi vrai si la carte est plus forte que la carte c
	public boolean plusForte(Carte c)
	{
		if( this.memeCouleur(c))
		{
			return rang.getRang() > c.rang.getRang();
		}
		else
		{
			return c.couleur.getCouleur() < this.couleur.getCouleur() ;
		}
		
	}
	
	public boolean couleurPlusForte(Carte c)
	{
		return this.getCouleur().getCouleur() > c.getCouleur().getCouleur();
	}
	
	public boolean rangPlusFort(Carte c)
	{
		return this.getRang().getRang() > c.getRang().getRang();
	}
	
	public boolean rangSupDix()
	{
		return this.getRang().getRang()>=10;
	}
	
	public String toString()
	{
		return this.rang + " de " + this.couleur;
	}
	
	
	public boolean gagne(Carte c, Couleur atout)
	{
		if(atout != null)
		{
			if(this.memeCouleur(c))
			{
				return this.rangPlusFort(c);
			}
			else
			{
				if(this.couleur.getCouleur() == atout.getCouleur())
				{
					return true;
				}
				else
				{
					if(c.couleur.getCouleur() == atout.getCouleur())
					{
						return false;
					}
					else
					{
						return this.rangPlusFort(c);
					}
				}
			}
		}
		else
		{
			if(this.memeCouleur(c))
			{
				return this.rangPlusFort(c);
			}
			else
			{
				return true;
			}
		}
	}
	
	public String toFileString()
	{
	    if(this.rang.ordinal()+2 < 10)
	        return this.couleur.toString().toLowerCase()+"_0"+(this.rang.ordinal()+2)+".jpg";
	    else
	        return this.couleur.toString().toLowerCase()+"_"+(this.rang.ordinal()+2)+".jpg";
	}
	
}
