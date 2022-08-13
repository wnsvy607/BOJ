/*      작성자 : 이준표
 *      백준 문자열
 *      브론즈 1
 *      1157번 단어 공부
 *      created: 2022.08.14
 */

#include <iostream>

using namespace std;
int cnt[27];

int main(void) {
    string word;
    cin >> word;
    for (int i = 0; i < word.length(); ++i) {
        int idx;
        if(word[i] <= 'Z')
            idx = word[i] - 'A';
        else
            idx = word[i] - 'a';
        cnt[idx]++;
    }
    int max = 0, idx = 0;
    for (int i = 0; i < 26; ++i) {
        if(max < cnt[i]){
            max = cnt[i];
            idx = i;
        }
    }
    for (int i = 0; i < 26; ++i) {
        if(max == cnt[i] && i != idx){
            cout << '?';
            return 0;
        }
    }
    char answer = 'A' + idx;
    cout << answer;
}