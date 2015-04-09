/*
 * Code by: Kevin Maitland
 * Section ID: CST8132 302
 * Lab Teacher: Howard Rosenblum
 * Date: April 7th 2015
 */
package assignment3;

/**
 * @author Kevin A singleton class which checks if a value passed through it is
 *         valid
 *
 */
public class ValidationException extends java.lang.Exception {
	String message;

	/**
	 * @return message the reason the validation exception was called
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * the default constructor for the validationException class
	 */
	public ValidationException() {
		message = "Data not in valid format";
	}

	/**
	 * @param message the message which the validation exception will return
	 */
	public ValidationException(String message) {
		this.message = message;
	}

	/**
	 * @param message the string which the validation exception will return
	 * @param parameter the parameter which the validation exception will throw
	 */
	public ValidationException(String message, Throwable parameter) {
		this.message = message;
	}

	/**
	 * @param parameter the parameter which the validation exception will throw
	 */
	public ValidationException(Throwable parameter) {

	}

}
