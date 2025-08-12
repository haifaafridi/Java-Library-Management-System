import java.util.*;

abstract class Customer {
    protected String name;
    protected int customerID;
    protected String phoneNumber;
    protected ArrayList<Book> borrowHistory = new ArrayList<>();
    protected boolean isSubscribed;

    public Customer(String name, int customerID, String phoneNumber) {
        this.name = name;
        this.customerID = customerID;
        this.phoneNumber = phoneNumber;
    }

    public abstract void borrowBook(Book book);
    public abstract void returnBook(Book book);

    public String getName() {
        return name;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Book> getBorrowHistory() {
        return borrowHistory;
    }

    public boolean isSubscribed() {
        return isSubscribed;
    }
}
