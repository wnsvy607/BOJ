/*      작성자 : 이준표
 *      백준
 *      브론즈 4
 *      10808번 알파벳 개수
 *      created: 2022.08.07
 */

#include <iostream>
#include <algorithm>

using namespace std;
int alphabet[27];


int main() {
    string str;
    cin >> str;
    for (int i = 0; i < str.length(); ++i) {
        alphabet[str[i] - 'a'] ++;
    }
    for (int i = 0; i < 26; ++i) {
        cout << alphabet[i] << ' ';
    }
}