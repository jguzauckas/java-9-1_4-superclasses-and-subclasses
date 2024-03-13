package Notes.Books4;

public class Main {
    public static void main(String[] args) {
        Novel favoriteBook = new Novel("The Way of Kings", "Brandon Sanderson", 1001, "Fantasy");
        System.out.println(favoriteBook);

        PictureBook favoritePB = new PictureBook("If You Give a Mouse a Cookie", "Laura Joffe Numeroff", 40, "Felicia Bond");
        System.out.println(favoritePB);

        Textbook favoriteTextbook = new Textbook("Introduction to Algorithms", "Thomas H. Cormen", 1292, "Computer Science", 3);
        System.out.println(favoriteTextbook);
    }
}
