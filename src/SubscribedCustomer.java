import java.util.ArrayList;
import java.util.List;

class SubscribedCustomer extends Customer {
    private List<Book> borrowedBooks = new ArrayList<>();

    public SubscribedCustomer(String name, int customerID, String phoneNumber) {
        super(name, customerID, phoneNumber);
        isSubscribed = true;
    }

    @Override
    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.borrowBook(customerID);
            borrowedBooks.add(book);
            borrowHistory.add(book);
        }
    }

    @Override
    public void returnBook(Book book) {
        // Check if the book was borrowed by this specific customer
        if (book.getBorrowedByID() == customerID && borrowedBooks.contains(book)) {
            book.returnBook();
            borrowedBooks.remove(book);
        } else if (book.getBorrowedByID() != customerID) {
            System.out.println("This book was not borrowed by you.");
        } else {
            System.out.println("You haven't borrowed this book.");
        }
    }
}