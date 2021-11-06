package cz.osu.student.r19584.kip7opr3.bookstore.services;

import cz.osu.student.r19584.kip7opr3.bookstore.models.Book;
import cz.osu.student.r19584.kip7opr3.bookstore.models.Cart;

import java.util.Map;

public class CartService {
    private final Cart cart = new Cart();

    public void addBook(Book toAdd) {
        cart.addBook(toAdd);
    }

    public Map<Book, Integer> getBooks() {
        return cart.getBooks();
    }
}
