/*      작성자 : 이준표
 *      백준 그래프
 *      실버 5
 *      10709번 기상캐스터
 *      created: 2022.08.27
 */

#include <iostream>

using namespace std;
int joi[102][102];

int main(void) {
    int h, w;
    cin >> h >> w;
    for (int i = 0; i < h; ++i) {
        for (int j = 0; j < w; ++j) {
            char temp;
            cin >> temp;
            if (temp == 'c') {
                for (int k = j; k < w; ++k) {
                    joi[i][k] = k - j;
                }
            } else if(joi[i][j] == 0)
                joi[i][j] = -1;
        }
    }

    for (int i = 0; i < h; ++i) {
        for (int j = 0; j < w; ++j) {
            cout << joi[i][j] << ' ';
        }
        cout << '\n';
    }
}