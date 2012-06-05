
import java.util.ArrayList;

/**
 * @author Samy
 */
public class PC5 extends Joueur {

	public PC5(){}
    public PC5(Table t, int id, Main main, Carte carteAdv) {
        this.table = t;
        this.id = id;
        nbPlis = 0;
        score = 0;
        aJoue = false;
        aChoisi = false;
        this.carteAdv = carteAdv;
        this.main = main;
    }
    
    int minMax(Table t, int joueurCourant)
    {
    	if(table.getMain1().estVide() && table.getMain2().estVide())
    	{
    		return table.getInfoAdv1().getScore() -  table.getInfoAdv2().getScore();
    	}
    	else
    	{
    		int val=0;
    		if(table.getPhaseJouer()) // cas on est sur la phase de jeu
    		{
	    		if(joueurCourant == this.id) // le joueurCourant execute le minmax
	    		{
	    			//--------------------------
	    			int alpha = 0;
	    			Table tSim = new Table();
	    			tSim = t.clone();
	    			if(getCarteAdv()==null)// le cas ou le joueur courant dois poser en premier une carte
	    			{
	    				for(Carte c : getMain().getMain())
	    				{
	    					if(getId()==1) //cas joueur courant est le joueur1
	    					{
	    						tSim.setCarte1(c);
	    						tSim.getMain1().supp(c);
	    						tSim.getMain1connue().supp(c);
	    						
	    	                    val = minMax(tSim, 2) ;
	    	                    if( val > alpha)
	    	                    {
	    	                    	alpha = val;
	    	                        setBestCarteJouer(c);
	    	                    }
	    					}
	    					else
	    					{ //cas joueur courant est l'adversaire
	    						tSim.setCarte2(c);
	    						tSim.getMain2().supp(c);
	    						tSim.getMain2connue().supp(c);
	    						
	    	                    val = minMax(tSim, 2) ;
	    	                    if( val > alpha)
	    	                    {
	    	                    	alpha = val;
	    	                        setBestCarteJouer(c);
	    	                    }
	    					}
	    				}
	    				return alpha;
	    			}
	    			else
	    			{ // cas ou une carte à deja etait pose par l'adversair
	    				for(Carte c : getMain().getMain())
	    				{
	    					if(getId()==1)
	    					{//cas joueur courant est le joueur1
	    						tSim.setCarte1(c);
	    						tSim.getMain1().supp(c);
	    						tSim.getMain1connue().supp(c);
	    						tSim.setPhaseJouer(false);
	    						if(getCarteAdv().gagne(c,getTable().getAtout() ))
	    						{
	    							tSim.getInfoAdv2().setScore(tSim.getInfoAdv2().getScore()+1);
	    							val = minMax(tSim, 2);
	    						}
	    						else
	    						{
	    							tSim.getInfoAdv1().setScore(tSim.getInfoAdv1().getScore()+1);
	    							val = minMax(tSim, 1) ;
	    						}
	    	                    
	    	                    if( val > alpha)
	    	                    {
	    	                    	alpha = val;
	    	                        setBestCarteJouer(c);
	    	                    }
	    					}
	    					else
	    					{//cas joueur courant est le joueur2
	    						tSim.setCarte2(c);
	    						tSim.getMain2().supp(c);
	    						tSim.getMain2connue().supp(c);
	    						tSim.setPhaseJouer(false);
	    						if(getCarteAdv().gagne(c,getTable().getAtout() ))
	    						{
	    							tSim.getInfoAdv1().setScore(tSim.getInfoAdv1().getScore()+1);
	    							val = minMax(tSim, 1);
	    						}
	    						else
	    						{
	    							tSim.getInfoAdv2().setScore(tSim.getInfoAdv2().getScore()+1);
	    							val = minMax(tSim, 2) ;
	    						}
	    	                    
	    	                    if( val > alpha)
	    	                    {
	    	                    	alpha = val;
	    	                        setBestCarteJouer(c);
	    	                    }
	    	                    
	    	                    val = minMax(tSim, 2) ;
	    	                    if( val > alpha)
	    	                    {
	    	                    	alpha = val;
	    	                        setBestCarteJouer(c);
	    	                    }
	    					}
	    				}
	    				return alpha;
	    			}
	    			//------------------------------------------------
	    		}
	    		else
	    		{ // le joueurCourant veut faire perdre le joueur qui exe minmax (le Min)
	    			int beta = 100;
	    			Table tSim = new Table();
	    			tSim = t.clone();
	    			if(getCarteAdv()==null)// le cas ou le joueur courant dois poser en premier une carte
	    			{
		    			if(getId()==1) 
						{
			                for(Carte c : this.getTable().getMain2().getMain())
			                {
			                	tSim.setCarte2(c);
	    						tSim.getMain2().supp(c);
	    						tSim.getMain2connue().supp(c);
			                	val = minMax(tSim, 2) ;
			                	if(val < beta)
			                	{
			                		beta = val;
			                	}
			                }
			                return beta;
						}
		    			else
		    			{
		    				for(Carte c : this.getTable().getMain1().getMain())
			                {
			                	tSim.setCarte1(c);
	    						tSim.getMain1().supp(c);
	    						tSim.getMain1connue().supp(c);
			                	val = minMax(tSim, 1) ;
			                	if(val < beta)
			                	{
			                		beta = val;
			                	}
			                }
			                return beta;
		    			}
	    			}
	    			else
	    			{	// cas ou une carte à deja etait pose par l'adversair
	    				for(Carte c : getMain().getMain())
	    				{
	    					if(getId()==1)
	    					{
	    						tSim.setCarte2(c);
	    						tSim.getMain2().supp(c);
	    						tSim.getMain2connue().supp(c);
	    						getTable().setPhaseJouer(false);
	    						if(getCarteAdv().gagne(c,getTable().getAtout() ))
	    						{
	    							tSim.getInfoAdv2().setScore(tSim.getInfoAdv2().getScore()+1);
	    							val = minMax(tSim, 2);
	    						}
	    						else
	    						{
	    							tSim.getInfoAdv1().setScore(tSim.getInfoAdv1().getScore()+1);
	    							val = minMax(tSim, 1) ;
	    						}
	    	                    
	    	                    if( val < beta)
	    	                    {
	    	                    	beta =val;
	    	                    }
	    					}
	    					else
	    					{//cas joueur courant est le joueur2
	    						if(getCarteAdv().gagne(c,getTable().getAtout() ))
	    						{
	    							tSim.getInfoAdv1().setScore(tSim.getInfoAdv1().getScore()+1);
	    							val = minMax(tSim, 1);
	    						}
	    						else
	    						{
	    							tSim.getInfoAdv2().setScore(tSim.getInfoAdv2().getScore()+1);
	    							val = minMax(tSim, 2) ;
	    						}
	    	                    
	    	                    if( val < beta)
	    	                    {
	    	                    	beta =val;
	    	                    }
	    					}
	    				}
	    				return beta;
	    			}
		    	}
    		}
    		else
    		{// Phase de choix de carte
    			if(!t.pilesVides())
    			{
    				if(joueurCourant == this.id) // le joueurCourant execute le minmax
    	    		{
    	    			//--------------------------
    	    			int alpha = 0;
    	    			Table tSim = new Table();
    	    			tSim = t.clone();
    	    			ArrayList<Carte> cartePiles = new ArrayList<Carte>();
    	    			cartePiles = tSim.getCartesPiles();
    	    			if(getId() == 1)
    	    			{
    	    				if(tSim.getInfoAdv2().getaChoisi())
    	    				{//le joueur 2 n'a pas encore choisi
    	    					for(int i=0; i <6;i++)
    	    					{
    	    						if(tSim.getPiles().get(i).getSize()!=0)
    	    						{
    	    							if(tSim.getPiles().get(i).getSize()==1)
    	    							{
    	    								tSim.getMain1().add(tSim.getPiles().get(i).piocher());
    	    								tSim.getInfoAdv1().setaChoisi(true);
    	    								///////////////////////minMax(tSim, 2);
    	    							}
    	    							else
    	    							{
    	    								tSim.getMain1().add(tSim.getPiles().get(i).piocher());
    	    								
    	    								Carte simule = tSim.getPiles().get(i).piocher();
    	    								//for(int j=0;j<6;j++)
    	    							}
    	    						}
    	    					}
    	    				}
    	    				else
    	    				{
    	    					
    	    				}
    	    			}
    	    			else
    	    			{
    	    				
    	    			}
    	    		}
    				else
    				{
    					
    				}
    			}
    			else // il n'y a plus de carte à piocher
    			{
    				
    			}
    		}
    	}
    	return 0;
    }

       
    @Override
    void jouer() {
    	this.minMax(this.getTable(), this.getId());
    	if (id == 2) {
            table.setCarte2(getBestCarteJouer());
            table.getMain2connue().getMain().remove(getBestCarteJouer());
        } else {
            table.setCarte1(getBestCarteJouer());
            table.getMain1connue().getMain().remove(getBestCarteJouer());
        }
    	main.getMain().remove(getBestCarteJouer());
    	
        /*if (id == 2) {
            carteAdv = table.getCarte1();
        } else {
            carteAdv = table.getCarte2();
        }
        ArrayList<Carte> jouables = getCartesJouables();
        ArrayList<Carte> gagnantes = new ArrayList<Carte>();
        Boolean prems;
        if (carteAdv != null) {
            prems = false;
            for (Carte ca : jouables) {
                if (carteAdv.gagne(ca, table.getAtout())) {
                    gagnantes.add(ca);
                }
            }

        } else {
            prems = true;
        }

        Carte meilleure = null;
        if (!gagnantes.isEmpty()) {

            meilleure = gagnantes.get(0);
            for (Carte ca : gagnantes) {
                if (!ca.rangPlusFort(meilleure)) {
                    meilleure = ca;
                }
            }

        } else {//pas de gagnante donc on balance une carte nulle
            if (!prems) {
                meilleure = jouables.get(0);
                for (Carte ca : jouables) {
                    if (!ca.rangPlusFort(meilleure)) {
                        meilleure = ca;
                    }
                }
            } else {//si on commence a jouer alors on met la plus grosse carte possible
                meilleure = jouables.get(0);
                for (Carte ca : jouables) {
                    if (ca.rangPlusFort(meilleure)) {
                        meilleure = ca;
                    }
                }
            }
        }

        if (id == 2) {
            table.setCarte2(meilleure);
            table.getMain2connue().getMain().remove(meilleure);
        } else {
            table.setCarte1(meilleure);
            table.getMain1connue().getMain().remove(meilleure);
        }

        main.getMain().remove(meilleure);*/
        aJoue = true;
    }

    @Override
    void choisir() {
        ArrayList<Pile> piochables = new ArrayList<Pile>();
        for (Pile p : table.getPiles()) {
            if (!p.estVide()) {
                piochables.add(p);
            }
        }
        Pile meilleure = null;
        if (!piochables.isEmpty()) {
            meilleure = piochables.get(0);
            for (Pile p : piochables) {
                if (meilleure.getPile().get(meilleure.getPile().size() - 1).getCouleur().equals(table.getAtout())) {
                    if (p.getAPiocher().getCouleur().equals(table.getAtout()) && p.getAPiocher().rangPlusFort(meilleure.getPile().get(meilleure.getPile().size() - 1))) {
                        meilleure = p;
                    }
                } else {
                    if (p.getAPiocher().getCouleur().equals(table.getAtout()) || p.getAPiocher().rangPlusFort(meilleure.getPile().get(meilleure.getPile().size() - 1))) {
                        meilleure = p;
                    }
                }
            }
            Carte c = meilleure.piocher();
            main.add(c);
            if (id == 2) {
                table.getMain2connue().add(c);
            } else {
                table.getMain1connue().add(c);
            }
        }

        aChoisi = true;
    }
    
    public Joueur clone()
    {
    	Joueur j = new PC();
    	j.setTable(table);
    	j.setId(id);
    	j.setNbPlis(nbPlis);
        j.setScore(score);
        j.setaJoue(aJoue);
        j.setaChoisi(aChoisi);
        j.setPhaseChoisir(phaseChoisir);
        j.setPhaseJouer(phaseJouer);
        j.setCarteAdv(carteAdv);
        j.setMain(main);
    	return j;
    }


    ArrayList<Carte> getCartesJouables() {
        ArrayList<Carte> jouables = new ArrayList<Carte>();
        if (carteAdv != null) {
            for (Carte ca : main.getMain()) {
                if (carteAdv.memeCouleur(ca)) {
                    jouables.add(ca);
                }
            }
            if (jouables.isEmpty()) {//pas la bonne couleur donc bah on met tout
                for (Carte ca : main.getMain()) {
                    jouables.add(ca);
                }
            }
        } else {
            if (jouables.isEmpty()) {//on commence donc bah on met tout
                for (Carte ca : main.getMain()) {
                    jouables.add(ca);
                }
            }
        }
        return jouables;
    }
}
