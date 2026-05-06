import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Library {
    //place for all the books
    private ArrayList<Book> books;
    //creates empty lib for the books
    public Library() {
        books = new ArrayList<>();
    }
    //adds book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }
    //removes a book
    public void removeBook(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                System.out.println("Book removed: " + book.getTitle());
                books.remove(book);
                return;
                //stops after match is found
            }
        }
        System.out.println("Book with ISBN " + ISBN + " not found.");
    }
    //searches for the books
    public void searchBook(String keyword) {
        boolean found = false;
        String lowerKeyword = keyword.toLowerCase();

        for (Book book : books) {
            // check title, author, and ISBN
            if (book.getTitle().toLowerCase().contains(lowerKeyword)
                    || book.getAuthor().toLowerCase().contains(lowerKeyword)
                    || book.getISBN().contains(keyword)) {

                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found for the keyword: " + keyword);
        }
    }

    //displays all books currently in the lib
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("\n|--- Library Collection (" + books.size() + " book(s)) ---|");
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
    }
    //checks out an available book
    public void checkOutBook(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("Book checked out: " + book.getTitle());
                } else {
                    System.out.println("Book is already checked out: " + book.getTitle());
                }
                return;
            }
        }
        System.out.println("Book with ISBN " + ISBN + " not found.");
    }
    //returns a checked out book
    public void returnBook(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("Book returned: " + book.getTitle());
                } else {
                    System.out.println("Book was not checked out: " + book.getTitle());
                }
                return;
            }
        }
        System.out.println("Book with ISBN " + ISBN + " not found.");
    }
    //loads books from txt file
    public void loadBooksFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                // skip blank lines
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");

                if (parts.length == 4) {
                    // parse the four fields
                    String title  = parts[0].trim();
                    String author = parts[1].trim();
                    String isbn   = parts[2].trim();
                    int    year;

                    try {
                        year = Integer.parseInt(parts[3].trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid year in line, skipping: " + line);
                        continue;
                    }

                    books.add(new Book(title, author, isbn, year));
                } else {
                    System.out.println("Invalid book data format: " + line);
                }
            }

            System.out.println("Books loaded from file: " + filename);

        } catch (IOException e) {
            // handles file-not-found and other I/O errors
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

