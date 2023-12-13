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
        dict.addWord("rose");
        dict.addWord("oven");
        dict.addWord("send");
        dict.addWord("ends");
        dict.addWord("done");
        dict.addWord("veer");
        dict.addWord("sere");

        GridConstructor grid = new GridConstructor(dict);
        grid.constructGrid(4, "eeeeddoonnnsssrv");

        List<String> words = grid.getGrid();
        assertEquals(4, words.size());
        assertTrue(words.contains("oven"));
        assertTrue(words.contains("send"));
        assertTrue(words.contains("rose"));
        assertTrue(words.contains("ends"));
    }

    @Test
    public void generatesEmptyGridWhenNoValidCombos() {
        System.out.println("none");
        LanguageDictionary dict = new LanguageDictionary();
        dict.addWord("null");
        dict.addWord("hi");
        dict.addWord("in");
        dict.addWord("bye");
        dict.addWord("full");
        dict.addWord("rose");
        dict.addWord("oven");
        dict.addWord("senn");
        dict.addWord("ends");
        dict.addWord("done");
        dict.addWord("veer");
        dict.addWord("sere");

        GridConstructor grid = new GridConstructor(dict);
        grid.constructGrid(4, "eeeednoonnnsssrv");

        List<String> words = grid.getGrid();
        assertEquals(0, words.size());
    }

    // This one is basically testing edge case stuff
    @Test
    public void generatesEmptyGridWhenDimensionIsZero() {
        LanguageDictionary dict = new LanguageDictionary();
        dict.addWord("null");
        dict.addWord("hi");
        dict.addWord("in");
        dict.addWord("bye");
        dict.addWord("full");
        dict.addWord("rose");
        dict.addWord("oven");
        dict.addWord("senn");
        dict.addWord("ends");
        dict.addWord("done");
        dict.addWord("veer");
        dict.addWord("sere");

        GridConstructor grid = new GridConstructor(dict);
        grid.constructGrid(0, "eeeednoonnnsssrv");

        List<String> words = grid.getGrid();
        assertEquals(0, words.size());
    }

    // This one is basically testing edge case stuff
    @Test
    public void generatesEmptyGridWhenDimensionIsNegative() {
        LanguageDictionary dict = new LanguageDictionary();
        dict.addWord("null");
        dict.addWord("hi");
        dict.addWord("in");
        dict.addWord("bye");
        dict.addWord("full");
        dict.addWord("rose");
        dict.addWord("oven");
        dict.addWord("senn");
        dict.addWord("ends");
        dict.addWord("done");
        dict.addWord("veer");
        dict.addWord("sere");

        GridConstructor grid = new GridConstructor(dict);
        grid.constructGrid(-1, "eeeednoonnnsssrv");

        List<String> words = grid.getGrid();
        assertEquals(0, words.size());
    }
}
