package cz.osu.student.r19584.kip7opr3.seminarka.servlets.history;

import cz.osu.student.r19584.kip7opr3.seminarka.models.Result;
import cz.osu.student.r19584.kip7opr3.seminarka.services.ResultService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "globalHistoryServlet", value = "/history/global")
public class globalHistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Result> results = ResultService.getResults();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<title>Tic-Tac-Toe :: Global history</title>");

        for (Result result : results)
            out.print("<p>" + result + "<iframe width=\"150\" height=\"'150\" src=\"../simulate?steps=" + result.getSteps().toString().replace("[", "").replace("]", "").replace(" ", "") + "\"></iframe></p>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(403);
    }
}
