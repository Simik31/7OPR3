package cz.osu.student.r19584.kip7opr3jsp;

import java.io.*;
import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "studentServlet", value = "/students")
public class StudentServlet extends HttpServlet {

    public void init() {
        StudentService.init();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        List<Student> students = StudentService.getStudents();
        for (Student student : students) {
            out.println("<div>");
            out.println("<h2>" + student.getName() + " " + student.getSurname() + "(" + student.getStudent_number() + ")" + "</h2><p>");
            out.println("Datum narození: " + student.getBirthdate().toString() + "<br>");
            out.println("Pohlaví: " + Sex.sexToStr(student.getSex()) + "<br>");
            out.println("Kontakt: <a href='mailto:" + student.getEmail() + "'>" + student.getEmail() + "</a> | " + student.getPhone_number() + "<br>");
            out.println("Koníček: " + Hobby.hobbyToStr(student.getHobby()) + "<br>");
            out.println("Heslo: " + student.getPassword() + "</p>");
            out.println("</div>");
        }

        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String  name = request.getParameter("name"),
                    surname = request.getParameter("surname"),
                    student_number = request.getParameter("student_no"),
                    email = request.getParameter("email"),
                    phone_number = request.getParameter("phone_no"),
                    password = request.getParameter("password"),
                    password_confirm = request.getParameter("password_confirm"),
                    sex = request.getParameter("sex"),
                    hobby = request.getParameter("hobby"),
                    birth_day = request.getParameter("day_of_birth"),
                    birth_month = request.getParameter("month_of_birth"),
                    birth_year = request.getParameter("year_of_birth");

            if (password.equals(password_confirm) != true)
                throw new InvalidParameterException("Password does not match confirmation password");

            phone_number = validatePhoneNumberAndGetNineDigitVersion(phone_number);

            validateBirthDate(birth_day, birth_month, birth_year);

            Student student = new Student(
                name,
                surname,
                student_number,
                email,
                Integer.parseInt(phone_number),
                password,
                Sex.strToSex(sex),
                Hobby.stringToHobby(hobby),
                LocalDate.of(
                    Integer.parseInt(birth_year),
                    Integer.parseInt(birth_month),
                    Integer.parseInt(birth_day)
                )
            );

            StudentService.addStudent(student);

            response.sendRedirect("./students");
        } catch (Exception ex) {
            response.sendRedirect("./form.jsp?error=" + ex.getMessage());
        }
    }

    private static final int[] daysInMonths = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public void validateBirthDate(String s_day, String s_month, String s_year) throws NumberFormatException, IllegalArgumentException {
        int day = Integer.parseInt(s_day);
        int month = Integer.parseInt(s_month);
        int year = Integer.parseInt(s_year);

        if (year < 1970 || year > 2000)
            throw new IllegalArgumentException("Invalid year");

        if (month < 1 || month > 12)
            throw new IllegalArgumentException("Invalid month");

        int days = daysInMonths[month - 1];
        if (month == 2 && LocalDate.of(year, 1, 1).isLeapYear())
            days++;

        if (day < 1 || day != days)
            throw new IllegalArgumentException("Invalid day");
    }


    public String validatePhoneNumberAndGetNineDigitVersion(String phone_no) throws Exception {
        String patternString = "^((\\+|00)\\d{3}[\\s-]?)?((\\d{3}[\\s-]?)(\\d{3}[\\s-]?)(\\d{3}[\\s-]?))$";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(phone_no);

        if (!matcher.find())
            throw new Exception("Invalid phone number");

        return matcher.group(4) + matcher.group(5) + matcher.group(6);
    }
}