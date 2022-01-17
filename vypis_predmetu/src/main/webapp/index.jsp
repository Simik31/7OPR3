<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="cz.osu.student.r19584.vypis_predmetu.Utils" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="courseService" class="cz.osu.student.r19584.vypis_predmetu.CourseService" scope="application" />

<c:set var="name" value="${(param.name == null || param.name == '') ? '' : param.name}" />
<c:set var="surname" value="${(param.surname == null || param.surname == '') ? '' : param.surname}" />
<c:set var="email" value="${(param.email == null || param.email == '') ? '' : param.email}" />
<c:set var="student_id" value="${(param.student_id == null || param.student_id == '') ? '' : param.student_id}" />

<c:set var="errors" value="${(param.errors == null || param.errors == '') ? [] : Utils.arrayStringToList(param.errors)}" />
<c:set var="courses" value="${(param.courses == null || param.courses == '') ? [] : Utils.arrayStringToList(param.courses)}" />

<!DOCTYPE html>
<html lang="cs">
    <head>
        <title>Výpis předmětů</title>
        <link rel="stylesheet" href="css/index.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">Výpis předmětů</h1>
            <br/>

            <c:if test="${errors != []}">
                <div id="errors" class="alert alert-danger" role="alert">
                    <ul>
                        <c:forEach var="error" items="${errors}">
                            <li>${error}</li>
                        </c:forEach>
                    </ul>
                </div>
            </c:if>

            <form action="./send" method="post">
                <div class="form-group">
                    <label for="name">Jméno</label>
                    <input type="text" class="form-control" id="name" name="name" value="${name}">
                </div>
                <div class="form-group">
                    <label for="surname">Příjmení</label>
                    <input type="text" class="form-control" id="surname" name="surname" value="${surname}">
                </div>
                <br>
                <div class="form-group">
                    <label for="email">E-mail</label>
                    <input type="email" class="form-control" id="email" name="email" value="${email}">
                </div>
                <div class="form-group">
                    <label for="student_id">Studijní číslo</label>
                    <input type="text" class="form-control" id="student_id" name="student_id" value="${student_id}">
                </div>
                <table class="table table-striped text-center">
                    <thead><tr><th></th><th>Zkratka</th><th>Název předmětu</th><th>Kredity</th></tr></thead>
                    <tbody>
                        <c:set var="id" value="${Utils.nextId(true)}" />
                        <c:forEach var="course" items="${courseService.courses}">
                            <c:set var="id" value="course_${Utils.nextId(false)}" />
                            <tr>
                                <th><label for="${id}"><input type="checkbox" id="${id}" name="${id}" value="${course.UUID}" ${courses.contains(course.UUID) ? 'checked' : ''}></label></th>
                                <th>${course.abbreviation}</th>
                                <th>${course.name}</th>
                                <th>${course.credits}</th>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <button type="submit" class="btn btn-success float-end">Odešli</button>
            </form>
        </div>
    </body>
</html>