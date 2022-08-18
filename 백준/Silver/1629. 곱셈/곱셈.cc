/*      작성자 : 이준표
 *      백준
 *      실버 1
 *      1629번 곱셈
 *      created: 2022.08.18
 */

#include <iostream>

using namespace std;
typedef long long ll;

int main(void) {
    ll a, b, c;
    cin >> a >> b >> c;
    ll res = 1;
    while (b > 0) {
        if (b % 2 == 1)
            res = (a * res) % c;
        a = (a * a) % c;
        b >>= 1;
    }

    cout << res % c;
}