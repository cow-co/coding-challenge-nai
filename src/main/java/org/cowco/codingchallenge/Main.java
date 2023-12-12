package org.cowco.codingchallenge;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cowco.codingchallenge.dictionary.DictionaryParser;
import org.cowco.codingchallenge.dictionary.LanguageDictionary;
import org.cowco.codingchallenge.grid.GridConstructor;

public class Main {
    private static final String USAGE = "Usage: java -jar <jar name> {dictionary file path} {grid size} {list of letters to use}";
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println(USAGE); // We only need to print to the console, not to any log files.
        } else {
            // XXX Just a little thing for testing, we'll get rid of this later.
            try {
                String dictFile = args[0];
                Integer dim = Integer.parseInt(args[1]);
                String allowedLetters = args[2];

                LanguageDictionary dict = DictionaryParser.parseDictionaryFile(dictFile);
                LOGGER.info("There are " + dict.numWords() + " words in the dictionary.");
                
                dict.filterByLength(dim).filterByLetters(allowedLetters);
                LOGGER.info("There are " + dict.numWords() + " words in the dictionary after filtering.");
                LOGGER.debug("They are:");
                dict.getWordStream().forEach(word -> LOGGER.debug(word));

                GridConstructor grid = new GridConstructor(dict);
                grid.constructGrid(dim, allowedLetters);
            } catch (IOException ex) {
                LOGGER.fatal(ex.getMessage());
            }
        }
    }
}