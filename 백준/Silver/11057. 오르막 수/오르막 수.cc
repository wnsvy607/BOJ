/*      작성자 : 이준표
 *      백준 DP
 *      실버 1
 *      11057번 오르막 수
 *      created: 2022.07.28
 */

#include <iostream>
#include <algorithm>
#include <vector>

long dp[1002][10];
using namespace std;

int main() {
    int n;
    cin >> n;

    for (int i = 0; i < 10; ++i) {
        dp[0][i] = 1;
    }

    for (int i = 1; i < n; ++i) {
        dp[i][0] = dp[i - 1][0] % 10007;
        for (int j = 1; j < 10; ++j) {
            for (int k = 0; k < j + 1; ++k) {
                dp[i][j] += dp[i-1][k] % 10007;
            }
        }

    }
    long total = 0;
    for (int i = 0; i < 10; ++i) {
        total += dp[n-1][i] % 10007;
    }
    cout << total % 10007;
}