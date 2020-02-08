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
	// Contact c = new Contact("Adam");
	GUI gui = new GUI();
	private JButton listaB2 = new JButton("Lista");
	private JButton listaGUI;
	JPanel panel = new JPanel();

	@Test
	public void listaTest() {
		// lista är tomt
		assertEquals("", gui.getResultatTA().getText());
	}

	@Test
	public void sök() {

	}

	@Test
	public void laggTill() {
		// index av contact book ökar för 1 efter vi addera en ny kontakt
//		int y = cb.size();
//		Contact c = new Contact("XXXXXX");
//		cb.add(c);
//		int x = cb.size() - 1;
//
//		assertEquals(x, y);

		gui.getSkrivInTF().setText("xxxx");
		gui.getLäggB().doClick();
		gui.getListaB().doClick();
		String nyText = gui.getResultatTA().getText();
		assertEquals("0:  xxxx           \n", nyText);
	}

	@Test
	public void taBortTest() {
//		int y = cb.size();
//		Contact c = new Contact("XXXXXX");
//		cb.add(c);
//		cb.remove();
//		int x = cb.size();
//
//		assertEquals(x, y);

		gui.getSkrivInTF().setText("xxxx");
		gui.getLäggB().doClick();
		gui.getListaB().doClick();
		String text = gui.getResultatTA().getText();

		gui.getResultatTA().selectAll();

		gui.getTaBortB().doClick();
		gui.getListaB().doClick();

		String nyText = gui.getResultatTA().getText();
		assertEquals("", nyText);

	}
}
