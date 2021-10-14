<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="cs">
<head>
    <title>FORM</title>
</head>
<body>

<form>
    <h3>Zadejte detaily nového studenta:</h3>
    <label for="name">Jméno: </label>
    <input type="text" name="name" id="name">
    <label for="surname">Příjmení: </label>
    <input type="text" name="surname" id="surname">
    <label for="student_no">Studentské číslo: </label>
    <input type="text" name="student_no" id="student_no">
    <label for="email">E-mail: </label>
    <input type="text" name="email" id="email">
    <label for="phone_no">Telefon: </label>
    <input type="text" name="phone_no" id="phone_no">
    <hr>
    <label for="password">Heslo: </label>
    <input type="password" name="password" id="password">
    <label for="password_confirm">Potvrďte heslo: </label>
    <input type="password" name="password_confirm" id="password_confirm">
    <hr>
    <label for="sex">Pohlaví: </label>
    <select name="sex" id="sex">
        <option value="" selected disabled>VYBERTE</option>
        <option value="M">Muž</option>
        <option value="F">Žena</option>
    </select>
    <hr>
    <label>Zájem: </label>
    <div id="hobby">
        <label for="active_sport">Aktivní sport: </label>
        <input type="radio" name="hobby" id="active_sport" value="active_sport"><br>
        <label for="passive_sport">Pasivní sport: </label>
        <input type="radio" name="hobby" id="passive_sport" value="passive_sport"><br>
        <label for="shopping">Nakupování: </label>
        <input type="radio" name="hobby" id="shopping" value="shopping"><br>
        <label for="watching_movies">Sledování filmů: </label>
        <input type="radio" name="hobby" id="watching_movies" value="watching_movies"><br>
        <label for="travelling">Cestování: </label>
        <input type="radio" name="hobby" id="travelling" value="travelling">
    </div>
    <hr>
    <label for="birth_date">Datum narození:</label>
    <div id="birth_date">
        <select name="day_of_birth" id="day_of_birth">
            <option value="" selected disabled>DEN</option>
            <%
                for (int d = 1; d <= 31; d++)
                    out.print("<option value=\"" + d + "\">" + d + "</option>\n");
            %>
        </select>
        <select name="month_of_birth" id="month_of_birth">
            <option value="" selected disabled>MĚSÍC</option>
            <%
                for (int m = 1; m <= 12; m++)
                    out.print("<option value=\"" + m + "\">" + m + "</option>\n");
            %>
        </select>
        <select name="year_of_birth" id="year_of_birth">
            <option value="" selected disabled>ROK</option>
            <%
                for (int y = 2000; y >= 1970; y--)
                    out.print("<option value=\"" + y + "\">" + y + "</option>\n");
            %>
        </select>
    </div>
</form>

</body>
</html>
