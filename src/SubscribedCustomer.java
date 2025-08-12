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
        book.borrowBook(customerID);
        borrowHistory.add(book);
    }

    @Override
    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            book.returnBook();
            borrowedBooks.remove(book);
        } else {
            System.out.println("This book was not borrowed by you.");
        }
    }

}
