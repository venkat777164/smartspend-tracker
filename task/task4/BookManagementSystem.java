import java.util.ArrayList;
import java.util.Scanner;

public class BookManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        library.addBook(new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book("B002", "1984", "George Orwell"));
        library.addBook(new Book("B003", "To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book("B004", "Pride and Prejudice", "Jane Austen"));
        library.addBook(new Book("B005", "The Catcher in the Rye", "J.D. Salinger"));

        int choice;
        do {
            System.out.println("\n--- Library Management System Menu ---");
            System.out.println("1. Add a new Book");
            System.out.println("2. Remove a Book (by ID)");
            System.out.println("3. Search Book (by ID)");
            System.out.println("4. Search Books (by Title)");
            System.out.println("5. Search Books (by Author)");
            System.out.println("6. Display All Books");
            System.out.println("7. Borrow a Book");
            System.out.println("8. Return a Book");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                System.out.print("Enter your choice: ");
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(id, title, author));
                    break;
                case 2:
                    System.out.print("Enter Book ID to remove: ");
                    String removeId = scanner.nextLine();
                    library.removeBook(removeId);
                    break;
                case 3:
                    System.out.print("Enter Book ID to search: ");
                    String searchId = scanner.nextLine();
                    Book foundBook = library.searchBookById(searchId);
                    if (foundBook != null) {
                        System.out.println("\nBook Found:");
                        foundBook.displayBookDetails();
                    } else {
                        System.out.println("Book with ID '" + searchId + "' not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Title (or part of title) to search: ");
                    String searchTitle = scanner.nextLine();
                    ArrayList<Book> booksByTitle = library.searchBooksByTitle(searchTitle);
                    if (!booksByTitle.isEmpty()) {
                        System.out.println("\nBooks with title containing '" + searchTitle + "':");
                        for (Book b : booksByTitle) {
                            b.displayBookDetails();
                            System.out.println("----");
                        }
                    } else {
                        System.out.println("No books found with title containing '" + searchTitle + "'.");
                    }
                    break;
                case 5:
                    System.out.print("Enter Author (or part of author name) to search: ");
                    String searchAuthor = scanner.nextLine();
                    ArrayList<Book> booksByAuthor = library.searchBooksByAuthor(searchAuthor);
                    if (!booksByAuthor.isEmpty()) {
                        System.out.println("\nBooks by author containing '" + searchAuthor + "':");
                        for (Book b : booksByAuthor) {
                            b.displayBookDetails();
                            System.out.println("----");
                        }
                    } else {
                        System.out.println("No books found by author containing '" + searchAuthor + "'.");
                    }
                    break;
                case 6:
                    library.displayAllBooks();
                    break;
                case 7:
                    System.out.print("Enter Book ID to borrow: ");
                    String borrowId = scanner.nextLine();
                    library.borrowBook(borrowId);
                    break;
                case 8:
                    System.out.print("Enter Book ID to return: ");
                    String returnId = scanner.nextLine();
                    library.returnBook(returnId);
                    break;
                case 0:
                    System.out.println("Exiting Library Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}