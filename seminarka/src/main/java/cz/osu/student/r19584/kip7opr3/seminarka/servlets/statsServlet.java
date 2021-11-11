package cz.osu.student.r19584.kip7opr3.seminarka.servlets;

import cz.osu.student.r19584.kip7opr3.seminarka.models.Winner;
import cz.osu.student.r19584.kip7opr3.seminarka.services.ResultService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "statsServlet", value = "/stats")
public class statsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\" />\n" +
                "    <title>Tic-Tac-Toe :: Statistics</title>\n" +
                "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\n" +
                "    <script src=\"https://cdn.jsdelivr.net/npm/js-cookie@3.0.1/dist/js.cookie.min.js\"></script>\n" +
                "    <script src=\"./AlertifyJS/alertify.min.js\"></script>\n" +
                "    <link rel=\"stylesheet\" href=\"./AlertifyJS/alertify.min.css\">\n" +
                "    <link rel=\"stylesheet\" href=\"./AlertifyJS/default.min.css\">" +
                "    <link rel=\"stylesheet\" href=\"./css/main.css\" />\n" +
                "    <link rel=\"stylesheet\" href=\"./css/stats.css\" />\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"content\">\n" +
                "        <h1 id=\"title\">Statistics</h1>\n" +
                "\n" +
                "        <span id=\"scope_theoretical\" class=\"w-33 l-0 r-66 text-center font-size-ui-45 pointer\" onclick=\"update('theoretical')\">Theoretical</span>\n" +
                "        <span id=\"scope_global\" class=\"w-33  l-33 r-33 text-center font-size-ui-45 pointer\" onclick=\"update('global')\">Global</span>\n" +
                "        <span id=\"scope_local\" class=\"w-33 l-66 r-0 text-center font-size-ui-45 pointer\" onclick=\"update('local')\">Local</span>\n" +
                "\n" +
                "        <span class=\"color_x w-100 t-50 y-200 font-size-ui-100 text-left\">x</span>\n" +
                "        <span class=\"w-100 t-50 y-200 font-size-ui-100 text-center\">draw</span>\n" +
                "        <span class=\"color_o w-100 t-50 y-200 font-size-ui-100 text-right\">O</span>\n" +
                "\n" +
                "        <span id=\"percentage_x\" class=\"color_x w-100 t-50 y-200 font-size-ui-60 text-left\">0.0%</span>\n" +
                "        <span id=\"percentage_d\" class=\"w-100 t-50 y-200 font-size-ui-60 text-center\">0.0%</span>\n" +
                "        <span id=\"percentage_o\" class=\"color_o w-100 t-50 y-200 font-size-ui-60 text-right\">0.0%</span>\n" +
                "\n" +
                "        <div class=\"bar text-center bar_box font-size-ui-60 t-50 y-50 l-0 r-0 border-radius-100\">\n" +
                "            <div id=\"bar_x\" class=\"bar over-hidden bg_color_x border-radius-50 l-0\" style=\"width:0\">x</div>\n" +
                "            <div id=\"bar_o\" class=\"bar over-hidden bg_color_o border-radius-50 r-0\" style=\"width:0\">O</div>\n" +
                "        </div>\n" +
                "\n" +
                "       <div id=\"stats_list\">\n" +
                "            <span id=\"count_x\" class=\"t-50 font-size-ui-60\">X wins: </span>\n" +
                "            <span id=\"count_d\" class=\"t-50 font-size-ui-60\">Draws: </span>\n" +
                "            <span id=\"count_o\" class=\"t-50 font-size-ui-60\">O wins: </span>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "\n" +
                "<script src=\"./js/stats.js\"></script>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(403);
    }
}
