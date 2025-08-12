
import java.util.*;



class Library {
    private Book[] books = new Book[500];
    private int bookCount = 0;
    private List<Customer> customers = new ArrayList<>();
    private List<Manager> managers = Arrays.asList(
            new Manager("zainab", "1234"),
            new Manager("haifa", "1234"),
            new Manager("shameel", "1234")
    );

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Login as Manager");
            System.out.println("2. Login as Customer");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    loginManager();
                    break;
                case 2:
                    loginCustomer();
                    break;
                case 3:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 3);
    }

    public void addBook(String title, int copies) {
        for (int i = 0; i < copies && bookCount < books.length; i++) {
            books[bookCount] = new Book(bookCount + 1, title);
            bookCount++;
        }
    }

    public void addNewBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter number of copies: ");
        int copies = scanner.nextInt();

        addBook(title, copies);
        System.out.println("Book(s) added successfully!");
    }

    public void displayBooks() {
        System.out.println("\n--- Available Books ---");
        for (int i = 0; i < bookCount; i++) {
            books[i].displayBookInfo(i + 1);
        }
    }

    public Book getBookByID(int bookID) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getBookID() == bookID) {
                return books[i];
            }
        }
        return null;
    }

    public void sortBooksByTitle() {
        Arrays.sort(books, 0, bookCount, Comparator.comparing(Book::getTitle));
        displayBooks();
    }

    public void sortBooksByID() {
        Arrays.sort(books, 0, bookCount, Comparator.comparingInt(Book::getBookID));
        displayBooks();
    }

    public void displaySubscribedCustomers() {
        System.out.println("--- Subscribed Customers ---");
        for (Customer c : customers) {
            if (c.isSubscribed()) {
                System.out.println("Name: " + c.getName() + " | ID: " + c.getCustomerID() + " | Phone: " + c.getPhoneNumber());
            }

        }
    }

    public void displayBorrowHistories() {
        for (Customer c : customers) {
            System.out.println("\nCustomer ID: " + c.getCustomerID() + ", Name: " + c.getName());
            if (c.getBorrowHistory().isEmpty()) {
                System.out.println("No borrow history.");
            } else {
                for (Book book : c.getBorrowHistory()) {
                    System.out.println("- " + book.getTitle());
                }
            }
        }
    }



    private void loginManager() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter manager username: ");
        String username = scanner.next();
        System.out.print("Enter manager password: ");
        String password = scanner.next();

        for (Manager manager : managers) {
            if (manager.login(username, password)) {
                System.out.println("Login successful.");
                manager.manageLibrary(this);

            }
        }

        System.out.println("Invalid login credentials.");
    }

    private void loginCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Regular Customer");
        System.out.println("2. Subscribed Customer");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer ID: ");
        int customerID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter customer phone number: ");
        String phoneNumber = scanner.nextLine();

        Customer customer = null;

        if (choice == 1) {
            customer = new RegularCustomer(name, customerID, phoneNumber);
        } else if (choice == 2) {
            customer = new SubscribedCustomer(name, customerID, phoneNumber);
        }

        if (customer != null) {
            customers.add(customer);
            System.out.println("Customer account created successfully.");
            customerOperations(customer);
        }
    }

    private void customerOperations(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nCustomer Options:");
            System.out.println("1. Borrow a Book");
            System.out.println("2. Return a Book");
            System.out.println("3. View Borrow History");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    borrowBook(customer);
                    break;
                case 2:
                    returnBook(customer);
                    break;
                case 3:
                    viewBorrowHistory(customer);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }

    private void borrowBook(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        displayBooks();
        System.out.print("Enter book ID to borrow: ");
        int bookID = scanner.nextInt();
        Book book = getBookByID(bookID);

        if (book != null) {
            customer.borrowBook(book);
        } else {
            System.out.println("Invalid book ID.");
        }
    }

    private void returnBook(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book ID to return: ");
        int bookID = scanner.nextInt();
        Book book = getBookByID(bookID);

        if (book != null) {
            customer.returnBook(book);
        } else {
            System.out.println("Invalid book ID.");
        }
    }

    private void viewBorrowHistory(Customer customer) {
        System.out.println("\nBorrow History:");
        for (Book book : customer.getBorrowHistory()) {
            System.out.println(book.getTitle());
        }
    }
}