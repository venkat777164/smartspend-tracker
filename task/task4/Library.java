import java.util.ArrayList;
import java.util.Iterator;

public class Library {
    private ArrayList<Book> Books;

    // Constructor
    public Library() {
        Books = new ArrayList<>();
    }

    // Method to add a book to the library
    public void addBook(Book Book) {
        Books.add(Book);
        System.out.println("Book added: " + book.getTitle());
    }

    // Method to remove a book from the library using book ID
    public void removeBook(String bookId) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getBookId().equalsIgnoreCase(bookId)) {
                iterator.remove();
                System.out.println("Book with ID '" + bookId + "' removed successfully.");
                return;
            }
        }
        System.out.println("Book with ID '" + bookId + "' not found.");
    }
    public Book searchBookById(String bookId) {
        for (Book book : books) {
            if (book.getBookId().equalsIgnoreCase(bookId)) {
                return book;
            }
        }
        return null;
    }
    public ArrayList<Book> searchBooksByTitle(String title) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

   
    public ArrayList<Book> searchBooksByAuthor(String author) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("The library is empty.");
            return;
        }
        System.out.println("\n--- All Books in Library ---");
        for (Book book : books) {
            book.displayBookDetails();
            System.out.println("--------------------");
        }
    }
    public void borrowBook(String bookId) {
        Book book = searchBookById(bookId);
        if (book != null) {
            if (book.isAvailable()) {
                book.setAvailable(false);
                System.out.println("You have successfully borrowed: " + book.getTitle());
            } else {
                System.out.println(book.getTitle() + " is currently not available for borrowing.");
            }
        } else {
            System.out.println("Book with ID '" + bookId + "' not found.");
        }
    }
    public void returnBook(String bookId) {
        Book book = searchBookById(bookId);
        if (book != null) {
            if (!book.isAvailable()) {
                book.setAvailable(true);
                System.out.println("You have successfully returned: " + book.getTitle());
            } else {
                System.out.println(book.getTitle() + " was already available.");
            }
        } else {
            System.out.println("Book with ID '" + bookId + "' not found.");
        }
    }
}