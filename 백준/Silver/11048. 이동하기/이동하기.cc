/*      작성자 : 이준표
 *      백준 DP
 *      실버 2
 *      11048번 이동하기
 *      created: 2022.08.04
 */

#include <iostream>
#include <algorithm>

using namespace std;

int maze[1002][1002];
int dp[1002][1002];

int main() {
    int n, m;
    cin >> n >> m;
    for (int i = 1; i < n + 1; ++i) {
        for (int j = 1; j < m + 1; ++j) {
            cin >> maze[i][j];
        }
    }
    dp[1][1] = maze[1][1];
    dp[1][2] = dp[1][1] + maze[1][2];
    dp[2][1] = dp[1][1] + maze[2][1];
    for (int i = 1; i < n + 1; ++i) {
        dp[i][1] = dp[i - 1][1] + maze[i][1];
        for (int j = 2; j < m + 1; ++j) {
            dp[1][j] = dp[1][j - 1] + maze[1][j];
            dp[i][j] = max(dp[i - 1][j], max(dp[i - 1][j - 1], dp[i][j - 1])) + maze[i][j];
        }
    }

    cout << dp[n][m];
}