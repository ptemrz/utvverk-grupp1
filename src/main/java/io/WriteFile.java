package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import domain.Contact;
import domain.ContactBook;

public class WriteFile {
	BufferedWriter bw = null;

	public static void writeToFile(ContactBook cb) {
		
		File file = new File("Contact cb");
		for(Contact lines: cb) {
			for(String s : lines.toStringArray()) {
				System.out.println(s);
			}
		}
	}

	{

		try {
			String mycontent = "This String would be written" + " to the specified File";
			// Specify the file name and path here
			File file = new File("(...)");

			/*
			 * This logic will make sure that the file gets created if it is not present at
			 * the specified location
			 */
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write(mycontent);
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
