package cz.osu.student.r19584.cviceni_3;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "articleServlet", value = "/article")
public class ArticleServlet extends HttpServlet {
    private String message;

    public void init() {
        ArticleService.init();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        List<Article> articles = ArticleService.getArticles();
        for (Article article : articles) {
            out.println("<div>");
            out.println("<h2>" + article.getTitle() + "</h2>");
            out.println("<h3>" + article.getAuthor() + "</h3>");
            out.println("<p>" + article.getContent() + "</p>");
            out.println("</div>");
        }

        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String id = request.getParameter("id");
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            String author = request.getParameter("author");

            Article a = new Article(Integer.parseInt(id), title, author, content);
            ArticleService.addArticle(a);
            response.sendRedirect("article");
        } catch (Exception ex) {
            response.sendRedirect("?error");
        }
    }

    public void destroy() {
    }
}