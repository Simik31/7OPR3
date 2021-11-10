package cz.osu.student.r19584.kip7opr3.bookstore.servlets;

import cz.osu.student.r19584.kip7opr3.bookstore.models.Book;
import cz.osu.student.r19584.kip7opr3.bookstore.services.BookService;
import cz.osu.student.r19584.kip7opr3.bookstore.services.CartService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "paymentServlet", value = "/payment")
public class paymentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(403);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CartService cartService = (CartService) request.getSession().getAttribute("cartService");
        BookService bookService = (BookService) request.getServletContext().getAttribute("bookService");

        List<Book> allBooks = bookService.getBooks();
        Map<Book, Integer> cartBooks = cartService.getBooks();

        cartBooks.forEach((cartBook, count) -> {
            allBooks.forEach(book -> {
                if (book.getId() == cartBook.getId())
                    bookService.payBook(book);
            });
        });

        cartService.emptyCart();

        response.sendRedirect("index.jsp");
    }
}
