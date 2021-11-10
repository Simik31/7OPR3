<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<jsp:include page="header.jsp" />
<h1>Přidat knihu</h1>
<form action="addBookServlet" method="post">
    <div class="form-outline mb-4">
        <label class="form-label" for="id">ID knihy</label>
        <input type="number" id="id" name="id" class="form-control" />
    </div>
    <div class="form-outline mb-4">
        <label class="form-label" for="title">Název knihy</label>
        <input type="text" id="title" name="title" class="form-control" />
    </div>
    <div class="form-outline mb-4">
        <label class="form-label" for="author">Autor knihy</label>
        <input type="text" id="author" name="author" class="form-control" />
    </div>
    <div class="form-outline mb-4">
        <label class="form-label" for="downloadUrl">URL pro stažení knihy</label>
        <input type="text" id="downloadUrl" name="downloadUrl" class="form-control" />
    </div>

    <div class="form-outline mb-4">
        <button type="submit" class="btn btn-success">
            Přidat knihu
            <i class="bi bi-plus-circle"></i>
        </button>
    </div>
</form>
<jsp:include page="footer.jsp" />
</body>
</html>