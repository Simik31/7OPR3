package cz.osu.student.r19584.kip7opr3jsp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private static final List<Student> students = new ArrayList<>();

    public static void init() {
        System.out.println("StudentService.init()");
        Student me = new Student("Martin", "Simara", "R19584", "r19584@student.osu.cz", 731845732, "password", Sex.MALE, Hobby.WATCHING_MOVIES, LocalDate.of(1999, 12, 31));
        students.add(me);
        System.out.println("Done init()");
    }

    public static List<Student> getStudents() {
        return students;
    }

    public static void addStudent(Student student) {
        students.add(student);
    }
}
