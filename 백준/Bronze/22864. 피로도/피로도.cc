/*작성자 : 이준표
 *      백준 그리디 알고리즘
 *      브론즈 2
 *      22864번 피로도
 *      created: 2022.06.16
 */
#include <iostream>

using namespace std;

int main() {
    int a, b, c, m;
    cin >> a >> b >> c >> m;
    int lefttime = 24, work = 0, stress = 0;
    while (lefttime > 0) {
        if (stress <= m - a) {
            stress += a;
            work += b;
        } else {
            if (stress < c)
                stress = 0;
            else
                stress -= c;
        }
        lefttime--;
    }
    cout << work;
}