import java.util.*;
class Book {
    private int bookID;
    private String title;
    private boolean isAvailable;
    private int borrowedByID = -1;

    public Book(int bookID, String title) {
        this.bookID = bookID;
        this.title = title;
        this.isAvailable = true;
    }

    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getBorrowedByID() {
        return borrowedByID;

    }

    public void borrowBook(int customerID) {
        if (isAvailable) {
            isAvailable = false;
            borrowedByID = customerID;
            System.out.println("You have successfully borrowed \"" + title + "\".");
        } else {
            System.out.println("Sorry, \"" + title + "\" is currently unavailable.");
        }
    }

    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            borrowedByID = -1;
            System.out.println("You have successfully returned \"" + title + "\".");
        } else {
            System.out.println("This book was not borrowed.");
        }
    }

    public void displayBookInfo(int serialNumber) {
        String availability = isAvailable ? "Available" : "Unavailable";
        System.out.println(serialNumber + ". ID: " + bookID + " | Title: " + title + " | " + availability);
    }
}