package Notes.Books3;

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

    public String getGenre() {
        return this.genre;
    }

    public boolean isLong() {
        if (super.getPagecount() > 600) {
            return true;
        }
        return false;
    }
}
