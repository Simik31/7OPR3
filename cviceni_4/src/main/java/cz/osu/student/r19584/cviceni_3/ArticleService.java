package cz.osu.student.r19584.cviceni_3;

import java.util.ArrayList;
import java.util.List;

public class ArticleService {
    private static final List<Article> articles = new ArrayList<>();

    public static void init() {
        Article a = new Article(1, "Programování", "Martin Šimara", "Prej to má být zábava...", "731845732"),
                b = new Article(2, "Umělá inteligence", "Martin Šimara", "SkyNet útočí! :p", "739568956");
        articles.add(a);
        articles.add(b);
    }

    public static List<Article> getArticles() {
        return articles;
    }

    public static void addArticle(Article article) {
        articles.add(article);
    }
}
