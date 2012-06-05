
import java.io.*;
import javax.swing.*;

public class Sauvegarde {


    // -------------------------------------Attributs-------------------------------------
    // -------------------------------------Constructeur-------------------------------------
    Sauvegarde() {
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
	int c = Integer.parseInt(str.substring(i+4, str.length()));
	int r = Integer.parseInt(str.substring(0,i));
	return (new Carte(Couleur.convert(c), Rang.convert(r)));
    }

    // Charge une partie
    static boolean loadGame(String filename, JFrame f) {
    
        Table t = null;
        Historique h = null;
        int mode = -1;
        int max = -1;
        int diff = -1;
        int type = -1;
        int joueurCourant = -1;
        int atout = -1;
        int nbPlis1 = -1;
        int nbPlis2 = -1;
        int score1 = -1;
        int score2 = -1;
    
        try {
            ObjectInputStream buf2 = new ObjectInputStream(new FileInputStream(filename+".hist"));
            ObjectInputStream buf3 = new ObjectInputStream(new FileInputStream(filename+".table"));
            InputStream file = new FileInputStream(filename);
            InputStreamReader fd = new InputStreamReader(file);
            BufferedReader buf = new BufferedReader(fd);
            String ligne = "";
            String opt = "";

            t = (Table) buf3.readObject();
            h = (Historique) buf2.readObject();
            buf2.close();
            buf3.close();

            while ((ligne = buf.readLine()) != null) {
                opt = getOpt(ligne);
               /* if (opt.equals("test")) {
                    test = getValue(ligne);
                }*/
            }
            buf.close();
        } catch (Exception e) {
            System.out.println(e.toString());
            return (false);
        }
        
        
        
        final Table jt = t;
        final Historique jh = h;
        final int jmode = mode;
        final int jmax = max;
        final int jdiff = diff;
        final int jtype = type;
        final int jjoueurCourant = joueurCourant;
        final int jatout = atout;
        final int jnbPlis1 = nbPlis1;
        final int jnbPlis2 = nbPlis2;
        final int jscore1 = score1;
        final int jscore2 = score2;
        
        
        
        f.dispose();
        
        new Thread(new Runnable() {
        	public void run() {
                final Moteur jmoteur = new Moteur(jt);
		        Jeu monJeu = new Jeu(jmoteur, jmode, jtype, jmax, jdiff);
		        final Graphique gg = new Graphique(monJeu);
		        monJeu.addObservateur(new Observateur() {
					public void update(Jeu jeu) {
						gg.getZoneDessin().repaint();
                        if (jeu.fin) {
                           final FinPartie fin =new FinPartie(gg.frame,true,jeu.fin,jeu.gg);
                           fin.setVisible(true);
                        }
					}
				});
		        SwingUtilities.invokeLater(gg);
		        monJeu.jouer();
		      }
        }).start();
       return (true);
    }

    // Sauveguarde la partie
    static void saveGame(String filename, Jeu j) {
	Table t = j.getMoteur().getTable();
        try {

            ObjectOutputStream buf2 = 
             new ObjectOutputStream(
                new FileOutputStream(filename+".hist"));
                
            ObjectOutputStream buf3 = 
             new ObjectOutputStream(
                new FileOutputStream(filename+".table"));
        

            buf2.writeObject(t);
            buf3.writeObject(j.hist);
            buf2.close();
            buf3.close();
            FileWriter file = new FileWriter(filename+".opt");
            BufferedWriter fd = new BufferedWriter(file);
            PrintWriter buf = new PrintWriter(fd);

	        // Ecriture de l'atout
            buf.println("atout = " + t.atout.ordinal());
	        // Ecriture scores
            buf.println("score1 = " + j.joueur1.getScore());
            buf.println("score2 = " + j.joueur2.getScore());
	        // Ecriture nbPlis
            buf.println("nbPlis1 = " + j.joueur1.getNbPlis());
            buf.println("nbPlis2 = " + j.joueur2.getNbPlis());
	        // Ecriture type/mode/difficultee
            buf.println("type = " + j.type);
            buf.println("mode = " + j.mode);
            buf.println("diff = " + j.diff);
            buf.println("max = " + j.max);
            buf.println("joueurCourant = " + j.joueurCourant);


            buf.close();
            System.out.println("Sauvegarde " + filename + " effectuée!");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }


}
