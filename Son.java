/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amine
 */
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.swing.JDialog;

public class Son extends Object implements LineListener {

    String fileAudio;
    JDialog playingDialog;
    Clip clip;
    public Config cfg;

    /*public static void main(String[] args) throws Exception {
    Son s = new Son();
    }*/
    public Son(String fileAudio) throws Exception {

        //fileAudio = new File("Bcarte.wav");
        cfg = new Config();
        if (cfg.isSon()) {
            System.out.println("morceau : " + fileAudio);

            Line.Info linfo = new Line.Info(Clip.class);
            Line line = AudioSystem.getLine(linfo);
            clip = (Clip) line;
            clip.addLineListener(this);
            String pathres = "res/";
            AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(pathres + fileAudio));
            clip.open(ais);
            clip.start();
        }
    }

    public void update(LineEvent le) {
        LineEvent.Type type = le.getType();
        if (type == LineEvent.Type.OPEN) {
            //System.out.println("OUVERT");
        } else if (type == LineEvent.Type.CLOSE) {
            //System.out.println("FERME");
            //System.exit(0);
        } else if (type == LineEvent.Type.START) {
            //System.out.println("DEBUT");
            //  playingDialog.setVisible(true);
        } else if (type == LineEvent.Type.STOP) {
            //System.out.println("FIN");
            //playingDialog.setVisible(false);
            clip.close();
        }
    }
}