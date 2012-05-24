
import java.awt.*;
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
        System.out.println("ZoneDessin repaint");

        System.out.println(mode);
        Graphics2D drawable = (Graphics2D) g;

        // On reccupere quelques infos provenant de la partie JComponent
        int width = getSize().width;
        int height = getSize().height;
        //TAILLE_CASE_X = (width - (ma_gaufre.getLargeur()-1) )/ma_gaufre.getLargeur() ;
        //TAILLE_CASE_Y = (height - (ma_gaufre.getHauteur()-1) )/ma_gaufre.getHauteur()  ;

        // Mode Partie
        if (mode == 2) {

            // Background
            Image left = Toolkit.getDefaultToolkit().getImage("res/left.jpg");
            Image right = Toolkit.getDefaultToolkit().getImage("res/right.jpg");
            Image middle = Toolkit.getDefaultToolkit().getImage("res/middle.jpg");
            Image empty = Toolkit.getDefaultToolkit().getImage("res/empty.png");

            int bw = left.getWidth(null);

            g.drawImage(left, 0, 0, bw, height, this);
            g.drawImage(right, width - bw, 0, bw, height, this);
            g.drawImage(middle, bw, 0, width - (2 * bw), height, this);

            // Joueur non actif
            Image cback = Toolkit.getDefaultToolkit().getImage("cartes/carte-dos.jpg");
            int cw = cback.getWidth(null);
            int ch = cback.getHeight(null);
	        this.cw = cw;
	        this.ch = ch;

            for (int f = 0; f < t.main1.getSize(); f++) {

                int mid = (int) ((width / 2) - (((t.main1.getSize() + 1) * (cw) / 2) * 0.5)) + ((f * cw) / 2);
                Carte c = t.main1.getCarte(f);

                ImageIcon cup = new ImageIcon(cback);
               // this.add(cup);

		       g.drawImage(cback, mid , 0, this);
            }

            // Dessin du jeu du Joueur actif 
            for (int f = 0; f < t.main2.getSize(); f++) {
                int mid = (int) ((width / 2) - (((t.main1.getSize() + 1) * (cw) / 2) * 0.5)) + (f * cw) / 2;
                Carte c = t.main2.getCarte(f);
                // on check le type de c et on charge le graphique associe
                System.out.println("ZONEDESSIN");
                System.out.println("LACARTE : " + c.getCouleur().toString() + " " + c.getRang().toString());
                System.out.println(c.toFileString());
                Image cfront = Toolkit.getDefaultToolkit().getImage("cartes/" + c.toFileString());
                g.drawImage(cfront, mid, height - ch, cw, ch, this);
            }
            // Dessin des Piles
            for (int p = 0; p < 6; p++) {
                for (int pc = 0; pc < t.piles.get(p).getSize(); pc++) {

                    int mid = (int) ((width / 2) - ((6 * (cw) + 5 * 20 + 4 * 3) / 2) + (pc * 3) + (p * (cw + 20)));

                    //int mid = (int) ((width/2) - (( 7 * (cw) / 2)* 0.5)) + (p*(cw)/2);


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
            g.drawImage(empty, (width / 2) - (ch / 2), ch + 10, cw, ch, this);
            g.drawImage(empty, (width / 2) - (ch / 2), height - (2 * ch + 10), cw, ch, this);

        }

        // Menu
        if (mode == 0) {
            // fenetre de menu de valentin et amine
        }

    }
}
