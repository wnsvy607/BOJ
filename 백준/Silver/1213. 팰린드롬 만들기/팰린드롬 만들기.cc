/*      작성자 : 이준표
 *      백준 문자열
 *      실버 3
 *      1213번 팰린드롬 만들기
 *      created: 2022.08.15
 */

#include <iostream>
#include <algorithm>

int alphabet[27];
char middle;


using namespace std;

int main(void) {
    string name;
    cin >> name;
    int len = name.length();
    for (int i = 0; i < len; ++i) {
        int idx = name[i] - 'A';
        alphabet[idx]++;
    }

    int odd;
    //글자가 홀수면 하나의 홀수자가 1개 허용된다.
    if (len % 2 == 1)
        odd = 0;
    else // 그렇지 않으면 홀수자가 1개도 허용되지 않는다.
        odd = 1;

    //팰린드롬으로 만들 수 있는 지를 검증
    for (int i = 0; i < 26; ++i) {
        if (alphabet[i] % 2 == 1) {
            odd++;
            if (odd == 2) {
                cout << "I'm Sorry Hansoo";
                return 0;
            }
        }
    }

    string new_name, reversed;
    for (int i = 0; i < 26; ++i) {
        //홀수인 경우(가운데에 놓는다.)
        if (alphabet[i] % 2 == 1) {
            middle = 'A' + i;
            alphabet[i]--;
        }

        //나머지는 앞에서부터 하나씩 붙여준다.
        while (alphabet[i] != 0) {
            new_name += i + 'A';
            alphabet[i] -= 2;
        }
    }
    reversed = new_name;
    reverse(reversed.begin(), reversed.end());
    string palindrome = new_name;
    if (len % 2 == 0) 
        palindrome += reversed;
    else
        palindrome += middle + reversed;

    cout << palindrome;
}