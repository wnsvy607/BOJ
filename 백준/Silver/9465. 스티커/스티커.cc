/*      작성자 : 이준표
 *      백준 DP
 *      실버 1
 *      9465번 스티커
 *      created: 2022.07.26
 */

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
    int t;
    cin >> t;
    vector<long> answer;
    for (int i = 0; i < t; ++i) {
        int n;
        cin >> n;
        long result[2][100001];
        long v[2][100001];
        for (int k = 0; k < 2; ++k) {
            for (int j = 1; j < n + 1; ++j) {
                cin >> v[k][j];
            }
        }
        result[0][0] = 0; result[1][0] = 0;
        result[0][1] = v[0][1];
        result[1][1] = v[1][1];
        for (int j = 2; j < n + 1; ++j) {
            result[0][j] = max(result[1][j-1],result[1][j-2]) + v[0][j];
            result[1][j] = max(result[0][j-1],result[0][j-2]) + v[1][j];
        }
        long a = max(result[0][n], result[1][n]);
        answer.push_back(a);
    }
    for (int i = 0; i < t; ++i) {
        cout << answer[i] << '\n';
    }
}