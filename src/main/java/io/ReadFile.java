package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import domain.Contact;
import domain.ContactBook;

public class ReadFile {
	Scanner s = null;
	BufferedReader br = null;
	String result;

	ContactBook cb = new ContactBook();

	/**
	 * Nadia H.
	 * 
	 * @return
	 * @throws IOException
	 */
	public ContactBook readfile() throws IOException {
		File file = new File("Contact cb");
		FileReader fr = null;
		{

			try {
				fr = new FileReader(file);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			s = new Scanner(new BufferedReader(new FileReader("Contact cb")));

			while (s.hasNextLine()) {
				String line = s.nextLine();
				String[] falt = line.split("; ");

				Contact c = new Contact();

				c.setTitle(falt[0]);
				c.setFirstName(falt[1]);
				c.setFirstName(falt[2]);
				c.setMiddleName(falt[3]);
				c.setLastName(falt[4]);
				c.setEmail(falt[5]);
				c.setStreetAdress(falt[6]);
				c.setCode(falt[7]);
				c.setCity(falt[8]);
				c.setCountry(falt[9]);
				c.setComment(falt[10]);
				c.setBirthday(null);

				cb.add(c);

			}
			br = new BufferedReader(fr);
			try {
				result = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cb;
	}
}