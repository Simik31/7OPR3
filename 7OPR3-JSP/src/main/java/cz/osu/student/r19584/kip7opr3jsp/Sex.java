package cz.osu.student.r19584.kip7opr3jsp;

public enum Sex {
    MALE, FEMALE;

    public static Sex strToSex(String str) {
        switch (str) {
            case "M": return MALE;
            case "F": return FEMALE;
            default: throw new IllegalArgumentException("Unreachable");
        }
    }

    public static String sexToStr(Sex sex) {
        switch (sex) {
            case MALE: return "Muž";
            case FEMALE: return "Žena";
            default: throw new IllegalArgumentException("Unreachable");
        }
    }
}
