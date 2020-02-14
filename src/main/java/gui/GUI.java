package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;

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

import domain.Contact;
import domain.ContactBook;

/**
 * @author danijela här vi bygger vår Swing application
 *
 */

public class GUI extends JFrame implements ActionListener {
	private JFrame frame = new JFrame("Contacts");
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	// private JLabel infoL = new JLabel("Skriv text i blå rutan och klicka den
	// lämpliga knappen", JLabel.CENTER);
	private JButton listaB = new JButton("List");
	private JButton sökB = new JButton("Search");
	private JButton läggB = new JButton("Create");
	private JButton taBortB = new JButton("Delete");
	private JScrollPane sp;

	// label för TextFields
	private JLabel title = new JLabel("Title");
	private JLabel name = new JLabel("Name");
	private JLabel mName = new JLabel("Middle Name");
	private JLabel lName = new JLabel("Last Name");
	private JLabel phone = new JLabel("Telephone");
	private JLabel email = new JLabel("Email");
	private JLabel street = new JLabel("Street");
	private JLabel code = new JLabel("Code");
	private JLabel city = new JLabel("City");
	private JLabel country = new JLabel("Country");
	private JLabel comment = new JLabel("Comment");
	private JLabel bday = new JLabel("Birthday");

	// här man skriver text
	private JTextField inTitle = new JTextField(10);
	private JTextField inName = new JTextField(10);
	private JTextField inMname = new JTextField(10);
	private JTextField inLname = new JTextField(10);
	private JTextField inPhone = new JTextField(10);
	private JTextField inEmail = new JTextField(10);
	private JTextField inStreet = new JTextField(10);
	private JTextField inCode = new JTextField(10);
	private JTextField inCity = new JTextField(10);
	private JTextField inCountry = new JTextField(10);
	private JTextField inComment = new JTextField(10);
	private JTextField inBDay = new JTextField(10);

	// Här man ser resultat efter mak klicka på knappen
	private JTextArea resultatTA = new JTextArea(50, 50); // 20 rader, 1 kolumn
	
	public GUI() {
		
		inTitle.setBackground(Color.lightGray);
		inTitle.setPreferredSize(new Dimension(200, 25));

		inName.setBackground(Color.lightGray);
		inName.setPreferredSize(new Dimension(200, 25));

		inMname.setBackground(Color.lightGray);
		inMname.setPreferredSize(new Dimension(200, 25));

		inLname.setBackground(Color.lightGray);
		inLname.setPreferredSize(new Dimension(200, 25));

		inPhone.setBackground(Color.lightGray);
		inPhone.setPreferredSize(new Dimension(200, 25));

		inEmail.setBackground(Color.lightGray);
		inEmail.setPreferredSize(new Dimension(200, 25));

		inStreet.setBackground(Color.lightGray);
		inStreet.setPreferredSize(new Dimension(200, 25));

		inCode.setBackground(Color.lightGray);
		inCode.setPreferredSize(new Dimension(200, 25));

		inCity.setBackground(Color.lightGray);
		inCity.setPreferredSize(new Dimension(200, 25));

		inCountry.setBackground(Color.lightGray);
		inCountry.setPreferredSize(new Dimension(200, 25));

		inComment.setBackground(Color.lightGray);
		inComment.setPreferredSize(new Dimension(200, 25));

		inBDay.setBackground(Color.lightGray);
		inBDay.setPreferredSize(new Dimension(200, 25));

		resultatTA.setBackground(Color.lightGray);
		resultatTA.setFont(new Font("SansSeriff", Font.PLAIN, 14));
		// resultatTA.setPreferredSize(new Dimension(380,200));

		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel1.setBackground(Color.white);
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel2.setBackground(Color.white);
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel3.setBackground(Color.white);
		
		// panel1.add(infoL);
		panel1.setLayout(new GridLayout(12,2));//2 rader 1 kolumn
		panel1.add(title);  panel1.add(inTitle);
		panel1.add(name);   panel1.add(inName);
		panel1.add(mName);  panel1.add(inMname);
		panel1.add(lName);  panel1.add(inLname);
		panel1.add(phone);  panel1.add(inPhone);
		panel1.add(email);  panel1.add(inEmail);
		panel1.add(street); panel1.add(inStreet);
		panel1.add(code);   panel1.add(inCode);
		panel1.add(city);  	panel1.add(inCity);
		panel1.add(country);panel1.add(inCountry);
		panel1.add(comment);panel1.add(inComment);
		panel1.add(bday);   panel1.add(inBDay);
		
		panel2.add(listaB);
		panel2.add(sökB);
		panel2.add(läggB);
		panel2.add(taBortB);

		panel1.setBorder(new TitledBorder(new EtchedBorder()));
		panel2.setBorder(new TitledBorder(new EtchedBorder()));
		panel3.setBorder(new TitledBorder(new EtchedBorder()));

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
				boolean s = cb.loadContactsFromFile();
				if (s == true)
					resultatTA.setText(cb.toString());
				else
					resultatTA.setText("Listan är tom");				
				
			}
		}

		/**
		 * kontakt som vill man leta efter i kontaktboken först behöver man att skriva i
		 * JTextFiled och sen klicka på knappen "sök" .Om kontakt finns i kontaktboken
		 * resultatet är skriven iJTextArea, men om där finns inte kontakten i boken får
		 * man meddelande om där finns inte denna kontakt.
		 *
		 */
		if (e.getSource() == sökB) {

			String titleStr = inTitle.getText();
			String nameStr = inTitle.getText();	
			String mNameStr=inMname.getText();
			String lNameStr=inLname.getText();
			String phoneStr=inPhone.getText();
			String emailStr=inEmail.getText();
			String streetStr=inStreet.getText();
			String codeStr=inCode.getText();
			String cityStr=inCity.getText();
			String countryStr=inCountry.getText();
			String commentStr=inComment.getText();
			String bDayStr= inBDay.getText();
			
			String[] data= {titleStr,nameStr,mNameStr,lNameStr,phoneStr,emailStr,streetStr,codeStr,cityStr,countryStr,commentStr, bDayStr};
			
			ContactBook temp = cb.find(data);
			if (temp.isEmpty()) {
				resultatTA.setText("Kontakt finns inte i boken! " );
				
			}else {
				resultatTA.setText(temp.toString());
				
			}
			
			
//			if (!cb.find(titleStr).toString().equals(null))
//				resultatTA.setText(cb.find(inTitle.getText()).toString());
////			else
////				resultatTA.setText("No results found " + inTitle.getText());
//								
//			else if (!cb.find(nameStr).toString().equals(null))
//				resultatTA.setText(cb.find(inName.getText()).toString());
////			else
////				resultatTA.setText("No results found " + inName.getText());
////						
//			else if (!cb.find(mNameStr).toString().equals(null))
//				resultatTA.setText(cb.find(inMname.getText()).toString());
////			else
////				resultatTA.setText("No results found " + inMname.getText());
//						
//			else if (!cb.find(lNameStr).toString().equals(null))
//				resultatTA.setText(cb.find(inLname.getText()).toString());
////			else
////				resultatTA.setText("No results found " + inLname.getText());
//			
//			
//			else if (!cb.find(phoneStr).toString().equals(null))
//				resultatTA.setText(cb.find(inPhone.getText()).toString());
////			else
////				resultatTA.setText("No results found " + inPhone.getText());
//			
//			
//			else if (!cb.find(emailStr).toString().equals(null))
//				resultatTA.setText(cb.find(inEmail.getText()).toString());
////			else
////				resultatTA.setText("No results found " + inEmail.getText());
//			
//			
//			else if (!cb.find(streetStr).toString().equals(null))
//				resultatTA.setText(cb.find(inStreet.getText()).toString());
////			else
////				resultatTA.setText("No results found " + inStreet.getText());
//			
//			
//			else if (!cb.find(codeStr).toString().equals(null))
//				resultatTA.setText(cb.find(inCode.getText()).toString());
////			else
////				resultatTA.setText("No results found " + inCode.getText());
//			
//			
//			else if (!cb.find(cityStr).toString().equals(null))
//				resultatTA.setText(cb.find(inCity.getText()).toString());
////			else
////				resultatTA.setText("No results found " + inCity.getText());
//			
//			
//			else if (!cb.find(countryStr).toString().equals(null))
//				resultatTA.setText(cb.find(inCountry.getText()).toString());
////			else
////				resultatTA.setText("No results found " + inCountry.getText());
//			
//			
//			else if (!cb.find(commentStr).toString().equals(null))
//				resultatTA.setText(cb.find(inComment.getText()).toString());
////			else
////				resultatTA.setText("No results found " + inComment.getText());
//			else if (!cb.find(bDayStr).toString().equals(""))
////				resultatTA.setText(cb.find(inBDay.getText()).toString());
			
			
			
//			String bDayStr=inBDay.getText();
//			if (!cb.find(bDayStr).toString().equals(""))
//				resultatTA.setText(cb.find(inBDay.getText()).toString());
//			else
//				resultatTA.setText("No results found " + inBDay.getText());
//			else
//				resultatTA.setText("Kontakt finns inte i boken! " );
//			
//			
			
			
			
			
			
		}

		/**
		 * Om man vill att lägga till en nya kontakt i boken behöver man att skriva
		 * denna nya kontakt i JTextFiled och sen klicka på knappen "Lägga till". Om man
		 * vill se resultat behöver man att klicka knappen "lista" och man kan se i
		 * JTextArea alla kontakter som finns i boken. Den nya kontakten finns också
		 * där.
		 */
		if (e.getSource() == läggB) {

			Contact nyCon = new Contact();
			nyCon.setTitle(inTitle.getText());
			nyCon.setFirstName(inName.getText());
			nyCon.setMiddleName(inMname.getText());
			nyCon.setLastName(inLname.getText());
			nyCon.setNumber(inPhone.getText());
			nyCon.setEmail(inEmail.getText());
			nyCon.setStreetAdress(inStreet.getText());
			nyCon.setCode(inCode.getText());
			nyCon.setCity(inCity.getText());
			nyCon.setCountry(inCountry.getText());
			nyCon.setComment(inComment.getText());
			//nyCon.setBirthday(inBDay.getText());
			cb.add(nyCon);
			cb.save();
			inTitle.setText(null);
			inName.setText(null);
			inMname.setText(null);
			inLname.setText(null);
			inPhone.setText(null);
			inEmail.setText(null);
			inStreet.setText(null);
			inCode.setText(null);
			inCity.setText(null);
			inCountry.setText(null);
			inComment.setText(null);
			//inBDay.setText(null);
			
			
		}

		/**
		 * Om man vill att ta bort en kontakt fron boken behöver man först att skriva
		 * denna kontakt i JTextFiled och sen klicka på knappen "ta bort". Om man vill
		 * se resultat behöver man att klicka knappen "lista" och man kan se i JTextArea
		 * alla kontakter som finns i boken. Denna kontakten som man vill ta bort finns
		 * inte längre i kontaktboken.
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

	public JTextField getInTitle() {
		return inTitle;
	}

	public void setInTitle(JTextField inTitle) {
		this.inTitle = inTitle;
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
	
	public JTextField getInName() {
		return inName;
	}

	public void setInName(JTextField inName) {
		this.inName = inName;
	}

	public JTextField getInMname() {
		return inMname;
	}

	public void setInMname(JTextField inMname) {
		this.inMname = inMname;
	}

	public JTextField getInLname() {
		return inLname;
	}

	public void setInLname(JTextField inLname) {
		this.inLname = inLname;
	}

	public JTextField getInPhone() {
		return inPhone;
	}

	public void setInPhone(JTextField inPhone) {
		this.inPhone = inPhone;
	}

	public JTextField getInEmail() {
		return inEmail;
	}

	public void setInEmail(JTextField inEmail) {
		this.inEmail = inEmail;
	}

	public JTextField getInStreet() {
		return inStreet;
	}

	public void setInStreet(JTextField inStreet) {
		this.inStreet = inStreet;
	}

	public JTextField getInCode() {
		return inCode;
	}

	public void setInCode(JTextField inCode) {
		this.inCode = inCode;
	}

	public JTextField getInCity() {
		return inCity;
	}

	public void setInCity(JTextField inCity) {
		this.inCity = inCity;
	}

	public JTextField getInCountry() {
		return inCountry;
	}

	public void setInCountry(JTextField inCountry) {
		this.inCountry = inCountry;
	}

	public JTextField getInComment() {
		return inComment;
	}

	public void setInComment(JTextField inComment) {
		this.inComment = inComment;
	}

	public JTextField getInBDay() {
		return inBDay;
	}

	public void setInBDay(JTextField inBDay) {
		this.inBDay = inBDay;

	}
	
}
