/*      작성자 : 이준표
 *      백준 브루트 포스
 *      실버 5
 *      1436번 영화감독 숌
 *      created: 2022.08.29
 */

#include <iostream>

using namespace std;

int main(void) {
    int n;
    cin >> n;
    long long candidate = 666;
    while (n != 0) {
        string num = to_string(candidate);
        int checker = 0;
        for (int i = 2; i < num.length(); ++i) {
            if (num[i] == '6' && num[i - 1] == '6' && num[i - 2] == '6'){
                n--;
                break;
            }
        }
        candidate++;
    }
    cout << candidate - 1;
}