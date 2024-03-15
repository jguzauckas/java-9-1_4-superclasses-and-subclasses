# Inheritance

In Unit 5 we went through a lot of tools on how to build **objects**, a way to store related information in a more structured way. Instead of storing something like a name and age for a person in two separate variables, we could put those variables in a `Person` **class**, and now make a single variable storing a `Person` object based on that class. These classes can have many variables, as well as more tools like methods to perform actions as a cohesive collective, instead of separate parts.

Unit 9 expands on these ideas, as we look at the idea of different classes having relationships between each other, similar to how our name and age variables have a relationship. We have new tools that allow us to program these relationships, again with the goal to simplify and codify our programs to be more cohesive and easier to use.

---

## is-a Relationships

When programming, we might come across two or more classes that share certain properties. Consider the following situation:

- We are programming a library application, meant to store the collection of things a library offers to its users. Libraries offer many types of books, each of which have different properties that need to be stored.
    - There are novels, which have properties like a title, an author, a pagecount, and a genre.
    - There are also picture books, which have properties like a title, an author, a pagecount, and an illustrator.
    - There are even textbooks, which have properties like a title, an author, a pagecount, a subject, and an edition.

Obviously there are more types of books, but this sampling can still demonstrate what we are going to see when we program it. Given our current tools, we have two options:

- Make a class for each type of book, in this case `Novel`, `PictureBook`, and `Textbook`. While we are very capable of doing this, we are going to spend a lot of time rewriting the same code, as they all have to have some of the same instance variables (like `title`, `author`, and `pagecount`), while they do have some unique variables among them (like `genre` for `Novel`, `illustrator` for `PictureBook`, and `subject` and `edition` for `Textbook`).

- Make one big class that handles all types of books, maybe called `Book`. With this approach we save a lot of time as we don't have to program the same variables over and over (like `title`, `author`, and `pagecount`). This time though, we have an odd situation of what to do with the unique pieces of information between each of the types of books. We could have the variables for each, and make them `null` when it's not correct for this type of book? Or maybe we have additional `boolean` variables that helps us to determine which type of book we are looking at (like `isNovel`, `isPictureBook`, or `isTextbook`)? None of these solutions seem perfect.

The issues we have here all comes down to the fact that these three types of objects all have things in common between them. What if we could program the things in common to be shared between all of them? This is the concept of **inheritance**. We are going to be looking at a specific kind of inheritance in this unit, **is-a relationships**.

An is-a relationship is one where we can say one class is another class. In our example, this isn't like saying a `Novel` is a `PictureBook`, as that doesn't make any sense. Instead, we want to move up the **hierarchy** to the class that shares the common attributes, which we alluded to in our second option as `Book`. Is-a relationships would be saying that a `Novel` is a `Book`, a `PictureBook` is a `Book`, and a `Textbook` is a `Book`.

Notably, is-a relationships only work in one direction. Just like the classic math example "all squares are rectangles, but not all rectangles are squares", we can say similar versions for our examples like "all `Novel`s are `Book`s, but not all `Book`s are `Novel`s". This makes sense in our example, as some books are going to be `PictureBook`s or `Textbook`s, and so they most likely are not all `Novel`s.

---

## Superclasses and Subclasses

It turns out then, that the most optimal way to program our library is to merge aspects of the two options we had earlier. While it sounds like more work, the best way forward is to program four classes: `Book`, as well as `Novel`, `PictureBook`, and `Textbook`.

In this scenario, `Book` is going to have just the properties that need to be stored by all types of books. We highlighted earlier that through our sample, these seem to be instance variables for `title`, `author`, and `pagecount`. Putting common attributes together like this (and potentially common actions in the form of methods) makes `Book` a **superclass**.

Objects that want to utilize the common attributes (and potentially common methods) of a superclass are called **subclasses**. In this case, our subclasses are `Novel`, `PictureBook`, and `Textbook`. When we program each of these classes, our superclass `Book` comes in handy, as it is handling three of the instance variables we already know we need for each. As we noted earlier though, these classes do need something unique to each of them:
- `Novel` needs another instance variable for `genre`.
- `PictureBook` needs another instance variable for `illustrator`.
- `Textbook` needs instance variables for `subject` and `edition`.

With this structure, we've combined the best of both of our previous options. We have a `Book` class to store the information in common between all of our book types, but we still have a class for each of our types of books to help each feel unique.

A basic detail: any class can only have up to one superclass, and any given class can have none to many subclasses.

To establish an inheritance relationship in the code, we use the keyword `extends`. In the class declaration for a subclass, we would write class declarations like these:
- `public class Novel extends Book`
- `public class PictureBook extends Book`
- `public class Textbook extends Book`

Interestingly, nothing has to be written in the class declaration for a superclass for it to be used in an inheritance relationship, so it would just be `public class Book`.

Here are our classes with the instance variables so far from the `Books1` notes folder:

```java
public class Book {
    private String title;
    private String author;
    private int pagecount;
}

public class Novel extends Book {
    private String genre;
}

public class PictureBook extends Book {
    private String illustrator;
}

public class Textbook extends Book {
    private String subject;
    private int edition;
}
```

Note that we are ignoring the `package Notes.Books1` line at the top of the files, this is to help the Java files understand where they are in the file structure to interact with each other. (Notice that the folders are `Notes` and `Books1` so the dot `.` is just stringing them together.)

---

## Hierarchy

What we've demonstrated above with the `Book` superclass and the `Novel`, `PictureBook`, and `Textbook` subclasses is the most basic version of inheritance relationships. It is basic because we have a single tier of relationships: one superclass and its subclasses.

This isn't something we are limited to though, we could have a superclass above `Book` like `Media` (since `Book`s are a form of `Media`, but not all `Media` are `Book`s). When we do this, `Book` now functions as both a superclass and a subclass. It is the superclass for `Novel`, `PictureBook`, and `Textbook`, and it is a subclass of `Media`.

Similarly, we could make a subclass below `Novel` called `FantasyNovel` whose `genre` is always `Fantasy`, but now has a `subgenre` like `High Fantasy`. This makes `Novel` now both a superclass of `FantasyNovel` and a subclass of `Book`.

We can make hierarchies where there are many layers of superclass-subclass relationships as needed to help program a particular scenario.

---

## Constructors

The classes we've made so far are cool in design, but are not functional yet as they don't have any constructors (and therefore we can't make any books to store in the library).

Just like the class declaration was no different for a superclass, constructors for a superclass are completely normal as well. Here then, is the constructor for the `Book` class:

```java
public Book(String title, String author, int pagecount) {
    this.title = title;
    this.author = author;
    this.pagecount = pagecount;
}
```

As usual, the parameter names could have been different and eliminate the need for the `this` keyword, but it is considered best practice to use this style.

Following the trend, the subclasses are where things change a little for our constructors. To understand the changes, it is important to understand the intended "user experience" when using a subclass. By "user experience", we are referring to the experience of making and using a subclass object, potentially by someone who didn't write the subclass (or its associated superclass).

To the "user", creating and using an object from a subclass should feel like a normal class. They don't need to see or understand the intricate relationship between the subclass and its superclass. This means then, that they should just have to call the subclass constructor and provide all information for the object, both for the subclass and its superclass. For the `Novel` subclass for example, this means there should be four parameters; three parameters for the `Book` superclass (`title`, `author`, and `pagecount`), and one more parameter for the `Novel` subclass (`genre`). Using this as our template, we would expect the constructor headers to look like this for our three subclasses:

```java
public Novel(String title, String author, int pagecount, String genre) {
public PictureBook(String title, String author, int pagecount, String illustrator) {
public Textbook(String title, String author, int pagecount, String subject, int edition) {
```

Note that all of these headers share the same first three parameters, since they all share the same `Book` superclass, and the last parameter is what is different, to represent what makes the subclasses unique from each other.

Now the question is how do we set up the superclass-related instance variables? We can't just use something like `this.title = title;` because our subclass itself doesn't have an instance variable `title`. The simple answer then, is that we have to call the superclass constructor, but how?

Anytime we need to reference our superclass in any way from a subclass, we can use the keyword `super`. It functions much like the keyword `this`, except it only refers to components of a superclass as opposed to our current subclass. Between `super` for our superclass and `this` for our subclass, we can get access to everything.

Just like calling a constructor is as simple as using the name of the class, calling a superclass constructor is as simple as using the `super` keyword. We do need to provide parameters, if relevant. For all of our subclasses in this example, they can use the same superclass constructor call, since they all use the same parameter names for the relevant instance variables:

```java
super(title, author, pagecount);
```

Since `title`, `author`, and `pagecount` are defined parameters of the constructors above, we can just pass them in as variables to our superclass constructor. When we call this constructor, it runs the `Book` constructor and initializes those three instance variables, and ties this new `Book` object into our subclass object. From now on, when we use the `super` keyword, it functions as this `Book` object, so we can use instance variables or methods from the `Book` class.

It is a requirement for our subclass constructors that this superclass constructor call is the first line of the constructor. Anything else in the subclass constructor can go afterwards. For our subclasses in this case, we can use the next line of the subclass constructor to intialize our unique instance variables. This gives us the final forms of these constructors:

```java
public Novel(String title, String author, int pagecount, String genre) {
    super(title, author, pagecount);
    this.genre = genre;
}

public PictureBook(String title, String author, int pagecount, String illustrator) {
    super(title, author, pagecount);
    this.illustrator = illustrator;
}

public Textbook(String title, String author, int pagecount, String subject, int edition) {
    super(title, author, pagecount);
    this.subject = subject;
    this.edition = edition;
}
```

Notice that the superclass constructor call is identical for each of these.

Here is a brief example of creating a `Novel` object from the `Main.java` file in the `Books2` folder:

```java
Novel favoriteBook = new Novel("The Way of Kings", "Brandon Sanderson", 1001, "Fantasy");
```

This call would make an internal `Book` object with `title` `"The Way of Kings"`, `author` `"Brandon Sanderson"`, and `pagecount` `1001`, and then the `Novel` subclass stores that `Book` and the `genre` `"Fantasy"`.

---

## No-Argument Constructors

What if we don't call the superclass constructor from within our subclass constructor? In this case, before executing any lines of the subclass constructor, Java automatically calls the superclass no-argument constructor, then continues with the subclass constructor.

With our current work, this would do basically nothing, as we didn't define a no-argument constructor for our `Book` superclass (remember that Java will automatically "create" a no-argument or default constructor if we do not provide one, that does functionally nothing). We can also make our own no-argument constructors for our superclass and its subclasses.

For our book superclass, it would look like this:

```java
public Book() {
    this.title = "";
    this.author = "";
    this.pagecount = -1;
}
```

In our subclasses, we can call the no-argument constructor of a superclass by just using the `super` keyword with empty parentheses:

```java
public Novel() {
    super();
    this.genre = "";
}

public PictureBook() {
    super();
    this.illustrator = "";
}

public Textbook() {
    super();
    this.subject = "";
    this.edition = 0;
}
```

Look at the files in the `Books2` folder to see this version of these classes with instance variables and constructors.

--- 

## Method Inheritance

An object of a subclass **inherits** the methods of the superclass. This means that when we create a subclass object, it can use superclass methods as if it were its own.

Let's demonstrate this with some getter and setter methods. For both a superclass and its subclasses, these don't look any different from before. Here are some getter methods for our `Book` superclass:

```java
public String getTitle() {
    return this.title;
}

public String getAuthor() {
    return this.author;
}

public int getPagecount() {
    return this.pagecount;
}
```

Here are the getter methods for each of our subclasses:

```java
// Novel
public String getGenre() {
    return this.genre;
}

// PictureBook
public String getIllustrator() {
    return this.illustrator;
}

// Textbook
public String getSubject() {
    return this.subject;
}

public int getEdition() {
    return this.edition;
}
```

This example from the `Main.java` file in the `Books3` folder makes the same `Novel` from earlier:

```java
Novel favoriteBook = new Novel("The Way of Kings", "Brandon Sanderson", 1001, "Fantasy");
```

Since it is a `Novel`, it obviously can use the `getGenre` method:

```java
System.out.println(favoriteBook.getGenre());
```

The new piece for us, is that due to inheritance from the `Book` class, this `Novel` object can also use the `getTitle`, `getAuthor` and `getPagecount` methods:

```java
System.out.println(favoriteBook.getTitle());
System.out.println(favoriteBook.getAuthor());
System.out.println(favoriteBook.getPagecount());
```

All of this together produces the following output:

```
Fantasy
The Way of Kings
Brandon Sanderson
1001
```

It is important to note that our superclass methods have the same limitations as our subclass methods: they have to be `public`. Just like an object can't use `private` methods, an object can't use `private` superclass methods either.

This method inheritance also applies to the internal workings of subclass methods. Let's say for the `Novel` subclass, we wanted a method called `isLong`, which returns `true` if the `Novel` object is a long book, and `false` if it is not a long book. For our purposes here, let's say that a `Novel` is considered long if it is more than `600` pages long.

Seems straight-forward enough, just need to check the `pagecount` and see if it is greater than `600`. Since `super` gives us access to the `Book` object that helps make up a novel, it would seem then that we just need to access the `pagecount` variable through `super`, like `super.pagecount`. Unfortunately even though we are inside of the `Novel` subclass, the same `public`/`private` rules for our superclass that we have to follow whenever we are outside of a class.

This means then that to actually access our superclass instance variables from a subclass, we have to use `public` accessor methods like `getPagecount` in this case. This means to get the `pagecount` for our use in the `isLong` method, we need to use `super.getPagecount()`. Here is what the `Novel` method `isLong` would look like:

```java
public boolean isLong() {
    if (super.getPagecount() > 600) {
        return true;
    }
    return false;
}
```

Now back in the `Main.java` file in the `Books3` folder, we can test this method out on our `Novel` `favoriteBook`:

```java
System.out.println(favoriteBook.isLong());
```

This produces the output `true`, because this book has a `pagecount` of `1001`, which is bigger than `600`.

Look at the files in the `Books3` folder to see this version of these classes with instance variables, constructors, and basic methods.

---

## Overriding Methods

Sometimes a superclass and a subclass can share a method with the same **method signature**.

As a reminder, a method's signature is the combination of its name and the types and order of the parameter(s). Notably it does not include `public` or `private`, `static`, or the `return` type.

The variable names assigned to the parameters is not considered a part of its signature. Consider the method:

```java
public boolean sampleMethod(int val1, int val2, double val3)
```

The following are methods that are considered to have the same signature as the method above:

```java
private boolean sampleMethod(int val1, int val2, double val3) // private doesn't matter
public static boolean sampleMethod(int val1, int val2, double val3) // static doesn't matter
public double sampleMethod(int val1, int val2, double val3) // return type doesn't matter
public boolean sampleMethod(int val2, int val1, double val3) // order of two parameters of the same type doesn't matter
public boolean sampleMethod(int num1, int num2, double num3) // parameter names doesn't matter
```

The following are methods that are considered to have different signatures as the method above:

```java
public boolean otherSampleMethod(int val1, int val2, double val3) // Different name
public boolean sampleMethod(int val1, int val2) // Different number of parameters
public boolean sampleMethod(String val1, int val2, double val3) // Different types of parameters
public boolean sampleMethod(double val1, int val2, int val3) // Different parameter order
```

For this section, we are looking at methods that share the same signature. Earlier we saw that with a subclass object, you can call `public` methods of the superclass, as well as public methods of the subclass. What happens then, if the same method (or at least, method signature) appears in both the superclass and the subclass? Which will actually happen?

When there is a method in the superclass and a subclass that shares the same signature, the version of that method in the subclass will **override** that same method in the superclass. This means that the subclass version of the method takes priority and runs while the superclass version will not.

This is easiest to see when we have a method we know we would want in multiple classes. A great example is a `toString` method. While a `toString` method in `Book` might suffice, it makes sense that we would want a more detailed version in our subclasses, as there is more relevant information for a given `Book` there.

Here is a basic `toString` method for the `Book` superclass:

```java
public String toString() {
    return "\"" + this.title + "\" by " + this.author;
}
```

Recall that in a `toString` method we are not required to use every instance variable. It makes sense in this case that if someone asks "what are you reading?" we wouldn't include how long the book is, hence leaving `pagecount` out. Also notice the use of the escape character `\` to put quotation marks in the resulting `String`.

If we put this in the `Book` class and didn't include a `toString` method in any of our subclasses, they would all use this simpler version. For example, from the `Main.java` file in the `Books3` folder:

```java
Novel favoriteBook = new Novel("The Way of Kings", "Brandon Sanderson", 1001, "Fantasy");
System.out.println(favoriteBook);
```

This produces the output `"The Way of Kings" by Brandon Sanderson`. Recall that printing an object (or otherwise requesting it turn into a `String`) implicitly calls the `toString` method for us.

We know though, that this is a `Novel` with the `genre` fantasy. We might say then that an appropriate `toString` method for this object would say something like `Fantasy Novel "The Way of Kings" by Brandon Sanderson`. Interestingly, while this result is different from the `Book` `toString` method, it does utilize the full `String` from the `Book` `toString` method in its own result. Using this information, here is a sample `Novel` `toString` method:

```java
public String toString() {
    return this.genre + " Novel " + super.toString();
}
```

Now when we run the same sample code from earlier, we get the output `Fantasy Novel "The Way of Kings" by Brandon Sanderson`. It was important that we identified the ability to use the `super.toString()` method, as we saved ourselves some work even though we are otherwise overriding that `toString` method.

We won't always want to call the overridden method in our new one though, which is easier to see in the case of the `PictureBook` class. For example, from the `Main.java` file in the `Books3` folder:

```java
PictureBook favoritePB = new PictureBook("If You Give a Mouse a Cookie", "Laura Joffe Numeroff", 40, "Felicia Bond");
System.out.println(favoritePB);
```

This produces the output `"If You Give a Mouse a Cookie" by Laura Joffe Numeroff`. First, we should have it specify up front that it is a Picturebook, but also it should specify that the first person is the writer, then also specify who the illustrator is, like this: `Picturebook "If You Give a Mouse a Cookie" written by Laura Joffe Numeroff and illustrated by Felicia Bond`. Since we need to modify what would be in the middle of the `Book` `toString` method, it makes sense here to just write our own from scratch. Here is a sample `PictureBook` `toString` method:

```java
public String toString() {
    return "Picturebook \"" + super.getTitle() + "\" written by " + super.getAuthor() + " and illustrated by " + this.illustrator;
}
```

This problem also shows up with our `Textbook` class. For example, from the `Main.java` file in the `Books3` folder:

```java
Textbook favoriteTextbook = new Textbook("Introduction to Algorithms", "Thomas H. Cormen", 1292, "Computer Science", 3);
System.out.println(favoriteTextbook);
```

This produces the output `"Introduction to Algorithms" by Thomas H. Cormen`. Here is what I want to see from a `Textbook` `toString` method: `Computer Science Textbook "Introduction to Algorithms", Edition 3 by Thomas H. Cormen`. Again, we need something in the middle of the `Book` `toString`, so we can just make our own. Here is a sample `Textbook` `toString` method:

```java
public String toString() {
    return this.subject + " Textbook \"" + super.getTitle() + "\", Edition " + this.edition + " by " + super.getAuthor();
}
```

Despite being pretty different, all three of these subclass `toString` methods are examples of overriding the superclass `toString` method, since they share the same signature and therefore are called instead of the superclass version. Sometimes an overridden method will call the superclass version anyways (in the case of `Novel`), but sometimes it doesn't (in the case of `PictureBook` and `Textbook`).

Look at the files in the `Books4` folder to see this version of these classes with instance variables, constructors, and all methods.
