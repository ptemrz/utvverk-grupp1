package main;
import javax.swing.SwingUtilities;
import gui.GUI;

/**
 * 
 * @author danijela
 *
 */
public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new GUI());

	}

}
