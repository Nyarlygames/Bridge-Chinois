
public class InfoMain {
	boolean aTrefle, aCarreau, aCoeur, aPique, aChoisi;
	int score;
	public InfoMain()
	{
		this.aCarreau = true;
		this.aCoeur = true;
		this.aPique = true;
		this.aTrefle = true;
		this.score = 0;
		aChoisi = false;
	}

	public int getScore() {
		return score;
	}



	public void setScore(int score) {
		this.score = score;
	}
	



	public boolean getaChoisi() {
		return aChoisi;
	}

	public void setaChoisi(boolean aChoisi) {
		this.aChoisi = aChoisi;
	}

	public boolean aTrefle() {
		return aTrefle;
	}

	public void setaTrefle(boolean aTrefle) {
		this.aTrefle = aTrefle;
	}

	public boolean aCarreau() {
		return aCarreau;
	}

	public void setaCarreau(boolean aCarreau) {
		this.aCarreau = aCarreau;
	}

	public boolean aCoeur() {
		return aCoeur;
	}

	public void setaCoeur(boolean aCoeur) {
		this.aCoeur = aCoeur;
	}

	public boolean aPique() {
		return aPique;
	}

	public void setaPique(boolean aPique) {
		this.aPique = aPique;
	}
	
	public void hasCouleur(Couleur c)
	{
		switch(c)
		{
			case TREFLE:
				this.aTrefle = true;
				break;
			case CARREAU:
				this.aCarreau = true;
				break;
			case COEUR:
				this.aCoeur = true;
				break;
			case PIQUE:
				this.aPique = true;
				break;
				
		}
	}
	
	public void hasntCouleur(Couleur c)
	{
		switch(c)
		{
			case TREFLE:
				this.aTrefle = false;
				break;
			case CARREAU:
				this.aCarreau = false;
				break;
			case COEUR:
				this.aCoeur = false;
				break;
			case PIQUE:
				this.aPique = false;
				break;
				
		}
	}
	
}
