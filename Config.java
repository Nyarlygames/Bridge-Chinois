import java.io.*;
import java.lang.Integer;

public class Config {
    static int width, height, deck, style = 0;

    // -------------------------------------Attributs-------------------------------------

    // -------------------------------------Constructeur-------------------------------------
    Config() {
	getConfigs("options.cfg");
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

    // -------------------------------------Methodes-------------------------------------

    // Retourne la valeur de la ligne de config
    public String getValue(String str) {
	int i = 0;

	while (str.charAt(i) != '=')
	    i++;
	i += 2;
	return (str.substring(i,str.length()));
    }

    public String getOpt(String str) {
	int i = 0;

	while (str.charAt(i) != '=')
	    i++;
	i --;
	return (str.substring(0, i));
    }

    // Parse le fichier de config
    public void getConfigs(String filename) {
	String chaine = "";

	try{
	    InputStream file = new FileInputStream(filename); 
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
	}
	catch (Exception e){
	    System.out.println(e.toString());
	}

    }
}
