package org.cowco.codingchallenge.dictionary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class LanguageDictionaryTests {
    @Test
    public void filtersWordsCorrectly() {
        LanguageDictionary dict = new LanguageDictionary();
        dict.addWord("null");
        dict.addWord("hi");
        dict.addWord("bye");
        dict.addWord("full");

        dict.filterByLength(4);

        assertEquals(2, dict.numWords());
    }

    @Test
    public void filtersWordsWhenGivenLengthZero() {
        LanguageDictionary dict = new LanguageDictionary();
        dict.addWord("null");
        dict.addWord("hi");
        dict.addWord("bye");
        dict.addWord("full");

        dict.filterByLength(0);

        assertEquals(0, dict.numWords());
    }

    @Test
    public void filtersWordsWhenGivenLengthNegative() {
        LanguageDictionary dict = new LanguageDictionary();
        dict.addWord("null");
        dict.addWord("hi");
        dict.addWord("bye");
        dict.addWord("full");

        dict.filterByLength(-1);

        assertEquals(0, dict.numWords());
    }

    @Test
    public void filtersWordsByLetters() {
        LanguageDictionary dict = new LanguageDictionary();
        dict.addWord("null");
        dict.addWord("hi");
        dict.addWord("bye");
        dict.addWord("full");

        dict.filterByLetters("yeb");

        assertEquals(1, dict.numWords());
    }

    @Test
    public void filtersWordsByLettersCountDoesNotMatter() {
        LanguageDictionary dict = new LanguageDictionary();
        dict.addWord("null");
        dict.addWord("hi");
        dict.addWord("bye");
        dict.addWord("full");

        dict.filterByLetters("yyebbb");

        assertEquals(1, dict.numWords());
    }

    @Test
    public void filtersWordsByLettersWithNoMatches() {
        LanguageDictionary dict = new LanguageDictionary();
        dict.addWord("null");
        dict.addWord("hi");
        dict.addWord("bye");
        dict.addWord("full");

        dict.filterByLetters("ull");

        assertEquals(0, dict.numWords());
    }

    @Test
    public void filtersWordsByLettersWithNoLettersProvided() {
        LanguageDictionary dict = new LanguageDictionary();
        dict.addWord("null");
        dict.addWord("hi");
        dict.addWord("bye");
        dict.addWord("full");
        int initialLength = dict.numWords();

        dict.filterByLetters("");

        assertEquals(initialLength, dict.numWords());
    }
}
