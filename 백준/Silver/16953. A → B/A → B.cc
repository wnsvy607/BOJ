/*작성자 : 이준표
 *      백준 그리디 알고리즘
 *      실버 2
 *      16953번 A -> B
 *      created: 2022.06.10
 */
#include <iostream>

using namespace std;

int main() {
    long a, b;
    int count = 1;
    cin >> a >> b;
    while (b > a){          // 역으로 연산 1, 2를 그리디 알고리즘으로 적용
        if(b % 10 == 1){ // 맨 오른쪽이 1인 경우
            b = b/10;
            count++;
        } else if(b % 2 == 0){  // 2로 나누어 지는 경우
            b = b/2;
            count ++;
        } else {                // 둘 다 불가능한 경우
            count = -1;
            break;
        }
    }
    if(b != a)
        count = -1;
    cout << count;
}
