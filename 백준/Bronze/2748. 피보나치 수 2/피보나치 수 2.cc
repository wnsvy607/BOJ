/*      작성자 : 이준표
 *      백준 DP
 *      브론즈 1
 *      2748번 피보나치 수 2
 *      created: 2022.07.15
 */

#include <iostream>

using namespace std;


int main() {
    int n;
    long a[100];
    a[0] = 0l;
    a[1] = 1l;
    cin >> n;
    for (int i = 2; i < n + 1; ++i) {
        a[i] = a[i - 1] + a[i - 2];
    }
    cout << a[n];
}