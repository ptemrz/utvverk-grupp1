package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;

import domain.Contact;
import domain.ContactBook;

public class WriteFile {

	BufferedWriter bw = null;

	/**
	 * Nadia H.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// ta bort
		ContactBook cb = new ContactBook();
		cb.add(new Contact("Adam"));
		cb.add(new Contact("Bertil"));
		writeToFile(cb);

	}

	public static void writeToFile(ContactBook cb) {
		writeToFile(cb, "Contact cb");
	}

	public static void writeToFile(ContactBook cb, String fileName) {
		BufferedWriter bw = null;
		File file = new File(fileName);

		try {
			// Specify the file name and path here
			/*
			 * This logic will make sure that the file gets created if it is not present at
			 * the specified location
			 */
			if (!file.exists()) {
				file.createNewFile();
			}

			StringBuilder sb = new StringBuilder();
			for (Contact lines : cb) {
				String s = lines.getTitle() + "," + lines.getFirstName() + "," + lines.getMiddleName() + ","
						+ lines.getLastName() + "," + lines.getEmail() + "," + lines.getStreetAdress() + ","
						+ lines.getCode() + "," + lines.getCity() + "," + lines.getCountry() + "," + lines.getComment()
						+ "," + lines.getBirthday() + "\n";
				sb.append(s);
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write(sb.toString());
			System.out.println("File written Successfully");

		} catch (IOException ioe) {
			System.out.println("File written poorly");

			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error in closing the BufferedWriter" + ex);
			}
		}
	}
}
