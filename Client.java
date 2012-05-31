import java.io.*;
import java.lang.Integer;
import java.awt.*;
import java.net.*;
import javax.swing.*;

public class Client {

    // -------------------------------------Attributs-------------------------------------
    String ip;
    String host;
    int port = 4242;
    Socket client;
    String message ;
    ObjectInputStream in;
    ObjectOutputStream out;

    // -------------------------------------Constructeur-------------------------------------
    Client(String ip, String host) {
	this.ip = ip;
	this.host = host;
	startClient();
        /*new Thread(new Runnable() {
		public void run() {
		    Table table = new Table();
		    Moteur moteur = new Moteur(table);
		    Jeu monJeu = new Jeu(moteur, 1, 0, 1, 0);
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


    // Connexion au serveur
    public void startClient() {
	try{
            //Etape n:1;
            seConnecterAuServeur();

            //Etape n2;
            obtenirFlux();

            //Etape n3;
            traiterConnexion();

            //Etape n4;
            fermerConnexion();
        }
        catch(EOFException eof){
            // le serveur a fermé la connexion
            System.out.println(eof.getMessage());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    // Creation du socket
    public void seConnecterAuServeur()throws IOException{
        System.out.println("Essai de Connexion...\n");

        client = new Socket(InetAddress.getByName(this.ip), this.port);
        System.out.println("Connecté à:" + client.getInetAddress().getHostName());
    }


    public void obtenirFlux()throws IOException{
        this.out = new ObjectOutputStream( this.client.getOutputStream());
        out.flush();
        this.in = new ObjectInputStream(this.client.getInputStream());
        System.out.println("\nJ'ai eu les flux");
    }

    // Connecte
    public void traiterConnexion()throws IOException{
        do{
            try{
                message=(String)in.readObject();
                System.out.println("\n" +message);

            }
            catch(ClassNotFoundException e){
		// Echec de la connection
                System.out.println(e.getMessage());
            }
        }while(!message.equals("SERVEUR>>> TERMINER"));

    }

    // Ferme la connection au serveur
    public void fermerConnexion()throws IOException{
        System.out.println("\nUtilisateur a fermé la connexion.");
        out.close();
        in.close();
        client.close();
    }

    // Envoie une string au serveur
    public void envoyerDonner(String message){
        try{
	    out.writeObject("CLIENT>>> " + message);
	    out.flush();
        }
        catch(IOException e){
	    // Echec de l'envoie
            System.out.println(e.getMessage());
        }
    }

}
