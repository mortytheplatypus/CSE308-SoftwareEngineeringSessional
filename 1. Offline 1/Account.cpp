#include <bits/stdc++.h>
using namespace std;

#define SAVINGS 0
#define STUDENT 1
#define LOAN 2
#define FIXED 3

#define PENDING 102
#define APPROVED 200
#define NOTAPPROVED 400
#define NOTREQUESTED -1

class Account {
    int balance, loan;
    string username; //use this in the request stack
    int type;
    int time;
    int loanRequestStatus, loanRequestAmount=0;
    bool loggedIn;
public:
    Account(string username, int type, int amount) {
        if (type==LOAN) {
            this->balance = 0;
            this->loan = amount;
        } else {
            this->balance = amount;
            this->loan = 0;
        }
        this->username = username;
        this->type = type;
        this->time = 0;
        this->loanRequestStatus = NOTREQUESTED;
        this->loanRequestAmount = 0;
        this->loggedIn = true;

        cout << this->getTypeName() << " account for ";
        cout << this->username << " created; ";
        cout << "initial balance " << this->balance << "$\n";
    }

    //getters and setters start
    void setBalance(int balance) {
        this->balance = balance;
    }

    int getBalance() {
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

    int getTime() {
        return this->time;
    }

    int getLoan() {
        return this->loan;
    }

    //increase or decrease methods
    void IncreaseBalance(int amount) {
        balance += amount;
    }

    void DecreaseBalance(int amount) {
        balance -= amount;
    }

    void IncreaseLoan(int amount) {
        loan += amount;
    }

    void DecreaseLoan(int amount) {
        loan -= amount;
    }

    void IncreaseTime() {
        this->time = 1 + this->time; 
        //have to adjust loans 
        //assuming loan amount bere jabe
        this->loan += ((this->loan)/10);
    }

    //required methods
    void Query(); //Hopefully Done
    void RequestLoan(int); 
    void Withdraw(int); //Hopefully Done
    void Deposit(int); //Hopefully Done
};

void Account::Query() {
    cout << "Current Balance " << this->getBalance();
    cout << "$, loan" << this->getLoan() << "$\n";
}

void Account::Deposit(int amount) {
    if (this->getType() == FIXED) {
        if (amount < 50000) {
            cout << "Invalid request\n";
            return;
        }
    } 
        
    if (this->getType() == LOAN) {
        this->DecreaseLoan(amount);
    } else {
        this->IncreaseBalance(amount);
    }
}

void Account::Withdraw(int amount) {
    bool INVALIDREQUEST = false;
    if (this->getBalance() < amount) {
        INVALIDREQUEST = true;
    } else if (this->getType() == STUDENT) {
        //cannot withdraw more than 10000 in one transaction
        if (amount > 10000) {
            INVALIDREQUEST = true;
        }
    } else if (this->getType() == SAVINGS) {
        //cannot withdraw if the withdrawal results in a deposit of less than 1000
        if (this->getBalance()-amount < 1000) {
            INVALIDREQUEST = true;
        }
    } else if (this->getType() == LOAN) {
        //cannot withdraw any amount
        INVALIDREQUEST = true;
    } else if (this->getType() == FIXED) {
        //cannot withdraw if it has not reached a maturity period of one year
        if (this->getTime() < 1) {
            INVALIDREQUEST = true; 
        }
    }

    if (INVALIDREQUEST) {
        cout << "Invalid request\n";
    } else {
        this->DecreaseBalance(amount);
    }
}

void Account::RequestLoan(int amount) {
    //create a loan request stack ///////////////
    //and handle them from MD
    bool INVALIDREQUEST = false;

    if (this->getType() == STUDENT) {
        if (amount > 1000) {
            INVALIDREQUEST = true;
        }
    } else if (this->getType() == SAVINGS) {
        if (amount > 10000) {
            INVALIDREQUEST = true;
        }
    } else if (this->getType() == FIXED) {
        if (amount > 100000) {
            INVALIDREQUEST = true;
        }
    } else {
        //
        int ln = (this->getLoan())/20;
        if (amount>ln) {
            INVALIDREQUEST = true;
        }
    }

    if (INVALIDREQUEST) {
        cout << "Invalid request\n";
    } else {
        this->loanRequestStatus = PENDING;
        this->loanRequestAmount = amount;   
    }

    
}


int main() {
    return 0;
}