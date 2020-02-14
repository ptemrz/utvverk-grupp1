package gui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
/**
 * 
 * @author danijela
 *
 */


public class actionPerformedTest {

	GUI gui = new GUI();

	@Test
	public void listaTest() {
		/**
		 * i början är kontaktboken är tomt, så vi jämför med en tom String
		 * 
		 */
//	gui.getListaB().doClick();
		assertEquals("", gui.getResultatTA().getText());
	}

	
	/**
	 * här testar vi funktionalitet av knappen "läggTill"
	 * vi tillsätter text i JTextFiled och sen skickad det till JTextArea med hjälp av 
	 * knappar l"äggTill". Resultatet kan vi se med hjälp av knappen "lista"
	 * Resultatet sätter vi i en string med hjälp av metoden getText() som hämtat textes som finns i
	 * JTextArea. Denna resultat vi jämföra med en string( som innehåller (index: string och nya rad).
	 * OBS ser metoder toString() och find() i ContactBook.
	 */
	
	@Test
	public void laggTill() {
		gui.getInTitle().setText("xxxx");
		gui.getLäggB().doClick();
		gui.getListaB().doClick();
		String nyText = gui.getResultatTA().getText();
		assertEquals("0: xxxx            \n", nyText);
	}

	
	/**
	 * här testar vi funktionalitet av knappen "taBort"
	 * Vi tillsätter text i JTextFiled och sen skickad det till JTextArea med hjälp av knappar l"äggTill" och  "lista"
	 *  Efter select vi det som vi innan skrev i JTextArea. Med hjälp av knappar taBort raderar vi kontakt från JTextArea.
	 * Resultatet skrev vi i JTextArea med hjälp av "Lista" knappen . TExten som finns i JTextArea hämtar vi med hjälp av metoden getText().
	 * Resultatet skulle vara en tomt string.
	 */
	
	@Test
	public void taBortTest() {

		gui.getInTitle().setText("xxxx");
		gui.getLäggB().doClick();
		gui.getListaB().doClick();
		
		gui.getResultatTA().selectAll();

		gui.getTaBortB().doClick();
		gui.getListaB().doClick();
		String nyText = gui.getResultatTA().getText();
		System.out.println(nyText);

		assertEquals("0: xxxx            \n", nyText);

	}
	
	/**
	 * text som vi sätter i JTextFiled skickar vi till JTextArea med hjälp av knappar läggTill och lista. För det anvender vi metoder 
	 * doClick() som simulerar en hendelse( att man klicka på knappen). Resultatet som finns som text i JTextArea ligger vi i en string variabel.
	 * 
	 * Nu sätter vi samma texten i JTextFiled en gån till och simulerar "click" av knappen "sök" med metoden doClick().
	 * Resultat sätter vi i andra string variabel. Vi jämföra dessa två stringer och m de är lika vår test passerar. 
	 */

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
