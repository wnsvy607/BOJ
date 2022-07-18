/*      작성자 : 이준표
 *      백준 DP
 *      실버 1
 *      2156번 포도주 시식
 *      created: 2022.07.18
 */

#include <iostream>
#include <algorithm>

using namespace std;

int wine[10001];
int result[10001];

int main() {
    int n;
    cin >> n;
    for (int i = 0; i < n; ++i) {
        cin >> wine[i];
    }

    result[0] = wine[0];
    result[1] = wine[0] + wine[1];
    result[2] = max(result[0] + wine[2], max(result[1], wine[1] + wine[2]));

    for (int i = 3; i < n; ++i) {
        result[i] = max(result[i - 2], wine[i - 1] + result[i - 3]) + wine[i];
        if(result[i] < result[i-1])
            result[i] = result[i-1];
    }

    int answer = *max_element(result, result + n);
    cout << answer;
}