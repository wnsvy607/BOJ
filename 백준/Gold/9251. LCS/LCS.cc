/*      작성자 : 이준표
 *      백준 DP
 *      골드 5
 *      9251번 LCS
 *      created: 2022.07.30
 */

#include <iostream>
#include <algorithm>
#include <vector>

long dp[1002][1002];
using namespace std;

int main() {
    string A, B;
    cin >> A >> B;
    int n = A.length(), m = B.length();
    for (int i = 1; i < n + 1; ++i) {
        for (int j = 1; j < m + 1; ++j) {
            if (A[i - 1] == B[j - 1])
                dp[i][j] = dp[i - 1][j - 1] + 1;
            else
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
        }
    }
    cout << dp[n][m];
}