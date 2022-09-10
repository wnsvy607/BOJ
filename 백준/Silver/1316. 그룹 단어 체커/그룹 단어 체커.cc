/*      작성자 : 이준표
 *      백준 문자열
 *      실버 5
 *      1316번 그룹 단어 체커
 *      created: 2022.09.10
 */

#include <iostream>
#include <algorithm>
#include <string.h>

using namespace std;
int cnt;
int alphabet[27];

int main(void) {
    int n;
    cin >> n;
    for (int i = 0; i < n; ++i) {
        memset(alphabet, 0, sizeof(alphabet));
        string word;
        cin >> word;
        int checker = 0;
        for (int j = 0; j < word.length(); ++j) {
            int idx = (int) word[j] - 'a';
            //이전에 나왔는데, 0보다 크고,
            if(alphabet[idx] && j > 0 && word[j-1] != word[j]){
                checker++;
                break;
            } else
                alphabet[idx]++;
        }
        if(checker == 0)
            cnt++;
    }

    cout << cnt;
}