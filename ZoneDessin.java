
import java.awt.*;
import javax.swing.*;

public class ZoneDessin extends JComponent {
    public int i = -1;
    public int j = -1;
    public int opt = 3;
    public int mode = 0;
    Table t;
        
    /**
     * Constructeur ZoneDessin
     */
    public ZoneDessin(Table t) {

        this.t = t;
    }

    /**
     * Dessine la fenetre
     */
    public void paint(Graphics g) {
        System.out.println("ZoneDessin repaint");
        
        System.out.println(mode);
        Graphics2D drawable = (Graphics2D) g;
        Image img1 = Toolkit.getDefaultToolkit().getImage("res/test.jpg");
        Image img2 = Toolkit.getDefaultToolkit().getImage("res/test2.jpg");
        Image img3 = Toolkit.getDefaultToolkit().getImage("res/test3.jpg");
        int w = img1.getWidth(null);
        int h = img1.getHeight(null);
        
        Image cback = Toolkit.getDefaultToolkit().getImage("cartes/carte-dos.jpg");
        Image cfront = Toolkit.getDefaultToolkit().getImage("cartes/carreau_01.jpg");

        int cw = cback.getWidth(null);
        int ch = cback.getHeight(null);

        // On reccupere quelques infos provenant de la partie JComponent
        int width = getSize().width;
        int height = getSize().height;
        //TAILLE_CASE_X = (width - (ma_gaufre.getLargeur()-1) )/ma_gaufre.getLargeur() ;
        //TAILLE_CASE_Y = (height - (ma_gaufre.getHauteur()-1) )/ma_gaufre.getHauteur()  ;

        g.drawImage(img1, width/3, (height % opt) + h, this);
        g.drawImage(img2, width/3, (height % opt) + 2*h, this);
        g.drawImage(img3, width/3, (height % opt) + 3*h, this);
        
        
        // Demarrer Partie
        if(mode == 2) {
            // Joueur non actif
           for(int f=0;f<t.main1.getSize();f++)
	        {
		    	Carte c = t.main1.getCarte(f);
                g.drawImage(cback, (width) % t.main1.getSize() + (f*cw), 0, this);
	    	}
		    // Joueur actif 
		    for(int f=0;f<t.main2.getSize();f++)
	    	{
	    	    
		    	Carte c = t.main2.getCarte(f);
		    	// on check le type de c et on charge le graphique associe
		    	System.out.println("ZONEDESSIN");
		    	System.out.println("LACARTE : "+ c.getCouleur().toString() +" "+c.getRang().toString());
		    	System.out.println(c.toFileString());
		    	cfront = Toolkit.getDefaultToolkit().getImage("cartes/"+c.toFileString());
                g.drawImage(cfront, (width) % t.main2.getSize() + (f*cw), height-ch, this);
	    	}
	    }
        

        // Menu
        if (mode == 0) {
            if (i > width/3) {
                 drawable.setPaint(Color.red);
            }
            if ((j> (height % opt) + h) && (j < (height % opt) + 2*h)) {
                drawable.drawString("test1", i, j);
            }
            else {
                    if ((j> (height % opt) + 2*h) && (j < (height % opt) + 3*h)) {
                        drawable.drawString("test2", i, j);
                    } 
                    else {
                            if ((j> (height % opt) + 3*h) && (j < (height % opt) + 4*h)) {
                            drawable.drawString("test3", i, j);
                            }   
                    }
            }                  
        }   
                
    }
    
}
