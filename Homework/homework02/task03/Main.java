package homework02.task03;

public class Main {
    public static void main(String[] args) {
        //an inbox:
        Inbox heisenbergsInbox = new Inbox();

        //some mails:
        Mail m1 = new Mail("xX_jesse6969_Xx","u gon too far","Yo Mr. White, this ain't it. You crazy man. " +
                "janes dead the kids dead imma kill you next slimee");
        Mail m2 = new Mail("g.fring@email.cz","Stop the Operation Immediatly",
                "The Pinkman kid is too far up his addiction. I must worry he will fuck up something. If he does I'll hold you accountable.");
        Mail m3 = new Mail("hankschrader@mail.com","WW",
                "I know. And I know you know. Either I will get you or someother agent but you WILL be caught. Just hand yourself in already Walt. Please.");

        heisenbergsInbox.addToInbox(m1);
        heisenbergsInbox.addToInbox(m2);
        heisenbergsInbox.addToInbox(m3);

        m1.markRead();
        m2.markRead();

        System.out.println("Unread mails: "+heisenbergsInbox.countUnread());
        System.out.println("All mails: \n"+heisenbergsInbox.printHeaders());
        System.out.println(
                heisenbergsInbox.giveMails(2) != null //should give out m2 as user input is based on input-1
                        ? heisenbergsInbox.giveMails(2).getMailFormatted()
                        : "Mail not found."
        );

    }
}
