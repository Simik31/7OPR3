<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>My blog</title>
    <style>
        <%@ include file="style.css" %>
    </style>
</head>
<body>
<h1>Čauky lidi!</h1>
<br/>
<h2>Kód vygenerovaný Javou:</h2>
<p><%
    for(int i = 0; i < 5; i++) {
        out.print(i + ": Ahoj :) <br>");
    }
%></p>
<p>
Hello servlet: <a href="hello-servlet">Hello Servlet</a><br>
Article servlet: <a href="article">Article Servlet</a><br>
</p>

<%
    if (request.getQueryString() != null && request.getQueryString().contains("error")) {
        out.print("<span class='error'>" + request.getParameter("error") + "</span>");
    }
%>

<h2>Napište nám :)</h2>
<form action="article" method="post">
    <label>ID clanku:</label>
    <input type="number" name="id">
    <br>
    <label>Autor:</label>
    <input type="text" name="author">
    <br>
    <label>Tel. cislo:</label>
    <input type="tel" name="phone_no">
    <br>
    <label>Nadpis:</label>
    <input type="text" name="title">
    <br>
    <label>Obsah:</label>
    <input type="text" name="content">
    <br>
    <input type="submit" value="Odeslat">
</form>

</body>
</html>