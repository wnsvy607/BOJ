/*작성자 : 이준표
 *      백준
 *      실버 3
 *      1783번 병든 나이트
 *      created: 2022.11.12
 */
#include <iostream>

using namespace std;

int n, m, cnt = 1;

//병든 나이트가 N × M 크기 체스판의 가장 왼쪽아래 칸에 위치해 있다. (1 , 1)
//병든 나이트의 이동 횟수가 4번보다 적지 않다면, 이동 방법을 모두 한 번씩 사용해야 한다.
//병든 나이트는 건강한 보통 체스의 나이트와 다르게 4가지로만 움직일 수 있다. (오른쪽으로만 이동 가능)
int main(void) {
    cin >> n >> m;

    if (n == 1) {
        cnt = 1;
    } else if (n == 2) {
        if (m > 6)
            cnt = 4;
        else
            cnt = (m + 1) / 2;
    } else {
        if (m < 4)
            cnt = m;
        else if (m < 7) {
            cnt = 4;
        } else {
            cnt = m - 2;
        }
    }
    
    cout << cnt;
}