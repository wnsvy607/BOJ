/*      작성자 : 이준표
 *      백준 DP
 *      실버 2
 *      11051번 이항 계수 2
 *      created: 2022.08.02
 */

#include <iostream>

using namespace std;
long long dp[1002][1002];

int main() {
    int n, k;
    cin >> n >> k;
    dp[1][1] = 1;
    dp[1][0] = 1;
    for (int i = 2; i < n + 1; ++i) {
        dp[i][0] = 1;
        for (int j = 1; j < i + 1; ++j) {
            dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % 10007;
        }
    }
    cout << dp[n][k];
}