package domain;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import io.ReadFile;

/**
 * Right now a contact book is the same thing as a linked list of contacts,
 * with additional features.
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
	
	/**
	 * 
	 * @param filePath
	 * @throws IOException
	 */
	public void loadContactsFromFile() throws IOException {
		ReadFile r = new ReadFile();
		ContactBook cb = r.readfile();
		this.addAll(cb);
	}
	
	/**
	 * 
	 * @param indexedRow
	 */
	public void remove(String indexedRow) {
		Scanner s = new Scanner(indexedRow);
		s.useDelimiter(":");
		int i = s.nextInt();
		s.close();
		this.remove(i);
	}
	
	/**
	 * 
	 */
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

	/**
	 * 
	 */
	@Override
	public boolean equals(Object o) {
		
		if(! (o instanceof ContactBook)) {
			return false;
		}
		ContactBook c = (ContactBook) o;
		
		if(c.size() != this.size()) {
			return false;
		}
		
		for(int i = 0; i < size(); i++) {
			if(!c.get(i).equals(c.get(i))) {
				return false;
			}
		}
		
		return true;
	}
}
