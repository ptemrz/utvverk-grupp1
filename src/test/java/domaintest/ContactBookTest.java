package domaintest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
	public void testEquals() {
		ContactBook cb2 = new ContactBook();
		cb2.add(new Contact("Adam"));
		cb2.add(new Contact("Bertil"));
		cb2.add(new Contact("Caesar"));
		cb2.add(new Contact("David"));

		assertEquals(cb, cb2);

	}

	@Test
	public void testFind() {
		List<Contact> found;

		found = cb.find("Adam");
		assertEquals(1, found.size());
	}

	@Test
	public void testFindMoreThanOne() {
		Contact c = new Contact("Adam2");
		cb.add(c);

		List<Contact> found;

		found = cb.find("Adam");
		assertEquals(2, found.size());
	}

	@Test
	public void testFindCorrectContact() {
		Contact c = new Contact("Erik");
		cb.add(c);

		List<Contact> found;

		found = cb.find("Erik");

		assertTrue(c == found.get(0));
	}

	@Test
	public void testRemoveByString() {
		int before = cb.size();
		cb.remove("3: David");
		int after = cb.size();
		assertTrue(before > after);
	}

	@Test
	public void testDontRemoveIfStringIsBad() {
		int before = cb.size();
		cb.remove("5: David");
		int after = cb.size();
		assertTrue(before == after);
	}

	@Test
	public void saveTest() {
		boolean testing = true;
		assertEquals(testing, cb.save());
	}

	@Test
	public void testFindByPhoneNumber() {
		Contact c = new Contact("Erik");
		c.setNumber("0707123456");
		cb.add(c);
		ContactBook found = cb.find("0707123456");

		assertTrue(found.get(0) == c);
	}
}
