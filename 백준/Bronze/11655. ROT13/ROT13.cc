/*      작성자 : 이준표
 *      백준 문자열
 *      브론즈 1
 *      11655번 ROT13
 *      created: 2022.08.10
 */

#include <iostream>

using namespace std;
char str[102];

int main(void) {
    fgets(str, 101, stdin);
    int i = 0;
    while (str[i] != '\0') {
        if (str[i] == ' ' || str[i] <= '9')
            printf("%c",str[i]);
        else if (str[i] > 'M' && str[i] < '[')
            printf("%c", str[i] - 13);
        else if (str[i] > 'm' && str[i] < '{')
            printf("%c", str[i] - 13);
        else
            printf("%c", str[i] + 13);
        i++;
    }

}