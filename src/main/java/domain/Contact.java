package domain;

import java.time.LocalDate;

/**
 * Contact POJO
 * 
 * @author ptemrz
 *
 */
public class Contact implements Comparable<Contact> {
	private String title, firstName, middleName, lastName;
	private String number;
	private String email;
	private String streetAdress, code, city, country;
	private String comment;
	private LocalDate birthday;

	/**
	 * Creates a contact with no contact information. Contact information must be
	 * set with the setter methods. The use of the empty constructor is discouraged.
	 * 
	 * @deprecated
	 */
	public Contact() {
		super();
		// Null contact
	}

	public Contact(String firstName) {
		super();
		this.firstName = firstName;
	}

	public Contact(String title, String firstName, String middleName, String lastName, String number, String email,
			String streetAdress, String code, String city, String country, String comment, LocalDate birthday) {
		super();
		this.title = title;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.number = number;
		this.email = email;
		this.streetAdress = streetAdress;
		this.code = code;
		this.city = city;
		this.country = country;
		this.comment = comment;
		this.birthday = birthday;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreetAdress() {
		return streetAdress;
	}

	public void setStreetAdress(String streetAdress) {
		this.streetAdress = streetAdress;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	/**
	 * @param birthday
	 */
	public void setBirthday(String birthday) {
		String[] split = birthday.split("-");
		try {
			this.birthday = LocalDate.of(Integer.parseInt(split[0]), Integer.parseInt(split[1]),
					Integer.parseInt(split[2]));
		} catch (Exception e) {
			System.err.println("Failed to set birthday for contact " + getFirstName() + " " + getLastName());
		}

	}

	public String[] toStringArray() {
		String bDay = "";
		if (birthday != null) {
			bDay = birthday.toString();
		}

		String[] allFields = { title, firstName, middleName, lastName, number, email, streetAdress, code, city, country,
				comment, bDay };

		for (int i = 0; i < allFields.length; i++) {
			if (allFields[i] == null) {
				allFields[i] = "";
			}
		}
		return allFields;
	}

	@Override
	public String toString() {
		return "Contact [title=" + title + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", number=" + number + ", email=" + email + ", streetAdress=" + streetAdress + ", code="
				+ code + ", city=" + city + ", country=" + country + ", comment=" + comment + ", birthday=" + birthday
				+ "]";
	}

	/**
	 * Compare last names lexicographically
	 */
	@Override
	public int compareTo(Contact o) {
		return lastName.compareTo(o.getLastName());
	}

	/**
	 * @return true iff all fields are equal
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Contact)) {
			return false;
		}
		Contact c = (Contact) o;

		String[] fThis = this.toStringArray();
		String[] fOther = c.toStringArray();

		for (int i = 0; i < fThis.length; i++) {
			if (!fThis[i].equalsIgnoreCase(fOther[i])) {
				return false;
			}
		}

		return true;
	}
}
