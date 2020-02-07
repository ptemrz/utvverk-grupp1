package domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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
	 * @return A new contact book with contacts that match the searchString
	 */
	public ContactBook find(String searchString) {
		ContactBook foundContacts = new ContactBook();

		for (Contact c : this) {
			for (String s : c.toStringArray()) {
				if (s.equalsIgnoreCase(searchString) || s.contains(searchString)) {
					foundContacts.add(c);
					break;
				}
			}
		}

		return foundContacts;
	}
	
	public void remove(String indexedRow) {
		Scanner s = new Scanner(indexedRow);
		s.useDelimiter(":");
		int i = s.nextInt();
		s.close();
		this.remove(i);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(Contact c : this) {
			sb.append(this.indexOf(c)+": ");
			for (String field : c.toStringArray()) {
				sb.append(field+" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
