
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.ImageIcon;

public class ZoneDessin extends JComponent {

    public int i = -1;
    public int j = -1;
    public int opt = 3;
    public int mode = 2;
    public int cw = 0;
    public int ch = 0;
    public Table t;

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
        Graphics2D drawable = (Graphics2D) g;

        // On reccupere quelques infos provenant de la partie JComponent
        int width = getSize().width;
        int height = getSize().height;
        //TAILLE_CASE_X = (width - (ma_gaufre.getLargeur()-1) )/ma_gaufre.getLargeur() ;
        //TAILLE_CASE_Y = (height - (ma_gaufre.getHauteur()-1) )/ma_gaufre.getHauteur()  ;

        // Mode Partie
        if (mode == 2) {

            // Background
            Image corner = Toolkit.getDefaultToolkit().getImage("res/corner.png");
            Image left = Toolkit.getDefaultToolkit().getImage("res/left.png");
	    Image bottom = Toolkit.getDefaultToolkit().getImage("res/bottom.png");
	    Image top = Toolkit.getDefaultToolkit().getImage("res/top.png");
            Image right = Toolkit.getDefaultToolkit().getImage("res/right.png");
            Image center = Toolkit.getDefaultToolkit().getImage("res/center.png");
            Image empty = Toolkit.getDefaultToolkit().getImage("res/empty.png");

            int bw = left.getWidth(null);
            int bh = top.getHeight(null);
            int cornerh = corner.getHeight(null);
            int cornerw = corner.getWidth(null);

	      // HAUT GAUCHE
            g.drawImage(corner, 0, 0, cornerw, cornerh, this);
	    // HAUT DROIT
            g.drawImage(corner, width-cornerw, 0, cornerw, cornerh, this);
	    // BAS GAUCHE
            g.drawImage(corner, 0, height-cornerh, cornerw, cornerh, this);
	    // BAS DROIT
            g.drawImage(corner, width-cornerw, height-cornerh, cornerw, cornerh, this);

            g.drawImage(left, 0, cornerh, bw, height-(2*cornerh), this);
            g.drawImage(right, width - bw, cornerh, bw, height-(2*cornerh), this);
            g.drawImage(bottom, cornerw, height-bh, width-(2*cornerw), bh, this);
            g.drawImage(top, cornerw, 0, width-(2*cornerw), bh, this);
            g.drawImage(center, bw, bh, width - (2 * bw), height-(2*bh), this);

            // Joueur non actif
            Image cback = Toolkit.getDefaultToolkit().getImage("cartes/carte-dos.jpg");
            int cw = cback.getWidth(null);
            int ch = cback.getHeight(null);
            this.cw = cw;
            this.ch = ch;

            for (int f = 0; f < t.main2.getSize(); f++) {

                int mid = (int) ((width / 2) - (((t.main2.getSize() + 1) * (cw) / 2) * 0.5)) + ((f * cw) / 2);
                Carte c = t.main2.getCarte(f);


                ImageIcon cup = new ImageIcon(cback);
                // this.add(cup);

                g.drawImage(cback, mid, 0, this);

            }

            // Dessin du jeu du Joueur actif 
            for (int f = 0; f < t.main1.getSize(); f++) {
                int mid = (int) ((width / 2) - (((t.main1.getSize() + 1) * (cw) / 2) * 0.5)) + (f * cw) / 2;
                Carte c = t.main1.getCarte(f);
                // on check le type de c et on charge le graphique associe
                Image cfront = Toolkit.getDefaultToolkit().getImage("cartes/" + c.toFileString());
                g.drawImage(cfront, mid, height - ch, cw, ch, this);
            }
            // Dessin des Piles
            for (int p = 0; p < 6; p++) {
                for (int pc = 0; pc < t.piles.get(p).getSize(); pc++) {

                    int mid = (int) ((width / 2) - ((6 * (cw) + 5 * 20 + 4 * 3) / 2) + (pc * 3) + (p * (cw + 20)));



                    if (pc == (t.piles.get(p).getSize() - 1)) {
                        Carte c = t.piles.get(p).getCarte(pc);
                        Image cfront = Toolkit.getDefaultToolkit().getImage("cartes/" + c.toFileString());
                        g.drawImage(cfront, mid, (height / 2) - (ch / 2), cw, ch, this);

                    } else {
                        g.drawImage(cback, mid, (height / 2) - (ch / 2), cw, ch, this);
                    }
                }
            }


            // Cartes jouées
            if (t.getCarte1() == null) {
                g.drawImage(empty, (width / 2) - (ch / 2), ch + 10, cw, ch, this);
            } else {
                Image cfront = Toolkit.getDefaultToolkit().getImage("cartes/" + t.getCarte1().toFileString());
                g.drawImage(cfront, (width / 2) - (ch / 2), height - (2 * ch + 10), cw, ch, this);
            }

            if (t.getCarte2() == null) {
                g.drawImage(empty, (width / 2) - (ch / 2), height - (2 * ch + 10), cw, ch, this);
            } else {
                Image cfront = Toolkit.getDefaultToolkit().getImage("cartes/" + t.getCarte2().toFileString());
                g.drawImage(cfront, (width / 2) - (ch / 2), ch + 10, cw, ch, this);
               
            }

        }

        // Menu
        if (mode == 0) {
            // fenetre de menu de valentin et amine
        }

    }
}
