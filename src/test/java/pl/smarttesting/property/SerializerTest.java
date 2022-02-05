package pl.smarttesting.property;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import static org.assertj.core.api.BDDAssertions.then;

class SerializerTest {

	@TempDir File tmp;

	@Test
	void should_serialize_input_to_file()  {
		File temp = new File(tmp, "test.txt");

		new Serializer(temp).serialize("hello");

		then(temp).exists().hasContent("hello");
	}
}
