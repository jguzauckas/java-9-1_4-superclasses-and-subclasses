package Notes.Books3;

public class Main {
    public static void main(String[] args) {
        Novel favoriteBook = new Novel("The Way of Kings", "Brandon Sanderson", 1001, "Fantasy");
        System.out.println(favoriteBook.getGenre());
        System.out.println(favoriteBook.getTitle());
        System.out.println(favoriteBook.getAuthor());
        System.out.println(favoriteBook.getPagecount());
        System.out.println(favoriteBook.isLong());
    }
}
