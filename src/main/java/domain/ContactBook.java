package domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Right now a contact book is the same thing as a linked list of contacts
 * 
 * @author ptemrz
 *
 */
public class ContactBook extends LinkedList<Contact> {
	private static final long serialVersionUID = 1L;

	
	/**
	 * 
	 * @param searchString the string to find
	 * @return List of all contacts that match the searchString
	 */
	public List<Contact> find(String searchString) {
		List<Contact> contacts = new ArrayList<>();

		for (Contact c : this) {
			for (String s : c.toStringArray()) {
				if (s.equalsIgnoreCase(searchString) || s.contains(searchString)) {
					contacts.add(c);
					break;
				}
			}
		}

		return contacts;
	}
}
