package org.cowco.codingchallenge.dictionary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

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
     * Idea here is to only expose streaming access to the underlying list, which
     * should help with memory usage/performance.
     * 
     * @return The stream of words from the underlying collection
     */
    public Stream<String> getWordStream() {
        return words.stream();
    }

    /**
     * Finds all words in the dictionary that are of the given length
     * Note: we don't throw an exception if the length is <= 0, since our definition
     * of this method's behaviour has covered that eventuality (there are 0 words
     * with length <= 0, so we just return an empty LanguageDictionary).
     * We return a LanguageDictionary rather than a simple List, so that we can
     * chain multiple filters
     * 
     * @param length The length of word to find
     * @return A new LanguageDictionary, with the filtered words.
     */
    public LanguageDictionary filterByLength(int length) {
        List<String> filtered = new ArrayList<>();
        // Obviously, we don't need to return anything if the length is zero or negative
        if (length > 0) {
            filtered = words.stream().filter(word -> word.length() == length).toList();
        }
        LanguageDictionary dict = new LanguageDictionary();
        dict.words = filtered;
        return dict;
    }

    /**
     * Filters out words which have letters *not* in the given string.
     * For example, the word "full" does *not* match the filter "ull", but *does*
     * match the filter "lfu".
     * 
     * @param letters The letters to filter for; does not matter how many times they
     *                occur
     * @return A LanguageDictionary containing the filtered-in words
     */
    public LanguageDictionary filterByLetters(String letters) {
        List<String> filtered = new ArrayList<>();
        String regex = String.format("[%s]+", letters);
        if (letters.length() > 0) {
            Pattern pattern = Pattern.compile(regex);
            filtered = words.stream().filter(word -> pattern.matcher(word).matches()).toList();
        }
        LanguageDictionary dict = new LanguageDictionary();
        dict.words = filtered;
        return dict;
    }

    // XXX This is a pretty bruteforce implementation - can we improve it?
    // public List<String> formWordsWithGivenCharacters(List<Character> letters) {
    // Iterator<String> iter = words.iterator();
    // while (iter.hasNext()) {
    // String word = iter.next();

    // }
    // }
}
