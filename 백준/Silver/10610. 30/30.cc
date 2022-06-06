#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

int main(void) {
    string str;
    vector<long> v;
    cin >> str;
    int i = 0;
    while (i != str.size()){
        v.push_back(str[i++] - '0');
    }
    sort(v.begin(), v.end());
    long checker = 0;
    for (int j = 1; j < v.size(); ++j) {
        checker += v[j];
    }

    if(v[0] == 0 && checker % 3 == 0){
        for (int j = v.size() - 1; j > -1; j--) {
            cout << v[j];
        }
    } else{
        cout << -1;
    }
}