
import java.util.ArrayList;

/**
 * @author Samy
 */
public class PC5 extends PC implements java.io.Serializable{

	public PC5(){}
	public PC5(Table t, int id) {
		this.table = t;
	    this.id = id;
	    nbPlis = 0;
	    score = 0;
	    aJoue = false;
	    aChoisi = false;
    }
    
    
    
    int minMax(Table t, int joueurCourant, int profondeur)
    {
    	Main main;
        Carte carteAdv;
        if (id == 2) {
            carteAdv = table.getCarte1();
            main = table.getMain2();
        } else {
            carteAdv = table.getCarte2();
            main = table.getMain1();
        }
    	if(table.getMain1().estVide() && table.getMain2().estVide() || profondeur==0)
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
	    			int alpha = -100;
	    			Table tSim = new Table();
	    			
	    			if(carteAdv==null)// le cas ou le joueur courant dois poser en premier une carte
	    			{
	    				for(Carte c : main.getMain())
	    				{
	    					tSim = t.clone();
	    					if(getId()==1) //cas joueur courant est le joueur1
	    					{
	    						
	    						tSim.setCarte1(c);
	    						tSim.getMain1().supp(c);
	    						tSim.getMain1connue().supp(c);
	    						
	    	                    val = minMax(tSim, 2, profondeur-1) ;
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
	    						
	    	                    val = minMax(tSim, 2, profondeur-1) ;
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
	    				
	    				if(getId()==1)
	    				{
	    					ArrayList<Carte> carteJouable= new ArrayList<Carte>();
		    				carteJouable = carteJouable(carteAdv,joueurCourant);
		    				for(Carte c : carteJouable)
		    				{
		    					tSim = t.clone();
		    					tSim.setCarte1(c);
	    						tSim.getMain1().supp(c);
	    						tSim.getMain1connue().supp(c);
	    						if(!t.pilesVides())
	    						{
	    							tSim.setPhaseJouer(false);
	    						}
	    						
	    						if(carteAdv.gagne(c,getTable().getAtout() ))
	    						{
	    							tSim.getInfoAdv2().setScore(tSim.getInfoAdv2().getScore()+1);
	    							val = minMax(tSim, 2, profondeur-1);
	    						}
	    						else
	    						{
	    							tSim.getInfoAdv1().setScore(tSim.getInfoAdv1().getScore()+1);
	    							val = minMax(tSim, 1, profondeur-1) ;
	    						}
	    	                    
	    	                    if( val > alpha)
	    	                    {
	    	                    	alpha = val;
	    	                        setBestCarteJouer(c);
	    	                    }
		    				}
	    				}
	    				else
	    				{
	    					ArrayList<Carte> carteJouable= new ArrayList<Carte>();
		    				carteJouable = carteJouable(carteAdv,joueurCourant);
		    				for(Carte c : carteJouable)
		    				{
		    					tSim = t.clone();
		    					tSim.setCarte2(c);
	    						tSim.getMain2().supp(c);
	    						tSim.getMain2connue().supp(c);
	    						if(!tSim.pilesVides())
	    						{
	    							tSim.setPhaseJouer(false);
	    						}
	    						if(carteAdv.gagne(c,getTable().getAtout() ))
	    						{
	    							tSim.getInfoAdv1().setScore(tSim.getInfoAdv1().getScore()+1);
	    							val = minMax(tSim, 1, profondeur-1);
	    						}
	    						else
	    						{
	    							tSim.getInfoAdv2().setScore(tSim.getInfoAdv2().getScore()+1);
	    							val = minMax(tSim, 2, profondeur-1) ;
	    						}
	    	            
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
	    			if(carteAdv==null)// le cas ou le joueur courant dois poser en premier une carte
	    			{
		    			if(getId()==1) 
						{
			                for(Carte c : this.getTable().getMain2().getMain())
			                {
			                	tSim = t.clone();
			                	tSim.setCarte2(c);
	    						tSim.getMain2().supp(c);
	    						tSim.getMain2connue().supp(c);
			                	val = minMax(tSim, 2, profondeur-1) ;
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
		    	    			tSim = t.clone();
			                	tSim.setCarte1(c);
	    						tSim.getMain1().supp(c);
	    						tSim.getMain1connue().supp(c);
			                	val = minMax(tSim, 1, profondeur-1) ;
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
	    				for(Carte c : main.getMain())
	    				{
	    					tSim = t.clone();
	    					if(getId()==1)
	    					{
	    		    			
	    						tSim.setCarte2(c);
	    						tSim.getMain2().supp(c);
	    						tSim.getMain2connue().supp(c);
	    						if(!t.pilesVides())
	    						{
	    							tSim.setPhaseJouer(false);
	    						}
	    						if(carteAdv.gagne(c,getTable().getAtout() ))
	    						{
	    							tSim.getInfoAdv2().setScore(tSim.getInfoAdv2().getScore()+1);
	    							val = minMax(tSim, 2, profondeur-1);
	    						}
	    						else
	    						{
	    							tSim.getInfoAdv1().setScore(tSim.getInfoAdv1().getScore()+1);
	    							val = minMax(tSim, 1, profondeur-1) ;
	    						}
	    	                    
	    	                    if( val < beta)
	    	                    {
	    	                    	beta =val;
	    	                    }
	    					}
	    					else
	    					{//cas joueur courant est le joueur2
	    						if(carteAdv.gagne(c,getTable().getAtout() ))
	    						{
	    							tSim.getInfoAdv1().setScore(tSim.getInfoAdv1().getScore()+1);
	    							val = minMax(tSim, 1, profondeur-1);
	    						}
	    						else
	    						{
	    							tSim.getInfoAdv2().setScore(tSim.getInfoAdv2().getScore()+1);
	    							val = minMax(tSim, 2, profondeur-1) ;
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

				if(joueurCourant == this.id) // le joueurCourant execute le minmax
	    		{
					System.out.println("test phase choix : ");

	    			int alpha = -100;
	    			Table tSim = new Table();
	    			tSim = t.clone();
	    			ArrayList<Carte> cartePiles = new ArrayList<Carte>();
	    			cartePiles = tSim.getCartesPiles();
					System.out.println("affichage des piles ");

	    			for(int i=0; i<6;i++)
	    			{
	    				tSim.getPiles().get(i).afficherPileConsole();
	    			}
					System.out.println("carte piles");
					for(int i=0;i<cartePiles.size();i++)
					{
						System.out.println(cartePiles.get(i).toString());
					}
					System.out.println("------------------------------- : ");


	    			
	    			if(getId() == 1)
	    			{
	    				if(!t.getInfoAdv2().getaChoisi())
	    				{//le joueur 2 n'a pas encore choisi
	    					for(int i=0; i <6;i++)
	    					{
	    						if(t.getPiles().get(i).getSize()!=0)
	    						{
	    							if(t.getPiles().get(i).getSize()==1)
	    							{
	    	    						tSim = t.clone();
	    								tSim.getMain1().add(tSim.getPiles().get(i).piocher());
	    								tSim.getInfoAdv1().setaChoisi(true);
	    								val = minMax(tSim, 2, profondeur-1) ;
	    								if( val > alpha)
     		    	                    {
	    									System.out.println("TEST!!!!!!!!");
     		    	                    	alpha = val;
     		    	                        setBestPile(i);
     		    	                    }
		    						}
	    							else
	    							{
	    								for(int j=0;j<cartePiles.size();j++)
	    								{
	    									tSim = t.clone();
		    								tSim.getMain1().add(tSim.getPiles().get(i).piocher());
    	    								Carte simule = tSim.getPiles().get(i).piocher();
    	    								tSim.getInfoAdv1().setaChoisi(true);
    	    								tSim.swapCartesDansPiles(simule,cartePiles.get(j));
    	    								val = minMax(tSim,2, profondeur-1);
    	    								if( val > alpha)
         		    	                    {
    	    									System.out.println("TEST!!!!!!!!");
         		    	                    	alpha = val;
         		    	                        setBestPile(i);
         		    	                    }
	    								}
	    							}   	    							
	    						}
	    					}
	    					return alpha;
	    				}
	    				else
	    				{// le joueur 2 a deja choisi
	    					
	    					for(int i=0; i <6;i++)
	    					{
	    						if(t.getPiles().get(i).getSize()!=0)
	    						{
	    							if(t.getPiles().get(i).getSize()==1)
	    							{
    									tSim = t.clone();
	    								tSim.getMain1().add(tSim.getPiles().get(i).piocher());
	    								tSim.getInfoAdv1().setaChoisi(false);
	    								tSim.getInfoAdv2().setaChoisi(false);
		    							tSim.setPhaseJouer(true);

	    								val = minMax(tSim, 2, profondeur-1) ;
	    								if( val > alpha)
     		    	                    {
	    									System.out.println("TEST!!!!!!!!");
     		    	                    	alpha = val;
     		    	                        setBestPile(i);
     		    	                    }
		    						}
	    							else
	    							{
	    								for(int j=0;j<cartePiles.size();j++)
	    								{
	    									tSim = t.clone();
		    								tSim.getMain1().add(tSim.getPiles().get(i).piocher());
    	    								Carte simule = tSim.getPiles().get(i).piocher();
    	    								tSim.getInfoAdv1().setaChoisi(false);
    	    								tSim.getInfoAdv1().setaChoisi(false);
    	    								tSim.swapCartesDansPiles(simule,cartePiles.get(j));
    		    							tSim.setPhaseJouer(true);

    	    								
    	    								val = minMax(tSim,1, profondeur-1);
    	    								if( val > alpha)
         		    	                    {
    	    									System.out.println("TEST!!!!!!!!");
         		    	                    	alpha = val;
         		    	                        setBestPile(i);
         		    	                    }
	    								}
	    							}   	    							
	    						}
	    					}
	    					return alpha;
	    				}
	    			}
	    			else
	    			{
	    				if(!t.getInfoAdv1().getaChoisi())
	    				{//le joueur 1 n'a pas encore choisi
	    					for(int i=0; i <6;i++)
	    					{
	    						tSim = t.clone();
	    						if(tSim.getPiles().get(i).getSize()!=0)
	    						{
	    							if(tSim.getPiles().get(i).getSize()==1)
	    							{
	    								
	    								tSim.getMain2().add(tSim.getPiles().get(i).piocher());
	    								tSim.getInfoAdv2().setaChoisi(true);
	    								val = minMax(tSim, 1, profondeur-1) ;
	    								if( val > alpha)
     		    	                    {
	    									System.out.println("TEST!!!!!!!!");
     		    	                    	alpha = val;
     		    	                        setBestPile(i);
     		    	                    }
		    						}
	    							else
	    							{
	    								for(int j=0;j<cartePiles.size();j++)
	    								{
	    									tSim = t.clone();
		    								tSim.getMain2().add(tSim.getPiles().get(i).piocher());

    	    								Carte simule = tSim.getPiles().get(i).piocher();
    	    								tSim.getInfoAdv2().setaChoisi(true);
    	    								tSim.swapCartesDansPiles(simule,cartePiles.get(j));
    	    								val = minMax(tSim,1, profondeur-1);
    	    								if( val > alpha)
         		    	                    {
    	    									System.out.println("TEST!!!!!!!!");
         		    	                    	alpha = val;
         		    	                        setBestPile(i);
         		    	                    }
	    								}
	    							}   	    							
	    						}
	    					}
	    					return alpha;
	    				}
	    				else
	    				{// le joueur 1 a deja choisi
	    					
	    					for(int i=0; i <6;i++)
	    					{
	    						tSim = t.clone();
	    						if(tSim.getPiles().get(i).getSize()!=0)
	    						{
	    							if(tSim.getPiles().get(i).getSize()==1)
	    							{
	    								
	    								tSim.getMain2().add(tSim.getPiles().get(i).piocher());
	    								tSim.getInfoAdv1().setaChoisi(false);
	    								tSim.getInfoAdv2().setaChoisi(false);
		    							tSim.setPhaseJouer(true);

	    								val = minMax(tSim, 1, profondeur-1) ;
	    								if( val > alpha)
     		    	                    {
	    									System.out.println("TEST!!!!!!!!");
     		    	                    	alpha = val;
     		    	                        setBestPile(i);
     		    	                    }
		    						}
	    							else
	    							{
	    								for(int j=0;j<cartePiles.size();j++)
	    								{
	    									tSim = t.clone();
		    								tSim.getMain2().add(tSim.getPiles().get(i).piocher());

    	    								Carte simule = tSim.getPiles().get(i).piocher();
    	    								tSim.getInfoAdv1().setaChoisi(true);
    	    								tSim.getInfoAdv1().setaChoisi(false);
    	    								tSim.swapCartesDansPiles(simule,cartePiles.get(j));
    		    							tSim.setPhaseJouer(false);

    	    								
    	    								val = minMax(tSim,1, profondeur-1);
    	    								if( val > alpha)
         		    	                    {
    	    									System.out.println("TEST!!!!!!!!");
         		    	                    	alpha = val;
         		    	                        setBestPile(i);
         		    	                    }
	    								}
	    							}   	    							
	    						}
	    					}
	    					return alpha;
	    				}
	    			}
	    		}
				else
				{	
	    			int beta = 100;
	    			Table tSim = new Table();
	    			tSim = t.clone();
	    			ArrayList<Carte> cartePiles = new ArrayList<Carte>();
	    			cartePiles = tSim.getCartesPiles();
	    			if(getId() == 1)
	    			{
	    				if(!tSim.getInfoAdv2().getaChoisi())
	    				{//le joueur 2 n'a pas encore choisi
	    					for(int i=0; i <6;i++)
	    					{
	    						tSim = t.clone();
	    						if(tSim.getPiles().get(i).getSize()!=0)
	    						{
	    							if(tSim.getPiles().get(i).getSize()==1)
	    							{
	    								
	    								tSim.getMain1().add(tSim.getPiles().get(i).piocher());
	    								tSim.getInfoAdv1().setaChoisi(true);
	    								val = minMax(tSim, 2, profondeur-1) ;
	    								if( val < beta)
     		    	                    {
     		    	                    	beta = val;
     		    	                    }
		    						}
	    							else
	    							{
	    								for(int j=0;j<cartePiles.size();j++)
	    								{
	    									tSim = t.clone();
		    								tSim.getMain1().add(tSim.getPiles().get(i).piocher());

    	    								Carte simule = tSim.getPiles().get(i).piocher();
    	    								tSim.getInfoAdv1().setaChoisi(true);
    	    								tSim.swapCartesDansPiles(simule,cartePiles.get(j));
    	    								val = minMax(tSim,2, profondeur-1);
    	    								if( val < beta)
         		    	                    {
         		    	                    	beta = val;
         		    	                    }
	    								}
	    							}   	    							
	    						}
	    					}
	    					return beta;
	    				}
	    				else
	    				{// le joueur 2 a deja choisi
	    					
	    					for(int i=0; i <6;i++)
	    					{
	    						tSim = t.clone();
	    						if(tSim.getPiles().get(i).getSize()!=0)
	    						{
	    							if(tSim.getPiles().get(i).getSize()==1)
	    							{
	    								
	    								tSim.getMain1().add(tSim.getPiles().get(i).piocher());
	    								tSim.getInfoAdv1().setaChoisi(false);
	    								tSim.getInfoAdv2().setaChoisi(false);
		    							tSim.setPhaseJouer(false);

	    								val = minMax(tSim, 2, profondeur-1) ;
	    								if( val < beta)
     		    	                    {
     		    	                    	beta = val;
     		    	                    }
		    						}
	    							else
	    							{
	    								for(int j=0;j<cartePiles.size();j++)
	    								{
	    									tSim = t.clone();
		    								tSim.getMain1().add(tSim.getPiles().get(i).piocher());

    	    								Carte simule = tSim.getPiles().get(i).piocher();
    	    								tSim.getInfoAdv1().setaChoisi(false);
    	    								tSim.getInfoAdv1().setaChoisi(false);
    	    								tSim.swapCartesDansPiles(simule,cartePiles.get(j));
    		    							tSim.setPhaseJouer(true);

    	    								
    	    								val = minMax(tSim,1, profondeur-1);
    	    								if( val < beta)
         		    	                    {
         		    	                    	beta = val;
         		    	                    }
	    								}
	    							}   	    							
	    						}
	    					}
	    					return beta;
	    				}
	    			}
	    			else
	    			{
	    				if(!t.getInfoAdv1().getaChoisi())
	    				{//le joueur 1 n'a pas encore choisi
	    					for(int i=0; i <6;i++)
	    					{
	    						tSim = t.clone();
	    						if(tSim.getPiles().get(i).getSize()!=0)
	    						{
		    						
	    							if(tSim.getPiles().get(i).getSize()==1)
	    							{
	    								tSim.getMain2().add(tSim.getPiles().get(i).piocher());
	    								tSim.getInfoAdv2().setaChoisi(true);
	    								val = minMax(tSim, 1, profondeur-1) ;
	    								if( val < beta)
     		    	                    {
     		    	                    	beta = val;
     		    	                    }
		    						}
	    							else
	    							{
	    								
	    								for(int j=0;j<cartePiles.size();j++)
	    								{
	    									tSim = t.clone();
		    								tSim.getMain2().add(tSim.getPiles().get(i).piocher());

    	    								Carte simule = tSim.getPiles().get(i).piocher();
    	    								tSim.getInfoAdv2().setaChoisi(true);
    	    								tSim.swapCartesDansPiles(simule,cartePiles.get(j));
    	    								val = minMax(tSim,1, profondeur-1);
    	    								if( val < beta)
         		    	                    {
         		    	                    	beta = val;
         		    	                    }
	    								}
	    							}   	    							
	    						}
	    					}
	    					return beta;
	    				}
	    				else
	    				{// le joueur 1 a deja choisi
	    					
	    					for(int i=0; i <6;i++)
	    					{
	    						tSim = t.clone();
	    						if(tSim.getPiles().get(i).getSize()!=0)
	    						{
	    							if(tSim.getPiles().get(i).getSize()==1)
	    							{
	    								
	    								tSim.getMain2().add(tSim.getPiles().get(i).piocher());
	    								tSim.getInfoAdv1().setaChoisi(false);
	    								tSim.getInfoAdv2().setaChoisi(false);
		    							tSim.setPhaseJouer(true);

	    								val = minMax(tSim, 1, profondeur-1) ;
	    								if( val < beta)
     		    	                    {
     		    	                    	beta = val;
     		    	                    }
		    						}
	    							else
	    							{
	    								for(int j=0;j<cartePiles.size();j++)
	    								{
	    									tSim = t.clone();
		    								tSim.getMain2().add(tSim.getPiles().get(i).piocher());
    	    								Carte simule = tSim.getPiles().get(i).piocher();
    	    								tSim.getInfoAdv1().setaChoisi(false);
    	    								tSim.getInfoAdv1().setaChoisi(false);
    	    								tSim.swapCartesDansPiles(simule,cartePiles.get(j));
    		    							tSim.setPhaseJouer(true);

    	    								
    	    								val = minMax(tSim,1, profondeur-1);
    	    								if( val < beta)
         		    	                    {
         		    	                    	beta = val;
         		    	                    }
	    								}
	    							}   	    							
	    						}
	    					}
	    					return beta;
	    				}
	    			}
				}
    		}
    	}
    }

       
    @Override
    void jouer() {
    	
    	this.minMax(this.getTable(), this.getId(),6);
    	if (id == 2) {
    		System.out.println(getBestCarteJouer().toString());
            table.setCarte2(getBestCarteJouer());
            table.getMain2connue().getMain().remove(getBestCarteJouer());
            table.getMain2().getMain().remove(getBestCarteJouer());
        } else {
            table.setCarte1(getBestCarteJouer());
            table.getMain1connue().getMain().remove(getBestCarteJouer());
            table.getMain1().getMain().remove(getBestCarteJouer());

        }
    	
        aJoue = true;
    }

    @Override
    void choisir() {
    	this.minMax(this.getTable(), this.getId(),9);
    	System.out.println("la pile !!!!!!!!!!!! : "+ getBestPile());

    	if (id == 2) {
    		Carte c = table.getPiles().get(getBestPile()).piocher();
            table.getMain2().add(c);
            table.getMain2connue().add(c);
        } else {
    		Carte c = table.getPiles().get(getBestPile()).piocher();
            table.getMain1().add(c);
            table.getMain1connue().add(c);
        }
    	
        aChoisi = true;
    }
    
    public ArrayList<Carte> carteJouable(Carte carteAdv, int joueurCourant)
    {
    	ArrayList<Carte> resultat = new ArrayList<Carte>();
    	Main main;
    	if(joueurCourant==1)
    	{
    		main = getTable().getMain1();
    	}
    	else
    	{
    		main = getTable().getMain2();
    	}
    	
    		
		if(main.aCouleur(carteAdv))
		{
			for(Carte c : main.getMain())
			{
				if(c.memeCouleur(carteAdv))
				{
					resultat.add(c);
				}
			}
		}
		else
		{
			for(Carte c : main.getMain())
			{
				resultat.add(c);
			}
		}
    	
    	return resultat;
    }
    
    public Joueur clone()
    {
    	Joueur j = new PC5();
    	j.setTable(table);
    	j.setId(id);
    	j.setNbPlis(nbPlis);
        j.setScore(score);
        j.setaJoue(aJoue);
        j.setaChoisi(aChoisi);
        j.setPhaseChoisir(phaseChoisir);
        j.setPhaseJouer(phaseJouer);
    	return j;
    }

}
