/*      작성자 : 이준표
 *      백준 DP
 *      실버 3
 *      11727번 2xN 타일링 2
 *      created: 2022.07.21
 */

#include <iostream>

using namespace std;

long result[1001];

int main() {
    int n;
    cin >> n;
    result[0] = 1;
    result[1] = 3;
    //3  9
    for (int i = 2; i < n; ++i) {
        result[i] = (result[i - 1] + result[i - 2] * 2)%10007 ;
    }
    cout << result[n - 1];
}