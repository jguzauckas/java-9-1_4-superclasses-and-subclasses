package Notes.Books2;

public class PictureBook extends Book {
    private String illustrator;

    public PictureBook() {
        super();
        this.illustrator = "";
    }

    public PictureBook(String title, String author, int pagecount, String illustrator) {
        super(title, author, pagecount);
        this.illustrator = illustrator;
    }
}
