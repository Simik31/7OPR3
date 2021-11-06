<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>R19584 BOOK STORE :: Main page</title>
</head>
<body>
<form action="addBookServlet" method="post">
    <label>
        ID Knihy:
        <input type="number" name="id">
    </label>
    <label>
        Název:
        <input type="text" name="title">
    </label>
    <label>
        Autor:
        <input type="text" name="author">
    </label>
    <label>
        Okdaz ke stažení:
        <input type="url" name="downloadUrl">
    </label>
    <input type="submit" value="Přidat knihu">
</form>
<br/>
<jsp:include page="bookList.jsp" />
<jsp:include page="cart.jsp" />
</body>
</html>