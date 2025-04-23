package Homework02.Task01;

public class Book extends Publication {
    private String author;

    public Book(String title, int year, String author) {
        super(title, year);
        this.author = author;
    }

    public String getInfo() {
        String var10000 = this.getTitle();
        return "Title: " + var10000 + "Year of Publication: " + this.getYear() + "Author: " + this.getAuthor();
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}