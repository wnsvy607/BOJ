/*      작성자 : 이준표
 *      백준 문자열
 *      1159번 농구 경기
 *      created: 2022.08.08
 */

#include <iostream>

using namespace std;
int alphabet[27];

int main() {
    int n;
    cin >> n;
    for (int i = 0; i < n; ++i) {
        string str;
        cin >> str;
        int idx = str[0] - 'a';
        alphabet[idx]++;
    }
    int checker = 0;
    for (int i = 0; i < 26; ++i) {
        if(alphabet[i] >= 5){
            char temp = 'a' + i;
            cout << temp;
            checker++;
        }
    }
    if(checker == 0)
        cout << "PREDAJA";
}