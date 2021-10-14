package cz.osu.student.r19584.cviceni_3;

public class Article {
    private int id;
    private String title;
    private String author;
    private String content;
    private String phone_no;

    public Article(int id, String title, String author, String content, String phone_no) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.phone_no = phone_no;
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

    public String getPhone_no() {
        return phone_no;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Article #" + getId() + " (Author: " + getAuthor() + " " + getPhone_no() + "):\n" +
                getTitle() + "\n" +
                getContent() + "\n";
    }
}
