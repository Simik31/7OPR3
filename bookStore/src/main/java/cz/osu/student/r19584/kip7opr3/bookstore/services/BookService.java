package cz.osu.student.r19584.kip7opr3.bookstore.services;

import cz.osu.student.r19584.kip7opr3.bookstore.models.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public Book getBookById(int id) {
        try {
            return books.stream().filter(book -> book.getId() == id).findFirst().get();
        } catch (Exception ignored) {
            return null;
        }
    }

    public List<Book> getBooks() {
        return books;
    }
}
