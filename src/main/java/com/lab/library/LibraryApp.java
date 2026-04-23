package com.lab.library;

import com.lab.library.model.Book;
import com.lab.library.repository.BookRepository;
import com.lab.library.service.BookService;
import java.util.List;

public class LibraryApp {

    public static void main(String[] args) {
        BookRepository repo = new BookRepository();
        BookService service = new BookService(repo);

        service.addBook("978-0-13-468599-1", "Effective Java", "Joshua Bloch");
        service.addBook("978-0-201-63361-0", "Design Patterns", "Gang of Four");
        service.addBook("978-0-13-235088-4", "Clean Code", "Robert Martin");

        System.out.println("=== Library catalog ===");
        service.getAvailableBooks().forEach(System.out::println);

        boolean success = service.checkOut("978-0-13-468599-1");
        System.out.println("\nChecked out Effective Java: " + success);

        System.out.println("\n=== Available books ===");
        service.getAvailableBooks().forEach(System.out::println);

        System.out.println("\n=== Checked-out books ===");
        service.getCheckedOutBooks().forEach(System.out::println);

        System.out.println("\n=== Search: 'clean' ===");
        List<Book> results = service.searchByTitle("clean");
        results.forEach(System.out::println);
    }
}
