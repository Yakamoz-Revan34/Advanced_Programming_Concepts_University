package Homework01.Task01;

public class Textbook extends Book {
    //attributes:
    private String subject;

    //constructor:
    public Textbook(String title, int year, String author, String subject) {
        super(title, year, author);
        this.subject = subject;
    }

    //methods:
    @Override
    public String getInfo() {
        return "Title: " + getTitle() + " Subject: " + getSubject() + " Year of Publication: " + getYear() + " Author: " + getAuthor();
    }

    //getter & setter:
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

