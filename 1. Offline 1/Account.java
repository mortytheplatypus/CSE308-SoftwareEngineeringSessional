public abstract class Account {
    protected static final int INVALID = 400;
    protected static final int PENDING = 102;
    protected static final int NOTREQUESTED = 0;

    //define member variables
    protected double balance, loan;
    protected String username, type;
    protected int loanRequestStatus;
    protected double loanRequestAmount;
    protected boolean loggedIn;

    Account(String username, String type, double amount) {
        this.loan = 0;
        this.balance = amount;
        this.username = username;
        this.loanRequestStatus = -1;
        this.loanRequestAmount = 0;
        this.loggedIn = true;
        this.type = type;

        System.out.println(type + " account for " +
                username + " created; initial balance " + balance + "$");
    }

    public void Query() {
        System.out.println("Current balance " + balance + "$, " +
                "loan " + loan + "$");
    }

    public abstract void RequestLoan(double amount);
    public abstract void Withdraw(double amount, int year);
    public abstract void Deposit(double amount);

    public int getTypeIndex() {
        if (type.equalsIgnoreCase("Savings")) return  0;
        else if (type.equalsIgnoreCase("Stuent")) return  1;
        else if (type.equalsIgnoreCase("Fixed")) return 2;
        else return 3;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getLoan() {
        return loan;
    }

    public void setLoan(double loan) {
        this.loan = loan;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLoanRequestStatus() {
        return loanRequestStatus;
    }

    public void setLoanRequestStatus(int loanRequestStatus) {
        this.loanRequestStatus = loanRequestStatus;
    }

    public double getLoanRequestAmount() {
        return loanRequestAmount;
    }

    public void setLoanRequestAmount(int loanRequestAmount) {
        this.loanRequestAmount = loanRequestAmount;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    //increase or decrease methods
    public void IncreaseBalance(double amount) {
        balance += amount;
    }

    public void DecreaseBalance(double amount) {
        balance -= amount;
    }

    public void IncreaseLoan(double amount) {
        loan += amount;
    }

    public void DecreaseLoan(double amount) {
        loan -= amount;
    }

    public void MakeActive() {
        loggedIn = true;
    }

    public void MakeInactive() {
        loggedIn = false;
        System.out.println("Transaction for " + username + " closed");
    }
}
