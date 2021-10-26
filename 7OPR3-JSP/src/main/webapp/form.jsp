<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="cs">
<head>
    <title>FORM</title>
    <link href="css/main.css" rel="stylesheet">
</head>
<body>
    <div id="wrapper">
        <%
            if (request.getParameter("error") != null) {
                out.print("<div class='error'><span>Přiukládání studenta nastala chyba: " + request.getParameter("error") + "</span></div>");
            }
        %>

        <form id="register_form" method="post" action="./students">
            <h3 id="title">Zadejte detaily nového studenta:</h3>
            <label id="name_label" for="name_input">Jméno: </label>
            <input id="name_input" type="text" name="name" required>
            <label id="surname_label" for="surname_input">Příjmení: </label>
            <input id="surname_input" type="text" name="surname" required><br>
            <label id="student_no_label" for="student_no_input">Studentské číslo: </label>
            <input id="student_no_input" type="text" name="student_no" required><br>
            <label id="email_label" for="email_input">E-mail: </label>
            <input id="email_input" type="text" name="email" required>
            <label id="phone_no_label" for="phone_no_input">Telefon: </label>
            <input id="phone_no_input" type="text" name="phone_no" required>
            <hr>
            <label id="password_label" for="password_input">Heslo: </label>
            <input id="password_input" type="password" name="password"  required>
            <label id="password_confirm_label" for="password_confirm_input">Potvrďte heslo: </label>
            <input id="password_confirm_input" type="password" name="password_confirm" required>
            <hr>
            <label id="sex_label" for="sex_select">Pohlaví: </label>
            <select id="sex_select" name="sex" required>
                <option value="" selected disabled>VYBERTE</option>
                <option value="M">Muž</option>
                <option value="F">Žena</option>
            </select>
            <hr>
            <label id="hobby_label">Zájem: </label>
            <div id="hobby_radio">
                <label for="active_sport">Aktivní sport: </label>
                <input type="radio" name="hobby" id="active_sport" value="active_sport"><br>
                <label for="passive_sport">Pasivní sport: </label>
                <input type="radio" name="hobby" id="passive_sport" value="passive_sport"><br>
                <label for="shopping">Nakupování: </label>
                <input type="radio" name="hobby" id="shopping" value="shopping"><br>
                <label for="watching_movies">Sledování filmů: </label>
                <input type="radio" name="hobby" id="watching_movies" value="watching_movies"><br>
                <label for="travelling">Cestování: </label>
                <input class="mt-heart" type="radio" name="hobby" id="travelling" value="travelling">
            </div>
            <hr>
            <label id="birth_date_label" for="day_of_birth">Datum narození:</label>
            <div id="birth_date_selects">
                <select name="day_of_birth" id="day_of_birth" required>
                    <option value="" selected disabled>DEN</option>
                    <%
                        for (int d = 1; d <= 31; d++)
                            out.print("<option value=\"" + d + "\">" + d + "</option>\n");
                    %>
                </select>
                <select name="month_of_birth" id="month_of_birth" required>
                    <option value="" selected disabled>MĚSÍC</option>
                    <%
                        for (int m = 1; m <= 12; m++)
                            out.print("<option value=\"" + m + "\">" + m + "</option>\n");
                    %>
                </select>
                <select name="year_of_birth" id="year_of_birth" required>
                    <option value="" selected disabled>ROK</option>
                    <%
                        for (int y = 2000; y >= 1970; y--)
                            out.print("<option value=\"" + y + "\">" + y + "</option>\n");
                    %>
                </select>
            </div>
            <button id="submit" type="submit">Přidat studenta</button>
        </form>
    </div>
</body>
</html>
