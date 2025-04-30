package homework03.task02;

public class Main {
    public static void main(String[] args) {
        Message m1 = new Email();
        Message m2 = new SMS();
        System.out. println(m1.getType ());
        System.out. println(m2.getType ());
        //System.out.println(m1.send()); // Uncomment this line and explain what happens
        /*
        What happens is that we declared the static type of m1 to be Message, and we are now trying to use a method which is not in Message but Email. Since the compiler excepts
        only static content we get the error "cannot find symbol method send()" as the compiler can't find the method in the static runtime.
         */

        /*
        Answer the following questions.
        • What is the static type of m1? What is its dynamic type?
        static type: Message
        dynamic type: Email

        • Which method is called? Why?
        The getType() method defined in Email is called because Java uses dynamic dispatch.
        While the compiler checks method existence based on the static type (Message), the method actually executed at runtime depends on the dynamic type (Email in this case).


        • Why can’t send() be called directly?
        See above - any method called need to be in the static runtime - dynamic solely doesn't suffice.

        • How could you safely call send() anyway (e.g. instanceof)?
        Well it would be the easiest to just declare m1 as an Email but if we do want to keep it as Message for whatever reason we may cast it to Email to adjust the static
        type as follows:
        if (m1 instanceof Email) {
            ((Email) m1).send();
        }
        with (m1 instanceof Email) checking wether the dynamic type of m1 is actually fit for such a casting/makes sense to do so in this case.
         */
    }
}
