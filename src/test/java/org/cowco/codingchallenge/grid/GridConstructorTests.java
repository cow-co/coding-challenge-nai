package org.cowco.codingchallenge.grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.cowco.codingchallenge.dictionary.LanguageDictionary;
import org.junit.jupiter.api.Test;

public class GridConstructorTests {
    @Test
    public void generatesAValidCombination() {
        LanguageDictionary dict = new LanguageDictionary();
        dict.addWord("null");
        dict.addWord("hi");
        dict.addWord("in");
        dict.addWord("bye");
        dict.addWord("full");

        GridConstructor grid = new GridConstructor(dict);
        grid.constructGrid(2, "ihni");

        List<String> words = grid.getGrid();
        assertEquals(2, words.size());
        assertTrue(words.contains("hi"));
        assertTrue(words.contains("in"));
    }
}
