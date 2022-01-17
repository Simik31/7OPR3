package cz.osu.student.r19584.vypis_predmetu;

import java.util.UUID;

public class Course {
    UUID uuid;
    String abbreviation;
    String name;
    int credits;

    public Course(String abbreviation, String name, int credits) {
        this.uuid = UUID.randomUUID();
        this.abbreviation = abbreviation;
        this.name = name;
        this.credits = credits;
    }

    public String getUUID() {
        return uuid.toString();
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }
}
