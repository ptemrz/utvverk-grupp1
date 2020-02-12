package io.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Contact;
import domain.ContactBook;
import io.ReadFile;
import io.WriteFile;

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
		assertTrue(f.isFile());
	}
	@Test
	public void readFileIsCorrectTest() throws IOException {	
		WriteFile.writeToFile(cb, "tesfile");
		ReadFile rf = new ReadFile();
		assertEquals(cb, rf.readfile());

	}
}
