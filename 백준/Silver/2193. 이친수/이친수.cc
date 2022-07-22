/*      작성자 : 이준표
 *      백준 DP
 *      실버 3
 *      2193번 이친수
 *      created: 2022.07.22
 */

#include <iostream>

using namespace std;

long result[91][2];

int main() {
    int n;
    cin >> n;


    result[0][0] = 0;
    result[0][1] = 1;
    result[1][0] = 1;
    result[1][1] = 0;

    for (int i = 2; i < n; ++i) {
        result[i][0] = result[i - 1][0] + result[i - 1][1];
        result[i][1] = result[i - 1][0];
    }

    cout << result[n - 1][0] + result[n - 1][1];
}