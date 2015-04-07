/*
 * Code by: Kevin Maitland
 * Section ID: CST8132 302
 * Lab Teacher: Howard Rosenblum
 * Date: March 27, 2015
 */

package assignment3;

public class Person {
	// Fields used throughout the Person class
	private String fullName, phoneNumber, email;

	/*
	 * Overloaded Person constructor - checks if the given data is valid then
	 * sets the local variables to the values passed into it if they are valid
	 */
	Person(String fullName, String phoneNumber, String email)
			throws ValidationException {

		this.fullName = fullName;
		validateString("Full name", 35, fullName);
		this.phoneNumber = phoneNumber;
		validateString("Phone nmber", 15, phoneNumber);
		this.email = email;
		validateString("email", 50, email);
	}

	/*
	 * Default Person constructor - not used
	 */
	Person() {

	}

	/*
	 * This returns the full name of the person
	 */
	public String getFullName() {

		return fullName;

	}

	/*
	 * this sets the full name of the person and verifies that it is valid
	 */
	public void setFullName(String fullName) throws ValidationException {

		validateString("fullName", 50, fullName);
		this.fullName = fullName;

	}

	/*
	 * This gets the phone number of the person
	 */
	public String getPhoneNumber() {

		return phoneNumber;

	}

	/*
	 * This sets the phone number of the person, after checking if it is valid
	 */
	public void setPhoneNumber(String phoneNumber) throws ValidationException {

		validateString("phoneNumber", 15, phoneNumber);
		this.phoneNumber = phoneNumber;

	}

	/*
	 * This returns the email of the person
	 */
	public String getEmail() {

		return email;

	}

	/*
	 * this sets the email of the person, after checking that it is valid
	 */
	public void setEmail(String email) throws ValidationException {

		validateString("email", 50, email);
		this.email = email;

	}

	@Override
	/*
	 * this pulls the persons data together into one string
	 */
	public String toString() {
		StringBuilder details = new StringBuilder("Person: ").append(fullName)
				.append(", ").append(phoneNumber).append(", ").append(email);
		return details.toString();
	}

	/*
	 * this checks if the value passed through it is valid for the field type,
	 * and throws an exception if it is not
	 */
	public void validateString(String fieldName, int maxLength, String value)
			throws ValidationException {

		if (value == null) {
			ValidationException vE = new ValidationException("The " + fieldName
					+ " cannot be null");
			throw vE;
		} else if (value.isEmpty() == true) {
			ValidationException vE = new ValidationException("The " + fieldName
					+ " cannot be empty");
			throw vE;
		} else if (value.trim().length() == 0) {
			ValidationException vE = new ValidationException("The " + fieldName
					+ " cannot consist of only whitespace");
			throw vE;
		} else if (value.length() > maxLength) {
			ValidationException vE = new ValidationException("The " + fieldName
					+ " was too long");
			throw vE;
		} else if (value.contains(",")) {
			ValidationException vE = new ValidationException("The " + fieldName
					+ " cannot contain a comma");
			throw vE;
		}

	}

}
