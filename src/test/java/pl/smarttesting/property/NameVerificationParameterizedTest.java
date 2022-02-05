package pl.smarttesting.property;

import java.io.File;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenNoException;

class NameVerificationParameterizedTest {

	@ParameterizedTest(name = "Person {0} should pass name verification? {1}")
	@MethodSource(value = "factory")
	void should_pass_name_verification(Person person, boolean expected) {
		then(new NameVerification().passes(person)).isEqualTo(expected);
	}

	static Stream<Arguments> factory() {
		return Stream.of(
				Arguments.of(new Person(GENDER.MALE, "Krzystof"), true),
				Arguments.of(new Person(GENDER.MALE, "Krzystofa"), true),
				Arguments.of(new Person(GENDER.OTHER, "Krzystof"), true),
				Arguments.of(new Person(GENDER.OTHER, "Krzystofa"), true),
				Arguments.of(new Person(GENDER.FEMALE, "Krzystof"), false),
				Arguments.of(new Person(GENDER.FEMALE, "Anna"), true));
	}
}
