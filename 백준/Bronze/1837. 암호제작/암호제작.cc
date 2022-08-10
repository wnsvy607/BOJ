/*      작성자 : 이준표
 *      백준 문자열, 소수
 *      브론즈 3
 *      1837번 암호 제작
 *      created: 2022.08.10
 */

#include <iostream>
#include <algorithm>

using namespace std;
int isPrime[10000002];

int main(void) {
    string p;
    int k;
    cin >> p >> k;

    for (int i = 2; i < k + 1; ++i) {
        isPrime[i] = 1;
    }

    for (int i = 2; i * i <= k; ++i) {

        if (isPrime[i]) {

            for (int j = i * i; j <= k; j += i) {
                isPrime[j] = 0;
            }
        }
    }


    for (long long i = 2; i < k; ++i) {
        if (isPrime[i]) {
            string quotient;
            long remainder = 0;
            for (int j = 0; j < p.length(); ++j) {
                int number = p[j] - '0';
                remainder += number;
                long q = (long) remainder / i;
                remainder = (remainder % i) * 10;
                char a = '0' + q;
                quotient += a;
            }
            if (remainder == 0) {
                cout << "BAD " << i;
                return 0;
            }
        }
    }
    cout << "GOOD";
}