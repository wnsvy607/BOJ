/*      작성자 : 이준표
 *      백준 DP
 *      실버 1
 *      11660번 구간 합 구하기 5
 *      created: 2022.08.05
 */

#include <iostream>
#include <vector>

using namespace std;

int graph[1025][1025];
int pos[100002][4];

int main() {
    int n, m;
    cin >> n >> m;
    int dp = 0;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            int temp;
            cin >> temp;
            dp += temp;
            graph[i][j] = dp;
        }
    }

    for (int i = 0; i < m; ++i) {
        cin >> pos[i][0] >> pos[i][1] >> pos[i][2] >> pos[i][3];
    }
    for (int i = 0; i < m; ++i) {
        int x1 = pos[i][1], y1 = pos[i][0], x2 = pos[i][3], y2 = pos[i][2];
        int total = 0;
        for (int j = y1 - 1; j < y2; ++j) {
            if(j != 0) {
                if (x1 == 1) {
                    total += graph[j][x2 - 1] - graph[j - 1][n - 1];
                } else {
                    total += graph[j][x2 - 1] - graph[j][x1 - 2];
                }
            } else {
                if (x1 == 1) {
                    total += graph[j][x2 - 1];
                } else {
                    total += graph[j][x2 - 1] - graph[j][x1 - 2];
                }
            }
        }
        cout << total << '\n';
    }
}