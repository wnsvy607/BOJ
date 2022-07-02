/*작성자 : 이준표
 *      백준 다이나믹 프로그래밍
 *      실버 3
 *      11726번 2×n 타일링
 *      created: 2022.07.02
 */
#include <iostream>

long long result[1003];

using namespace std;

int main() {
    int n;
    cin >> n;
    result[1] = 1;
    result[2] = 2;
    for (int i = 3; i < n + 1; ++i) {
        result[i] = (result[i - 1] + result[i - 2]) % 10007;
    }
    cout << result[n] % 10007;
}