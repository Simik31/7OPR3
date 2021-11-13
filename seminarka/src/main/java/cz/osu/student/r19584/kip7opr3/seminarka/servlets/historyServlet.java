package cz.osu.student.r19584.kip7opr3.seminarka.servlets;

import cz.osu.student.r19584.kip7opr3.seminarka.Utils;
import cz.osu.student.r19584.kip7opr3.seminarka.models.Result;
import cz.osu.student.r19584.kip7opr3.seminarka.services.ResultService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "historyServlet", value = "/history")
public class historyServlet extends HttpServlet {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss.SSS");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(
            "<title>Tic-Tac-Toe :: Global history</title>\n" +
            "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\n" +
            "<script src=\"https://cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/alertify.min.js\"></script>\n" +
            "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/alertify.min.css\"/>\n" +
            "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/default.min.css\"/>" +
            "<link rel=\"stylesheet\" href=\"./css/main.css\" />\n" +
            "<link rel=\"stylesheet\" href=\"./css/classes.css\" />" +
            "</head>\n" +
            "<body>\n" +
            "    <div class=\"content position-fixed\">\n" +
            "        <h1 id=\"title\" class=\"position-fixed\">History</h1>\n" +
            "        <span id=\"scope_global\" class=\"position-fixed w-50 l-0 r-50 text-center font-size-ui-60 pointer\" onclick=\"update('global')\">Global</span>\n" +
            "        <span id=\"scope_local\" class=\"position-fixed w-50 l-50 r-0 text-center font-size-ui-60 pointer\" onclick=\"update('local')\">Local</span>\n" +
            "    </div>\n" +
            "    <div id=\"results\" class=\"position-fixed w-100 h-70 overflow-y-auto t-30 text-center\"></div>\n" +
            "    <script src=\"./js/history.js\"></script>\n" +
            "</body>"
        );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        List<Result> results = switch(request.getParameter("scope")) {
            case "global" -> ResultService.getResults();
            case "local" -> ResultService.getResultsWithIds(Utils.getLocalGames(request));
            default -> throw new ServletException("Invalid scope");
        };

        Collections.reverse(results);

        for (Result result : results)
            out.printf(
                "       <div class=\"font-size-ui-40\">Game #%x | Played: %s | %s</div><iframe class=\"border-none r-0\" width=\"150\" height=\"'150\" src=\"./simulate?steps=%s\"></iframe>",
                result.getResultID(),
                sdf.format(result.getTimestamp()),
                (result.getWinner().equals("Draw")) ? "Draw" : "Winner: " + result.getWinner(),
                result.getSteps()
            );
    }
}
