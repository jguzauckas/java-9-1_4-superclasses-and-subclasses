# Assignment

You are going to build out several classes that follow an inheritance hierarchy.

The hierarchy is going to be built around the examples from the notes with `Book`, but expanded more to generally include `Media`. The hierarchy looks like this:

```
                                    Media
                                      |   
                     ---------------------------------------
                     |                                      |
                   Book                                   Video
                     |                                      |
          ---------------------------                 -------------
          |          |              |                 |           |
        Novel   PictureBook     Textbook            Movie    YoutubeVideo
```

Information about the lowest level classes (`Novel`, `PictureBook`, `Textbook`, `Movie`, and `YoutubeVideo`) and their requirements are below. Use these requirements to determine what can be moved up into their respective superclasses (`Book` and `Video`), and potentially what can move all the way up into the `Media` superclass.

The `Runner.java` file has a method called `runner` that is meant to thoroughly test everything about our class hierarchy. This involves trying each constructor and method to ensure everything is working properly. Full tests for the `Novel` class has been pre-filled in for you as an example, with spaces set out below them for you to write the tests for the other classes. Your tests should look similar to the pre-filled ones for `Novel`.

The most important uses of these tests is that you should be predicting what the output should be so that when you run the `Runner.java` file, you can evaluate whether things were working correctly or not. For example, if the output was different than what you expected, what is wrong? Were your predictions wrong, or is something implemented wrong with the class being tested?

Use the notes examples for the `Book`-related classes as supporting material as you work on this if needed.

---

## `Novel` (subclass of `Book`)

Instance Variables:
- Title
- Author
- Genre

Constructors:
- Default/No-Argument Constructor
- All-Argument Constructor (values for all instance variables)

Methods:
- `toString` method for printing
- Accessor and Mutator methods for all instance variables

## `PictureBook` (subclass of `Book`)

Instance Variables:
- Title
- Author
- Illustrator

Constructors:
- Default/No-Argument Constructor
- All-Argument Constructor (values for all instance variables)

Methods:
- `toString` method for printing
- Accessor and Mutator methods for all instance variables

## `Textbook` (subclass of `Book`)

Instance Variables:
- Title
- Author
- Subject
- Edition

Constructors:
- Default/No-Argument Constructor
- All-Argument Constructor (values for all instance variables)

Methods:
- `toString` method for printing
- Accessor and Mutator methods for all instance variables

## `Movie` (subclass of `Video`)

Instance Variables:
- Title
- Creator
- Release Year
- List of Actors (Strings)
- Run Time in Minutes
- Rating (0% to 100% scale)

Constructors:
- Default/No-Argument Constructor
- All-Argument Constructor (values for all instance variables)

Methods:
- `toString` method for printing
- Accessor and Mutator methods for all instance variables
- Methods to add and remove actors from the list

## `YoutubeVideo` (subclass of `Video`)

Instance Variables:
- Title
- Creator
- Release Year
- Run Time in Seconds
- Number of Views
- Whether or not it has subtitles (boolean)

Constructors:
- Default/No-Argument Constructor
- All-Argument Constructor (values for all instance variables)

Methods:
- `toString` method for printing
- Accessor and Mutator methods for all instance variables
- Method to increment views