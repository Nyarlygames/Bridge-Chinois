
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
    public int aw = 0;
    public int ah = 0;
    public int rw = 0;
    public int rh = 0;
    public int bouton = -1;
    public Table t;
    public Config cfg;
    int width;
    int dheight;
    int height;
    Carte carteactive;
    Font f;
    Graphics g;
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
        this.t = jeu.getMoteur().getTable();
        Graphics2D drawable = (Graphics2D) g;
        this.g = g;
        this.dheight = getSize().height;
        this.width = getSize().width;
        this.height = dheight - 20;

        // On reccupere quelques infos provenant de la partie JComponent
        int width = getSize().width;

        int dheight = getSize().height;
        int height = dheight - 20;


        String pathcartes = "cartes/" + this.cfg.deck + "/";
        String pathres = "res/" + this.cfg.style + "/";
        // Background
        Image corner_trefle = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathres + "corner_trefle.png"));
        Image corner_pique = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathres + "corner_pique.png"));
        Image corner_coeur = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathres + "corner_coeur.png"));
        Image corner_carreau = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathres + "corner_carreau.png"));
        Image left = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathres + "left.png"));
        Image bottom = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathres + "bottom.png"));
        Image top = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathres + "top.png"));
        Image right = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathres + "right.png"));
        Image center = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathres + "center.png"));
        Image empty = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathres + "empty.png"));
        // Cartes
        Image pli = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathcartes + "pli.png"));

        Image cback = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathcartes + "carte-dos.png"));

        // arrow des hints
        Image hintArrowCartes = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathres + "hintcartes.png"));
        Image hintArrowPiles = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathres + "hintpiles.png"));



        // Annuler/refaire graphique
        Image annuler = Toolkit.getDefaultToolkit().getImage(getClass().getResource("res/Bannuler.png"));
        Image annuler_mo = Toolkit.getDefaultToolkit().getImage(getClass().getResource("res/Bannuler_entered.png"));

        Image refaire = Toolkit.getDefaultToolkit().getImage(getClass().getResource("res/Brefaire.png"));
        Image refaire_mo = Toolkit.getDefaultToolkit().getImage(getClass().getResource("res/Brefaire_entered.png"));

        // corners
        int cornerh = corner_trefle.getHeight(null);
        int cornerw = corner_trefle.getWidth(null);
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
        // annuler/refaire
        int aw = annuler.getWidth(null);
        int ah = annuler.getHeight(null);
        this.aw = aw;
        this.ah = ah;
        int rw = refaire.getWidth(null);
        int rh = refaire.getHeight(null);
        this.rw = rw;
        this.rh = rh;


        // HAUT GAUCHE
        g.drawImage(corner_coeur, 0, 0, cornerw, cornerh, this);
        // HAUT DROIT
        g.drawImage(corner_trefle, width - cornerw, 0, cornerw, cornerh, this);
        // BAS GAUCHE
        g.drawImage(corner_pique, 0, height - cornerh, cornerw, cornerh, this);
        // BAS DROIT
        g.drawImage(corner_carreau, width - cornerw, height - cornerh, cornerw, cornerh, this);

        g.drawImage(left, 0, cornerh, bw, height - (2 * cornerh), this);
        g.drawImage(right, width - bw, cornerh, bw, height - (2 * cornerh), this);
        g.drawImage(bottom, cornerw, height - bh, width - (2 * cornerw), bh, this);
        g.drawImage(top, cornerw, 0, width - (2 * cornerw), bh, this);
        g.drawImage(center, bw, bh, width - (2 * bw), height - (2 * bh), this);


        //Annuler/refaire
        if (jeu.getMode() != 2) {
            if (bouton == 0) {
                g.drawImage(annuler_mo, bw, height - bh - rh - ah, aw, ah, this);
                g.drawImage(refaire, bw, height - bh - rh, rw, rh, this);
            } else if (bouton == 1) {
                g.drawImage(refaire_mo, bw, height - bh - rh, rw, rh, this);
                g.drawImage(annuler, bw, height - bh - rh - ah, aw, ah, this);
            } else {
                g.drawImage(annuler, bw, height - bh - rh - ah, aw, ah, this);
                g.drawImage(refaire, bw, height - bh - rh, rw, rh, this);
            }
        }
        //--- Dessin des slots ou faut jouer les cartes ---//

        // hauteur carte joueur adverse
        int cjah = ((height / 2) - (ch / 2) - ch - bh) / 2 + ch + bh - ch / 2;
        // hauteur carte joueur
        int cjh = ((height / 2) - (ch / 2) - ch - bh) / 2 + height / 2;

        if (t.getCarte1() == null) {
            g.drawImage(empty, (width / 2) - (ch / 2), cjh, cw, ch, this);
        } else {

            Image cfront = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathcartes + t.getCarte1().toFileString()));
            g.drawImage(cfront, (width / 2) - (ch / 2), cjh, cw, ch, this);
        }


        if (t.getCarte2() == null) {
            g.drawImage(empty, (width / 2) - (ch / 2), cjah, cw, ch, this);
        } else {
            Image cfront = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathcartes + t.getCarte2().toFileString()));
            g.drawImage(cfront, (width / 2) - (ch / 2), cjah, cw, ch, this);
        }


        //--- Dessin des cartes du joueur distant ou du joueur PC (IA) ---//

        for (int f = 0; f < t.main2.getSize(); f++) {

            int mid = (int) ((width / 2) - (((t.main2.getSize() + 1) * (cw) / 2) * 0.5)) + ((f * cw) / 2);
            Carte c = t.main2.getCarte(f);
            if (cfg.isVoitCartes() && jeu.getMode() !=2) {
                Image cfront = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathcartes + c.toFileString()));
                g.drawImage(cfront, mid, bh, cw, ch, this);
            } else {
                g.drawImage(cback, mid, bh, this);
            }
        }

        //--- Dessin des cartes du joueur 1 ---//

        for (int f = 0; f < t.main1.getSize(); f++) {

            int mid = (int) ((width / 2) - (((t.main1.getSize() + 1) * (cw) / 2) * 0.5)) + (f * cw) / 2;
            int up = height - ch - bh;
            Carte c = t.main1.getCarte(f);

            // si la carte est hover par la souris, on la raise
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

            // Affichage indices des cartes
            if (jeu.getHintCarte() != null && c.equals(jeu.getHintCarte())) {
                int hw = hintArrowCartes.getWidth(null);
                int hh = hintArrowCartes.getHeight(null);
                g.drawImage(hintArrowCartes, mid, up - hh, hw, hh, this);
            }
            // on check le type de c et on charge le graphique associe

            Image cfront = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathcartes + c.toFileString()));
            g.drawImage(cfront, mid, up, cw, ch, this);
        }

        // Dessin des Piles
        for (int p = 0; p < 6; p++) {
            for (int pc = 0; pc < t.piles.get(p).getSize(); pc++) {

                int mid = (int) ((width / 2) - ((6 * (cw) + 5 * 20 + 4 * 3) / 2) + (pc * 3) + (p * (cw + 20)));

                if (pc == (t.piles.get(p).getSize() - 1)) {
                    Carte c = t.piles.get(p).getCarte(pc);
                    Image cfront = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathcartes + c.toFileString()));
                    g.drawImage(cfront, mid, (height / 2) - ch / 2, cw, ch, this);

                } else {
                    g.drawImage(cback, mid, (height / 2) - ch / 2, cw, ch, this);
                }
            }
        }

        //Affichage des indices piles
        if (jeu.getHintPile() != null && jeu.getHintPile() > 0) {
            int p = jeu.getHintPile() - 1;
            System.out.println(p);
            int pc = t.piles.get(p).getSize();
            int mid = (int) ((width / 2) - ((6 * (cw) + 5 * 20 + 4 * 3) / 2) + (pc * 3) + (p * (cw + 20)));
            int hw = hintArrowPiles.getWidth(null);
            int hh = hintArrowPiles.getHeight(null);
            g.drawImage(hintArrowPiles, mid, (height / 2) + ch / 2, hw, hh, this);
        }

        // Chargement de la police d'ecriture
        f = new Font("sansserif", Font.BOLD, 14);
        FontMetrics fontw = g.getFontMetrics(f);
        g.setFont(f);

        // Affichage dernier pli
        if (cfg.isVoitPlis() && (jeu.getHist().position > 0) && (jeu.lastcarte1 != null) && (jeu.lastcarte2 != null)) {
            String str = "Dernier pli :";

            // Affichage "Dernier pli"
            g.setColor(Color.red);
            g.drawString(str, width - bw - fontw.stringWidth(str), (height / 2) - ch - fontw.getHeight());

            // Affichage des cartes
            if (jeu.lastcarte1 != null) {
                Image c1 = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathcartes + jeu.lastcarte1.toFileString()));
                g.drawImage(c1, width - bw - cw, (height / 2), cw, ch, this);
            }
            if (jeu.lastcarte2 != null) {
                Image c2 = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathcartes + jeu.lastcarte2.toFileString()));
                g.drawImage(c2, width - bw - cw, (height / 2) - ch, cw, ch, this);
            }
        }

        //--- Dessin du nombre de plis (score de la partie actuelle) ---//

        // Joueur 1
        g.drawImage(pli, width - bw - cw - 1, height - bh - ch - 1, cw, ch, this);
        g.setColor(Color.black);

        String pli1 = String.valueOf(jeu.getJoueur1().nbPlis);
        g.setColor(Color.white);
        g.drawString(pli1, width - bw - cw / 2 - fontw.stringWidth(pli1) / 2, height - bh - ch / 2 + 4);

        // Joueur 2 (adversaire)
        g.drawImage(pli, bw + 1, bh + 1, cw, ch, this);
        g.setColor(Color.black);
        String pli2 = String.valueOf(jeu.getJoueur2().nbPlis);
        g.setColor(Color.white);
        g.drawString(pli2, bh + ch / 2 - fontw.stringWidth(pli2) / 2 - 12, bh + ch / 2 + 5);


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
        if (atout == "Atout : ♦" || atout == "Atout : ♥") {
            g.setColor(Color.red);
            g.drawString(atout, width - fontw.stringWidth(atout), dheight - 5);
            g.setColor(Color.black);
        } else {
            g.drawString(atout, width - fontw.stringWidth(atout), dheight - 5);
        }

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
        String score = "";
        // Partie par nombre de donnes ou pli
        if ((jeu.type == 0) || (jeu.type == 1)) {
            score = "Score - Vous : " + jeu.getJoueur1().score + ", Adversaire : " + jeu.getJoueur2().score;
        } // Partie aventure
        else {
            score = "Aventure";
        }
        g.drawString(score, 0, dheight - 5);

    } // fin fonction paint

    // Animation carte jouee
    public void jouerCarte(Carte c) {
        int start = 0;
        int end = 1000;
        // hauteur arrivee
        int ha = ((height / 2) - (ch / 2) - ch - bh) / 2 + height / 2;
        // hauteur départ
        int hd = height - ch - bh - 20;
        // largeur arrivee
        int la = (width / 2) - (ch / 2);
        // largeur depart
        int ld = (int) ((width / 2) - (((t.main1.getSize() + 1) * (cw) / 2) * 0.5)) + (1 * cw) / 2;
        // hauteur mouvement
        int hm = hd;
        // largeur mouvement
        int lm = ld;
        Image cfront = Toolkit.getDefaultToolkit().getImage(getClass().getResource("cartes/1/" + c.toFileString()));
        int i = 0;

        while ((hm != ha) && (lm != la)) {
            hm = hd + (int) ((double) ((ha - hd) * i / 100));
            lm = ld + (int) ((double) ((la - ld) * i / 100));
            g.drawImage(cfront, lm, hm, cw, ch, this);
            this.repaint();
            i += 1;
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                System.out.println("Echec de l'echellonage du deplacement");
            }
        }
    }
}
