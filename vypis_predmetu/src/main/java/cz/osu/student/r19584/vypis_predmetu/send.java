package cz.osu.student.r19584.vypis_predmetu;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "send", value = "/send")
public class send extends HttpServlet {
    List<String> errors = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(403);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            errors.clear();

            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String email = request.getParameter("email");
            String student_id = request.getParameter("student_id");
            String[] courses = new String[]{
                    request.getParameter("course_1"),
                    request.getParameter("course_2"),
                    request.getParameter("course_3"),
                    request.getParameter("course_4"),
                    request.getParameter("course_5"),
                    request.getParameter("course_6"),
                    request.getParameter("course_7"),
                    request.getParameter("course_8"),
                    request.getParameter("course_9"),
                    request.getParameter("course_10")
            };

            test_inputs(name, surname, email, student_id, courses);

            response.sendRedirect((errors.size() == 0 ? "confirmation.jsp?" : "?errors=" + Arrays.toString(errors.toArray()) + "&") +
                    "name=" + name +
                    "&surname=" + surname +
                    "&email=" + email +
                    "&student_id=" + student_id +
                    "&courses=" + Arrays.toString(Arrays.stream(courses).filter(Objects::nonNull).toArray())
            );
        } catch (Exception e) {
            response.sendRedirect("?errors=[Critical server error: " + e.getMessage() + "]");
        }
    }

    private void test_inputs(String name, String surname, String email, String student_id, String[] courses) {
        test_empty(name, surname, email, student_id);
        test_email(email);
        test_student_id(student_id);
        test_mutually_identical(email, student_id);
        test_course_count(courses);
    }

    private void test_empty(String name, String surname, String email, String student_id) {
        if (name.equals("")) errors.add("Jmeno nebylo vyplneno.");
        if (surname.equals("")) errors.add("Prijmeni nebylo vyplneno.");
        if (email.equals("")) errors.add("E-mail nebyl vyplnen.");
        if (student_id.equals("")) errors.add("Studentske cislo nebylo vyplneno.");
    }

    private void test_email(String email) {
        String patternString = "^[A-Z]\\d{5}@student\\.osu\\.cz$";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.find()) errors.add("Zadany e-mail neni validni studentsky e-mail.");
    }

    private void test_student_id(String student_id) {
        String patternString = "^[A-Z]\\d{5}$";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(student_id);

        if (!matcher.find()) errors.add("Zadane studentske cislo neni validni studentske cislo.");
    }

    private void test_mutually_identical(String email, String student_id) {
        if (!email.contains("@")) return;
        if (!student_id.equals(email.substring(0, email.indexOf('@')))) errors.add("Zadany email (" +email.substring(0, email.indexOf('@'))  + ") a studentske cislo (" + student_id + ") nejsou vzajemne shodne.");
    }

    private void test_course_count(String[] courses) {
        long courseCount = Arrays.stream(courses).filter(Objects::nonNull).count();
        if (courseCount != 5) errors.add("Je vyzadovano zvoleni prave 5 kurzu. Pocet zvolenych kurzu: " + courseCount + ".");
    }
}
