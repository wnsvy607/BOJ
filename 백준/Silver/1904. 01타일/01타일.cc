/*      작성자 : 이준표
 *      백준 DP
 *      실버 3
 *      1904번 01타일
 *      created: 2022.07.24
 */

#include <iostream>
#include <vector>

using namespace std;

long result[1000001][2];

int main() {
    int n;
    cin >> n;
    result[0][0] = 0;
    result[0][1] = 1;
    result[1][0] = 1;
    result[1][1] = 1;

    for (int i = 2; i < n; ++i) {
        result[i][0] = (result[i-2][0] + result[i-2][1]) % 15746;
        result[i][1] = (result[i - 1][0] + result[i - 1][1]) % 15746;
    }
    cout << (result[n - 1][0] + result[n - 1][1]) % 15746;
}