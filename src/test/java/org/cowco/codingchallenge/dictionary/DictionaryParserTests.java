package org.cowco.codingchallenge.dictionary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class DictionaryParserTests {
    @Test
    public void parsesDictionaryFile() throws IOException {
        LanguageDictionary dict = DictionaryParser.parseDictionaryFile("src/test/resources/test-dict.txt");

        assertEquals(7, dict.numWords());
    }

    @Test
    public void parsesDictionaryFileWithWhitespaceLine() throws IOException {
        LanguageDictionary dict = DictionaryParser.parseDictionaryFile("src/test/resources/test-dict-empty-line.txt");

        assertEquals(7, dict.numWords());
    }

    @Test
    public void parsesEmptyFile() throws IOException {
        LanguageDictionary dict = DictionaryParser.parseDictionaryFile("src/test/resources/test-dict-empty.txt");

        assertEquals(0, dict.numWords());
    }
}
