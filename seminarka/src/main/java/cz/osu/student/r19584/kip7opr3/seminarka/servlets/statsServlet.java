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

        String x_percent = String.format("%.1f", ResultService.getNumberOfWinedGames(Winner.X) * 100.0 / Math.max(1, ResultService.getNumberOfGames()));
        String o_percent = String.format("%.1f", ResultService.getNumberOfWinedGames(Winner.O) * 100.0 / Math.max(1, ResultService.getNumberOfGames()));
        String d_percent = String.format("%.1f", ResultService.getNumberOfWinedGames(Winner.DRAW) * 100.0 / Math.max(1, ResultService.getNumberOfGames()));

        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\" />\n" +
                "    <title>Tic-Tac-Toe :: Stats</title>\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n" +
                "    <link rel=\"stylesheet\" href=\"./css/main.css\" />\n" +
                "    <link rel=\"stylesheet\" href=\"./css/stats.css\" />\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"content\">\n" +
                "        <h1 id=\"title\">Win rates</h1>\n" +
                "        <div id=\"stats_theoretical\">\n" +
                "            <h1 class=\"title\">Theroteical</h1>\n" +
                "            <span class=\"stats_label win_rate_x\">x</span>\n" +
                "            <span class=\"stats_label draw_rate\">draw</span>\n" +
                "            <span class=\"stats_label win_rate_o\">O</span>\n" +
                "\n" +
                "            <span class=\"stats_percent win_rate_x\">58.5%</span>\n" +
                "            <span class=\"stats_percent draw_rate\">12.7%</span>\n" +
                "            <span class=\"stats_percent win_rate_o\">28.8%</span>\n" +
                "\n" +
                "            <div class=\"bar\">\n" +
                "                <div class=\"bar_x bar_line\">x</div>\n" +
                "                <div class=\"bar_o bar_line\">O</div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div id=\"stats_real\">\n" +
                "            <h1 class=\"title\">Real</h1>\n" +
                "            <span class=\"stats_label win_rate_x\">x</span>\n" +
                "            <span class=\"stats_label draw_rate\">draw</span>\n" +
                "            <span class=\"stats_label win_rate_o\">O</span>\n" +
                "\n" +
                "            <span class=\"stats_percent win_rate_x\">" + x_percent + "%</span>\n" +
                "            <span class=\"stats_percent draw_rate\">" + d_percent + "%</span>\n" +
                "            <span class=\"stats_percent win_rate_o\">" + o_percent + "%</span>\n" +
                "\n" +
                "            <div class=\"bar\">\n" +
                "                <div class=\"bar_x bar_line\" style=\"width: calc(" + x_percent + "% - " + ((Double.parseDouble(x_percent) < 98.5) ? "" : "2 * ") + "var(--bar-border-width));\">x</div>\n" +
                "                <div class=\"bar_o bar_line\" style=\"width: calc(" + o_percent + "% - " + ((Double.parseDouble(o_percent) < 98.5) ? "" : "2 * ") + "var(--bar-border-width));\">O</div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div id=\"stats_list\">\n" +
                "            <span>X wins: " + ResultService.getNumberOfWinedGames(Winner.X) + " - " + x_percent + "%</span><br />\n" +
                "            <span>O wins: " + ResultService.getNumberOfWinedGames(Winner.O) + " - " + o_percent + "%</span><br />\n" +
                "            <span>Draws: " + ResultService.getNumberOfWinedGames(Winner.DRAW) + " - " + d_percent + "%</span>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(403);
    }
}
