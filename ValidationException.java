/*
 * Code by: Kevin Maitland
 * Section ID: CST8132 302
 * Lab Teacher: Howard Rosenblum
 * Date: March 27, 2015
 */
package assignment3;

public class ValidationException extends java.lang.Exception {
	String message;
	/*
	 *returns the message set when a new validationException is created
	 */
	public String getMessage() {
		return message;
	}
	
	/*
	 * the default constructor for the validationException class
	 */
	public ValidationException() {
		message = "Data not in valid format";
	}
	
	/*
	 * an overloaded constructor which takes a message as the argument
	 */
	public ValidationException (String message){
		this.message = message;
	}
	
	/*
	 * an overloaded constructor which takes a message and a parameter as arguments
	 */
	public ValidationException (String message, Throwable parameter){
		this.message = message;
	}
	
	/*
	 * an overloaded constructor which takes a throwable parameter as an argument
	 */
	public ValidationException (Throwable parameter){
		
	}

}
