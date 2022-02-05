package pl.smarttesting.property;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;
import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.*;

class AppPropertyBasedTest {

	@Test
	@Disabled("will fail")
	public void should_add_2_positive_numbers() {
		qt()
				.forAll(integers().allPositive(), integers().allPositive())
				.checkAssert((i, j) -> then(new Calculator().add(i, j)).isPositive());
	}

}
