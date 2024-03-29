package mortytheplatypus.Accounts;

public class LoanAccount extends Account {
    public LoanAccount(String username, String type, double amount) {
        super(username, "Loan", amount);
    }

    @Override
    public int RequestLoan(double amount) {
        if (amount > (loan*0.05)) {
            System.out.println("Invalid request; current balance " +
                    balance + "$, loan " + loan + "$");
//            this.loanRequestStatus = INVALID;
            return INVALID;
        } else {
//            this.loanRequestStatus = PENDING;
            this.loanRequestAmount = amount;
            System.out.println("Loan request successful, sent for approval");
            return PENDING;
        }
    }

    @Override
    public void Withdraw(double amount, int year) {
        System.out.println("Invalid request; current balance " +
                    balance + "$, loan " + loan + "$");
    }

    @Override
    public void Deposit(double amount) {
        this.DecreaseLoan(amount);
    }
}
