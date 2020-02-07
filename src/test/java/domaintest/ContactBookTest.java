package domaintest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Contact;
import domain.ContactBook;

public class ContactBookTest {
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
	public void testFind() {
		List<Contact> found;
		
		found = cb.find("Adam");
		assertEquals(1, found.size());
	}
}
