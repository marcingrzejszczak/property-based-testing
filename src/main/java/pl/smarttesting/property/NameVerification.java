package pl.smarttesting.property;

/**
 * Weryfikacja po imieniu. Dla kobiety imię musi się kończyc na "a".
 */
public class NameVerification {

	public boolean passes(Person person) {
		if (person.gender == GENDER.FEMALE) {
			return person.name.endsWith("a");
		}
		return true;
	}
}

class Person {
	final GENDER gender;
	final String name;

	Person(GENDER gender, String name) {
		this.gender = gender;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person{" +
				"gender=" + gender +
				", name='" + name + '\'' +
				'}';
	}
}

enum GENDER {
	MALE, FEMALE, OTHER
}
