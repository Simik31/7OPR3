<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="cartService" class="cz.osu.student.r19584.kip7opr3.bookstore.services.CartService" scope="session" />

<h1>
    Můj košík
</h1>
<table>
    <thead>
        <tr><td>Název</td><td>Autor</td><td>Počet</td></tr>
    </thead>
    <tbody>
        <c:forEach var="book" items="${cartService.books}">
            <tr>
                <td>${book.key.title}</td>
                <td>${book.key.author}</td>
                <td>${book.value}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<button>Zaplatit</button>