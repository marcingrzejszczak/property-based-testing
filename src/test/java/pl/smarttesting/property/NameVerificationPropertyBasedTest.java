package pl.smarttesting.property;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;
import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.arbitrary;
import static org.quicktheories.generators.SourceDSL.strings;

class NameVerificationPropertyBasedTest {

	@Test
	void should_pass_name_verification_for_women_with_proper_name() {
		qt()
				.forAll(strings().basicMultilingualPlaneAlphabet().ofLengthBetween(1, 10))
				.checkAssert((s) -> then(new NameVerification().passes(new Person(GENDER.FEMALE, s + "a"))).isTrue());
	}

	@Test
	void should_fail_name_verification_for_women_with_invalid_name() {
		qt()
				.forAll(strings().basicMultilingualPlaneAlphabet().ofLengthBetween(1, 10))
				.assuming(s -> !s.endsWith("a"))
				.checkAssert((s) -> then(new NameVerification().passes(new Person(GENDER.FEMALE, s))).isFalse());
	}

	@Test
	void should_pass_name_verification_for_other_gender() {
		qt()
				.forAll(strings().basicMultilingualPlaneAlphabet().ofLengthBetween(1, 10), arbitrary().enumValues(GENDER.class))
				.assuming((s, g) -> g != GENDER.FEMALE)
				.checkAssert((s, g) -> then(new NameVerification().passes(new Person(g, s))).isTrue());
	}

}
