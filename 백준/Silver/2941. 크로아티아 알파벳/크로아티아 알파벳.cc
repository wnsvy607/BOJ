/*      작성자 : 이준표
 *      백준 문자열
 *      실버 5
 *      2941번 크로아티아 알파벳
 *      created: 2022.09.16
 */

#include <iostream>

using namespace std;

int main(void) {
    string s;
    cin >> s;
    int res = s.length();
    for (int i = 1; i < s.length(); ++i) {
        if (s[i] == '=') {
            if (i > 1 && s[i - 2] == 'd' && s[i - 1] == 'z')
                res -= 2;
            else if (s[i - 1] == 'c' || s[i - 1] == 's' || s[i - 1] == 'z')
                res--;
        } else if (s[i] == '-') {
            if (s[i - 1] == 'c' || s[i - 1] == 'd')
                res--;

        } else if (s[i] == 'j') {
            if (s[i - 1] == 'l' || s[i - 1] == 'n')
                res--;
        }
    }
    cout << res;
}