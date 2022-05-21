#include <bits/stdc++.h>
#include "Employee.cpp"
using namespace std;

string TakeInput(char*);

//constructor of bank being called twice
//working one minute and then crashing the next

//Created in a way that no bad request is given

int main() {
    Bank bank;
    Account activeAccount;
    Employee activeEmployee;
    int whoIsActiveStatus;

    while (1) {
        char* inputArray;
        string INPUT, inputString = TakeInput(inputArray);
        stringstream ss(inputString);
        ss >> INPUT;

        if (INPUT == "Create") {
            string username;
            int accountType;
            int amount;

            //take username input
            ss >> INPUT; username = INPUT;

            //take accountType input
            ss >> INPUT;
            if (INPUT == "Savings") accountType = SAVINGS;
            else if (INPUT == "Student") accountType = STUDENT;
            else if (INPUT == "Loan") accountType = LOAN;
            else accountType = FIXED;

            //take deposite/loan input
            ss >> INPUT;
            amount = stoi(INPUT);

            Account account(username, accountType, amount);
            bank.addAccount(account);
            whoIsActiveStatus = ACCOUNT;
            activeAccount = account;
        } else if (INPUT == "Deposit") {
            ss >> INPUT;
            int amount = stoi(INPUT);
            activeAccount.Deposit(amount);
        } else if (INPUT == "Withdraw") {
            ss >> INPUT;
            int amount = stoi(INPUT);
            activeAccount.Withdraw(amount, bank.getTime());
        } else if (INPUT == "Query") {
            activeAccount.Query();
        } else if (INPUT == "Request") {
            ss >> INPUT;
            int amount = stoi(INPUT);
            activeAccount.RequestLoan(amount);
        } else if (INPUT == "Open") {
            //ekhaneo jhamela ache, jodi employee open kore
            string username;
            ss >> INPUT;
            username = INPUT;

            whoIsActiveStatus = bank.CheckIfAccountExists(username);

            if (whoIsActiveStatus == ACCOUNT) {
                activeAccount = bank.AccountLogin(username);
            } else {
                //implement employee login/active
            }
            
        } else if (INPUT == "Close") {
            //je active ache, take bank er active variable e rakha lagbe
            // bool whoIsActiveStatus = bank.getWhoIsActive();
            if (whoIsActiveStatus == ACCOUNT) {
                activeAccount.MakeInactive();
                cout << "Transaction Closed for " << activeAccount.getUsername() << "\n";
            } else if (whoIsActiveStatus == EMPLOYEE) {
                //
            } 
            
            whoIsActiveStatus = NOONE;
        }

//Create Alice Student 1000
        
    }
    return 0;
}

string TakeInput(char* inputArray) {
    string inputString;
    cin.getline(inputArray, 100);

    //converts the char array into string
    for (int i=0; inputArray[i]!='\0'; i++) {
        inputString += inputArray[i];
    }
    return inputString;
}
