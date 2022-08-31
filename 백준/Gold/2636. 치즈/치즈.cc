/*      작성자 : 이준표
 *      백준 그래프
 *      골드 4
 *      2636번 치즈
 *      created: 2022.08.31
 */

#include <iostream>
#include <queue>

using namespace std;
int cheese[102][102];
int answer[101];

int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, -1, 0, 1};

typedef pair<int, int> pi;

int main(void) {
    int n, m;
    cin >> n >> m;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            cin >> cheese[i][j];
        }
    }
    int melted = 1;
    int hour;
    for (hour = 1; melted != 0; ++hour) {
        melted = 0;
        int visited[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                visited[i][j] = 0;
            }
        }
        pi start = {0, 0};
        visited[0][0] = 1;
        queue<pi> zeroQ, airQ;
        zeroQ.push(start);
        while (!zeroQ.empty()) {
            int y = zeroQ.front().first;
            int x = zeroQ.front().second;
            for (int i = 0; i < 4; ++i) {
                int cy = y + dy[i];
                int cx = x + dx[i];
                if (cy < 0 || cx < 0 || cy > n - 1 || cx > m - 1)continue;
                if (cheese[cy][cx] == 0 && visited[cy][cx] == 0) {
                    visited[cy][cx] = 1;
                    zeroQ.push({cy, cx});
                } else if (cheese[cy][cx] == 1)
                    airQ.push({cy, cx});
            }
            zeroQ.pop();
        }
        while (!airQ.empty()) {
            int y = airQ.front().first;
            int x = airQ.front().second;
            if (cheese[y][x] != 0) {
                cheese[y][x] = 0;
                melted++;
            }
            airQ.pop();
        }
        answer[hour] = melted;
    }

    cout << hour - 2 << '\n';
    cout << answer[hour - 2];

}