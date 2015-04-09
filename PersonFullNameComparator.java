/*
 * Based on code provided by Stanley Pieda (2015) personal communication
 */
package assignment3;

import java.util.Comparator;

public class PersonFullNameComparator implements Comparator<Person> {
	private static PersonFullNameComparator instance = new PersonFullNameComparator();
	private PersonFullNameComparator() {
	}
	public static PersonFullNameComparator getInstance() {
		return instance;
	}
	@Override
	public int compare(Person arg0, Person arg1) {
		return arg0.getFullName().compareTo(arg1.getFullName());
	}
}