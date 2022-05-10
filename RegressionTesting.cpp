#include<bits/stdc++.h>
using namespace std;

int main() {
    vector <string> testCase;
    freopen("testData\\testcase.txt", "r", stdin);
    string str;
    while (cin >> str) {
        testCase.push_back(str);
    }

    for (auto name : testCase) {
        string str = "agenda.bat < testData\\in\\" + name + " > testData\\out\\" + name;
        system(str.c_str());
        str = "fc testData\\ans\\" + name + " testData\\out\\" + name;
        if (system(str.c_str())) {
            cout << "Wrong answer at test case " << name << endl;
            system("pause");
            return 0;
        }
        else
            cout << "Accepted at test case " << name << endl << endl << endl;
    }
    system("pause");
}
