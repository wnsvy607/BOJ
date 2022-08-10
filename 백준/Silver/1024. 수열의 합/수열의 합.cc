/*      작성자 : 이준표
 *      백준
 *      실버 2
 *      1024번 수열의 합
 *      created: 2022.08.10
 */

#include <iostream>

using namespace std;

int main() {
    long n, l;
    cin >> n >> l;
    int checker = 0;
    while (1) {
        int sum = (l * (l - 1) / 2);
        for (int i = 0; sum <= n; ++i) {
            if (sum == n) {
                int start = i;
                int end = start + l;
                for (int j = start; j < end; ++j) {
                    cout << j << ' ';
                }
                checker++;
                break;
            }
            sum += l;
        }
        l++;
        if (checker == 1) {
            break;
        } else if (l == 101) {
            cout << -1;
            break;
        }
    }

}