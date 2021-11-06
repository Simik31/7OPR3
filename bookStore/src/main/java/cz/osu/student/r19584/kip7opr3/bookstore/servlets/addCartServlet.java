package cz.osu.student.r19584.kip7opr3.bookstore.servlets;

import cz.osu.student.r19584.kip7opr3.bookstore.models.Book;
import cz.osu.student.r19584.kip7opr3.bookstore.services.BookService;
import cz.osu.student.r19584.kip7opr3.bookstore.services.CartService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "addCartServlet", value = "/addCartServlet")
public class addCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(403);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CartService cartService = (CartService) request.getSession().getAttribute("cartService");
        BookService bookService = (BookService) request.getServletContext().getAttribute("bookService");

        int id = Integer.parseInt(request.getParameter("id"));

        Book toAdd = bookService.getBookById(id);

        cartService.addBook(toAdd);

        response.sendRedirect("index.jsp");
    }
}
