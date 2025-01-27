import Library.LibraryManagement;
import Person.*;
import Rack.Rack;
import Book.Book;

public class Main {
    public static void main(String[] args) {
        
        LibraryManagement libraryManagement = new LibraryManagement();

        Person admin = new Admin();

        Book book = new Book("NEW BOOK", "NEW AUTHOR", "NEW CATEGORY", 5050);

        Rack rack = new Rack(1);

        libraryManagement.add_book(admin, book , rack);

    }
}
