import java.io.*;
import java.lang.Integer;
import javax.swing.*;
import java.net.*;

public class Serveur {

    // -------------------------------------Attributs-------------------------------------
    ServerSocket serv;
    Socket connexion;
    ObjectInputStream in;
    ObjectOutputStream out;
    String ip;
    String host;
    int port = 4242;

    // -------------------------------------Constructeur-------------------------------------
    Serveur(final int mod, final int nbPart, String ip, String host) {
	this.ip = ip;
	this.host = host;
	startServer();
	System.out.println("IP : "+this.ip);
	System.out.println("HOST : "+this.host);
	/*        new Thread(new Runnable() {
		public void run() {
		    Table table = new Table();
		    Moteur moteur = new Moteur(table);
		    Jeu monJeu = new Jeu(moteur, 1, mod, nbPart, 0);
		    Graphique gg = new Graphique(monJeu, 2);
		    SwingUtilities.invokeLater(gg);
		    monJeu.jouer();
		}
	    }).start();*/
    }

    // -------------------------------------Accesseurs-------------------------------------

    public String getHost() {
        return(this.host);
    }
    public String getIp() {
        return(this.ip);
    }

    // -------------------------------------Setters-------------------------------------
    public void setHost(String host) {
        this.host = host;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }

    // -------------------------------------Methodes-------------------------------------


    // Demarre le serveur
    public void startServer(){
        try{
            System.out.println("dddddd");
            //ETAPE 1:preparation d'un socket serveur
            this.serv = new ServerSocket(this.port);

            while(true){
                //ETAPE 2: attendre une connexion
                attendreUneConnexion();

                //ETAPE 3: obtenir les flux...
                obtenirLesFlux();

                //ETAPE 4:Traiter la connexion
                traiterConnexion();

                //ETAPE 5: fermer la connexion
                fermerConnexion();
            }
        }
        catch(EOFException eof){
            System.out.println("Connexion interrompue");

        }
        catch(IOException io){
            // trate les eventuelles problémes d'E/S
            io.printStackTrace();
        }
    }

    // Listen
    public void attendreUneConnexion()throws IOException{
        System.out.println("En attente de connexion......\n");
        this.connexion = serv.accept();
        System.out.println("connexion recue de : "+ connexion.getInetAddress().getHostName());
    }

    public void obtenirLesFlux()throws IOException{
        // Recuperer la sortie
        out = new ObjectOutputStream(connexion.getOutputStream());
        out.flush();
        // Recuperer l'entree
        in = new ObjectInputStream(connexion.getInputStream());
        System.out.println("\n J'ai reçu les flux");
    }

    // Connecte
    public void traiterConnexion()throws IOException{
        String message = "SERVEUR>>>  Connection";
        out.writeObject(message);
        out.flush();
        // Traite les infos
        do{
            try{
                message = (String)in.readObject();
                System.out.println("\n"+message);
            }
            catch(ClassNotFoundException e){
                System.out.println(e.getMessage()+"\nl'object reçu de type inconnu");
            }
        }while (!message.equals("CLIENT>>> TERMINER"));
    }

    // Ferme le serveur
    public void fermerConnexion()throws IOException{
        System.out.println("\nL'utilisateur a fermé la connexion.");
        envoyerDonnees("TERMINER");
        out.close();
        in.close();
        connexion.close();
    }

    // Envoie une string au client
    public void envoyerDonnees(String message){
        try{
            out.writeObject("SERVEUR>>> "+ message);
            out.flush();
            System.out.println("\nSERVEUR>>> "+message);
            System.out.println("");
        }
        catch(IOException io){
            System.out.println("\nErreur à l'écriture d'un object");
        }
    }
}
