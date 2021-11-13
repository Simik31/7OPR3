package cz.osu.student.r19584.kip7opr3.seminarka.servlets;

import cz.osu.student.r19584.kip7opr3.seminarka.models.Result;
import cz.osu.student.r19584.kip7opr3.seminarka.services.ResultService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@WebServlet(name = "addResultServlet", value = "/addResult")
public class addResultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(403);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Result result = new Result();
        result.setID(Integer.parseInt(request.getParameter("id"), 16));
        result.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
        result.setWinner(request.getParameter("result"));
        result.setSteps(request.getParameter("steps"));
        ResultService.addResult(result);

    }
}
