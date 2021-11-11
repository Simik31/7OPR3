package cz.osu.student.r19584.kip7opr3.seminarka.servlets.history;

import cz.osu.student.r19584.kip7opr3.seminarka.Utils;
import cz.osu.student.r19584.kip7opr3.seminarka.models.Result;
import cz.osu.student.r19584.kip7opr3.seminarka.services.ResultService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "localHistoryServlet", value = "/history/local")
public class localHistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Result> results = ResultService.getResultsWithIds(Utils.getLocalGames(request));

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<title>Tic-Tac-Toe :: Local history</title>");
        out.print("<script src=\"https://cdn.jsdelivr.net/npm/js-cookie@3.0.1/dist/js.cookie.min.js\"></script>");

        for (Result result : results)
            out.print("<p>" + result + "<iframe width=\"150\" height=\"150\" src=\"../simulate?steps=" + result.getSteps().toString().replace("[", "").replace("]", "").replace(" ", "") + "\"></iframe></p>");

        if (results.size() > 0) {
            out.print("<form id=\"clearForm\" action=\"../\" method=\"post\">" +
                    "   <input type=\"hidden\" value=\"\">" +
                    "   <a href=\"#\" onclick=\"clearHistory()\">Clear local history</a>" +
                    "</form>");
            out.print("<script>" +
                    "   function clearHistory() {" +
                    "       Cookies.remove(\"resultIds\");" +
                    "       document.getElementById(\"clearForm\").submit();" +
                    "   }" +
                    "</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(403);
    }
}
