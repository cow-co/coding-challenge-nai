package org.cowco.codingchallenge.dictionary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LanguageDictionaryTests {
    @Test
    public void filtersWordsCorrectly() {
        LanguageDictionary dict = new LanguageDictionary();
        dict.addWord("null");
        dict.addWord("hi");
        dict.addWord("bye");
        dict.addWord("full");

        List<String> words = dict.getWordsOfLength(4);

        assertEquals(2, words.size());
    }

    @Test
    public void filtersWordsWhenGivenLengthZero() {
        LanguageDictionary dict = new LanguageDictionary();
        dict.addWord("null");
        dict.addWord("hi");
        dict.addWord("bye");
        dict.addWord("full");

        List<String> words = dict.getWordsOfLength(0);

        assertEquals(0, words.size());
    }
}
