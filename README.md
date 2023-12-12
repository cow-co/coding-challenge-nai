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