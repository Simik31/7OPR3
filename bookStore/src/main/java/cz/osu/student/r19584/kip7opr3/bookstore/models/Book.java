package cz.osu.student.r19584.kip7opr3.bookstore.models;

public class Book {
    private final int id;
    private final String title;
    private final String author;
    private final String downloadUrl;
    private boolean purchased;

    public Book(Integer id, String title, String author, String downloadUrl) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.downloadUrl = downloadUrl;
        this.purchased = false;
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

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    @Override
    public String toString() {
        return "Book #" + getId() + " " + getTitle() + " (" + getAuthor() + ") available at: " + getDownloadUrl();
    }
}
