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
		GUI guiLista=new GUI();
		/**
		 * I början är kontaktboken är tomt, så vi jämför med en tom String
		 * 
		 */
		guiLista.getListaB().doClick();
		assertEquals("", gui.getResultatTA().getText());
	}

	
	/**
	 * Här testar vi funktionalitet av knappen "Create".
	 * Vi tillsätter text i JTextFiled-titel  med metoden .setText() och sen skickad det till JTextArea med hjälp av 
	 * knappen "Create". Resultatet kan vi se med hjälp av knappen "List"
	 * 
	 * Resultatet sätter vi i en string med hjälp av metoden getText() som hämtat textes som finns i 
	 * JTextArea. Denna resultat vi jämföra med en string( som innehåller (index: string och nya rad).
	 * OBS ser metoder toString()  i ContactBook.
	 *  
	 * @see domain.ContactBook#String toString()
	 */
	
	@Test
	public void laggTill() {
		gui.getInTitle().setText("xxxx");
		gui.getLäggB().doClick();
		gui.getListaB().doClick();
		String nyText = gui.getResultatTA().getText();
		assertEquals("1: xxxx            \n", nyText);
	}

	
	/**
	 * Här testar vi funktionalitet av knappen "Delete".
	 * Först man skriva ut kontakt booken och efter markerar kontakt som vi vill ta bort.
	 * Med hjälp av knappar "Delete" raderar vi kontakt.
	 * Resultatet skrev vi i JTextArea med hjälp av "List" knappen .
	 * 
	 * Texten som finns i JTextArea hämtar vi med hjälp av metoden getText().
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

		assertEquals("", nyText);

	}
	
	/**
	 * Text som vi sätter i JTextFiled-titel skickar vi till JTextArea med hjälp av knappar "Create" och "List". För det använder vi metoden 
	 * doClick() som simulerar en hendelse( att man klickar på knappen). Resultatet som finns som text i JTextArea ligger vi i en string variabel.
	 * 
	 * Nu sätter vi samma texten i JTextFiled-titel en gång till och simulerar "click" av knappen "Search" med metoden doClick().
	 * Resultat sätter vi i andra string variabel. Vi jämföra dessa två stringer och om de är lika vår test passerar. 
	 */

	@Test
	public void sök() {
		gui.getInTitle().setText("yyy");
		gui.getLäggB().doClick();
		gui.getListaB().doClick();
		String input1 = gui.getResultatTA().getText();

		gui.getInTitle().setText("yyy");
		gui.getSökB().doClick();
		String input2 = gui.getResultatTA().getText();

		assertEquals(input2, input1);
	}

}
