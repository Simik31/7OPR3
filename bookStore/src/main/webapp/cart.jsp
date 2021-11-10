<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="cartService" class="cz.osu.student.r19584.kip7opr3.bookstore.services.CartService" scope="session" />

<jsp:include page="header.jsp" />

<c:if test="${cartService.books.isEmpty() == false}">
<h1>
    Můj košík
</h1>
    <table class="table text-light">
        <thead class="thead-light">
        <tr><th scope="col" class="w-50">Název</th><th scope="col" class="w-25">Autor</th><th scope="col" class="w-25">Počet</th></tr>
    </thead>
    <tbody>
        <c:forEach var="book" items="${cartService.books}">
            <tr>
                <th scope="row">${book.key.title}</th>
                <td>${book.key.author}</td>
                <td>${book.value}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<form action="payment" method="post">
    <button type="submit" class="btn btn-success">
        Zaplatit
        <i class="bi bi-credit-card-fill"></i>
    </button>
</form>
</c:if>
<c:if test="${cartService.books.isEmpty()}">
    <h1>Nemáte nic v košíku</h1>
</c:if>
<jsp:include page="footer.jsp" />