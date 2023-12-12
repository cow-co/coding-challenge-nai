package org.cowco.codingchallenge.grid;

import java.util.ArrayList;
import java.util.List;

import org.cowco.codingchallenge.dictionary.LanguageDictionary;

/**
 * This class handles creating the actual grid of words
 */
public class GridConstructor {
    private LanguageDictionary dict;
    private int gridDim;
    private List<String> gridContents;

    public GridConstructor(LanguageDictionary dict) {
        this.dict = dict;
    }

    // public void constructGrid(int dimension, String letters) {
    // gridDim = dimension;
    // gridContents = new ArrayList<>();
    // dict = dict.filterByLength(dimension).filterByLetters(letters);
    // dict.getWordStream().forEach(word -> {
    // word.chars().forEach(c -> {
    // int idx = letters.indexOf(c);
    // letters = letters.substring(0, idx) + letters.substring(idx,
    // letters.length());
    // });
    // });
    // }
}
