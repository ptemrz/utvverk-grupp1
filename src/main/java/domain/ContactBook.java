package domain;

import java.io.IOException;
import java.util.InputMismatchException;
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

	/**
	 * Saves this ContactBook to permanent storage (hard drive)
	 * 
	 * @return true - if the ContactBook was successfully saved<br>
	 *         false - if any exception is caught
	 */
	public boolean save() {
		try {
			WriteFile.writeToFile(this);
		} catch (Exception e) {
			System.err.println("failed to save ContactBook");
			return false;
		}
		return true;
	}

	/**
	 * Add which disallows duplicates
	 */
	@Override
	public boolean add(Contact c) {
		if (this.contains(c)) {
			return false;
		} else {
			return super.add(c);
		}
	}

	/**
	 * Find contacts by multiple search strings<br>
	 * 
	 * @see find(String searchString)
	 * @param searchStrings
	 * @return
	 */
	public ContactBook find(String[] searchStrings) {
		ContactBook cb = new ContactBook();
		for (String string : searchStrings) {
			if (string.isEmpty()) {
				continue;
			}
			ContactBook temp = find(string);
			for (Contact c : temp) {
				cb.add(c);
			}
		}
		return cb;
	}

	/**
	 * Find contacts by a search string.
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
	 * Silently loads all contacts from a file into this ContactBook. Does not allow
	 * duplicates.
	 * 
	 * @return true if and only if the IO operation succeeds, even if the file is
	 *         empty and no contacts are loaded.
	 */
	public boolean loadContactsFromFile() {
		ReadFile r = new ReadFile();
		ContactBook cb;
		try {
			cb = r.readfile();
		} catch (IOException e) {
			return false;
		}

		for (Contact c : cb) {
			if (!this.contains(c)) {
				add(c);
			}
		}

		return true;
	}

	/**
	 * Remove a contact from this ContactBook by parsing a special String object,
	 * the indexedRow. <br>
	 * An indexedRow begins with an index number followed by a colon. <br>
	 * Example "1: Mr. John Doe 0707123456" <br>
	 * The "1" will be parsed as the index to be removed from the ContactBook. <br>
	 * If the index is out of bounds, nothing will happen. If indexedRow is
	 * malformed, nothing will happen.
	 * 
	 * @param indexedRow
	 */
	public void remove(String indexedRow) {
		Scanner s = new Scanner(indexedRow);
		s.useDelimiter(":");
		int i;
		try {
			i = s.nextInt();
		} catch (InputMismatchException e) {
			s.close();
			return;
		}
		s.close();
		try {
			this.remove(i-1);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("ContactBook error");
		}
	}

	/**
	 * Builds a string from all the contacts in this ContactBook. Each contact will
	 * be on its own row. Each row can be used as an indexedString for the remove
	 * method.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < this.size(); i++) {
			sb.append((i+1) + ": ");
			for (String field : this.get(i).toStringArray()) {
				sb.append(field + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	/**
	 * Two ContactBooks are considered equal if they contain exactly the same
	 * contact information.
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
