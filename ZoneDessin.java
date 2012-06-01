
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

    public ZoneDessin(Jeu j, Config cfg) {
	    this.cfg = cfg;
	    this.jeu = j;
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
        int height = dheight - 20;


        String pathcartes = "cartes/" + this.cfg.deck + "/";
        String pathres = "res/" + this.cfg.style + "/";
        // Background
        Image corner = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathres+"corner.png"));
        Image left = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathres+"left.png"));
        Image bottom = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathres+"bottom.png"));
        Image top = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathres+"top.png"));
        Image right = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathres+"right.png"));
        Image center = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathres+"center.png"));
        Image empty = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathres+"empty.png"));
        // Cartes
        Image pli = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathcartes+"pli.png"));

        Image cback = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathcartes+"carte-dos.png"));


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
        g.drawImage(corner, width - cornerw, 0, cornerw, cornerh, this);
        // BAS GAUCHE
        g.drawImage(corner, 0, height - cornerh, cornerw, cornerh, this);
        // BAS DROIT
        g.drawImage(corner, width - cornerw, height - cornerh, cornerw, cornerh, this);

        g.drawImage(left, 0, cornerh, bw, height - (2 * cornerh), this);
        g.drawImage(right, width - bw, cornerh, bw, height - (2 * cornerh), this);
        g.drawImage(bottom, cornerw, height - bh, width - (2 * cornerw), bh, this);
        g.drawImage(top, cornerw, 0, width - (2 * cornerw), bh, this);
        g.drawImage(center, bw, bh, width - (2 * bw), height - (2 * bh), this);


        //--- Dessin des slots ou faut jouer les cartes ---//

        // hauteur carte joueur adverse
        int cjah = ((height / 2) - (ch / 2) - ch - bh) / 2 + ch + bh - ch / 2;
        // hauteur carte joueur
        int cjh = ((height / 2) - (ch / 2) - ch - bh) / 2 + height / 2;

        if (t.getCarte1() == null) {
            g.drawImage(empty, (width / 2) - (ch / 2), cjh, cw, ch, this);
        } else {

            Image cfront = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathcartes + t.getCarte1().toFileString()));
            g.drawImage(cfront, (width / 2) - (ch / 2),  cjh, cw, ch, this);
        }


        if (t.getCarte2() == null) {
            g.drawImage(empty, (width / 2) - (ch / 2), cjah, cw, ch, this);
        } else {
            Image cfront = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathcartes + t.getCarte2().toFileString()));
            g.drawImage(cfront, (width / 2) - (ch / 2), cjah, cw, ch, this);
        }

        //--- Dessin des cartes du joueur 2 ---//

	    if (t.getCarte2() == null) {
	        g.drawImage(empty, (width / 2) - (ch / 2), cjah, cw, ch, this);
	    } else {
	        Image cfront = Toolkit.getDefaultToolkit().getImage(pathcartes + t.getCarte2().toFileString());
	        g.drawImage(cfront, (width / 2) - (ch / 2), cjah, cw, ch, this);
	    }
    
        //--- Dessin des cartes du joueur distant ou du joueur PC (IA) ---//

        for (int f = 0; f < t.main2.getSize(); f++) {

            int mid = (int) ((width / 2) - (((t.main2.getSize() + 1) * (cw) / 2) * 0.5)) + ((f * cw) / 2);
            Carte c = t.main2.getCarte(f);
            g.drawImage(cback, mid, bh, this);

        }

        //--- Dessin des cartes du joueur 1 ---//

        for (int f = 0; f < t.main1.getSize(); f++) {

            int mid = (int) ((width / 2) - (((t.main1.getSize() + 1) * (cw) / 2) * 0.5)) + (f * cw) / 2;
            int up = height - ch - bh;
            Carte c = t.main1.getCarte(f);

            if (carteactive != null) {

                if (c == carteactive) {
                    // Carte Jouable
                    if (jeu.carteJouable(c, 1) == true) {
                        up -= 20;
                    } // Carte non jouable
                    else {
                    }
                }
            }

            // on check le type de c et on charge le graphique associe

            Image cfront = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathcartes+ c.toFileString()));
            g.drawImage(cfront, mid, up, cw, ch, this);
        }

        // Dessin des Piles
        for (int p = 0; p < 6; p++) {
            for (int pc = 0; pc < t.piles.get(p).getSize(); pc++) {

            int mid = (int) ((width / 2) - ((6 * (cw) + 5 * 20 + 4 * 3) / 2) + (pc * 3) + (p * (cw + 20)));

                if (pc == (t.piles.get(p).getSize() - 1)) {
                    Carte c = t.piles.get(p).getCarte(pc);
                    Image cfront = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathcartes + c.toFileString()));
                    g.drawImage(cfront, mid, (height /2) -ch/2, cw, ch, this);

                } else {
                    g.drawImage(cback, mid, (height / 2) - ch / 2, cw, ch, this);
                }
            }
        }
    

		// Affichage des informations

		f = new Font("sansserif", Font.BOLD, 14);
		FontMetrics fontw = g.getFontMetrics(f);
		g.setFont(f);

		//--- Dessin du nombre de plis (score de la partie actuelle) ---//

		// Joueur 1
		g.drawImage(pli, width - bw - cw - 1, height - bh - ch - 1, cw, ch, this);
		g.setColor(Color.yellow);
		String pli1 = String.valueOf(jeu.getJoueur1().nbPlis);
		g.drawString(pli1, width - bw - cw / 2 - fontw.stringWidth(pli1) / 2, height - bh - ch / 2 + 4);

		// Joueur 2 (adversaire)
		g.drawImage(pli, width - bw - cw - 1, bh + 1, cw, ch, this);
		g.setColor(Color.yellow);
		String pli2 = String.valueOf(jeu.getJoueur2().nbPlis);
		g.drawString(pli2, width - bw - cw / 2 - fontw.stringWidth(pli2) / 2, bh + ch / 2 + 9);

		// Infos du bas
		String atout = " ";
		g.setColor(Color.black);
		if ((t != null) && (t.atout != null)) {
		    switch (t.atout) {
		        case CARREAU:
		            atout = "Atout : ♦";
		            break;
		        case COEUR:
		            atout = "Atout : ♥";
		            break;
		        case PIQUE:
		            atout = "Atout : ♠";
		            break;
		        case TREFLE:
		            atout = "Atout : ♣";
		            break;
		        default:
		            break;
		    }
		} else {
		    atout = "Pas d'atout ";
		}

		// on ecrit quel est l'atout
		g.drawString(atout, width - fontw.stringWidth(atout), dheight - 5);

		// Joueur actif
		String turnInfo = " ";
		if (jeu.getJoueurCourant() == 1 && !jeu.intVersJoueur().getaJoue()) {
		    turnInfo = "A vous de Jouer";
		} else if (jeu.getJoueurCourant() == 1 && jeu.intVersJoueur().getaJoue()) {
		    turnInfo = "A vous de Piocher";
		} else if (jeu.getJoueurCourant() == 2 && !jeu.intVersJoueur().getaJoue()) {
		    turnInfo = "A votre adversaire de Jouer";
		} else if (jeu.getJoueurCourant() == 2 && jeu.intVersJoueur().getaJoue()) {
		    turnInfo = "A votre adversaire de Piocher";
		}

		// Affichage des infos sur le tour
		g.drawString(turnInfo, width / 2 - fontw.stringWidth(turnInfo) / 2, dheight - 5);

		// Affichage du score
		String score = "Score - Vous : " + jeu.getJoueur1().score + ", Adversaire : " + jeu.getJoueur2().score;
		g.drawString(score, 0, dheight - 5);



    } // fin fonction paint
}

