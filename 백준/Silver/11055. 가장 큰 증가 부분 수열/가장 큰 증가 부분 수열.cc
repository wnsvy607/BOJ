/*      작성자 : 이준표
 *      백준 DP
 *      실버 2
 *      11055번 가장 큰 증가 부분 수열
 *      created: 2022.07.29
 */

#include <iostream>
#include <algorithm>
#include <vector>

long dp[1002];
using namespace std;

int main() {
    int n;
    cin >> n;
    vector<int> v;
    for (int i = 0; i < n; ++i) {
        int temp;
        cin >> temp;
        v.push_back(temp);
    }
    for (int i = 0; i < n; ++i) {
        dp[i] = v[i];
    }
    dp[0] = v[0];
    int max_seq = v[0];
    for (int i = 1; i < n; ++i) {
        for (int j = 0; j < i; ++j) {
            if(v[i] > v[j])
            dp[i] = max(dp[i], dp[j] + v[i]);
        }
        if(dp[i] > max_seq)
            max_seq = dp[i];
    }

    cout << max_seq;
}