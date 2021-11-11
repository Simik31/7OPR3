package cz.osu.student.r19584.kip7opr3.seminarka;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Utils {
    public static List<Integer> getLocalGames(HttpServletRequest request) {
        List<Cookie> cookies = List.of(request.getCookies());
        Optional<Cookie> id_cookie = cookies.stream().filter(cookie -> cookie.getName().equals("resultIds")).findFirst();

        String id_string;
        if (id_cookie.isEmpty() || (id_string = id_cookie.get().getValue()).equals(""))
            return new ArrayList<>();

        id_string = URLDecoder.decode(id_string, Charset.defaultCharset());
        List<String> ids_str = List.of(id_string.contains(",") ? id_string.split(",") : new String[]{id_string});
        List<Integer> ids = new ArrayList<>();
        for (String id : ids_str)
            ids.add(Integer.parseInt(id, 16));

        return ids;
    }
}
