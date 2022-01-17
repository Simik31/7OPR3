package cz.osu.student.r19584.vypis_predmetu;

import java.util.ArrayList;
import java.util.List;

public class CourseService {
    private final List<Course> courses = new ArrayList<>();

    public CourseService() {
        courses.add(new Course("KIP/7AKI1", "Anglická konverzace v oblasti ICT 1", 3));
        courses.add(new Course("KIP/7AKI2", "Anglická konverzace v oblasti ICT 2", 3));
        courses.add(new Course("KIP/7MDSN", "Model. dat. struktur a jejich vzory", 4));
        courses.add(new Course("KIP/7OPR3", "Programování serverových aplikací", 4));
        courses.add(new Course("KIP/7VBAP", "Vývoj backendových aplikací", 4));
        courses.add(new Course("KIP/7AGI3", "Angličtina v informatice 3", 5));
        courses.add(new Course("KIP/7DBS1", "Databázové systémy 1", 5));
        courses.add(new Course("KIP/7UVDT", "Úvod do databází", 5));
        courses.add(new Course("KIP/7POS1", "Počítačové sítě 1", 6));
        courses.add(new Course("KIP/7SWI2", "Softwarové inženýrství 2", 6));
    }

    public Course getCourseByUUID(String uuid) {
        try {
            return courses.stream().filter(course -> course.getUUID().equals(uuid)).findFirst().orElseThrow();
        } catch (Exception ignored) {
            return null;
        }
    }

    public List<Course> getCourses() {
        return new ArrayList<>(courses);
    }
}
