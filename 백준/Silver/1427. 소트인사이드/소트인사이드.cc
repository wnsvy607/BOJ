/*      작성자 : 이준표
 *      백준 문자열
 *      실버 5
 *      1427번 소트인사이드
 *      created: 2022.09.07
 */

#include <iostream>
#include <algorithm>

using namespace std;

int main(void) {
    string num;
    cin >> num;
    sort(num.begin(), num.end(),greater());
    for (int i = 0; i < num.length(); ++i) {
        cout << num[i];
    }
}