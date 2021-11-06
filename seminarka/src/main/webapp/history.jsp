<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <title>Tic-Tac-Toe :: History</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="./css/main.css" />
    <link rel="stylesheet" href="./css/history.css" />
</head>
<body>

<div class="content">
    <a id="global" href="./history/global">Global history</a>
    <form id="localForm" action="./history/local" method="post">
        <input type="hidden" name="resultIds" id="resultIds" value="">
        <a id="local" href="#" onclick="localHistory()">Local history</a>
    </form>
</div>
<script>
    function localHistory() {
        document.getElementById("resultIds").value = localStorage.getItem("resultIds");
        document.getElementById("localForm").submit();
    }
</script>
</body>
</html>