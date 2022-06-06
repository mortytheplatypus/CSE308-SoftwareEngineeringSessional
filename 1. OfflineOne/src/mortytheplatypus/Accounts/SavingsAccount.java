package mortytheplatypus.Accounts;

public class SavingsAccount extends Account {
    public SavingsAccount(String username, String type, double amount) {
        super(username, "Savings", amount);
    }

    @Override
    public int RequestLoan(double amount) {
        if (amount > 10000) {
            System.out.println("Invalid request; current balance " +
                    balance + "$, loan " + loan + "$");
            return INVALID;
        } else {
            this.loanRequestAmount = amount;
            System.out.println("Loan request successful, sent for approval");
            return PENDING;
        }
    }

    @Override
    public void Withdraw(double amount, int year) {
        if (balance-amount < 1000)  {
            System.out.println("Invalid request; current balance " +
                    balance + "$, loan " + loan + "$");
        } else {
            this.DecreaseBalance(amount);
            System.out.println("Withdraw successful; current balance " +
                    balance + "$, loan " + loan + "$");
        }
    }

    @Override
    public void Deposit(double amount) {
        this.IncreaseBalance(amount);
        System.out.println(amount + "$ deposited; current balance " +
                balance + "$, loan " + loan + "$");
    }
}
