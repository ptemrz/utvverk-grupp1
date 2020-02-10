package domaintest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import domain.Contact;

public class ContactTest {

	@Test
	public void testCompareTo() {
		Contact c1 = new Contact();
		Contact c2 = new Contact();
		
		c1.setFirstName("Adam");
		c1.setLastName("Andersson");
		
		c2.setFirstName("Adam");
		c2.setLastName("Bengtsson");
		
		//c2 greater than c1
		assertTrue(c1.compareTo(c2) < 0);
	}
	
	@Test
	public void testEquals() {
		Contact c1 = new Contact();
		Contact c2 = new Contact();
		
		c1.setFirstName("Adam");
		c1.setLastName("Andersson");
		
		c2.setFirstName("Adam");
		c2.setLastName("Andersson");
		
		assertTrue(c1.equals(c2));
	}
}
