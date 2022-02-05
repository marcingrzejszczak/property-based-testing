package pl.smarttesting.property;

import org.junit.jupiter.api.Test;

import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.*;

public class SomeTests {

	@Test
	public void addingTwoPositiveIntegersAlwaysGivesAPositiveInteger() {
		qt()
				.forAll(integers().allPositive()
						, integers().allPositive())
				.check((i, j) -> new Calculator().add(i, j) > 0);
	}

}
