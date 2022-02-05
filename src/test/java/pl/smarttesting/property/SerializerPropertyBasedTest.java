package pl.smarttesting.property;

import java.io.File;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenNoException;
import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.integers;
import static org.quicktheories.generators.SourceDSL.strings;

class SerializerPropertyBasedTest {

	@TempDir File tmp;

	@Test
	@Disabled("will fail")
	public void should_serialize_text_to_file() {
		File temp = new File(tmp, "test.txt");

		qt()
				.forAll(strings().allPossible().ofLength(100))
				.checkAssert((text) -> {
					new Serializer(temp).serialize(text);

					then(temp).hasBinaryContent(text.getBytes(StandardCharsets.UTF_8));
				});
	}
}
