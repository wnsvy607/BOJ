/*      작성자 : 이준표
 *      백준 그래프 이론
 *      실버 2
 *      1012번 유기농 배추
 *      created: 2022.07.05
 */
#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int dy[4] = {1, -1, 0, 0};
    int dx[4] = {0, 0, -1, 1};
    int t;
    cin >> t;
    vector<int> result;
    for (int pass = 0; pass < t; ++pass) {
        int field[51][51] = {0,};
        int visited[51][51] = {0,};
        int n, m, k;
        cin >> n >> m >> k;
        for (int i = 0; i < k; ++i) {
            int y, x;
            cin >> y >> x;
            field[y][x] = 1;
        }
        int count = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (field[i][j] == 1 && visited[i][j] == 0) {
                    count++;
                    queue<pair<int, int>> q;
                    q.push({i, j});
                    visited[i][j] = 1;
                    while (!q.empty()) {
                        int cy = q.front().first;
                        int cx = q.front().second;
                        q.pop();
                        for (int l = 0; l < 4; ++l) {
                            int y = cy + dy[l];
                            int x = cx + dx[l];
                            if (y > -1 && x > -1 && visited[y][x] == 0 && field[y][x] == 1) {
                                visited[y][x] = 1;
                                q.push({y, x});
                            }
                        }
                    }
                }
            }
        }
        result.push_back(count);
    }
    for (int i: result) {
        cout << i << '\n';
    }
}