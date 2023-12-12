package org.cowco.codingchallenge.grid;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.iterators.PermutationIterator;
import org.cowco.codingchallenge.dictionary.LanguageDictionary;

/**
 * This class handles creating the actual grid of words.
 * Running the permutations is inherently expensive - couldn't think of a more efficient way to do that.
 * There were a couple of helpful ways to filter out words, however.
 */
public class GridConstructor {
    private LanguageDictionary dict;
    private int gridDim;
    private List<String> gridContents;

    public GridConstructor(LanguageDictionary dict) {
        this.dict = dict;
    }

    public void constructGrid(int dimension, String letters) {
        gridDim = dimension;
        gridContents = new ArrayList<>();
        dict = dict.filterByLength(dimension).filterByLetters(letters);
        
        if (dict.numWords() > 0) {
            List<Character> allowedCharacters = letters.chars().mapToObj(c -> (char)c).toList();
            PermutationIterator<Character> iter = new PermutationIterator<>(allowedCharacters);
            int i = 0;
            while (iter.hasNext()) {
                System.out.println("Perm " + i);    // TODO Remove
                List<Character> perm = iter.next();
                List<String> words = buildStringsFromCharPermutation(perm);
                if (permutationIsValidWords(words) && permutationIsArrangedVertically(words)) {
                    System.out.println("We have a valid permutation:"); // TODO return properly
                    gridContents = words;
                    printGrid();
                    break;
                }
                i++;
            }
        } else {
            System.out.println("No words fit the criteria!"); // TODO Handle this properly
        }
    }

    public final List<String> getGrid() {
        return gridContents;
    }

    private boolean permutationIsValidWords(List<String> permutation) {
        boolean isValid = true;
        for (String word : permutation) {
            if (!dict.doesDictContainWord(word)) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    private boolean permutationIsArrangedVertically(List<String> permutation) {
        boolean isArranged = true;
        for (int i = 0; i < gridDim; i++) {
            char[] vertChars = new char[gridDim];
            for (int j = 0; j < gridDim; j++) {
                String word = permutation.get(j);
                vertChars[j] = word.charAt(i);
            }
            String vertWord = new String(vertChars);
            if (!vertWord.equals(permutation.get(i))) {
                isArranged = false;
                break;
            }
        }
        return isArranged;
    }

    private void printGrid() {
        System.out.println("The permutation is: ");
        for (String word : gridContents) {
            System.out.println(word);
        }
    }

    private List<String> buildStringsFromCharPermutation(List<Character> chars) {
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < gridDim; i++) {
            int start = i * gridDim;
            List<Character> wordChars = chars.subList(start, start + gridDim);
            for (Character c : wordChars) {
                builder.append(c);
            }
            result.add(builder.toString());
            builder.setLength(0);
        }
        return result;
    }
}
