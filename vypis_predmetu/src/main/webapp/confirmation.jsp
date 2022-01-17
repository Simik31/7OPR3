<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="cz.osu.student.r19584.vypis_predmetu.Utils" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="courseService" class="cz.osu.student.r19584.vypis_predmetu.CourseService" scope="application" />

<!DOCTYPE html>
<html lang="cs">
<head>
    <title>Výpis předmětů :: Potvrzení</title>
    <link rel="stylesheet" href="css/index.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 class="text-center">Výpis předmětů :: Potvrzení</h1>
    <br/>

    <div class="form-group">
        <span>Jméno</span>
        <div class="form-control" id="name">${param.name}</div>
    </div>
    <div class="form-group">
        <span>Příjmení</span>
        <div class="form-control" id="surname">${param.surname}</div>
    </div>
    <br>
    <div class="form-group">
        <span>E-mail</span>
        <div class="form-control" id="email" >${param.email}</div>
    </div>
    <div class="form-group">
        <span>Studijní číslo</span>
        <div class="form-control" id="student_id">${param.student_id}</div>
    </div>

    <br>
    <h2 class="text-center">Zapsané kurzy</h2>
    <table class="table table-striped text-center">
        <thead>
            <tr>
                <th>Zkratka</th><th>Název předmětu</th><th>Kredity</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="uuid" items="${Utils.arrayStringToList(param.courses)}">
                <c:set var="course" value="${courseService.getCourseByUUID(uuid)}" />
                <tr id="${uuid}">
                    <th>${course.abbreviation}</th>
                    <th>${course.name}</th>
                    <th>${course.credits}</th>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>