/*      작성자 : 이준표
 *      백준 DP
 *      실버 2
 *      1699번 제곱수의 합
 *      created: 2022.08.01
 */

#include <iostream>
#include <algorithm>
#include <math.h>

using namespace std;
int dp[100002];

int main() {
    int n;
    cin >> n;
    dp[1] = 1;
    int k = (int) sqrt(n) + 1;
    for (int i = 1; i < k; ++i) {
        long qud = i * i;
        dp[qud] = 1;
    }
    for (int i = 2; i < n + 1; ++i) {
        if (dp[i] != 1) {
            int min_num = n;
            for (int j = 1; j < sqrt(i); ++j) {
                int num = pow(j, 2);
                min_num = min(min_num, dp[i - num]);
            }
            dp[i] = 1 + min_num;
        }
    }
    cout << dp[n];
}