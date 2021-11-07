package cz.osu.student.r19584.kip7opr3.seminarka.servlets.history;

import cz.osu.student.r19584.kip7opr3.seminarka.models.Result;
import cz.osu.student.r19584.kip7opr3.seminarka.services.ResultService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "localHistoryServlet", value = "/history/local")
public class localHistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cookie> cookies = List.of(request.getCookies());
        Optional<Cookie> id_cookie = cookies.stream().filter(cookie -> cookie.getName().equals("resultIds")).findFirst();

        String id_string;
        List<Result> results;

        if (id_cookie.isPresent() && !(id_string = id_cookie.get().getValue()).equals("")) {
            id_string = URLDecoder.decode(id_string, Charset.defaultCharset());
            List<String> ids_str = List.of(id_string.contains(",") ? id_string.split(",") : new String[]{id_string});
            List<Integer> ids = new ArrayList<>();
            for (String id : ids_str)
                ids.add(Integer.parseInt(id, 16));

            results = ResultService.getResultsWithIds(ids);
        } else results = new ArrayList<>();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<title>Tic-Tac-Toe :: Local history</title>");
        out.print("<script src=\"https://cdn.jsdelivr.net/npm/js-cookie@3.0.1/dist/js.cookie.min.js\"></script>");

        for (Result result : results)
            out.print(result + "<br>");

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
