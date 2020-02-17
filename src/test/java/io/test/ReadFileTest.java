package io.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Contact;
import domain.ContactBook;
import io.ReadFile;
import io.WriteFile;

public class ReadFileTest {
	private ContactBook cb;

	/**
	 * @author Nadia H. 
	 * ReadFile tester testar om filen existerar och den inte är ifylld
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
	public void ReadFileIsReadingTest() throws IOException {
		ContactBook a = new ContactBook();
		WriteFile.writeToFile(a, "test2");
		ReadFile rf = new ReadFile();
		a = rf.readfile("test2");
		assertTrue(a.isEmpty());		
	}
	
	/**
	 * Testar att metoden kan skilja ifrån olika filen 
	 * @throws IOException
	 */
	@Test
	public void readFileReadCorrectTest() throws IOException {

		ContactBook c = new ContactBook();
		c.addAll(cb);
		WriteFile.writeToFile(c, "test2");
		ReadFile rf = new ReadFile();
		ContactBook a = rf.readfile("test2");
		assertEquals(a, c);

	}
	/**
	 * raderar alla onödiga filer
	 */
	@AfterEach
	public void deleteFileTest() {
		File f = new File("test2");
		f.delete();
	}
}