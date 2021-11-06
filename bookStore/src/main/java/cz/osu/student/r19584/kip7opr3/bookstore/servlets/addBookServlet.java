package cz.osu.student.r19584.kip7opr3.bookstore.servlets;

import cz.osu.student.r19584.kip7opr3.bookstore.models.Book;
import cz.osu.student.r19584.kip7opr3.bookstore.services.BookService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "addBookServlet", value = "/addBookServlet")
public class addBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(403);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookService bookService = (BookService) request.getServletContext().getAttribute("bookService");

        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            String url = request.getParameter("downloadUrl");

            Book toAdd = new Book(id, title, author, url);
            bookService.addBook(toAdd);

            response.sendRedirect("index.jsp");
        } catch (Exception e)  {
            response.setContentType("text/html");

            // Hello
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>Error during adding book: " + e.getMessage() + "</h1>");
            out.println("</body></html>");
        }
    }
}
