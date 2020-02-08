package io.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Contact;
import domain.ContactBook;

public class ReadFileTest {
	
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
		public void readFileTest() throws FileNotFoundException {
			File f = new File("Contact cb");
			FileReader fr = new FileReader(f);
			assertTrue(f.isFile());
			
		}
		
		@Test
		
		public void readLineTest() {
			Contact c = new Contact();
			String s = "Adam; Laura; Maria";
			String[] falt = s.split("; ");
			c.setFirstName(falt[0]);
			assertEquals(c.getFirstName(), "Adam");
			
			
			
			

		}

	
}
