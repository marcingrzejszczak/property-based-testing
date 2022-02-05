package pl.smarttesting.property;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import pl.smarttesting.property.serialization.SerializationUtils;

class Serializer {

	private final File output;

	Serializer(File output) {
		this.output = output;
	}

	void serialize(String text) {
		// 1 trial
		// SerializationUtils.serialize(output.toPath(), text.getBytes());

		// 2 trial to fix NPE on string
//		if (text != null) {
		// 3 trial to fix NPE on file
		if (text != null && output != null) {
			SerializationUtils.serialize(output.toPath(), text);
		}
	}
}
