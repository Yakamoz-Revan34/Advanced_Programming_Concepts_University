package homework02.task03;
import java.util.List;
import java.util.ArrayList;

public class Inbox {
    //attributes:
    private List<Mail> allMails = new ArrayList<Mail>();

    //constructor:
    public Inbox(Mail dummy) {
        allMails.add(dummy);
    }
    public Inbox() {
    }

    //methods:
    public void addToInbox(Mail mail) {
        allMails.add(mail);
    }

    public Mail giveMails(int index) {
        index = index-1; //assuming the end-user thinks of the list starting at 1
        if((index > 0) && (index <= allMails.size())) {
            return allMails.get(index);
        } else {
            return null;
        }
    }

    public List<String> printHeaders() {
        List<String> headers = new ArrayList<>();
        for(Mail mail : allMails) {
            headers.add(mail.isRead()+" | "+mail.getSubject()+" | "+mail.getSenderAddress()+" | "+mail.getTimestamp() +"\n");
        }
        return headers;
    }

    public int countUnread() {
        int i = 0;
        for(Mail mail : allMails) {
            if(!mail.isRead())i++;
        }
        return i;
    }

    //getter & setter:
    public List<Mail> getAllMails() {
        return allMails;
    }

    //Mail shall only be added via addToInbox. Ain't no setting an inbox as you like.
}