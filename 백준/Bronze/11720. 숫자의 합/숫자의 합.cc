/*      작성자 : 이준표
 *      백준 문자열
 *      브론즈 4
 *      11720번 숫자의 합
 *      created: 2022.09.08
 */

#include <iostream>

using namespace std;

int main(void) {
    int n;
    cin >> n;
    int total = 0;
    for (int i = 0; i < n; ++i) {
        int temp;
        scanf("%1d", &temp);
        total += temp;
    }
    cout << total;
}