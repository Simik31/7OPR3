package cz.osu.student.r19584.vypis_predmetu;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    private static int idCounter = 0;

    public static List<String> arrayStringToList(String string) {
        string = string.substring(1, string.length() - 1);
        List<String> arr = new ArrayList<>();

        while (string.contains(",")) {
            arr.add(string.substring(0, string.indexOf(',')));
            string = string.substring(string.indexOf(',') + 1);
            if (string.startsWith(" ")) string = string.substring(1);
        }

        if (string.startsWith(" ")) string = string.substring(1);
        arr.add(string);

        return arr;
    }

    public static int nextId(boolean reset) {
        if (reset) idCounter = 0;
        return idCounter++;
    }
}
