import java.util.ArrayList;

public abstract class Employee {
    protected static final int PENDING=100;
    protected static final int INVALID=400;
    protected static final int NOTREQUESTED=0;

    //member variables
    protected String username;
    protected String type;
    protected boolean loggedIn;
    protected Bank bank;

    public String getType() {
        return type;
    }

    Employee(String username, String type, Bank bank) {
        this.username = username;
        this.type = type;
        this.bank = bank;
    }

    public void Lookup(String username) {
        ArrayList<Account> accounts = bank.getAccounts();

        for (Account account : accounts) {
            if (account.getUsername() == username) {
                System.out.println(username + "'s current Balance " + account.getBalance() +
                        "$, loan" + account.getLoan() + "$");
            }
        }
    }
    public abstract void ApproveLoan();
    public abstract void ChangeInterestRate(String accountType, double newRate);
    public abstract void SeeInternalFund();

    public void MakeActive() {
        loggedIn = true;
    }
    public void MakeInactive() {
        loggedIn = false;
    }
}
