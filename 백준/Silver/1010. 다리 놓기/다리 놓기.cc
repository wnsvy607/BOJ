/*      작성자 : 이준표
 *      백준 DP
 *      실버 5
 *      1010번 다리 놓기
 *      created: 2022.07.24
 */

#include <iostream>
#include <vector>

using namespace std;


int main() {
    int t;
    cin >> t;
    vector<long> answer;
    for (int i = 0; i < t; ++i) {
        int n, m;
        cin >> n >> m;
        long result[32] = {0,};
        result[0] = 1;
        result[1] = m;
        for (int j = 2; j < n + 1; ++j) {
            result[j] = result[j - 1] * (m - j + 1) / j;
        }
        answer.push_back(result[n]);
    }

    for (int i = 0; i < t; ++i) {
        cout << answer[i] << '\n';
    }
}