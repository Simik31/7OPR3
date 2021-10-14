package cz.osu.student.r19584.cviceni_3;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            out.println("<h3>" + article.getAuthor() + " (Kontakt: " + article.getPhone_no() + ")</h3>");
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
            String phone_no = request.getParameter("phone_no");

            validatePhoneNumber(phone_no);

            ArticleService.addArticle(new Article(Integer.parseInt(id), title, author, content, phone_no));
            response.sendRedirect("article");
        } catch (Exception ex) {
            response.sendRedirect("?error=" + ex.getMessage());
        }
    }

    public void validatePhoneNumber(String phone_no) throws Exception {
        String patternString = "(\\+420 {0,1})?(\\d{3}[\\s-]*){3}";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(phone_no);

        if (!matcher.find())
            throw new Exception("Invalid phone number");
    }
}