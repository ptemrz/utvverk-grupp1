package io.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Contact;
import domain.ContactBook;

public class ReadFileTest {
	private ContactBook cb;

	/**
	 * Nadia H. ReadFile tester testar om filen existerar
	 * 
	 * @throws IOException
	 */

	@BeforeEach
	public void init() {
		cb = new ContactBook();

		cb.add(new Contact("Adam"));
		cb.add(new Contact("Bertil"));
		cb.add(new Contact("Caesar"));
		cb.add(new Contact("David"));
	}

	@Test
	public void readFileTest() throws FileNotFoundException {
		File f = new File("Contact cb");
		FileReader fr = new FileReader(f);
		assertTrue(f.isFile());
	}
	/**
	 * 
	 * @throws IOException
	 */

	@Test
	public void readLineTest() throws IOException {
		Scanner s;
		File f = new File("testfile");
		s = new Scanner(new BufferedReader(new FileReader("testfile")));

		while (s.hasNextLine()) {
			String line = s.nextLine();

			String[] falt = line.split(",");
			for (int i = 0; i < falt.length - 1; i++) {
				if (falt[i].equals("null")) {
					falt[i] = null;
				}
				System.out.println(falt[i]);
			}

		}
	}
}