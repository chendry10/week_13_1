package com.lab.library.model;


public class Book {

    private final String isbn;
    private final String title;
    private final String author;
    private boolean checkedOut;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.checkedOut = false;
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isCheckedOut() { return checkedOut; }

    public void checkOut() { this.checkedOut = true; }
    public void returnBook() { this.checkedOut = false; }

    @Override
    public String toString() {
        return String.format("Book{isbn='%s', title='%s', author='%s', checkedOut=%s}",
                isbn, title, author, checkedOut);
    }
}
