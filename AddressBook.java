/*
 * Code by: Kevin Maitland
 * Section ID: CST8132 302
 * Lab Teacher: Howard Rosenblum
 * Date: March 27, 2015
 */
package assignment3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AddressBook {
	/*
	 * These are the constants used to generate the menu and in the switch case
	 * statements
	 */
	private static final int ADD_PERSON = 1;
	private static final int REMOVE_PERSON = 2;
	private static final int SORT_FULL_NAME = 3;
	private static final int VIEW_PERSONS = 4;
	private static final int EXIT = 5;

	/*
	 * creates an arraylist of people and a scanner called input
	 */
	ArrayList<Person> Person = new ArrayList<Person>();
	Scanner input = new Scanner(System.in);

	/*
	 * the default constructor for addressbook
	 */
	AddressBook() {

	}

	/*
	 * the method that runs the addressbook program
	 */
	public void runAddressBook() throws ValidationException {

		int num;

		do {
			showMenu();
			num = input.nextInt();
			input.nextLine();

			switch (num) {
			case ADD_PERSON:
				addPerson();
				break;
			case REMOVE_PERSON:
				removePerson();
				break;
			case SORT_FULL_NAME:
				sortByFullName();
				break;
			case VIEW_PERSONS:
				viewPersons();
				break;
			case EXIT:
				System.out.println("Program will exit");
				break;

			}

		} while (num != 5);

	}

	/*
	 * the method that loops over all the entries in the person arraylist and
	 * outputs them using system.out
	 */
	private void viewPersons() {

		for (int i = 0; i < Person.size(); i++) {
			System.out.println("Index " + i + " " + Person.get(i).toString());
		}

	}

	/*
	 * calls the sort class on the arraylist in order to order them by first
	 * names
	 */
	private void sortByFullName() {

		if (Person.isEmpty() == true) {
			System.out.println("Nothing to sort");
		} else {
			Collections.sort(Person, new PersonFullNameComparator());
		}

	}

	/*
	 * this method removes the person at the indicated index, or outputs an
	 * error message if that index is empty
	 */
	private void removePerson() {

		if (Person.isEmpty() == true) {
			System.out.println("Nothing to remove, the list is empty");
		}
		System.out
				.println("Please enter the index number of the person you want to remove: ");
		int i = input.nextInt();
		if (Person.get(i) == null) {
			System.out.println("That index is invalid");
		} else {
			Person.remove(i);
		}

	}

	/*
	 * This method adds a person to the next empty index of the arraylist,
	 * assuming that the entry is valid
	 */
	private void addPerson() throws ValidationException {

		System.out.println("Please enter full name: ");
		String fullName = input.nextLine();
		// input.nextLine();
		System.out.println("Please enter phone number: ");
		String phoneNumber = input.nextLine();
		// input.nextLine();
		System.out.println("Please enter email: ");
		String email = input.nextLine();
		// input.nextLine();
		try {
			Person.add(new Person(fullName, phoneNumber, email));
		} catch (ValidationException ex) {
			System.out.println(ex.getMessage());
		}

	}

	/*
	 * this outputs the menu, using the constants to populate the numbers, so
	 * that even if the constants change, the menu will still be accurate
	 */
	private void showMenu() {

		System.out.println(ADD_PERSON + " - add a person\n" + REMOVE_PERSON
				+ " - remove a person\n" + SORT_FULL_NAME + " - Sort by name\n"
				+ VIEW_PERSONS + " - View persons\n" + EXIT + " - Exit");

	}

}
