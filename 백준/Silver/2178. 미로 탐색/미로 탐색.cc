/*작성자 : 이준표
 *      백준 그래프 이론
 *      실버 1
 *      2178번 미로 탐색
 *      created: 2022.06.26
 */
#include <iostream>
#include <algorithm>
#include <queue>


int maze[102][102];
int visited[102][102];

using namespace std;

int main() {
int dy[4] = {-1,0,1,0};
int dx[4] = {0,1,0,-1};

    int n, m;
    cin >> n >> m;

    for (int i = 0; i < n + 1; ++i) {
        string str;
        getline(cin, str);
        for (int j = 1; j < m + 1; ++j) {
            maze[i][j] = str[j - 1] - '0';
        }
    }

    queue<pair<int,int>> wait;

    wait.push({1,1});
    visited[1][1] = 1;
    while (!wait.empty()){
        pair<int,int> pos = wait.front();
        int sty = pos.first;
        int stx = pos.second;
        wait.pop();

        for (int i = 0; i <4; ++i) {
            int y = dy[i] + sty;
            int x = dx[i] + stx;
            if(maze[y][x] == 1 && visited[y][x] == 0){
                wait.push({y,x});
                visited[y][x] = visited[sty][stx] + 1;
            }
        }
    }

    cout << visited[n][m];
}