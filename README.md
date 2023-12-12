# Coding Challenge

## Build and Run

- This code uses maven as a build tool
- Run `mvn clean package` to generate an executable JAR file (this also runs the unit tests).
  - Note the tests assume you are running them from the root directory of the project (it reads data files relative to that)
- The JAR can then be run as usual by `java -jar codingchallenge.jar {command line arguments}`

## Requirements

- JDK 17
- Maven version 3

## Design Notes

This section contains various notes about the solution design and implementation, that didn't fit as code comments. Normally I would write these in dedicated documentation (Confluence, etc.)

- Due to the length of a usual dictionary, we want to filter words as much as possible before attempting to generate grids with them. So we have a `LanguageDictionary` class which provides filtering methods, and stores a working list of valid words. The filtering methods modify the `LanguageDictionary` instance, so that we don't risk having multiple copies knocking around.
- I have attempted to keep the design simple but flexible, adhering to the principle that the essence of good design is in reducing complexity. 
- A particularly important aspect is that I've tried to maintain careful encapsulation of the words list in the `LanguageDictionary` class. Access to the list is provided only via a stream of its entries and via a method to get its length. This ensures we can't modify the list outside the class. Also, I do not provide access to set the list directly, again in order to avoid having to keep multiple lists around.
- Generating the grid is done by a recursive approach. We start by generating a map of which words have which prefixes, then we use that to generate a list of words which have the correct prefixes with each other.
  - Start with empty prefix
  - Any word matches, let's say "rose"
  - Prefix is now "r", but the first word always matches its own prefix obviously, so we ignore that case.
  - Prefix is now "o" (letter 2 from rose)
  - "oven" matches
  - Prefix is now "se" (letter 3 from rose and oven)
  - "send" matches
  - Prefix is now "end" (letter 4 from rose, oven, send)
  - "ends" matches
  - grid is complete.
- Otherwise, things are fairly straightforward.
- Tests are done via JUnit 5. I've covered off the main scenarios and edge cases (that I can think of at least).