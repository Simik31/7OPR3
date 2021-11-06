package cz.osu.student.r19584.kip7opr3.bookstore.models;

public class Book {
    Integer id;
    String title;
    String author;
    String downloadUrl;

    public Book(Integer id, String title, String author, String downloadUrl) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.downloadUrl = downloadUrl;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    @Override
    public String toString() {
        return "Book #" + getId() + " " + getTitle() + " (" + getAuthor() + ") available at: " + getDownloadUrl();
    }
}
