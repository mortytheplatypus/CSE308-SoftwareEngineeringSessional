#include <bits/stdc++.h>
using namespace std;

#define SAVINGS 0
#define STUDENT 1
#define FIXED 2
#define LOAN 3

#define PENDING 102
#define INVALID 400
#define NOTREQUESTED -1


class Account {
    double balance, loan;
    string username; //use this in the request stack
    int type;
    // int time;
    int loanRequestStatus, loanRequestAmount=0;
    bool loggedIn;
    //have to also include interest rate
public:
    Account() {
        //
    }
    Account(string username, int type, double amount) { 
        this->loan = 0;
        this->balance = amount;
        this->username = username;
        this->type = type;
        // this->time = 0;
        this->loanRequestStatus = NOTREQUESTED;
        this->loanRequestAmount = 0;
        this->loggedIn = true;

        if (type==LOAN) {
            this->loan = amount;
        }

        cout << this->getTypeName() << " account for ";
        cout << this->username << " created; ";
        cout << "initial balance " << this->balance << "$\n";
    }

    //getters and setters start
    void setBalance(double balance) {
        this->balance = balance;
    }

    double getBalance() {
        return this->balance;
    }

    void setUsername(string username) {
        this->username = username;
    }

    string getUsername() {
        return this->username;
    }

    void setType(int type) {
        this->type = type;
    }

    int getType() {
        return this->type;
    }

    string getTypeName() {
        if (type==SAVINGS) return "Savings";
        else if (type==STUDENT) return "Student";
        else if (type==LOAN) return "Loan";
        else return "Fixed deposit";
    }

    // int getTime() {
    //     return this->time;
    // }

    double getLoan() {
        return this->loan;
    }

    int getloanRequestStatus() {
        return loanRequestStatus;
    }

    void setLoanRequestStatus(int status) {
        loanRequestStatus = status;
    }

    void setLoanRequestAmount(int amount) {
        loanRequestAmount = amount;
    }

    double getloanRequestAmount() {
        return loanRequestAmount;
    }

    //increase or decrease methods
    void IncreaseBalance(double amount) {
        balance += amount;
    }

    void DecreaseBalance(double amount) {
        balance -= amount;
    }

    void IncreaseLoan(double amount) {
        loan += amount;
    }

    void DecreaseLoan(double amount) {
        loan -= amount;
    }

    void MakeActive() {
        loggedIn = true;
    }

    void MakeInactive() {
        loggedIn = false;
        cout << "Transaction for " << username << "closed\n";
    }

    // void IncreaseTime() {
    //     this->time = 1 + this->time; 
    //     //have to adjust loans 
    //     //assuming loan amount bere jabe
    //     this->loan += ((this->loan)/10);
    // }

    //required methods
    void Query(); //Hopefully Done
    void RequestLoan(double); 
    void Withdraw(double, int); //Hopefully Done
    void Deposit(double); //Hopefully Done
};

void Account::Query() {
    cout << "Current Balance " << balance;
    cout << "$, loan " << loan << "$\n";
}

void Account::Deposit(double amount) {
    if (type == FIXED) {
        if (amount < 50000) {
            cout << "Invalid request; current balance ";
            cout << balance << "$, loan " << loan << "$\n";
            return;
        }
    } 
        
    if (type == LOAN) {
        this->DecreaseLoan(amount);
    } else {
        this->IncreaseBalance(amount);
    }

    cout << amount << " deposited; current balance ";
    cout << balance << "$, loan " << loan << "$\n";
}

void Account::Withdraw(double amount, int time) {
    bool INVALIDREQUEST = false;

    if (balance < amount) {
        INVALIDREQUEST = true;
    } else if (type == STUDENT) {
        //cannot withdraw more than 10000 in one transaction
        if (amount > 10000) {
            INVALIDREQUEST = true;
        }
    } else if (type == SAVINGS) {
        //cannot withdraw if the withdrawal results in a deposit of less than 1000
        if (balance-amount < 1000) {
            INVALIDREQUEST = true;
        }
    } else if (type == LOAN) {
        //cannot withdraw any amount
        INVALIDREQUEST = true;
    } else if (type == FIXED) {
        //cannot withdraw if it has not reached a maturity period of one year
        if (time < 1) {
            INVALIDREQUEST = true; 
        }
    }

    if (INVALIDREQUEST) {
        cout << "Invalid request; current balance ";
        cout << balance << "$, loan " << loan << "$\n";
    } else {
        this->DecreaseBalance(amount);
        cout << "Withdraw successful; current balance ";
        cout << balance << "$, loan " << loan << "$\n";
    }
}

void Account::RequestLoan(double amount) {
    //create a loan request stack ///////////////
    //and handle them from MD
    bool INVALIDREQUEST = false;

    if (type == STUDENT) {
        if (amount > 1000) {
            INVALIDREQUEST = true;
        }
    } else if (type == SAVINGS) {
        if (amount > 10000) {
            INVALIDREQUEST = true;
        }
    } else if (type == FIXED) {
        if (amount > 100000) {
            INVALIDREQUEST = true;
        }
    } else {
        if (amount != (loan * 0.05)) {
            INVALIDREQUEST = true;
        }
    }

    if (INVALIDREQUEST) {
        cout << "Invalid request; current balance ";
        cout << balance << "$, loan " << loan << "$\n";
        this->loanRequestStatus = INVALID;
    } else {
        this->loanRequestStatus = PENDING;
        this->loanRequestAmount = amount;   
        cout << "Loan request successful, sent for approval\n";
    }    
}
