package cz.osu.student.r19584.cviceni_3;

public class Article {
    private int id;
    private String title;
    private String author;
    private String content;

    public Article(int id, String title, String author, String content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Article #" + getId() + " (Author: " + getAuthor() + "):\n" +
                getTitle() + "\n" +
                getContent() + "\n";
    }
}
