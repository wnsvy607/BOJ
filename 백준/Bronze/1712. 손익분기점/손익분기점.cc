/*작성자 : 이준표
 *      백준 수학
 *      브론즈 2
 *      1712번 손익분기점
 *      created: 2022.06.25
 */
#include <iostream>

using namespace std;

int main(void) {
    long a, b, c;
    cin >> a >> b >> c;
    long inter = c - b, sales;
    if (b >= c) {
        cout << -1;
    } else {
        sales = a / inter + 1;
        cout << sales;
    }
}