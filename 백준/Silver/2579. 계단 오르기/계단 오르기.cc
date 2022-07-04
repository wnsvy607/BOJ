/*      작성자 : 이준표
 *      백준 다이나믹 프로그래밍
 *      실버 3
 *      2579번 계단 오르기
 *      created: 2022.07.04
 */
#include <iostream>
#include <algorithm>

using namespace std;

int score[301];
int stair[301];

int solve(int n, int *score, int *stair);

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int n;
    cin >> n;
    for (int i = 0; i < n; ++i) {
        cin >> stair[i];
    }
    score[0] = stair[0];
    score[1] = stair[0] + stair[1];
    score[2] = max(stair[0] + stair[2], stair[1] + stair[2]);
    int temp = solve(n - 1, score, stair);
    cout << temp;
}

int solve(int n, int *score, int *stair) {
    if (n == 0)
        return stair[0];
    else if (n == 1)
        return stair[1] + stair[0];
    else if (n == 2)
        return max(stair[0] + stair[2], stair[1] + stair[2]);
    else if (score[n] != 0)
        return score[n];
    score[n] = max(stair[n] + stair[n - 1] + solve(n - 3, score, stair), stair[n] + solve(n - 2, score, stair));
    return score[n];
}