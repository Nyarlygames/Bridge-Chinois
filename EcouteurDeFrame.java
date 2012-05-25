import java.awt.event.ComponentListener;
import java.awt.event.ComponentEvent;
import java.awt.Dimension;
import javax.swing.*;

class EcouteurDeFrame implements ComponentListener {

    // -------------------------------------Attribute-------------------------------------
    JFrame f;

    // -------------------------------------Constructor-------------------------------------
    public EcouteurDeFrame(JFrame f) {
        this.f = f;
    }
    public void componentResized(ComponentEvent e) {

	if (f.getSize().height < 565) {
	    f.setSize(new Dimension(f.getSize().width,565));
	}
	if (f.getSize().width < 620) {
	    f.setSize(new Dimension(620, f.getSize().height));
	}
	
	System.out.println("H : " + f.getSize().height);
	System.out.println("W : " + f.getSize().width);
    }

    // Il faut aussi une implementation pour les autres methodes de l'interface
    public void componentHidden(ComponentEvent e) {
    }

    public void componentMoved(ComponentEvent e) {
    }

    public void componentShown(ComponentEvent e) {
    }
}
