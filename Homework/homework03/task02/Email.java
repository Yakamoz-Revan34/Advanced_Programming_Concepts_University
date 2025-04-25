package homework03.task02;

public class Email extends Message {
    //attributes:
    private final String type="Email";

    //constructor:
    //not needed by task

    //methods:
    public String send() {
        return "E-Mail sent.";
    }

    //getter & setter:
    public String getType() {
        return type;
    }
}
