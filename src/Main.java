import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //initial setup
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to our Library!");


        //Main Loop starts here
        while (true) {
            System.out.println("\n------ Menu ------");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display All Books");
            System.out.println("5. Check Out Book");
            System.out.println("6. Return Book");
            System.out.println("7. Load Books From File");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                scanner.nextLine();
                System.out.println("Please enter a number between 1 and 8.");
                continue;
            }

            switch (choice) {

                // add book
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();

                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();

                    System.out.print("Enter publication year: ");
                    int year = 0;
                    if (scanner.hasNextInt()) {
                        year = scanner.nextInt();
                        scanner.nextLine();
                    } else {
                        scanner.nextLine();
                        System.out.println("Invalid year. Book not added.");
                        break;
                    }

                    // creates book and adds to new lib
                    Book newBook = new Book(title, author, isbn, year);
                    library.addBook(newBook);
                    break;

                // Remove Book
                case 2:
                    System.out.print("Enter ISBN of the book to remove: ");
                    String removeISBN = scanner.nextLine();
                    library.removeBook(removeISBN);
                    break;

                // Search for book
                case 3:
                    System.out.print("Enter title or author to search: ");
                    String keyword = scanner.nextLine();
                    library.searchBook(keyword);
                    break;

                // All books displayed
                case 4:
                    library.displayBooks();
                    break;

                // Check out a book
                case 5:
                    System.out.print("Enter ISBN of the book to check out: ");
                    String checkOutISBN = scanner.nextLine();
                    library.checkOutBook(checkOutISBN);
                    break;

                // Return a book
                case 6:
                    System.out.print("Enter ISBN of the book to return: ");
                    String returnISBN = scanner.nextLine();
                    library.returnBook(returnISBN);
                    break;

                // Load book from file
                case 7:
                    System.out.print("Enter filename (e.g., books.txt): ");
                    String filename = scanner.nextLine();
                    library.loadBooksFromFile(filename);
                    break;

                // Exit case
                case 8:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;   // ends main(), which ends the program

                // Def Bad Input
                default:
                    System.out.println("Invalid option. Please choose 1–8.");
                    break;
            }
        }
    }
}