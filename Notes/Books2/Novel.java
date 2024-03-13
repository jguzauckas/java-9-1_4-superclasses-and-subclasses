package Notes.Books2;

public class Novel extends Book {
    private String genre;

    public Novel() {
        super();
        this.genre = "";
    }

    public Novel(String title, String author, int pagecount, String genre) {
        super(title, author, pagecount);
        this.genre = genre;
    }
}
