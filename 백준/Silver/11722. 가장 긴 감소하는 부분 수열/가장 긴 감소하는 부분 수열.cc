/*      작성자 : 이준표
 *      백준 DP
 *      실버 2
 *      11722번 가장 긴 감소하는 부분 수열
 *      created: 2022.08.03
 */

#include <iostream>
#include <vector>

using namespace std;
int dp[1002];

int main() {
    int n;
    cin >> n;
    vector<int> seq;
    for (int i = 0; i < n; ++i) {
        int temp;
        cin >> temp;
        seq.push_back(temp);
    }
    dp[0] = 1;
    int max_num = 1;
    for (int i = 1; i < n; ++i) {
        int checker = 0;
        for (int j = i - 1; j >= 0; --j) {
            if (seq[i] < seq[j]) {
                dp[i] = max(dp[j] + 1, dp[i]);
                checker++;
            }
        }
        if (checker == 0)
            dp[i] = 1;
        if (dp[i] > max_num)
            max_num = dp[i];
    }

    cout << max_num;
}