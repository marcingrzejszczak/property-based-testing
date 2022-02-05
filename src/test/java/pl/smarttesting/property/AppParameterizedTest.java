package pl.smarttesting.property;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class AppParameterizedTest {

	@ParameterizedTest(name = "{0} + {1}")
	@MethodSource(value = "factory")
	void should_add_2_numbers(int[] values) {
		int a = values[0];
		int b = values[1];
		int result = new Calculator().add(a, b);

		BDDAssertions.then(result).isEqualTo(a + b);
	}

	static int[][] factory() {
		return new int[][] {
				{1, 2}, {-1, -2}, {-1, 2}, {0, 0}
		};
	}
}
