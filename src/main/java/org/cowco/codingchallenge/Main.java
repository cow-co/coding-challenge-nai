package org.cowco.codingchallenge;

import java.io.IOException;

import org.cowco.codingchallenge.dictionary.DictionaryParser;
import org.cowco.codingchallenge.dictionary.LanguageDictionary;

public class Main {
    private static final String USAGE = "Usage: java -jar <jar name> {dictionary file path} {grid size}";

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println(USAGE); // TODO Change this to a logger output? Using log4j2.
        } else {
            // XXX Just a little thing for testing, we'll get rid of this later.
            try {
                LanguageDictionary dict = DictionaryParser.parseDictionaryFile(args[0]);
                System.out.println("There are " + dict.numWords() + " words in the dictionary.");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}