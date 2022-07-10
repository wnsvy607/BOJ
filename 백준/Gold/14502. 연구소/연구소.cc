/*      작성자 : 이준표
 *      백준 그래프
 *      골드 5
 *      14502번 연구소
 *      created: 2022.07.10
 */
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int graph[10][10];
int dy[4] = {-1,1,0,0};
int dx[4] = {0,0,-1,1};
vector<pair<int,int>> v;

int solve(int n, int m, int y1, int x1, int y2, int x2, int y3, int x3);

int main() {
    int n, m;
    cin >> n >> m;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            cin >> graph[i][j];
            if(!graph[i][j]) v.push_back({i, j});
        }
    }

    int a = v.size();
    int max = 0;
    for (int i = 0; i < a; ++i) {
        for (int j = i + 1; j < a; ++j) {
            for (int k = j + 1; k < a; ++k) {
                int x1, y1, x2, y2, x3, y3;
                y1 = v[i].first; x1 = v[i].second; y2 = v[j].first; x2 = v[j].second; y3 = v[k].first; x3 = v[k].second;
                int result = solve(n, m, y1, x1, y2, x2, y3, x3);
                if(result > max)
                    max = result;
            }
        }
    }
    cout << max;
}

int solve(int n, int m, int y1, int x1, int y2, int x2, int y3, int x3){
    int temp[10][10] = {0, };
    int visited[10][10] = {0, };
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            temp[i][j] = graph[i][j];
        }
    }
    temp[y1][x1] = 1;
    temp[y2][x2] = 1;
    temp[y3][x3] = 1;


    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if(temp[i][j] == 2 && visited[i][j] == 0){
                queue<pair<int,int>> q;
                q.push({i, j});
                visited[i][j] = 1;
                while (!q.empty()){
                    int cy = q.front().first;
                    int cx = q.front().second;
                    q.pop();
                    for (int k = 0; k < 4; ++k) {
                        int y = cy + dy[k];
                        int x = cx + dx[k];
                        if(y > -1 && x > -1 && y < n && x < m && temp[y][x] == 0){
                            temp[y][x] = 2;
                            q.push({y,x});
                            visited[y][x] = 1;
                        }
                    }
                }
            }
        }
    }
    int count = 0;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if(temp[i][j] == 0)
                count++;
        }
    }
    return count;
}