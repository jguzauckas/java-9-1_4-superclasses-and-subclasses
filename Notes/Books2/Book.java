package Notes.Books2;

public class Book {
    private String title;
    private String author;
    private int pagecount;

    public Book() {
        this.title = "";
        this.author = "";
        this.pagecount = -1;
    } 

    public Book(String title, String author, int pagecount) {
        this.title = title;
        this.author = author;
        this.pagecount = pagecount;
    }
}
