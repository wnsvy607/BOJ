/*작성자 : 이준표
 *      백준
 *      실버 2
 *      4963번 병든 나이트
 *      created: 2022.11.12
 */
#include <iostream>
#include <vector>

using namespace std;

int map[52][52];
int visited[52][52];
int w, h, cnt;
typedef pair<int, int> pi;

int dx[8] = {1, 1, -1, -1, 1, 0, -1, 0};
int dy[8] = {1, -1, 1, -1, 0, 1, 0, -1};

void dfs(int y, int x) {
    visited[y][x] = 1;
    for (int i = 0; i < 8; ++i) {
        int cy = dy[i] + y;
        int cx = dx[i] + x;
        if (cx < 0 || cy < 0 || cx >= w || cy >= h || visited[cy][cx] == 1 || map[cy][cx] == 0) continue;
        dfs(cy, cx);
    }
}

int main(void) {
    vector<int> answer;
    while (1) {
        cin >> w >> h;
        cnt = 0;
        if (!w || !h)
            break;
        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; ++j) {
                int temp;
                cin >> temp;
                map[i][j] = temp;
            }
        }
        //visited 배열 메모리 초기화
        for (int i = 0; i < h; i++)
            fill(visited[i], visited[i] + w, 0);
        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; ++j) {
                // 방문하지 않은 땅일 경우
                if (map[i][j] == 1 && visited[i][j] == 0) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        answer.push_back(cnt);
    }
    for (int i = 0; i < answer.size(); ++i) {
        cout << answer[i] << '\n';
    }
}