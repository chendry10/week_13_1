package com.lab.library.repository;

import com.lab.library.model.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class BookRepository {

    private final List<Book> books = new ArrayList<>();

    public void save(Book book) {
        books.add(book);
    }

    public List<Book> findAll() {
        return new ArrayList<>(books);
    }

    public Optional<Book> findByIsbn(String isbn) {
        return books.stream()
                .filter(b -> b.getIsbn().equals(isbn))
                .findFirst();
    }

    public List<Book> findCheckedOut() {
        return books.stream()
                .filter(Book::isCheckedOut)
                .collect(Collectors.toList());
    }

    public List<Book> findAvailable() {
        return books.stream()
                .filter(b -> !b.isCheckedOut())
                .collect(Collectors.toList());
    }

    public void clear() {
        books.clear();
    }
}
