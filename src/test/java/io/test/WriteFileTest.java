package io.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Contact;
import domain.ContactBook;
import io.ReadFile;
import io.WriteFile;

public class WriteFileTest {
	private ContactBook cb;

	@BeforeEach
	public void init() {
		cb = new ContactBook();

		cb.add(new Contact("Adam"));
		cb.add(new Contact("Bertil"));
		cb.add(new Contact("Caesar"));
		cb.add(new Contact("David"));
	}

	@Test
	public void writeToFileTest() {
		File f = new File("testfile");
		f.delete();
		WriteFile.writeToFile(cb, "testfile");
		assertTrue(f.exists());

	}

	/// *@Test
	// public void writeToFileIsCorrectTest() throws IOException {
	// WriteFile.writeToFile(cb, "testfile");
	// ReadFile rf = new ReadFile();
	// assertEquals(rf.readfile("testfile"), cb);
	// */
}
