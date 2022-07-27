/*      작성자 : 이준표
 *      백준 DP
 *      골드 5
 *      12865번 평범한 배낭
 *      created: 2022.07.27
 */

#include <iostream>
#include <algorithm>
#include <vector>

int dp[102][100002];
using namespace std;

int main() {
    int n, k;
    cin >> n >> k;
    vector<pair<int,int>> stuff;
    
    stuff.emplace_back(0,0);
    for (int i = 0; i < n; ++i) {
        int w, v;
        cin >> w >> v;
        stuff.emplace_back(w, v); //weight & value
    }
    
    for (int i = 1; i < n + 1; ++i) {
        for (int j = 0; j < k + 1; ++j) {
            if(stuff[i].first <= j)
                dp[i][j] = max(dp[i - 1][j], stuff[i].second + dp[i - 1][j - stuff[i].first]);
            else
                dp[i][j] = dp[i - 1][j];
        }
    }
    cout << dp[n][k];
}