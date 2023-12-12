package org.cowco.codingchallenge.dictionary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * This class handles parsing of dictionary files.
 */
public class DictionaryParser {
    /**
     * Parses the dictionary file at the given path, and puts the words into a
     * LanguageDictionary object.
     * The files are assumed to have a simple structure of one word per line.
     * 
     * @param filePath Path (relative or absolute) to the file for parsing.
     * @return The LanguageDictionary object containing the parsed words.
     */
    public static LanguageDictionary parseDictionaryFile(String filePath) throws IOException {
        LanguageDictionary dict = new LanguageDictionary();

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            lines.forEach((line) -> {
                if (!line.isBlank()) {
                    dict.addWord(line);
                }
            });
        }

        return dict;
    }
}
