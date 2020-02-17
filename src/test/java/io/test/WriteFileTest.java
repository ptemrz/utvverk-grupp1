package io.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
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
		File f = new File("test2");
		f.delete();
		WriteFile.writeToFile(cb, "test2");
		Assertions.assertTrue(f.exists());
	}

	@Test
	public void writeToFileIsCorrectTest() throws IOException {
		ContactBook c = new ContactBook();
		ReadFile rf = new ReadFile();
		WriteFile.writeToFile(cb, "test2");
		c = rf.readfile("test2");
		assertEquals(cb, c);
	}

	@Test
	public void writeToFileWritesCorrectTest() throws IOException {
		WriteFile.writeToFile(cb, "test2");
		// Contact c = new Contact();
		ReadFile rf = new ReadFile();
		ContactBook a = rf.readfile("test2");
		assertFalse(cb.contains(a));
	}

	@Test
	public void writeToFileNullsTest() {
		File f = new File("test2");
		f.delete();
		WriteFile.writeToFile(cb, "test2");
		assertFalse(cb.isEmpty());
	}

	@AfterEach
	public void deleteFileTest() {
		File f = new File("test2");
		f.delete();
	}
}
