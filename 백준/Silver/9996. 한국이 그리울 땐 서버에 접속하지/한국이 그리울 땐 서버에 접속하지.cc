/*      작성자 : 이준표
 *      백준 문자열
 *      실버 3
 *      9996번 한국이 그리울 땐 서버에 접속하지
 *      created: 2022.08.12
 */

#include <iostream>

using namespace std;

int main(void) {
    int n;
    cin >> n;
    string pattern, sub1, sub2;
    cin >> pattern;
    int star = 0;
    for (int i = 0; i < pattern.length(); ++i) {
        if (pattern[i] == '*') {
            star = i;
            break;
        } else
            sub1 += pattern[i];
    }
    for (int i = star + 1; i < pattern.length(); ++i) {
        sub2 += pattern[i];
    }

    for (int i = 0; i < n; ++i) {
        int checker = 0;
        string file;
        cin >> file;
        int len = file.length();
        if (len < sub1.length() + sub2.length()) {
            cout << "NE" << endl;
            continue;
        }


        for (int j = 0; j < sub1.length(); ++j) {
            if (file[j] != sub1[j]) {
                checker++;
            }
        }

        for (int j = len - sub2.length(); j < len; ++j) {
            if (file[j] != sub2[j + sub2.length() - len]) {
                checker++;
            }
        }
        if (checker == 0)
            cout << "DA" << endl;
        else
            cout << "NE" << endl;
    }
}