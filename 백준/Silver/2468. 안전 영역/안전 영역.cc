/*      작성자 : 이준표
 *      백준
 *      실버 1
 *      2468번 안전 영역
 *      created: 2022.08.19
 */

#include <iostream>
#include <queue>

using namespace std;
typedef pair<int, int> pi;
int zone[102][102];
int color[102][102];
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, -1, 0, 1};


int main(void) {
    int n;
    cin >> n;
    int maxLevel = 0;
    for (int i = 1; i < n + 1; ++i) {
        for (int j = 1; j < n + 1; ++j) {
            cin >> zone[i][j];
            if(maxLevel < zone[i][j])
                maxLevel = zone[i][j];
        }
    }
    int cnt = 1;
    for (int level = 1; level < maxLevel; ++level) {
        int safe = 0;
        for (int i = 1; i < n + 1; ++i) {
            for (int j = 1; j < n + 1; ++j) {
                if (zone[i][j] <= level)
                    color[i][j] = 1; // 잠김
                else
                    color[i][j] = 0; // 안잠김
            }
        }

        queue<pi> q;
        for (int i = 1; i < n + 1; ++i) {
            for (int j = 1; j < n + 1; ++j) {
                if (color[i][j] == 0) {
                    q.push({i, j});
                    while (!q.empty()) {
                        pi cur = q.front();
                        for (int k = 0; k < 4; ++k) {
                            int cx = cur.second + dx[k];
                            int cy = cur.first + dy[k];
                            if (color[cy][cx] == 0 && cy > 0 && cx > 0 && cx < n + 1 && cy < n + 1) {
                                q.push({cy, cx});
                                color[cy][cx] = 2;
                            }
                        }
                        q.pop();
                    }
                    safe++;
                }
            }
        }
        if (safe > cnt)
            cnt = safe;
    }
    cout << cnt;

}