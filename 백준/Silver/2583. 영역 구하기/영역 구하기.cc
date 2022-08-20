/*      작성자 : 이준표
 *      백준
 *      실버 1
 *      2583번 영역 구하기
 *      created: 2022.08.20
 */

#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;
typedef pair<int, int> pi;
int graph[102][102];
int visited[102][102];
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, -1, 0, 1};
int cnt;

int main(void) {
    int n, m, k;
    cin >> n >> m >> k;
    for (int i = 0; i < k; ++i) {
        int y1, x1, y2, x2;
        cin >> x1 >> y1 >> x2 >> y2;
        for (int y = y1; y < y2; ++y) {
            for (int x = x1; x < x2; ++x) {
                graph[y][x] = 1;
            }
        }
    }

    vector<int> area;
    for (int y = 0; y < n; ++y) {
        for (int x = 0; x < m; ++x) {
            queue<pi> q;
            if(graph[y][x] == 0){
                int areaOf = 0;
                q.push({y, x});
                graph[y][x] = 2;
                while (!q.empty()){
                    pi cur = q.front();
                    areaOf++;
                    for (int i = 0; i < 4; ++i) {
                        int cy = cur.first + dy[i];
                        int cx = cur.second + dx[i];
                        if(graph[cy][cx] == 0 && cy > -1 && cx > -1 && cx <m && cy <n){
                            q.push({cy, cx});
                            graph[cy][cx] = 2;
                        }
                    }
                    q.pop();
                }

                area.push_back(areaOf);
                cnt++;
            }

        }
    }
    sort(area.begin(), area.end());

    cout << cnt << '\n';
    for (int i = 0; i < area.size(); ++i) {
        cout << area[i] << ' ';
    }
}