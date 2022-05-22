import java.util.ArrayList;

public abstract class Employee {
    //member variables
    protected String username;
    protected String type;
    protected Bank bank;

    Employee(String username, String type, Bank bank) {
        this.username = username;
        this.type = type;
        this.bank = bank;
    }

    public void Lookup(String username) {
        ArrayList<Account> accounts = bank.getAccounts();

        for (Account account : accounts) {
            if (account.getUsername().equalsIgnoreCase(username)) {
                System.out.println(username + "'s current Balance " + account.getBalance() +
                        "$, loan" + account.getLoan() + "$");
            }
        }
    }
    public abstract void ApproveLoan();
    public abstract void ChangeInterestRate(String accountType, double newRate);
    public abstract void SeeInternalFund();


    public String getUsername() {
        return username;
    }
}
