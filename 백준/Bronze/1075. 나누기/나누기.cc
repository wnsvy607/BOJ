/*      작성자 : 이준표
 *      백준
 *      브론즈 2
 *      1075번 나누기
 *      created: 2022.08.24
 */

#include <iostream>

using namespace std;

int main(void) {
    long long n;
    long long f;
    cin >> n >> f;

    int remainder = n % 100;
    n = n - remainder;
    int a = n % f;
    if(a == 0){
        cout << "00";
        return 0;
    }
    if(f == 100)
        f -= 100;

    if (f - a < 10)
        cout << "0" << f - a;
    else
        cout << f - a << endl;
}
