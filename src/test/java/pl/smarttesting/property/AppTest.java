package pl.smarttesting.property;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;

public class AppTest {

	@Test
	public void should_add_2_numbers() {
		int result = new Calculator().add(1, 2);

		BDDAssertions.then(result).isEqualTo(3);
	}
}
