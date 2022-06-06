import java.util.ArrayList;

public class Bank {
    double interestRates[] = {0.1, 0.05, 0.15}; //have to implement setInterestRates

    protected ArrayList<Account> accounts;
    protected ArrayList<Account> loanRequests;
    protected int year;
    protected double internalFund;

    Bank() {
//        System.out.println("Bank Created; MD, S1, S2, C1, C2, C3, C4, C5 created");
        accounts = new ArrayList<>();
        loanRequests = new ArrayList<>();
        internalFund = 1000000;
        year = 0;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public int getYear() {
        return year;
    }

    public double getInternalFund() {
        return internalFund;
    }

    public void DecreaseInternalFund(double amount) {
        internalFund -= amount;
    }

    public void IncreaseYear() {
        year++;
        System.out.println("1 year passed");

        //decrease loans
        for (Account account : accounts) {
            account.DecreaseLoan(account.getLoan()*0.1);
            account.IncreaseBalance(account.getBalance()*interestRates[account.getTypeIndex()]);
            account.DecreaseBalance(500 < account.getBalance() ? 500 : account.getBalance());
        }
    }

    Account CheckIfAccountExists(String username) {
        for (Account account : accounts) {
            if (account.getUsername().equalsIgnoreCase(username)) {
                return account;
            }
        }
        return null;
    }

    boolean CheckIfValidLoanRequest(double amount) {
        if (amount < internalFund) {
            return true;
        }
        return false;
    }

    boolean CheckIfLoanRequestsPending() {
        return !loanRequests.isEmpty();
    }

    public void AddAccount(Account account) {
        accounts.add(account);
    }

    public void AddLoanRequest(Account account) {
        loanRequests.add(account);
    }

}
