package org.cowco.codingchallenge.dictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * This class represents a dictionary for a particular language.
 * The data structure is designed to allow rapid culling of unnecessary words
 * when building the grid. Hence it provides filtering methos which can be chained.
 */
public class LanguageDictionary {
    private List<String> words;

    public LanguageDictionary() {
        words = new ArrayList<>();
    }

    /**
     * Adds a word to the word list. Due to the length of a standard language
     * dictionary, we don't permit constructors or setters that take an entire
     * list of words, since that could imply keeping multiple copies of the entire
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
     * should help with memory usage/performance. This also encourages encapsulation.
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
     * chain multiple filters.
     * 
     * NOTE: Modifies underlying list
     * 
     * @param length The length of word to find
     * @return A new LanguageDictionary, with the filtered words.
     */
    public LanguageDictionary filterByLength(int length) {
        // Obviously, we don't need to return anything if the length is zero or negative
        if (length > 0) {
            words = words.stream().filter(word -> word.length() == length).toList();
        } else {
            words = new ArrayList<>();
        }
        return this;
    }

    /**
     * Filters out words which have letters *not* in the given string.
     * For example, the word "full" does *not* match the filter "ull", but *does*
     * match the filter "lfu".
     * 
     * NOTE: Modifies underlying list
     * 
     * @param letters The letters to filter for; does not matter how many times they
     *                occur. If empty or null, does not modify the list.
     * @return A LanguageDictionary containing the filtered-in words
     */
    public LanguageDictionary filterByLetters(String letters) {
        if (letters == null || letters.length() > 0) {
            String regex = String.format("[%s]+", letters);
            Pattern pattern = Pattern.compile(regex);
            words = words.stream().filter(word -> pattern.matcher(word).matches()).toList();
        }
        return this;
    }
    
    public boolean doesDictContainWord(String word) {
        return words.contains(word);
    }
}
