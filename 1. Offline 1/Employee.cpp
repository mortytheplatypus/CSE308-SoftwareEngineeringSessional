#include <bits/stdc++.h>
#include "Bank.cpp"
using namespace std;

#define MD -1
#define OFFICER -2
#define CASHIER -3

//who is active, eita niye jhamela ache
//Loan niye jhamela ache - probably done
class Employee: public Bank {
    string name;
    int employeeType;
    bool loggedIn;
public:
    //
    Employee() {
        // employeeNo = 1;
        employeeType = MD;
    }

    void Lookup(string);
    void ApproveLoan();
    void ChangeInterestRate(int, double);
    void SeeInternalFund();
};

void Employee::Lookup(string username) {
    vector<Account> accounts = this->getAccounts();

    for (Account account : accounts) {
        if (account.getUsername() == username) {
            cout << username << "'s current Balance " << account.getBalance();
            cout << "$, loan" << account.getLoan() << "$\n";
        }
    }
}

void Employee::ApproveLoan() {
    if (this->employeeType == CASHIER) {
        cout << "You don't have permission for this operation.\n";
    } else {
        vector<Account> accounts = this->getAccounts();

        for (Account account : accounts) {
            if (account.getloanRequestStatus() == PENDING) {
                if (account.getloanRequestAmount() < this->getInternalFund()) {
                    cout << "Loan for " << account.getUsername() << " approved\n";
                    this->DecreaseInternalFund(account.getloanRequestAmount());
                    account.setLoanRequestStatus(NOTREQUESTED);
                    account.setLoanRequestAmount(0);
                }
            } else if (account.getloanRequestStatus() == INVALID) {
                cout << "Loan for " << account.getUsername() << " declined\n";
            }
        }
    }
    
}

void Employee::ChangeInterestRate(int accountType, double newRate) {
    if (this->employeeType == MD) {
        interestRates[accountType] = newRate;
    } else {
        cout << "You don't have permission for this operation.\n";
    }
}

void Employee::SeeInternalFund() {
    if (this->employeeType == MD) {
        cout << "Current internal fund " << this->getInternalFund() << "$\n";
    } else {
        cout << "You don't have permission for this operation.\n";
    }
}
