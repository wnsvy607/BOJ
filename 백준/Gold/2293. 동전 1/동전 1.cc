/*      작성자 : 이준표
 *      백준 DP
 *      골드 5
 *      2293번 동전1
 *      created: 2022.07.31
 */

#include <iostream>
#include <algorithm>
#include <vector>

int dp[10002];
using namespace std;

int main() {
    int n, k;
    cin >> n >> k;
    vector<int> coin;
    for (int i = 0; i < n; ++i) {
        int temp;
        cin >> temp;
        coin.push_back(temp);
    }
    sort(coin.begin(), coin.end());
    dp[0] = 1;
    for (int &item: coin) {
        for (int i = item; i < k + 1; ++i) {
            dp[i] += dp[i - item];
        }
    }

    cout << dp[k];
}