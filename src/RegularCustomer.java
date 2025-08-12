import java.util.*;

class RegularCustomer extends Customer {
    private List<Book> borrowedBooks = new ArrayList<>();

    public RegularCustomer(String name, int customerID, String phoneNumber) {
        super(name, customerID, phoneNumber);
        isSubscribed = false;
    }

    @Override
    public void borrowBook(Book book) {
        if (borrowedBooks.size() < 2) {
            book.borrowBook(customerID);
            borrowedBooks.add(book);
            borrowHistory.add(book);
        } else {
            System.out.println("You can only borrow up to 2 books at a time.");
        }
    }


    @Override
    public void returnBook(Book book) {
        book.returnBook();
    }
}