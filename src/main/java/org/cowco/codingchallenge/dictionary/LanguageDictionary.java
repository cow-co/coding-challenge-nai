package org.cowco.codingchallenge.dictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class represents a dictionary for a particular language.
 * The data structure is designed to allow rapid culling of unnecessary words
 * when building the grid; therefore it stores the words along with their
 * lengths. This allows us to easily ignore words that are not the right length.
 */
public class LanguageDictionary {
    private List<String> words;

    public LanguageDictionary() {
        words = new ArrayList<>();
    }

    /**
     * Adds a word to the word list. Due to the length of a standard language
     * dictionary, we don't permit constructors or setters that take an entire
     * list of words, since that would imply keeping multiple copies of the entire
     * dictionary in memory at once.
     * 
     * @param word The word to be added.
     */
    public void addWord(String word) {
        words.add(word);
    }

    /**
     * Gets the number of words in the dictionary. Just for utility purposes, as
     * well as a good sanity check against the number of lines in a parsed
     * dictionary file.
     * 
     * @return The total number of words in the dictionary
     */
    public int numWords() {
        return words.size();
    }

    /**
     * Finds all words in the dictionary that are of the given length
     * Note: we don't throw an exception if the length is <= 0, since our definition
     * of this method's behaviour has covered that eventuality (there are 0 words
     * with length <= 0, so we just return an empty list)
     * 
     * @param length The length of word to find
     * @return A List of the words with the given length
     */
    public List<String> getWordsOfLength(int length) {
        List<String> filtered = new ArrayList<>();
        // Obviously, we don't need to return anything if the length is zero or negative
        // TODO Could also store the maximum word length, and then short-circuit when
        // `length` > that value.
        if (length > 0) {
            filtered = words.stream().filter(word -> word.length() == length).collect(Collectors.toList());
        }
        return filtered;
    }
}
