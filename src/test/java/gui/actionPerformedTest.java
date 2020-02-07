package gui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.junit.jupiter.api.Test;

import domain.Contact;
import domain.ContactBook;

public class actionPerformedTest {

	Contact contact = new Contact();
	ContactBook cb = new ContactBook();
	Contact c = new Contact("Adam");
	GUI gui = new GUI();
	private JButton listaB2 = new JButton("Lista");
	private JButton listaGUI;
	JPanel panel = new JPanel();

	@Test
	public void listaTest() {
		
	assertEquals("",gui.getResultatTA().getText());

	}
	
	public void laggTill() {
		Contact c = new Contact("XXXXXX");
		
		String resultat= gui.getResultatTA().getText();
		assertEquals(c,gui.getResultatTA().getText());
	}
}
