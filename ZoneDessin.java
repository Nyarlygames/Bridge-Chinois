import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import javax.swing.JComponent;

public class ZoneDessin extends JComponent {

    public int i = -1;
    public int j = -1;
    public int opt = 3;
    public int mode = 2;
    public int cw = 0;
    public int ch = 0;
    public int bw = 0;
    public int bh = 0;
    public Table t;
    public Config cfg;
    public Carte carteactive;
    Font f;
    Jeu jeu;

    /**
     * Constructeur ZoneDessin
     */
    public ZoneDessin(Jeu j, Config cfg, int mode) {

	this.cfg = cfg;
	this.jeu = j;
	this.mode = mode;
        this.t = j.getMoteur().getTable();
    }

    /**
     * Dessine la fenetre
     */
    public void paint(Graphics g) {
        Graphics2D drawable = (Graphics2D) g;

        // On reccupere quelques infos provenant de la partie JComponent
        int width = getSize().width;
        int dheight = getSize().height;
        int height = dheight -20;

        // Mode Solo
        if (mode == 1) {
	    String pathcartes = "cartes/" + this.cfg.deck + "/";
	    String pathres = "res/" + this.cfg.style + "/";
            // Background
            Image corner = Toolkit.getDefaultToolkit().getImage(pathres+"corner.png");
            Image left = Toolkit.getDefaultToolkit().getImage(pathres+"left.png");
	    Image bottom = Toolkit.getDefaultToolkit().getImage(pathres+"bottom.png");
	    Image top = Toolkit.getDefaultToolkit().getImage(pathres+"top.png");
            Image right = Toolkit.getDefaultToolkit().getImage(pathres+"right.png");
            Image center = Toolkit.getDefaultToolkit().getImage(pathres+"center.png");
            Image empty = Toolkit.getDefaultToolkit().getImage(pathres+"empty.png");
	    // Cartes
            Image pli = Toolkit.getDefaultToolkit().getImage(pathcartes+"pli.png");
            Image cback = Toolkit.getDefaultToolkit().getImage(pathcartes+"carte-dos.jpg");

	    // corners
            int cornerh = corner.getHeight(null);
            int cornerw = corner.getWidth(null);
	    // cards
            int cw = cback.getWidth(null);
            int ch = cback.getHeight(null);
            this.cw = cw;
            this.ch = ch;
	    // borders
            int bw = left.getWidth(null);
            int bh = top.getHeight(null);
            this.bw = bw;
            this.bh = bh;


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

            for (int f = 0; f < t.main2.getSize(); f++) {

                int mid = (int) ((width / 2) - (((t.main2.getSize() + 1) * (cw) / 2) * 0.5)) + ((f * cw) / 2);
                Carte c = t.main2.getCarte(f);
                g.drawImage(cback, mid, bh, this);

            }

            // Dessin du jeu du Joueur actif
            for (int f = 0; f < t.main1.getSize(); f++) {
                int mid = (int) ((width / 2) - (((t.main1.getSize() + 1) * (cw) / 2) * 0.5)) + (f * cw) / 2;
		int up = height - ch -bh;
                Carte c = t.main1.getCarte(f);

		if (carteactive != null) {
		    if (c == carteactive) {
			// Carte Jouable
			if (jeu.carteJouable(c, 1) == true){
			    up -= 20;
			}
			// Carte non jouable
			else{
			}
		    }
		}
                // on check le type de c et on charge le graphique associe
                Image cfront = Toolkit.getDefaultToolkit().getImage(pathcartes+ c.toFileString());
                g.drawImage(cfront, mid, up, cw, ch, this);

            }
            // Dessin des Piles


            for (int p = 0; p < 6; p++) {
                for (int pc = 0; pc < t.piles.get(p).getSize(); pc++) {

                    int mid = (int) ((width / 2) - ((6 * (cw) + 5 * 20 + 4 * 3) / 2) + (pc * 3) + (p * (cw + 20)));



                    if (pc == (t.piles.get(p).getSize() - 1)) {
                        Carte c = t.piles.get(p).getCarte(pc);
                        Image cfront = Toolkit.getDefaultToolkit().getImage(pathcartes + c.toFileString());
                        g.drawImage(cfront, mid, (height /2) -ch/2, cw, ch, this);

                    } else {
                        g.drawImage(cback, mid, (height /2) -ch/2, cw, ch, this);
                    }
                }
            }

            // Cartes jouées


	    // hauteur carte joueur adverse
	    int cjah = ((height /2) - (ch/2) -ch -bh)/2 +ch+bh -ch/2;
	    // hauteur carte joueur
	    int cjh  = ((height /2) - (ch/2) -ch -bh)/2 + height/2;

            if (t.getCarte1() == null) {
                g.drawImage(empty, (width / 2) - (ch / 2), cjh, cw, ch, this);
            } else {
                Image cfront = Toolkit.getDefaultToolkit().getImage(pathcartes + t.getCarte1().toFileString());
                g.drawImage(cfront, (width / 2) - (ch / 2),  cjh, cw, ch, this);
            }

            if (t.getCarte2() == null) {
                g.drawImage(empty, (width / 2) - (ch / 2), cjah, cw, ch, this);
            } else {
                Image cfront = Toolkit.getDefaultToolkit().getImage(pathcartes + t.getCarte2().toFileString());
                g.drawImage(cfront, (width / 2) - (ch / 2), cjah, cw, ch, this);
            }

	    // Affichage des informations

	    f = new Font("sansserif", Font.BOLD, 18);
	    FontMetrics fontw = g.getFontMetrics(f);
	    g.setFont(f);

	    // Nombres de plis

	    // Joueur 1
            g.drawImage(pli, width - bw - cw - 1, height - bh - ch - 1, cw, ch, this);
	    g.setColor(Color.yellow);
	    String pli1 = String.valueOf(jeu.getJoueur1().nbPlis);
	    g.drawString(pli1, width -bw -cw/2 - fontw.stringWidth(pli1)/2, height - bh - ch/2 +4);

	    // Joueur 2 (adversaire)
            g.drawImage(pli, width - bw - cw - 1, bh + 1, cw, ch, this);
	    g.setColor(Color.yellow);
	    String pli2 = String.valueOf(jeu.getJoueur2().nbPlis);
	    g.drawString(pli2, width -bw - cw/2 - fontw.stringWidth(pli2)/2, bh + ch/2 + 9);


	    // Infos du bas
	    g.setColor(Color.black);
	    if ((t != null) && (t.atout != null)) {
	    switch (t.atout) {
		case CARREAU :
		    String atoutcx = "Atout : ♦";
		    g.drawString(atoutcx, width - fontw.stringWidth(atoutcx), dheight-2);
		    break;
		case COEUR :
		    String atoutcr = "Atout : ♥";
		    g.drawString(atoutcr,  width - fontw.stringWidth(atoutcr), dheight-2);
		    break;
		case PIQUE :
		    String atoutp = "Atout : ♠";
		    g.drawString(atoutp,  width - fontw.stringWidth(atoutp), dheight-2);
		    break;
		case TREFLE :
		    String atoutt = "Atout : ♣";
		    g.drawString(atoutt,  width - fontw.stringWidth(atoutt), dheight-2);
		    break;
		default :
		    break;
		}
	    }
	    else {
	        String noatout = "Pas d'atout ";
		g.drawString(noatout,  width - fontw.stringWidth(noatout), dheight-2);
	    }

	    // Joueur actif

	    if (jeu.getJoueurCourant() == 1) {
		String myturn = "A vous de jouer";
		g.drawString(myturn,  width/2 - fontw.stringWidth(myturn)/2, dheight-2);
	    }
	    else {
		String histurn = "A votre adversaire de jouer";
		g.drawString(histurn,  width/2 - fontw.stringWidth(histurn)/2, dheight-2);
	    }

	    // Affichage des donnes
	    String score = "Score : " + jeu.getJoueur1().score + " - " + jeu.getJoueur2().score;
	    g.drawString(score, 0, dheight-2);


	}

	// Mode réseau
	if (mode == 2)
	    {
	    }
    }
}
