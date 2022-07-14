/*      작성자 : 이준표
 *      백준 구현
 *      골드 5
 *      14503번 로봇 청소기
 *      created: 2022.07.14
 */
#include <iostream>

using namespace std;

int place[51][51];
int dy[4] = {-1, 0, 1, 0};     //0:북 1:동 2:남 3:서
int dx[4] = {0, 1, 0, -1};

int main() {
    int n, m, r, c, d;
    cin >> n >> m >> r >> c >> d;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            cin >> place[i][j];
        }
    }
    int clean = 0;
    while (1) {
        if (place[r][c] == 0) { //청소가 필요할 경우 청소
            place[r][c] = 2;
            clean++;            //청소횟수 추가
        }
        int checker = 0;
        for (int i = 1; i < 5; ++i) {   //왼쪽으로 돌아 360도까지 청소할 곳이 있는지 확인함
            int temp = d - i;
            if (temp < 0)
                temp += 4;
            int y = r + dy[temp], x = c + dx[temp];
            if (y < n && x < m && y > -1 && x > -1 && place[y][x] == 0) { 
                d = temp;
                r = y;
                c = x;
                checker = 1;
                break;
            }
        }
        if(checker == 0){
            int opposite = (d - 2 < 0 ? d + 2 : d - 2);
            int y = r + dy[opposite];
            int x = c + dx[opposite];   //여기서 y, x는 후진 했을 때의 좌표(y,x)를 말한다.
            if(place[y][x] == 1)        //벽일 경우
                break;
             else {                    //벽은 아닐 경우
                r = y; c = x;           //그대로 후진하며 방향은 유지한다.
            }
        }

    }
    cout << clean;
}