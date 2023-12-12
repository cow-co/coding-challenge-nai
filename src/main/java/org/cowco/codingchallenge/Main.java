package org.cowco.codingchallenge;

import java.io.IOException;

import org.cowco.codingchallenge.dictionary.DictionaryParser;
import org.cowco.codingchallenge.dictionary.LanguageDictionary;
import org.cowco.codingchallenge.grid.GridConstructor;

public class Main {
    private static final String USAGE = "Usage: java -jar <jar name> {dictionary file path} {grid size} {list of letters to use}";

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println(USAGE); // TODO Change this to a logger output? Using log4j2.
        } else {
            // XXX Just a little thing for testing, we'll get rid of this later.
            try {
                String dictFile = args[0];
                Integer dim = Integer.parseInt(args[1]);
                String allowedLetters = args[2];

                LanguageDictionary dict = DictionaryParser.parseDictionaryFile(dictFile);
                System.out.println("There are " + dict.numWords() + " words in the dictionary.");
                
                dict = dict.filterByLength(dim).filterByLetters(allowedLetters);
                System.out.println(
                        "There are " + dict.numWords() + " words in the dictionary after filtering.\nThey are:\n");
                dict.getWordStream().forEach(word -> System.out.println(word));

                GridConstructor grid = new GridConstructor(dict);
                grid.constructGrid(dim, allowedLetters);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}