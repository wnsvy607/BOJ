/*작성자 : 이준표
 *      백준 다이나믹 프로그래밍
 *      실버 1
 *      1149번 RGB거리
 *      created: 2022.06.30
 */
#include <iostream>
#include <algorithm>

using namespace std;

int cost[1001][3];
int house[1001][3];

int main() {
    int n;
    cin >> n;
    for (int i = 1; i < n + 1; ++i) {
        for (int j = 0; j < 3; ++j) {
            cin >> cost[i][j];
        }
    }
    cost[0][0] = 0;
    cost[0][1] = 0;
    cost[0][2] = 0;
    for (int i = 1; i < n + 1; ++i) {
        house[i][0] = min(house[i-1][1],house[i-1][2]) + cost[i][0];
        house[i][1] = min(house[i-1][0],house[i-1][2]) + cost[i][1];
        house[i][2] = min(house[i-1][0],house[i-1][1]) + cost[i][2];
    }

    cout << min({house[n][0],house[n][1],house[n][2]});
}
