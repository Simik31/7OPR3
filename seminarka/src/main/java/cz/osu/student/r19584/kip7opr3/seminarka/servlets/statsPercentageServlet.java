package cz.osu.student.r19584.kip7opr3.seminarka.servlets;

import cz.osu.student.r19584.kip7opr3.seminarka.Utils;
import cz.osu.student.r19584.kip7opr3.seminarka.models.Result;
import cz.osu.student.r19584.kip7opr3.seminarka.models.Winner;
import cz.osu.student.r19584.kip7opr3.seminarka.services.ResultService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "statsRenderServlet", value = "/statsPercentage")
public class statsPercentageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(403);
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
            "   \"px\": \"" + percent_x + "%\"," +
            "   \"pd\": \"" + percent_d + "%\"," +
            "   \"po\": \"" + percent_o + "%\"," +
            "" +
            "   \"cx\": " + count_x + "," +
            "   \"cd\": " + count_d + "," +
            "   \"co\": " + count_o + "" +
            "}]"
        );
    }
}
