package main;
import javax.swing.SwingUtilities;
import gui.GUI;

/**
 * 
 * @author danijela
 *i denna class man anropar GUI var ligger kod för SWING
 */
public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new GUI());

	}

}
