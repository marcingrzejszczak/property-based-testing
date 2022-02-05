package pl.smarttesting.property.serialization;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class SerializationUtils {

	public static void serialize(Path path, String text) {
		try {
			// We're storing in US_ASCII but we're writing UTF-8 chars
//			Files.write(path, text.getBytes(StandardCharsets.US_ASCII));
			Files.write(path, text.getBytes(StandardCharsets.UTF_8));
		}
		catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}
}
