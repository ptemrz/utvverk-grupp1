package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import domain.*;

/**
 *@author danijela 
 * här vi bygger vår Swing application
 *
 */

public class GUI extends JFrame implements ActionListener {
	private JFrame frame = new JFrame("Kontaktbok");
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	// private JLabel infoL = new JLabel("Skriv text i blå rutan och klicka den
	// lämpliga knappen", JLabel.CENTER);
	private JButton listaB = new JButton("Lista");


	private JButton sökB = new JButton("Sök");
	private JButton läggB = new JButton("Lägg");
	private JButton taBortB = new JButton("Ta bort");
	private JScrollPane sp;
	// här man skriver text
	private JTextField skrivInTF = new JTextField();

	// Här man ser resultat efter mak klicka på knappen
	private JTextArea resultatTA = new JTextArea(50, 50); // 20 rader, 1 kolumen

	public GUI() {
		skrivInTF.setBackground(Color.CYAN);
		skrivInTF.setPreferredSize(new Dimension(200, 25));

		resultatTA.setBackground(Color.GREEN);
		// resultatTA.setPreferredSize(new Dimension(380,200));

		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel1.setBackground(Color.GREEN);
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel2.setBackground(Color.GREEN);
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel3.setBackground(Color.GREEN);

		// panel1.add(infoL);
		panel1.add(skrivInTF);
		panel2.add(listaB);
		panel2.add(sökB);
		panel2.add(läggB);
		panel2.add(taBortB);

		panel1.setBorder(new TitledBorder(new EtchedBorder(), "Skriv text i blå rutan"));
		panel2.setBorder(new TitledBorder(new EtchedBorder(), "Klicka på den lämpliga knappen"));
		panel3.setBorder(new TitledBorder(new EtchedBorder(), "Resultat"));

		resultatTA.setEditable(false); // set textArea non-editable

		// resultat ligger i JSCrollPane för att ha scroller
		sp = new JScrollPane(resultatTA);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		frame.add(panel1);
		frame.add(panel2);
		frame.add(sp);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 1));
		// frame.pack();
		frame.setSize(500, 650);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		listaB.addActionListener(this);
		sökB.addActionListener(this);
		läggB.addActionListener(this);
		taBortB.addActionListener(this);

	}



	ContactBook cb = new ContactBook();

	@Override
	public void actionPerformed(ActionEvent e) {
		
		/**
		 * när man klicka på knappen "Lista" ligger innehåll från kontaktboken till
		 * JTextArea 
		 */

		if (e.getSource() == listaB) {
			{
				boolean s=cb.loadContactsFromFile();
				if(s==true)
				resultatTA.setText(cb.toString());
				else
				resultatTA.setText("Lista är tomt");
			}
		}
		


		/**
		 * kontakt som vill man leta efter i kontaktboken först behöver man att
		 * skriva i JTextFiled och sen klicka på knappen "sök" .Om kontakt finns i kontaktboken resultatet är skriven
		 * iJTextArea, men om där finns inte kontakten i boken får man meddelande om där finns inte denna kontakt.
		 *
		 */
		if (e.getSource() == sökB) {

			
			String input = skrivInTF.getText();
			if (!cb.find(input).toString().equals(""))
				resultatTA.setText(cb.find(skrivInTF.getText()).toString());
			else
				resultatTA.setText("Där finns inte " + skrivInTF.getText());
		}

		/**
		 * Om man vill att lägga till en nya kontakt i boken behöver man att skriva denna nya kontakt i JTextFiled och
		 * sen klicka på knappen "Lägga till". Om man vill se resultat behöver man att klicka knappen "lista" och man kan se
		 * i JTextArea alla kontakter som finns i boken. Den nya kontakten finns också där.
		 */
		if (e.getSource() == läggB) {

			Contact nyCon = new Contact();
			nyCon.setFirstName(skrivInTF.getText());
			cb.add(nyCon);
			cb.save();
		}

		/**
		 * Om man vill att ta bort en kontakt fron boken behöver man först att skriva denna kontakt i JTextFiled och
		 * sen klicka på knappen "ta bort". Om man vill se resultat behöver man att klicka knappen "lista" och man kan se
		 * i JTextArea alla kontakter som finns i boken. Denna kontakten som man vill ta bort finns inte längre i kontaktboken.
		 */
		if (e.getSource() == taBortB) {

			cb.remove(resultatTA.getSelectedText());
			cb.save();

		}

	}


	public JButton getListaB() {
		return listaB;
	}

	public void setListaB(JButton listaB) {
		this.listaB = listaB;
	}
	public JButton getSökB() {
		return sökB;
	}

	public void setSökB(JButton sökB) {
		this.sökB = sökB;
	}

	public JButton getTaBortB() {
		return taBortB;
	}

	public void setTaBortB(JButton taBortB) {
		this.taBortB = taBortB;
	}

	public JTextField getSkrivInTF() {
		return skrivInTF;
	}

	public void setSkrivInTF(JTextField skrivInTF) {
		this.skrivInTF = skrivInTF;
	}
	
	public JButton getLäggB() {
		return läggB;
	}

	public void setLäggB(JButton läggB) {
		this.läggB = läggB;
	}

	public JTextArea getResultatTA() {
		return resultatTA;
	}

	public void setResultatTA(JTextArea resultatTA) {
		this.resultatTA = resultatTA;
	}


}
