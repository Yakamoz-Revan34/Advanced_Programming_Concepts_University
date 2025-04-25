//First we mine. Then we craft. Let's Minecraft!
package homework02.task03;
import java.time.LocalDateTime;

public class Mail {
    //attributes:
    private String senderAddress;
    private String subject;
    private String message;
    private LocalDateTime timestamp;
    private boolean isRead;

    //constructor:
    public Mail(String senderAddress, String subject, String message) {
        this.senderAddress = senderAddress;
        this.subject = subject;
        this.message = message;
        this.timestamp = LocalDateTime.now(); //auto. set datetime to current local time
        this.isRead = false; //upon creation a mail should be unread
    }

    //methods:
    public void markRead() {
        this.isRead = true;
    }

    public String getMailFormatted() {
        return getSubject()+ " from " +getSenderAddress()+ " on " +getTimestamp()+ ": " +getMessage(); //better to do the Sys.out.prnt in Main
    }

    //getter & setter:
    public String getSenderAddress() {
        return senderAddress;
    }
    public String getSubject() {
        return subject;
    }
    public String getMessage() {
        return message;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public boolean isRead() {
        return isRead;
    }

    //no other setters 'cause ain't no editing a mail after it's done duh
}

