#include <iostream>
using namespace std;

int main(void) {
    int sack[2] = {0,};
    int left;
    cin >> left;
    while (left > 2) {
        if (left % 5 == 0) {
            left -= 5;
            sack[1]++;
        } else if ( left % 3 == 0 && left / 3 < 5) {
            left -= 3;
            sack[0]++;
        } else {
            left -= 5;
            sack[1]++;
        }
    }
    if(left == 0)
        cout << sack[0] + sack[1];
    else
        cout << -1;
}