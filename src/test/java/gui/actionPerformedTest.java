package gui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;



public class actionPerformedTest {

	GUI gui = new GUI();

	@Test
	public void listaTest() {
		// lista är tomt
		assertEquals("", gui.getResultatTA().getText());
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

	@Test
	public void sök() {
		gui.getSkrivInTF().setText("yyy");
		gui.getLäggB().doClick();
		gui.getListaB().doClick();
		String input1 = gui.getResultatTA().getText();

		gui.getSkrivInTF().setText("yyy");
		gui.getSökB().doClick();
		String input2 = gui.getResultatTA().getText();

		assertEquals(input2, input1);
	}

}
