/*      작성자 : 이준표
 *      백준 문자열
 *      실버 4
 *      1120번 문자열
 *      created: 2022.09.09
 */

#include <iostream>
#include <algorithm>

using namespace std;
//A와 B의 길이는 최대 50이므로 차이도 최대 50
int cnt = 51;

int main(void) {
    string a, b;
    cin >> a >> b;
    //a와 b의 길이가 같아질 때까지 조정
    if (a.length() < b.length()) {
        for (int i = 0; i < b.length() - a.length() + 1; ++i) {
            int tempCnt = 0;
            for (int j = 0; j < a.length(); ++j) {
                if (a[j] != b[j + i])
                    tempCnt++;
            }
            cnt = min(cnt, tempCnt);
        }
    } else {
        cnt = 0;
        for (int i = 0; i < a.length(); ++i) {
            if (a[i] != b[i]) {
                cnt++;
            }
        }
    }
    cout << cnt;
}