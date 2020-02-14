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
				System.out.println("File doesn't exist or is empty");
			}
			s = new Scanner(new BufferedReader(new FileReader("Contact cb")));

			while (s.hasNextLine()) {
				String line = s.nextLine();

				String[] falt = line.split(",");
				for (int i = 0; i < falt.length - 1; i++) {
					if (falt[i].equals("null")) {
						falt[i] = null;
					}
				}
				Contact c = new Contact();

				c.setTitle(falt[0]);
				c.setFirstName(falt[1]);
				c.setMiddleName(falt[2]);
				c.setLastName(falt[3]);
				c.setEmail(falt[4]);
				c.setStreetAdress(falt[5]);
				c.setCode(falt[6]);
				c.setCity(falt[7]);
				c.setCountry(falt[8]);
				c.setComment(falt[9]);
				c.setBirthday(null);

				cb.add(c);

			}
			br = new BufferedReader(fr);
			try {
				result = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return cb;
	}
}