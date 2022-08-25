/*      작성자 : 이준표
 *      백준
 *      브론즈 5
 *      1330번 두 수 비교하기
 *      created: 2022.08.25
 */

#include <iostream>

using namespace std;

int main(void) {
    int a, b;
    cin >> a >> b;

    if(a > b)
        cout << '>';
    else if(a == b)
        cout << "==";
    else
        cout << '<';
}