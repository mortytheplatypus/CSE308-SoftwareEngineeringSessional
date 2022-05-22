public class FixedDepositAccount extends Account {

    FixedDepositAccount(String username, String type, double amount) {
        super(username, "Fixed deposit", amount);
    }

    @Override
    public void RequestLoan(double amount) {
        if (amount > 100000) {
            System.out.println("Invalid request; current balance " +
                    balance + "$, loan " + loan + "$");
            this.loanRequestStatus = INVALID;
        } else {
            this.loanRequestStatus = PENDING;
            this.loanRequestAmount = amount;
            System.out.println("Loan request successful, sent for approval");
        }
    }

    @Override
    public void Withdraw(double amount, int year) {
        if (year < 1) {
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
        if (amount < 50000) {
            System.out.println("Invalid request; current balance " +
                    balance + "$, loan " + loan + "$");
            return;
        }

        this.IncreaseBalance(amount);
        System.out.println(amount + "$ deposited; current balance " +
                balance + "$, loan " + loan + "$");
    }
}
