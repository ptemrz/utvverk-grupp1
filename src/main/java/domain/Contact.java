package domain;

import java.time.LocalDate;

/**
 * Contact POJO
 * TODO getters, setters, toString, constructors
 * @author ptemrz
 *
 */
public class Contact {
	private String title, firstName, middleName, lastName;
	private String number;
	private String email;
	private String streetAdress, code, city, country;
	private String comment;
	private LocalDate birthday;
	
	public Contact(String firstName) {
		this.firstName = firstName;
	}
	
	@Override
	public String toString() {
		return "Contact [title=" + title + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", number=" + number + ", email=" + email + ", streetAdress=" + streetAdress + ", code="
				+ code + ", city=" + city + ", country=" + country + ", comment=" + comment + ", birthday=" + birthday
				+ "]";
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
}
