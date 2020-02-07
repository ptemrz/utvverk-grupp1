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
 * 
 * @author danijela
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
		frame.setSize(500, 700);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		listaB.addActionListener(this);
		sökB.addActionListener(this);
		läggB.addActionListener(this);
		taBortB.addActionListener(this);

	}
	
	
	public JTextArea getResultatTA() {
		return resultatTA;
	}

	public void setResultatTA(JTextArea resultatTA) {
		this.resultatTA = resultatTA;
	}

	ContactBook cb = new ContactBook();

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == listaB) {
			{
				resultatTA.setText(cb.toString());
			}
		}

		if (e.getSource() == sökB) {
			// metod2
		}

		if (e.getSource() == läggB) {

			Contact nyCon = new Contact();
			nyCon.setFirstName(skrivInTF.getText());
			cb.add(nyCon);
		}

		if (e.getSource() == taBortB) {
//			String taBort = resultatTA.getSelectedText();
//			String allt = resultatTA.getText();
//			allt = allt.replaceAll(taBort, "");
			cb.remove(resultatTA.getSelectedText());
			resultatTA.setText(cb.toString());
			

		}

	}

}
