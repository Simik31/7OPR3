package cz.osu.student.r19584.kip7opr3.seminarka.servlets.history;

import cz.osu.student.r19584.kip7opr3.seminarka.models.Result;
import cz.osu.student.r19584.kip7opr3.seminarka.services.ResultService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "localHistoryServlet", value = "/history/local")
public class localHistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("../history.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Result> results;
        String id_string = request.getParameter("resultIds");

        if (id_string != null && !id_string.equals("")) {
            List<String> ids_str = List.of(id_string.contains(",") ? id_string.split(",") : new String[]{id_string});
            List<Integer> ids = new ArrayList<>();
            for (String id : ids_str)
                ids.add(Integer.parseInt(id, 16));

            results = ResultService.getResultsWithIds(ids);
        } else results = new ArrayList<>();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<title>Tic-Tac-Toe :: Local history</title>");

        for (Result result : results)
            out.print(result + "<br>");

        if (results.size() > 0) {
            out.print("<form id=\"clearForm\" action=\"../history.jsp\" method=\"post\">" +
                    "   <input type=\"hidden\" value=\"\">" +
                    "   <a href=\"#\" onclick=\"clearHistory()\">Clear local history</a>" +
                    "</form>");
            out.print("<script>" +
                    "   function clearHistory() {" +
                    "       localStorage.clear();" +
                    "       document.getElementById(\"clearForm\").submit();" +
                    "   }" +
                    "</script>");
        }
    }
}
