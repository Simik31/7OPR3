<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="bookService" class="cz.osu.student.r19584.kip7opr3.bookstore.services.BookService" scope="application" />

<table>
    <thead>
        <tr>
            <td>Title</td><td>Author</td>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="book" items="${bookService.books}">
            <tr>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>
                    <form action="addCartServlet" method="post">
                        <input type="hidden" name="id" value="${book.id}">
                        <input type="submit" value="Přidat do košíku">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>