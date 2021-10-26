package cz.osu.student.r19584.kip7opr3jsp;

public enum Hobby {
    ACTIVE_SPORT, PASSIVE_SPORT, SHOPPING, WATCHING_MOVIES, TRAVELLING;

    public static Hobby stringToHobby(String str) {
        switch (str) {
            case "active_sport": return ACTIVE_SPORT;
            case "passive_sport": return PASSIVE_SPORT;
            case "shopping": return SHOPPING;
            case "watching_movies": return WATCHING_MOVIES;
            case "travelling": return TRAVELLING;
            default: throw new IllegalArgumentException("Unreachable");
        }
    }

    public static String hobbyToStr(Hobby hobby) {
        switch (hobby) {
            case ACTIVE_SPORT: return "Aktivní sport";
            case PASSIVE_SPORT: return "Pasivní sport";
            case SHOPPING: return "Nakupování";
            case WATCHING_MOVIES: return "Sledování filmů";
            case TRAVELLING: return "Cestování";
            default: throw new IllegalArgumentException("Unreachable");
        }
    }
}
