package homework02.task01;

public class Publication {
    //attributes:
    private String title;
    private int year;

    //constructor:
    public Publication(String title, int year) {
        this.title = title;
        this.year = year;
    }

    //methods:
    public String getInfo() {
        return "Title: " + getTitle() + " Year of Publication: " + getYear();
    }

    //getter & setter:
    public String getTitle() {
        return this.title;
    }
    public int getYear() {
        return this.year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
