/*      작성자 : 이준표
 *      백준 다이나믹 프로그래밍
 *      실버 1
 *      1932번 정수 삼각형
 *      created: 2022.07.12
 */
#include <iostream>
#include <algorithm>

using namespace std;

int tri[501][501];
int result[501][501];

int main() {
    int n;
    cin >> n;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < i + 1; ++j) {
            cin >> tri[i][j];
        }
    }

    result[0][0] = tri[0][0];
    for (int i = 1; i < n; ++i) {
        for (int j = 0; j < i + 1; ++j) {
            if (j == 0) {
                result[i][j] = result[i - 1][j] + tri[i][j];
            } else if (j == i) {
                result[i][j] = result[i - 1][j - 1] + tri[i][j];
            } else {
                result[i][j] = max(result[i - 1][j], result[i - 1][j - 1]) + tri[i][j];
            }
        }
    }
    int answer = 0;
    for (int i = 0; i < n; ++i) {
        answer = max(result[n - 1][i], answer);
    }
    cout << answer;
}