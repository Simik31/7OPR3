package cz.osu.student.r19584.kip7opr3.seminarka.servlets;

import cz.osu.student.r19584.kip7opr3.seminarka.Utils;
import cz.osu.student.r19584.kip7opr3.seminarka.Winner;
import cz.osu.student.r19584.kip7opr3.seminarka.models.Result;
import cz.osu.student.r19584.kip7opr3.seminarka.services.ResultService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
                "    <link rel=\"stylesheet\" href=\"./css/classes.css\" />\n" +
                "    <link rel=\"stylesheet\" href=\"./css/stats.css\" />\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"content position-fixed\">\n" +
                "        <h1 id=\"title\" class=\"position-fixed\">Statistics</h1>\n" +
                "\n" +
                "        <span id=\"scope_theoretical\" class=\"w-33 l-0 r-66 text-center font-size-ui-45 pointer position-fixed\" onclick=\"update('theoretical')\">Theoretical</span>\n" +
                "        <span id=\"scope_global\" class=\"w-33  l-33 r-33 text-center font-size-ui-45 pointer position-fixed\" onclick=\"update('global')\">Global</span>\n" +
                "        <span id=\"scope_local\" class=\"w-33 l-66 r-0 text-center font-size-ui-45 pointer position-fixed\" onclick=\"update('local')\">Local</span>\n" +
                "\n" +
                "        <span class=\"color_x w-100 t-50 y-200 font-size-ui-100 text-left position-fixed\">x</span>\n" +
                "        <span class=\"w-100 t-50 y-200 font-size-ui-100 text-center position-fixed\">draw</span>\n" +
                "        <span class=\"color_o w-100 t-50 y-200 font-size-ui-100 text-right position-fixed\">O</span>\n" +
                "\n" +
                "        <span id=\"percentage_x\" class=\"color_x w-100 t-50 y-200 font-size-ui-60 text-left position-fixed\"><span id=\"percent_x\" class=\"counter\" data-start=\"0.0\" data-target=\"0.0\" data-digits=\"1\">0.0</span>%</span>\n" +
                "        <span id=\"percentage_d\" class=\"w-100 t-50 y-200 font-size-ui-60 text-center position-fixed\"><span id=\"percent_d\" class=\"counter\" data-start=\"0.0\" data-target=\"0.0\" data-digits=\"1\">0.0</span>%</span>\n" +
                "        <span id=\"percentage_o\" class=\"color_o w-100 t-50 y-200 font-size-ui-60 text-right position-fixed\"><span id=\"percent_o\" class=\"counter\" data-start=\"0.0\" data-target=\"0.0\" data-digits=\"1\">0.0</span>%</span>\n" +
                "\n" +
                "        <div class=\"bar text-center bar_box font-size-ui-60 t-50 y-50 l-0 r-0 border-radius-100 position-fixed\">\n" +
                "            <div id=\"bar_x\" class=\"bar over-hidden bg_color_x border-radius-50 l-0 position-fixed\" style=\"width:0\">x</div>\n" +
                "            <div id=\"bar_o\" class=\"bar over-hidden bg_color_o border-radius-50 r-0 position-fixed\" style=\"width:0\">O</div>\n" +
                "        </div>\n" +
                "\n" +
                "        <span id=\"count_x\" class=\"t-50 font-size-ui-60 position-fixed\">X wins: <span id=\"counter_x\" class=\"counter\" data-start=\"0\" data-target=\"0\" data-digits=\"0\">0</span></span>\n" +
                "        <span id=\"count_d\" class=\"t-50 font-size-ui-60 position-fixed\">Draws: <span id=\"counter_d\" class=\"counter\" data-start=\"0\" data-target=\"0\" data-digits=\"0\">0</span></span>\n" +
                "        <span id=\"count_o\" class=\"t-50 font-size-ui-60 position-fixed\">O wins: <span id=\"counter_o\" class=\"counter\" data-start=\"0\" data-target=\"0\" data-digits=\"0\">0</span></span>\n" +
                "    </div>\n" +
                "\n" +
                "<script src=\"./js/stats.js\"></script>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String statsScope = request.getParameter("scope");

        long count_x, count_d, count_o, count_total;

        switch (statsScope) {
            case "theoretical" -> {
                count_total = 126;
                count_x = 74;
                count_d = 16;
                count_o = 36;
            }
            case "global" -> {
                count_total = Math.max(1, ResultService.getNumberOfGames());
                count_x = ResultService.getNumberOfWinedGames(Winner.X);
                count_d = ResultService.getNumberOfWinedGames(Winner.DRAW);
                count_o = ResultService.getNumberOfWinedGames(Winner.O);
            }
            case "local" -> {
                List<Result> results = ResultService.getResultsWithIds(Utils.getLocalGames(request));

                count_total = Math.max(1, results.size());
                count_x = results.stream().filter(result -> result.getWinner() == Winner.X).count();
                count_d = results.stream().filter(result -> result.getWinner() == Winner.DRAW).count();
                count_o = results.stream().filter(result -> result.getWinner() == Winner.O).count();
            }
            default -> throw new ServletException("Invalid scope");
        }

        String percent_x = String.format("%.1f", count_x * 100.0 / count_total);
        String percent_d = String.format("%.1f", count_d * 100.0 / count_total);
        String percent_o = String.format("%.1f", count_o * 100.0 / count_total);

        response.getWriter().println(
            "[{" +
            "   \"px\": " + percent_x + "," +
            "   \"pd\": " + percent_d + "," +
            "   \"po\": " + percent_o + "," +
            "" +
            "   \"cx\": " + count_x + "," +
            "   \"cd\": " + count_d + "," +
            "   \"co\": " + count_o + "" +
            "}]"
        );
    }
}
