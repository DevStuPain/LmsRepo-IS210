public class Book {
      // PROPERTIES
    private String title;
    private String author;
    private String ISBN;
    private int publicationYear;
    private boolean isAvailable;
  // CONSTRUCTOR
    public Book(String title, String author, String ISBN, int publicationYear) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publicationYear = publicationYear;
        this.isAvailable = true; // book is available when created
    }
