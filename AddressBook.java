/*
 * Code by: Kevin Maitland
 * Section ID: CST8132 302
 * Lab Teacher: Howard Rosenblum
 * Date: April 7th 2015
 */
package assignment3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.Scanner;

/**
 * The largest class file. It contains methods to add and remove people, to sort
 * and view the people in the address book and to save and load the address book
 * 
 * @author Kevin
 * @version 2.0
 * @since 2015-04-07
 */
public class AddressBook {
	/**
	 * These are the constants used to generate the menu and in the switch case
	 * statements
	 */
	private static final int ADD_PERSON = 1;
	private static final int REMOVE_PERSON = 2;
	private static final int SORT_FULL_NAME = 3;
	private static final int VIEW_PERSONS = 4;
	private static final int SAVE_ADDRESS_BOOK = 5;
	private static final int LOAD_ADDRESS_BOOK = 6;
	private static final int EXIT = 7;

	/**
	 * creates an arraylist of people and a scanner called input
	 */
	ArrayList<Person> Person = new ArrayList<Person>();
	Scanner input = new Scanner(System.in);

	/**
	 * @param none
	 *            needed
	 * @return nothing the default constructor for addressbook
	 */
	AddressBook() {

	}

	/**
	 * @param none
	 *            needed
	 * @exception IOException
	 *                On input error
	 * @exception ValidationException
	 *                on invalid person data the method that runs the
	 *                addressbook program
	 */
	public void runAddressBook() throws ValidationException, IOException {

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
			case SAVE_ADDRESS_BOOK:
				saveAddressBook();
				break;
			case LOAD_ADDRESS_BOOK:
				loadAddressBook();
				break;
			case EXIT:
				System.out.println("Program will exit");
				break;

			}

		} while (num != EXIT);

	}

	/**
	 * @throws FileNotFoundException
	 *             if addressbook.txt cannot be found loads the details of the
	 *             last saved addressbook from the addressbook.txt file
	 */
	private void loadAddressBook() throws FileNotFoundException {
		Person.clear();
		File file = new File("addressbook.txt");
		String line = null;
		Scanner inLine = new Scanner(file);
		System.out.println("Loading people from addressbook.txt");
		while (inLine.hasNextLine()) {
			line = inLine.nextLine();
			String[] arrayLine = line.split(",");
			String tempName = arrayLine[0];
			String tempPhone = arrayLine[1];
			String tempEmail = arrayLine[2];
			try {
				Person.add(new Person(tempName, tempPhone, tempEmail));
			} catch (ValidationException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @throws IOException
	 *             saves the current addressbook to the addressbook.txt file.
	 *             Currently only supports a single saved addressbook
	 */
	private void saveAddressBook() throws IOException {
		File file = new File("addressbook.txt");
		Formatter out = new Formatter(new FileWriter(
				new File("addressbook.txt")));
		System.out.println("Saving people to addressbook.txt");
		for (int i = 0; i < Person.size(); i++) {
			StringBuilder rawData = new StringBuilder(Person.get(i)
					.getFullName()).append(",")
					.append(Person.get(i).getPhoneNumber()).append(",")
					.append(Person.get(i).getEmail());
			String data = rawData.toString();
			out.format("%s%n", data);
		}
		out.close();

	}

	/**
	 * the method that loops over all the entries in the person arraylist and
	 * outputs them using system.out
	 */
	private void viewPersons() {

		for (int i = 0; i < Person.size(); i++) {
			System.out.println("Index " + i + " " + Person.get(i).toString());
		}

	}

	/**
	 * calls the sort class on the arraylist in order to order them by first
	 * names
	 */
	private void sortByFullName() {

		PersonFullNameComparator comparator = PersonFullNameComparator
				.getInstance();
		if (Person.isEmpty() == true) {
			System.out.println("Nothing to sort");
		} else {
			Collections.sort(Person, comparator);
		}

	}

	/**
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

	/**
	 * @throws ValidationException
	 *             if the input is not valid for that variable This method adds
	 *             a person to the next empty index of the arraylist, assuming
	 *             that the entry is valid
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

	/**
	 * this outputs the menu, using the constants to populate the numbers, so
	 * that even if the constants change, the menu will still be accurate
	 */
	private void showMenu() {

		System.out.println(ADD_PERSON + " - add a person\n" + REMOVE_PERSON
				+ " - remove a person\n" + SORT_FULL_NAME + " - Sort by name\n"
				+ VIEW_PERSONS + " - View persons\n" + SAVE_ADDRESS_BOOK
				+ " - Save the address book\n" + LOAD_ADDRESS_BOOK
				+ " - Load the address book\n" + EXIT + " - Exit");

	}

}
