/*      작성자 : 이준표
 *      백준
 *      브론즈 2
 *      10988번 팰린드롬인지 확인하기
 *      created: 2022.08.08
 */

#include <iostream>

using namespace std;

int main() {
    string word;
    cin >> word;
    int len = word.length();
    for (int i = 0; i < (len / 2); ++i) {
        if (word[i] != word[len - 1 - i]){
            cout << 0;
            return 0;
        }
    }
    cout << 1;
}