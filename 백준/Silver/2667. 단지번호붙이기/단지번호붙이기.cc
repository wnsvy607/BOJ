/*작성자 : 이준표
 *      백준 그래프
 *      실버 1
 *      2667번 단지번호붙이기
 *      created: 2022.07.01
 */
#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;

int graph[30][30];
int visited[30][30];

int main() {
    int dy[4] = {0, 0, 1, -1};
    int dx[4] = {-1, 1, 0, 0};
    int n;
    cin >> n;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            scanf("%1d", &graph[i][j]);
        }
    }
    int danzi = 1;
    vector<int> house;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            if (graph[i][j] == 1 && visited[i][j] == 0) {
                int count = 0;
                queue<pair<int, int>> q;
                q.push({i, j});
                while (!q.empty()) {
                    pair<int, int> temp = q.front();
                    q.pop();
                    visited[temp.first][temp.second] = 2;
                    count++;
                    for (int k = 0; k < 4; ++k) {
                        int y = temp.first + dy[k];
                        int x = temp.second + dx[k];
                        if (x > -1 && y > -1 && graph[y][x] == 1 && visited[y][x] == 0) {
                            q.push({y, x});
                            visited[y][x] = 1;
                        }
                    }
                }
                house.push_back(count);
                danzi++;
            }
        }
    }
    sort(house.begin(), house.end());
    cout << --danzi << endl;
    for (int i = 0; i < danzi; ++i) {
        cout << house[i] << endl;
    }
}