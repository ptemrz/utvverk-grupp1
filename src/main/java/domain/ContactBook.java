package domain;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import io.ReadFile;
import io.WriteFile;

/**
 * Right now a contact book is the same thing as a linked list of contacts, with
 * additional features.
 * 
 * @author ptemrz
 *
 */
public class ContactBook extends LinkedList<Contact> {
	private static final long serialVersionUID = 1L;

	
	@Override
	public boolean add(Contact c) {
		try {
			super.add(c);
			WriteFile.writeToFile(this);
		} catch(Exception e) {
			System.err.println("failed to add contact");
		}
		return true;
		
	}
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
	 * Silently loads all contacts from a file into this ContactBook.
	 * Does not allow duplicates.
	 * 
	 * @return true iff the IO operation succeeds, even if the file is empty and no contacts are loaded.
	 */
	public boolean loadContactsFromFile() {
		ReadFile r = new ReadFile();
		ContactBook cb;
		try {
			cb = r.readfile();
		} catch (IOException e) {
			return false;
		}
		for(Contact c: cb) {
			if(!this.contains(c)) {
				add(c);
			}
		}

		return true;
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

		for (Contact c : this) {
			sb.append(this.indexOf(c) + ": ");
			for (String field : c.toStringArray()) {
				sb.append(field + " ");
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

		if (!(o instanceof ContactBook)) {
			return false;
		}
		ContactBook c = (ContactBook) o;

		if (c.size() != this.size()) {
			return false;
		}

		for (int i = 0; i < size(); i++) {
			if (!c.get(i).equals(this.get(i))) {
				return false;
			}
		}

		return true;
	}
}
