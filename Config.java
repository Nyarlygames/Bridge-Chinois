import java.io.*;
import java.lang.Integer;

public class Config {
    static int width, height, deck, style = 0;
    String FILENAME = "options.cfg";

    // -------------------------------------Attributs-------------------------------------

    // -------------------------------------Constructeur-------------------------------------
    Config() {
		if (getConfigs() == 1) {
		    setWidth(800);
		    setHeight(650);
		    setDeck(1);
		    setStyle(1);
		    saveConfigs();
		}
    }

    // -------------------------------------Accesseurs-------------------------------------

    public int getWidth() {
        return(this.width);
    }

    public int getHeight() {
        return(this.height);
    }

    public int getDeck() {
        return(this.deck);
    }

    public int getStyle() {
        return(this.style);
    }

    // -------------------------------------Setters-------------------------------------
    public void setStyle(int value) {
        this.style = value;
    }
    public void setDeck(int value) {
        this.deck = value;
    }
    public void setHeight(int value) {
        this.height = value;
    }
    public void setWidth(int value) {
        this.width = value;
    }

    // -------------------------------------Methodes-------------------------------------


    // Retourne la valeur de la ligne de config
    public String getValue(String str) {
	int i = 0;

	while (str.charAt(i) != '=')
	    i++;
	i += 2;
	return (str.substring(i,str.length()));
    }

    // Retourne l'option de la ligne
    public String getOpt(String str) {
	int i = 0;

	while (str.charAt(i) != '=')
	    i++;
	i --;
	return (str.substring(0, i));
    }

    // Parse le fichier de config renvoie 0 si tout est bon, 1 si il échoue
    public int getConfigs() {
	String chaine = "";

	try{
	    InputStream file = new FileInputStream(FILENAME); 
	    InputStreamReader fd = new InputStreamReader(file);
	    BufferedReader buf = new BufferedReader(fd);
	    String ligne;
	    String opt;
	    String value;

	    while ((ligne=buf.readLine())!=null){
		opt = getOpt(ligne);

		// Largeur de la fenêtre
		if (opt.equals("width"))
		    this.width = Integer.parseInt(getValue(ligne));
		// Hauteur de la fenêtre
		if (opt.equals("height"))
		    this.height = Integer.parseInt(getValue(ligne));
		// Skin des cartes
		if (opt.equals("deck"))
		    this.deck = Integer.parseInt(getValue(ligne));
		// Style du tapis
		if (opt.equals("style"))
		    this.style = Integer.parseInt(getValue(ligne));
	    }
	    buf.close();
	    return (0);
	}
	catch (Exception e){
	    System.out.println(e.toString());
	    return (1);
	}

    }


    // Sauveguarde les configurations dans le fichier
    public void saveConfigs() {
	try {
	    FileWriter file = new FileWriter (FILENAME);
	    BufferedWriter fd = new BufferedWriter (file);
	    PrintWriter buf = new PrintWriter (fd);
	    buf.println ("width = " + this.width);
	    buf.println ("height = " + this.height);
	    buf.println ("style = " + this.style);
	    buf.println ("deck = " + this.deck);
	    buf.close();
	    System.out.println("Le fichier " + FILENAME + " a été créé!");
	}
	catch (Exception e){
	    System.out.println(e.toString());
	}
    }
}
