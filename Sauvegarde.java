
import java.io.*;

public class Sauvegarde {


    // -------------------------------------Attributs-------------------------------------
    // -------------------------------------Constructeur-------------------------------------
    Sauvegarde() {
        if (loadGame("test") != null) {
        }
    }

    // -------------------------------------Accesseurs-------------------------------------

    // -------------------------------------Setters-------------------------------------



    // -------------------------------------Methodes-------------------------------------
    // Retourne la valeur de la ligne
    static String getValue(String str) {
        int i = 0;

        while (str.charAt(i) != '=') {
            i++;
        }
        i += 2;
        return (str.substring(i, str.length()));
    }

    // Retourne l'option de la ligne
    static String getOpt(String str) {
        int i = 0;

        while (str.charAt(i) != '=') {
            i++;
        }
        i--;
        return (str.substring(0, i));
    }

    // Retourne la carte à partir de la ligne
    static Carte getCarte(String str) {
        int i = 0;

        while (!str.substring(i, i+2).equals("de")) {
            i++;
        }
        i--;
	int couleur = Integer.parseInt(str.substring(i+4, str.length()));
	int rang = Integer.parseInt(str.substring(0,i));
	Couleur c = getCouleur(couleur);
	Rang r = getRang(rang);
	return (new Carte(c, r));
    }

    // Charge une partie (renvoie ??? jeu ? table ?)  NYI
    public Table loadGame(String filename) {
        try {
            InputStream file = new FileInputStream(filename);
            InputStreamReader fd = new InputStreamReader(file);
            BufferedReader buf = new BufferedReader(fd);
            String ligne = "";
            String opt = "";

            while ((ligne = buf.readLine()) != null) {
                opt = getOpt(ligne);
            }
            buf.close();
            return (null);
        } catch (Exception e) {
            System.out.println(e.toString());
            return (null);
        }

    }

    // Sauveguarde la partie
    static void saveGame(String filename, Jeu j) {
	Table t = j.getMoteur().getTable();
        try {
            FileWriter file = new FileWriter(filename);
            BufferedWriter fd = new BufferedWriter(file);
            PrintWriter buf = new PrintWriter(fd);

	    // Ecriture de l'atout
            buf.println("atout = " + t.atout);
	    // Ecriture scores
            buf.println("score1 = " + j.joueur1.getScore());
            buf.println("score2 = " + j.joueur2.getScore());
	    // Ecriture nbPlis
            buf.println("nbPlis1 = " + j.joueur1.getNbPlis());
            buf.println("nbPlis2 = " + j.joueur2.getNbPlis());
	    // Ecriture type/mode/difficultee
            buf.println("type = " + j.type);
            buf.println("mode = " + j.mode);
            buf.println("difficultee = " + j.diff);
	    // Ecriture des piles
	    for (int p = 0; p < 6; p++) {
		buf.println("pile = "+p);
		for (int pc = 0; pc < t.piles.get(p).getSize(); pc++) {
		    buf.println(t.piles.get(p).getCarte(pc).getRang().ordinal() + " de " + t.piles.get(p).getCarte(pc).getCouleur().ordinal());
		}
	    }
	    // Ecriture des mains
	    // Main 1
	    buf.println("main = 1");
	    for (int f = 0; f < t.main1.getSize(); f++) {
		buf.println(t.main1.getCarte(f).getRang().ordinal() + " de " + t.main1.getCarte(f).getCouleur().ordinal());
	    }
	    // Main 2
	    buf.println("main = 2");
	    for (int f = 0; f < t.main2.getSize(); f++) {
		buf.println(t.main2.getCarte(f).getRang().ordinal() + " de " + t.main2.getCarte(f).getCouleur().ordinal());
	    }

            buf.close();
            System.out.println("Sauvegarde " + filename + " effectuée!");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    // Parce que j'arrive pas a faire autrement..
    static Couleur getCouleur(int couleur) {
	Couleur c = null;

	switch (couleur) {
	case 0:
	    c = Couleur.TREFLE;
	    break;
	case 1:
	    c = Couleur.CARREAU;
	    break;
	case 2:
	    c = Couleur.COEUR;
	    break;
	case 3:
	    c = Couleur.PIQUE;
	    break;
	default:
	    break;
	}
	return c;
    }

    // La meme pour les rangs...
    static Rang getRang(int rang) {
	Rang r = null;

	switch (rang) {
	case 2:
	    r = Rang.DEUX;
	    break;
	case 3:
	    r = Rang.TROIS;
	    break;
	case 4:
	    r = Rang.QUATRE;
	    break;
	case 5:
	    r = Rang.CINQ;
	    break;
	case 6:
	    r = Rang.SIX;
	    break;
	case 7:
	    r = Rang.SEPT;
	    break;
	case 8:
	    r = Rang.HUIT;
	    break;
	case 9:
	    r = Rang.NEUF;
	    break;
	case 10:
	    r = Rang.DIX;
	    break;
	case 11:
	    r = Rang.VALET;
	    break;
	case 12:
	    r = Rang.DAME;
	    break;
	case 13:
	    r = Rang.ROI;
	    break;
	case 14:
	    r = Rang.AS;
	    break;
	default:
	    break;
	}
	return r;
    }

}
