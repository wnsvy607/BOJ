#include <iostream>

using namespace std;

int main(void) {
    long total, i;
    cin >> total;
    i = 0;
    while (total > 0){
        total -= i++;
    }
    i--;
    if(total == 0)
        cout << i;
    else
        cout << i - 1;
}