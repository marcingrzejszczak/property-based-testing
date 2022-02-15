package pl.smarttesting.property;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;

class AppTest {

	@Test
	void should_add_2_numbers() {
		int result = new Calculator().add(1, 2);

		BDDAssertions.then(result).isEqualTo(3);

		result = new Calculator().add(-1, -2);

		BDDAssertions.then(result).isEqualTo(-3);

		result = new Calculator().add(-1, 2);

		BDDAssertions.then(result).isEqualTo(1);

		result = new Calculator().add(0, 0);

		BDDAssertions.then(result).isEqualTo(0);
	}
}
