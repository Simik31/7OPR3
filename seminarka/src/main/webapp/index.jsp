<%@ page import="java.util.Random" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="utf-8" />
        <title>Tic-Tac-Toe</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/js-cookie@3.0.1/dist/js.cookie.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/alertify.min.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/alertify.min.css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/default.min.css"/>
        <link rel="stylesheet" href="./css/main.css" />
        <link rel="stylesheet" href="./css/classes.css" />
        <link rel="stylesheet" href="./css/game.css" />
    </head>
    <body>
        <div class="content position-fixed">
            <h1 id="title" class="position-fixed">Tic-Tac-Toe</h1>
            <h2 id="on_move" class="position-fixed">On move</h2>

            <%
                for (int r = 0; r < 3; r++)
                    for (int c = 0; c < 3; c++)
                        out.print("<span id=\"cell_" + (r * 3 + c) + "\" class=\"r" + r + " c" + c + " cell playable position-fixed\"></span>\n");

                for (char c : new char[]{'h', 'v'})
                    for (int i = 1; i < 3; i++)
                        out.print("<span id=\"s" + c + "" + i + "\" class=\"s" + c + " spacer position-fixed\"></span>\n");
            %>

            <a id="history" class="position-fixed" href="./history">History</a>
            <a id="stats" class="position-fixed" href="./stats">Statistics</a>
        </div>

        <h3 id="game_id" class="position-fixed">Game #<span id="gameId"><%
            out.print(String.format("%x", new Random().nextInt(0x10000000) + 0x10000000)); // 161,061,273 combinations
        %></span></h3>

        <script type="module" src="./js/game.js"></script>
    </body>
</html>