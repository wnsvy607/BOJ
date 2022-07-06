/*      작성자 : 이준표
 *      백준 그래프 이론
 *      골드 5
 *      7576번 토마토
 *      created: 2022.07.07
 */
#include <iostream>
#include <queue>

using namespace std;

int tomato[1001][1001];
int visited[1001][1001];
int number[3];      //0은 토마토가 없는 상자, 1은 익지 않은 토마토, 2는 익은 토마토가 들은 상자의 개수

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int dy[4] = {1,-1,0,0}; //상하좌우
    int dx[4] = {0,0,-1,1};
    int n, m;
    cin >> m >> n;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            cin >> tomato[i][j];
            number[tomato[i][j] + 1]++;
        }
    }

    if (number[0] + number[2] == m * n) { //시작부터 다 익었는지를 검증한다.
        cout << 0;
        return 0;
    }

    queue<pair<int, int>> q;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (tomato[i][j] == 1) {
                q.push({i, j});
                visited[i][j] = 1;
            }
        }
    }

    int day = 0;
    while (!q.empty()){
        int cy = q.front().first;
        int cx = q.front().second;
        q.pop();
        for (int i = 0; i < 4; ++i) {
            int y = cy + dy[i];
            int x = cx + dx[i];
            if(y > -1 && x > -1 && y < n && x < m && tomato[y][x] == 0){
                tomato[y][x] = 1;
                q.push({y, x});
                visited[y][x] = visited[cy][cx] + 1;
                day = visited[y][x];
            }
        }
    }
    int checker = 1;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if(tomato[i][j] == 0) {
                checker = tomato[i][j];
                break;
            }
        }
        if(!checker)
            break;
    }

    if(!checker)
        cout << -1;
    else
        cout << day - 1;
}