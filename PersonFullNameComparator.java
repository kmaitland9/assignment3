/*
 * Code provided by Stanley Pieda (2015) personal communication
 */
package assignment3;

import java.util.Comparator;

public class PersonFullNameComparator implements Comparator<Person> {
	@Override
	public int compare(Person arg0, Person arg1) {
		return arg0.getFullName().compareTo(arg1.getFullName());
	}
}