import java.util.Scanner;

class Manager {
    private String username;
    private String password;

    public Manager(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login(String enteredUsername, String enteredPassword) {
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }

    public void manageLibrary(Library library) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nManager Options:");
            System.out.println("1. Display All Books");
            System.out.println("2. View Subscribed Customers");
            System.out.println("3. Sort Books by Title");
            System.out.println("4. Sort Books by ID");
            System.out.println("5. View Borrow Histories");
            System.out.println("6. Add New Book");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    library.displaySubscribedCustomers();
                    break;
                case 3:
                    library.sortBooksByTitle();
                    break;
                case 4:
                    library.sortBooksByID();
                    break;
                case 5:
                    library.displayBorrowHistories();
                    break;
                case 6:
                    library.addNewBook();
                    break;
                case 7:
                    System.out.println("Exiting Manager Panel...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 7);
    }
}