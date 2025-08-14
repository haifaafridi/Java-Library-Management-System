# Library Management System 📚

A comprehensive Java-based Library Management System developed as a second semester project at NUST University. This console application demonstrates object-oriented programming principles including inheritance, polymorphism, and encapsulation.

## Features

### 🔐 User Authentication
- **Manager Login**: Secure access for library administrators
- **Customer Registration**: Support for both regular and subscribed customers

### 📖 Book Management
- Add new books with multiple copies
- Display all available books
- Sort books by title or ID
- Track book availability and borrowing status

### 👥 Customer Management
- **Regular Customers**: Can borrow up to 2 books simultaneously
- **Subscribed Customers**: Unlimited book borrowing privileges
- View customer subscription status
- Track individual borrowing histories

### 📊 Administrative Features
- View all subscribed customers
- Display comprehensive borrowing histories
- Real-time book availability tracking
- Secure manager authentication system

## System Architecture

### Core Classes

- **`Book`**: Represents individual books with borrowing functionality
- **`Customer`** (Abstract): Base class for all customer types
- **`RegularCustomer`**: Extends Customer with borrowing limits
- **`SubscribedCustomer`**: Extends Customer with unlimited borrowing
- **`Manager`**: Handles administrative operations and authentication
- **`Library`**: Core system managing books, customers, and operations
- **`LibrarySystem`**: Main class with application entry point

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code) or command line

### Installation

1. Clone the repository:
```bash
git clone https://github.com/yourusername/library-management-system.git
cd library-management-system
```

2. Compile the Java files:
```bash
javac *.java
```

3. Run the application:
```bash
java LibrarySystem
```

## Usage

### Manager Access
**Default Manager Credentials:**
- Username: `zainab` | Password: `1234`
- Username: `haifa` | Password: `1234`
- Username: `shameel` | Password: `1234`

### Manager Operations
1. Display all books in the library
2. View subscribed customers
3. Sort books by title or ID
4. View customer borrowing histories
5. Add new books to the collection

### Customer Operations
1. **Registration**: Choose between Regular or Subscribed customer
2. **Borrow Books**: Select from available books (limits apply for regular customers)
3. **Return Books**: Return previously borrowed books
4. **View History**: Check personal borrowing history

## Sample Books Included

The system comes pre-loaded with:
- Harry Potter (3 copies)
- The Great Gatsby (2 copies)
- Maths (5 copies)
- Physics (5 copies)
- English (5 copies)
- Programming (5 copies)

## Technical Implementation

### Object-Oriented Principles
- **Inheritance**: Customer hierarchy with RegularCustomer and SubscribedCustomer
- **Polymorphism**: Abstract methods in Customer class
- **Encapsulation**: Private fields with public getters/setters
- **Abstraction**: Abstract Customer class defining common behavior

### Data Structures
- Arrays for book storage (capacity: 500 books)
- ArrayList for dynamic customer and borrowing history management
- Comparator interface for flexible sorting

## Project Structure

```
library-management-system/
├── Book.java
├── Customer.java
├── RegularCustomer.java
├── SubscribedCustomer.java
├── Manager.java
├── Library.java
├── LibrarySystem.java
└── README.md
```

## Contributing

This project was developed as an academic exercise. Feel free to fork and improve upon the codebase. Some areas for enhancement include:
- Database integration
- GUI implementation
- Enhanced search functionality
- Fine management system
- Date tracking for borrowing periods

## License

This project is open source and available under the [MIT License](LICENSE).

## Author

**NUST University Student**
- Second Semester Project
- Object-Oriented Programming Course

---

*Developed with ☕ and Java at National University of Sciences and Technology (NUST)*