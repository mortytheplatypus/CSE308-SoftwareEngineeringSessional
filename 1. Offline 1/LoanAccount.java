public class LoanAccount extends Account {
    LoanAccount(String username, String type, double amount) {
        super(username, "Loan", amount);
    }


    @Override
    public void RequestLoan(double amount) {
        if (amount > (loan*0.05)) {
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
        System.out.println("Invalid request; current balance " +
                    balance + "$, loan " + loan + "$");
    }

    @Override
    public void Deposit(double amount) {
        this.DecreaseLoan(amount);
    }
}
