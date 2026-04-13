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
         
    // METHODS
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean status) {
        isAvailable = status;
    }

    public String toString() {
        return "Title: " + title +
               ", Author: " + author +
               ", ISBN: " + ISBN +
               ", Year: " + publicationYear +
               ", Available: " + isAvailable;
    }
}

