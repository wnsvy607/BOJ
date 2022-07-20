/*      작성자 : 이준표
 *      백준 DP
 *      실버 1
 *      10844번 쉬운 계단 수
 *      created: 2022.07.20
 */

#include <iostream>

using namespace std;

long result[102][11];

int main() {
    int n;
    cin >> n;

    for (int i = 1; i < 10; ++i) {
        result[0][i] = 1;
    }

    for (int i = 1; i < n; ++i) {
        result[i][0] = result[i-1][1];
        result[i][9] = result[i-1][8];
        for (int j = 1; j < 9; ++j) {
            result[i][j] = (result[i - 1][j - 1] + result[i - 1][j + 1]) % 1000000000;
        }
    }

    long answer = 0;
    for (int i = 0; i < 10; ++i) {
        answer += result[n-1][i];
    }
    cout << answer % 1000000000;
}