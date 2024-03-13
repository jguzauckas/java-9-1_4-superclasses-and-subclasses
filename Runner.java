public class Runner {
    public static void runner() {
        // Test all aspects of a Novel
        System.out.println("Novel Tests:");
        System.out.println("Default Novel Tests:"); // Test making a default Novel and using methods
        Novel novel1 = new Novel(); // Test making a default Novel
        System.out.println("novel1 toString: " + novel1); // Test toString
        novel1.setTitle("New Title"); // Test setTitle
        System.out.println("novel1 set/get Title: " + novel1.getTitle()); // Test getTitle
        novel1.setAuthor("New Author"); // Test setAuthor
        System.out.println("novel1 set/get Author: " + novel1.getAuthor()); // Test getAuthor
        novel1.setGenre("New Genre"); // Test setGenre
        System.out.println("novel1 set/get Genre: " + novel1.getGenre()); // Test getGenre
        System.out.println("Non-Default Novel Tests:"); // Test making a non-default Novel and using methods
        Novel novel2 = new Novel("Way of Kings", "Brandon Sanderson", "Fantasy"); // Test making a non-default Novel
        System.out.println("novel2 toString: " + novel2); // Test toString
        novel2.setTitle("New Title"); // Test setTitle
        System.out.println("novel2 set/get Title: " + novel2.getTitle()); // Test getTitle
        novel2.setAuthor("New Author"); // Test setAuthor
        System.out.println("novel2 set/get Author: " + novel2.getAuthor()); // Test getAuthor
        novel2.setGenre("New Genre"); // Test setGenre
        System.out.println("novel2 set/get Genre: " + novel2.getGenre()); // Test getGenre
        System.out.println();

        // Test all aspects of a PictureBook
        System.out.println("PictureBook Tests:");
        System.out.println("Default PictureBook Tests:");

        System.out.println("Non-Default PictureBook Tests:");

        // Test all aspects of a Textbook
        System.out.println("Textbook Tests:");
        System.out.println("Default Textbook Tests:");

        System.out.println("Non-Default Textbook Tests:");
        
        // Test all aspects of a Book
        System.out.println("Book Tests:");
        System.out.println("Default Book Tests:");

        System.out.println("Non-Default Book Tests:");

        // Test all aspects of a Movie
        System.out.println("Movie Tests:");
        System.out.println("Default Movie Tests:");

        System.out.println("Non-Default Movie Tests:");

        // Test all aspects of a YoutubeVideo
        System.out.println("YoutubeVideo Tests:");
        System.out.println("Default YoutubeVideo Tests:");

        System.out.println("Non-Default YoutubeVideo Tests:");

        // Test all aspects of a Video
        System.out.println("Video Tests:");
        System.out.println("Default Video Tests:");

        System.out.println("Non-Default Video Tests:");

        // Test all aspects of a Media
        System.out.println("Media Tests:");
        System.out.println("Default Media Tests:");

        System.out.println("Non-Default Media Tests:");
        
    }
}
