package cz.osu.student.r19584.kip7opr3.bookstore.models;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private final Map<Book, Integer> books = new HashMap<>();

    public void addBook(Book toAdd) {
        int count = books.containsKey(toAdd) ? books.get(toAdd) + 1 : 1;
        books.put(toAdd, count);
    }

    public Map<Book, Integer> getBooks() {
        return new HashMap<>(books);
    }

    public void empty() {
        books.clear();
    }
}
