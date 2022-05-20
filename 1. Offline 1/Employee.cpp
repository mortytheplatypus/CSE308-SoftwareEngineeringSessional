#include <bits/stdc++.h>
using namespace std;

#define MD -1
#define OFFICER -2
#define CASHIER -3

class Employee{
    string name;
    int type;
    static int employeeNo;
public:
    //
    Employee() {
        employeeNo = 1;
    }

    int Lookup(string);
};
