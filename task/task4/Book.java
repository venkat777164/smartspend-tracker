public class Book {
    private String BookId;
    private String title;
    private String author;
    private boolean isAvailable; // To track if the book is available for borrowing

    // Constructor to initialize book attributes
    public Book(String bookId, String title, String author) {
        this.BookId = BookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true; // By default, a new book is available
    }

    // Getters for book attributes (needed for searching and displaying)
    public String getBookId() {
        return BookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Setter for availability (to change status when borrowed/returned)
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // Method to display book details
    public void displayBookDetails() {
        System.out.println("Book ID: " + BookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
    }
}