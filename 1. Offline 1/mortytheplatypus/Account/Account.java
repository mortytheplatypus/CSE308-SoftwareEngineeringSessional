public abstract class Account {
    protected static final int INVALID = 400;
    protected static final int PENDING = 102;

    //define member variables
    protected double balance, loan;
    protected String username, type;
    protected double loanRequestAmount;

    Account(String username, String type, double amount) {
        this.loan = 0;
        this.balance = amount;
        this.username = username;
        this.loanRequestAmount = 0;
        this.type = type;

        System.out.println(type + " account for " +
                username + " created; initial balance " + balance + "$");
    }

    public void Query() {
        System.out.println("Current balance " + balance + "$, " +
                "loan " + loan + "$");
    }

    public abstract int RequestLoan(double amount);
    public abstract void Withdraw(double amount, int year);
    public abstract void Deposit(double amount);

    public int getTypeIndex() {
        if (type.equalsIgnoreCase("Savings")) return  0;
        else if (type.equalsIgnoreCase("Student")) return  1;
        else if (type.equalsIgnoreCase("Fixed")) return 2;
        else return 3;
    }

    public double getBalance() {
        return balance;
    }

    public double getLoan() {
        return loan;
    }

    public String getUsername() {
        return username;
    }

    public double getLoanRequestAmount() {
        return loanRequestAmount;
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

}
