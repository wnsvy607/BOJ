/*      작성자 : 이준표
 *      백준 구현,시뮬레이션, 자료구조
 *      골드 4
 *      3190번 뱀
 *      created: 2022.07.13
 */
#include <iostream>
#include <queue>

using namespace std;

int apple[101][101];
int snake[101][101];
int dy[4] = {0, 1, 0, -1};     //0:좌 1:하 2:우 3:상
int dx[4] = {1, 0, -1, 0};
int info[10001];

int main() {
    int n, k;
    cin >> n >> k;
    for (int i = 0; i < k; ++i) {
        int y, x;
        cin >> y >> x;
        apple[y][x] = 1;
    }

    int l;
    cin >> l;
    for (int i = 0; i < l; ++i) {
        int x;
        char c;
        cin >> x >> c;
        if (c == 'D')
            info[x] = 1;
        else
            info[x] = -1;
    }

    queue<pair<int, int>> pos;
//    int length = 1;
    pos.push({1, 1});
    snake[1][1] = 1;
    int second = 0;
    int direction = 0;
    while (1) {
        if (info[second] != 0) {
            direction += info[second];
            if (direction > 3)
                direction = 0;
            else if (direction < 0)
                direction = 3;
        }
        pair<int, int> head = pos.back();
        int y = head.first + dy[direction]; //진행 방향에 따라 진행할 위치
        int x = head.second + dx[direction];
        second++;
        if (snake[y][x] == 1)                 //자기 몸에 부딪힌 경우
            break;
        else if (y > n || y < 1 || x > n || x < 1)   //벽에 부딪힌 경우
            break;
        else if (apple[y][x] == 1) {  //사과가 있을 때
            apple[y][x] = 0;
        } else {         //사과가 없을 때
            snake[pos.front().first][pos.front().second] = 0;
            pos.pop();
        }
        pos.push({y, x});
        snake[y][x] = 1;
    }
    cout << second;
}
