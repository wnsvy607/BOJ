/*      작성자 : 이준표
 *      백준 다이나믹 프로그래밍
 *      실버 3
 *      14501번 퇴사
 *      created: 2022.07.11
 */
#include <iostream>
#include <algorithm>

using namespace std;
int t[16];
int p[16];
int result[16];

int main() {
    int n;
    cin >> n;
    for (int i = 0; i < n; ++i) {
        cin >> t[i] >> p[i];
    }

    int val = 0;
    for (int i = 0; i < n; ++i) {
        if(i + t[i] > n)
            continue;
        for (int j = 0; j < i; ++j) {
            if (t[j] + j < i + 1) {
                result[i] = max(result[i], result[j] + p[i]);
            }
        }
        if (result[i] == 0)
            result[i] = p[i];
        if (result[i] > val)
            val = result[i];
    }
    cout << val;
}