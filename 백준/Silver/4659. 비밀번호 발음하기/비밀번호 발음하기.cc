/*      작성자 : 이준표
 *      백준
 *      실버 5
 *      4659번 비밀번호 발음하기
 *      created: 2022.08.23
 */

#include <iostream>
#include <vector>

using namespace std;

char vowels[5] = {'a', 'e', 'i', 'o', 'u'};

int main(void) {

    vector<string> v;
    string s;
    cin >> s;
    while (s != "end"){
        v.push_back(s);
        cin >> s;
    }
    for (int num = 0; num < v.size() ; num++) {
        s = v[num];
        int moum = 0;
        for (int i = 0; i < s.length(); ++i) {
            //같은 글자가 연속적으로 두번 오면 안되나, ee와 oo는 허용
            if (i > 0 && s[i] == s[i - 1] && s[i] != 'e' && s[i] != 'o') {
                moum = 0;
                break;
            }
            //모음 반드시 하나를 포함
            if (moum == 0) {
                for (int j = 0; j < 5; ++j) {
                    if (s[i] == vowels[j]){
                        moum++;
                        break;
                    }
                }
            }

            //모음이 3개 혹은 자음이 3개 연속으로 오면 안된다.
            if (i > 1) {
                int checker = 0;
                for (int j = 0; j < 3; ++j) {
                    for (int k = 0; k < 5; ++k) {
                        if (vowels[k] == s[i - j]){
                            checker++;
                            break;
                        }
                    }
                }
                if(checker == 0 || checker == 3) {
                    moum = 0;
                    break;
                }
            }
        }

        if (moum) {
            cout << '<' << s << '>' << " is acceptable." << '\n';
        } else {
            cout << '<' << s << '>' << " is not acceptable." << '\n';
        }

    }

}
