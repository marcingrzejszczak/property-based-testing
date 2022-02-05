package pl.smarttesting.property;

import java.io.File;
import java.io.IOException;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenNoException;

class SerializerParameterizedTest {

	@TempDir File tmp;

	@ParameterizedTest(name = "serialized {0}")
	@MethodSource(value = "factory")
	void should_serialize_a_value(String value) {
		File temp = new File(tmp, "test.txt");

		new Serializer(temp).serialize(value);

		then(temp).exists().hasContent(value);
	}

	static String[] factory() {
		return new String[] {
//				"hello", "", null // results in NPE
				"hello", "" // OK
//				"hello", "", "Brzęczyszczykiewicz" // non UTF-8 will blow up due to encoding
		};
	}

	@Test
	void should_do_nothing_when_text_null() {
		thenNoException().isThrownBy(() -> new Serializer(tmp).serialize(null));
	}

	// 3rd trial - what if file is null

	@Test
	void should_do_nothing_when_file_null() {
		thenNoException().isThrownBy(() -> new Serializer(null).serialize(""));
	}
}
