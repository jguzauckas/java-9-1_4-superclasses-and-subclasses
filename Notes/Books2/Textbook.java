package Notes.Books2;

public class Textbook extends Book {
    private String subject;
    private int edition;

    public Textbook() {
        super();
        this.subject = "";
        this.edition = 0;
    }

    public Textbook(String title, String author, int pagecount, String subject, int edition) {
        super(title, author, pagecount);
        this.subject = subject;
        this.edition = edition;
    }
}
