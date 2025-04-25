package homework03.task01.audit;

import homework03.task01.bank.Account;

public class ExternalAudit {
    public void testAccess(Account acc) {
        System.out.println(acc.owner);         //public - accessible
        // System.out.println(acc.balance);    //private - not accessible
        // System.out.println(acc.pin);       //protected - not accessible from outside package (not subclass)
        // System.out.println(acc.internalNote); //package-private - not accessible outside package
    }
}
