public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook("Harry Potter", 3);
        library.addBook("The Great Gatsby", 2);
        library.addBook("Maths", 5);
        library.addBook("Physics", 5);
        library.addBook("English", 5);
        library.addBook("Programming", 5);

        library.start();
    }
}
