package main;
import javax.swing.SwingUtilities;
import gui.GUI;

/**
 * i denna class man anropar GUI var ligger kod för SWING
 * @author danijela
 * 
 *  
 */
public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new GUI());

	}

}
