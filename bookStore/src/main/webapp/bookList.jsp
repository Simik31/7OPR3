<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="bookService" class="cz.osu.student.r19584.kip7opr3.bookstore.services.BookService" scope="application" />
<jsp:useBean id="cartService" class="cz.osu.student.r19584.kip7opr3.bookstore.services.CartService" scope="session" />

<c:if test="${bookService.books.size() > 0}">
<h1>
    Nabídka knih
</h1>
<table class="table text-light">
    <thead class="thead-light">
        <tr>
            <th scope="col" class="w-50">Title</th><th scope="col" class="w-25">Author</th><th scope="col" class="w-25"></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="book" items="${bookService.books}">
            <tr>
                <th scope="row">${book.title}</th>
                <td>${book.author}</td>
                <td>
                    <c:if test="${book.purchased == false}">
                        <c:if test="${cartService.isBookInCart(book) == false}">
                            <form action="addCartServlet" method="post">
                                <input type="hidden" name="id" value="${book.id}">
                                <button type="submit" class="btn btn-primary">
                                    <i class="bi bi-cart-plus"></i>
                                    Přidat do košíku
                                </button>
                            </form>
                        </c:if>
                        <c:if test="${cartService.isBookInCart(book) == true}">
                            <button class="btn btn-secondary" disabled>
                                <i class="bi bi-cart-check-fill"></i>
                                V košíku
                            </button>
                        </c:if>
                    </c:if>
                    <c:if test="${book.purchased == true}">
                        <form action="${book.downloadUrl}" method="post">
                            <button type="submit" class="btn btn-info">
                                <i class="bi bi-book"></i>
                                Zobrazit knihu
                            </button>
                        </form>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</c:if>
<c:if test="${bookService.books.size() == 0}">
<h1>
    Omlouváme se, ale aktuálně nemáme v nabídce žádné knihy.
</h1>
</c:if>