package domaintest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import domain.Contact;

@SuppressWarnings("deprecation")
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
	
	@Test
	public void testSetBirthday() {
		Contact c = new Contact("Adam");
		c.setBirthday("1990-01-01");
		LocalDate birthday = LocalDate.of(1990, 01, 01);
		assertEquals(birthday, c.getBirthday());
	}
	
	@Test
	public void testSetBirthdayBadFormat() {
		Contact c = new Contact("Adam");
		assertThrows(IllegalArgumentException.class, () -> c.setBirthday("19900101"));
	}
}
