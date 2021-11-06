<%@ page import="java.util.Random" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <title>Tic-Tac-Toe</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="./AlertifyJS/alertify.min.js"></script>
    <link rel="stylesheet" href="./AlertifyJS/alertify.min.css">
    <link rel="stylesheet" href="./AlertifyJS/default.min.css">
    <link rel="stylesheet" href="./css/main.css" />
    <link rel="stylesheet" href="./css/game.css" />
</head>
<body>
<div class="content">
    <h1 id="title">Tic-Tac-Toe</h1>
    <h2 id="on_move">On move</h2>

    <%
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                out.print("<span id=\"cell_" + (r * 3 + c) + "\" class=\"r" + r + " c" + c + " cell playable\"></span>\n");

        for (char c : new char[]{'h', 'v'})
            for (int i = 1; i < 3; i++)
                out.print("<span id=\"s" + c + "" + i + "\" class=\"s" + c + " spacer\"></span>\n");
    %>

    <a id="history" href="./history.jsp">History</a>
    <a id="stats" href="./stats">Statistics</a>
</div>

<h3 id="game_id">Game #<span id="gameId"><%
    out.print(String.format("%x", new Random().nextInt(0x10000000) + 0x10000000)); // 161,061,273 combinations
%></span></h3>

<script src="./js/game.js"></script>
</body>
</html>