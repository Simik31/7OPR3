package cz.osu.student.r19584.kip7opr3.seminarka.servlets;

import cz.osu.student.r19584.kip7opr3.seminarka.models.Winner;
import cz.osu.student.r19584.kip7opr3.seminarka.services.ResultService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "simulateServlet", value = "/simulate")
public class simulateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        out.println("    <link rel=\"stylesheet\" href=\"./css/main.css\" />\n" +
                "    <link rel=\"stylesheet\" href=\"./css/simulate.css\" />\n" +
                "    <link rel=\"stylesheet\" href=\"./css/game.css\" />");
        out.print("<div class=\"content\">");
        out.print("<input type=\"hidden\" id=\"steps\" value=\"" + request.getParameter("steps") + "\">");

        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                out.print("<span id=\"cell_" + (r * 3 + c) + "\" class=\"r" + r + " c" + c + " cell\"></span>\n");

        for (char c : new char[]{'h', 'v'})
            for (int i = 1; i < 3; i++)
                out.print("<span id=\"s" + c + "" + i + "\" class=\"s" + c + " spacer\"></span>\n");
        out.print("</div>");
        out.print("<canvas with=150 height=150 />");
        out.print("<script src=\"./js/simulate.js\"></script>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(403);
    }
}
