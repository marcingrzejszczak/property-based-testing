package pl.smarttesting.property.serialization;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class SerializationUtils {

	public static void serialize(Path path, String text) {
		try {
			Files.write(path, text.getBytes(StandardCharsets.US_ASCII));
		}
		catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}
}
