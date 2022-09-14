/*      작성자 : 이준표
 *      백준 문자열
 *      브론즈 1
 *      10798번 세로읽기
 *      created: 2022.09.14
 */

#include <iostream>
#include <vector>
#include <string.h>

using namespace std;
char s[5][17] ={'~',};

int main(void) {
    memset(s, '~', sizeof(s));
    int len = 0;
    for (int i = 0; i < 5; ++i) {
        int cnt;
        for (int j = 0; j < 16; j++) {
            char temp;
            scanf("%c", &temp);
            if (temp == '\n'){
                s[i][j] = '~';
                if(j > len)
                    len = j;
                break;
            }
            else
                s[i][j] = temp;
        }
    }
    string res = "";
    for (int i = 0; i < len; ++i) {
        for (int j = 0; j < 5; ++j) {
            if(s[j][i] == '~')
                continue;
            else
                res += s[j][i];
        }
    }
    cout << res;
}