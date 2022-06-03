#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void) {
    int a = 0, b = 0, c = 0, t = 0;
    cin >> t;
    while (t > 0) {
        if (t >= 300) {
            a++;
            t -= 300;
        } else if (t >= 60) {
            b++;
            t -= 60;
        } else {
            c++;
            t -= 10;
        }
    }

    if (t < 0)
        cout << -1;
    else
        cout << a << ' ' << b << ' ' << c << ' ';
}