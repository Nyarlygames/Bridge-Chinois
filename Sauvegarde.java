
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
    static int getValue(String str) {
        int i = 0;

        while (str.charAt(i) != '=') {
            i++;
        }
        i += 2;
        return (Integer.parseInt(str.substring(i, str.length())));
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
	int f = 0;

        while (str.charAt(i) != '=') {
            i++;
        }
        i += 2;
	f = i;
        while (!str.substring(f, f+2).equals("de")) {
            f++;
        }
        f--;
	int r = Integer.parseInt(str.substring(f+4, str.length()));
	int c = Integer.parseInt(str.substring(i,f));
	return (new Carte(Couleur.convert(c), Rang.convert(r)));
    }

    // Charge une partie
    static boolean loadGame(String filestr, JFrame f) {
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
        Carte lastcarte1 = null;
        Carte lastcarte2 = null;
	String filename = "saves/"+filestr+"/"+filestr;
        try {
            ObjectInputStream buf2 = new ObjectInputStream(new FileInputStream(filename+".hist"));
            ObjectInputStream buf3 = new ObjectInputStream(new FileInputStream(filename+".table"));
            InputStream file = new FileInputStream(filename+".opt");
            InputStreamReader fd = new InputStreamReader(file);
            BufferedReader buf = new BufferedReader(fd);
            String ligne = "";
            String opt = "";

            h = (Historique) buf2.readObject();
            t = (Table) buf3.readObject();
            buf2.close();
            buf3.close();

            while ((ligne = buf.readLine()) != null) {
                opt = getOpt(ligne);
               if (opt.equals("diff")) {
                    diff = getValue(ligne);
                }
               if (opt.equals("max")) {
                    max = getValue(ligne);
                }
                if (opt.equals("mode")) {
                    mode = getValue(ligne);
                }
                if (opt.equals("score1")) {
                    score1 = getValue(ligne);
                }
                if (opt.equals("score2")) {
                    score2 = getValue(ligne);
                }
                if (opt.equals("nbPlis1")) {
                    nbPlis1 = getValue(ligne);
                }
                if (opt.equals("nbPlis2")) {
                    nbPlis2 = getValue(ligne);
                }
                if (opt.equals("atout")) {
                    atout = getValue(ligne);
                }
                if (opt.equals("type")) {
                    type = getValue(ligne);
                }
                if (opt.equals("joueurCourant")) {
                    joueurCourant = getValue(ligne);
                }
                if (opt.equals("lastcarte1")) {
                    lastcarte1 = getCarte(ligne);
		}
                if (opt.equals("lastcarte2")) {
                    lastcarte2 = getCarte(ligne);
                }
		System.out.println("LAST 1 "+lastcarte1);
		System.out.println("LAST 2 "+lastcarte2);
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
        final Carte jlastcarte1 = lastcarte1;
        final Carte jlastcarte2 = lastcarte2;

        for (int p = 0; p < 6; p++) {
            jt.piles.get(p).afficherPileConsole();
            }
        
        f.dispose();
        
        new Thread(new Runnable() {
        	public void run() {
                final Moteur jmoteur = new Moteur(jt);
		        Jeu jeu = new Jeu(jmoteur, jmode, jtype, jmax, jdiff, true);
		        jeu.setHist(jh);
		        jeu.setMoteur(jmoteur);
		        jeu.getMoteur().setTable(jt);
		        jeu.joueur1.setScore(jscore1);
		        jeu.joueur2.setScore(jscore2);
		        jeu.joueur1.setNbPlis(jnbPlis1);
		        jeu.joueur2.setNbPlis(jnbPlis2);
			jeu.lastcarte1 = jlastcarte1;
			jeu.lastcarte2 = jlastcarte2;
			final Graphique gg = new Graphique(jeu);
		        jeu.addObservateur(new Observateur() {
					public void update(Jeu jeu) {
						gg.getZoneDessin().repaint();
                        if (jeu.fin) {
                           final FinPartie fin =new FinPartie(gg.frame,true,jeu.partieRestante,jeu.gg);
                           fin.setVisible(true);
                        }
					}
				});
		        SwingUtilities.invokeLater(gg);
		        jeu.jouer();
		      }
        }).start();
       return (true);
    }

    // Sauveguarde la partie
    static void saveGame(String filestr, Jeu j) {
	Table t = j.getMoteur().getTable();
	String filedir = "saves/"+filestr+"/";
	String filename = "saves/"+filestr+"/"+filestr;
	try {
	    System.out.println(filedir);
	    new File(filedir).mkdirs();
	}
	catch (Exception ex) {
	    System.out.println("Echec creation de fichier");
	}
        try {
            ObjectOutputStream buf2 = 
             new ObjectOutputStream(
                new FileOutputStream(filename+".table"));

            ObjectOutputStream buf3 = 
             new ObjectOutputStream(
                new FileOutputStream(filename+".hist"));

            buf2.writeObject(t);
            buf3.writeObject(j.hist);
            buf2.close();
            buf3.close();
            FileWriter file = new FileWriter(filename+".opt");
            BufferedWriter fd = new BufferedWriter(file);
            PrintWriter buf = new PrintWriter(fd);

	        // Ecriture de l'atout
	    if (t.atout != null) {
		buf.println("atout = " + t.atout.ordinal());
	    }
	        // Ecriture scores
            buf.println("score1 = " + j.joueur1.getScore());
            buf.println("score2 = " + j.joueur2.getScore());
	        // Ecriture nbPlis
            buf.println("nbPlis1 = " + j.joueur1.getNbPlis());
            buf.println("nbPlis2 = " + j.joueur2.getNbPlis());
	        // Ecriture options...
            buf.println("type = " + j.type);
            buf.println("mode = " + j.mode);
            buf.println("diff = " + j.diff);
            buf.println("max = " + j.max);
            buf.println("joueurCourant = " + j.joueurCourant);
	    if ((j.lastcarte2 != null) && (j.lastcarte1 != null)) {
		buf.println("lastcarte1 = " + j.lastcarte1.getCouleur().ordinal() + " de " + j.lastcarte1.getRang().ordinal());
		buf.println("lastcarte2 = " + j.lastcarte2.getCouleur().ordinal() + " de " + j.lastcarte2.getRang().ordinal());
	    }


            buf.close();
            System.out.println("Sauvegarde " + filename + " effectuée!");
        } catch (Exception e) {
            System.out.println(e.toString());
	    e.printStackTrace();
        }
    }


}
