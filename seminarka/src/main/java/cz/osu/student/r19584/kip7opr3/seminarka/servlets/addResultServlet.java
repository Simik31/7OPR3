package cz.osu.student.r19584.kip7opr3.seminarka.servlets;

import cz.osu.student.r19584.kip7opr3.seminarka.models.Result;
import cz.osu.student.r19584.kip7opr3.seminarka.models.Winner;
import cz.osu.student.r19584.kip7opr3.seminarka.services.ResultService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "addResultServlet", value = "/addResult")
public class addResultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(403);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Winner winner = switch (request.getParameter("result")) {
            case "x" -> Winner.X;
            case "O" -> Winner.O;
            case "draw" -> Winner.DRAW;
            default -> throw new ServletException("Invalid winner");
        };

        ResultService.addResult(new Result(
                Integer.parseInt(request.getParameter("id"), 16),
                LocalDateTime.now(),
                winner
        ));
    }
}
