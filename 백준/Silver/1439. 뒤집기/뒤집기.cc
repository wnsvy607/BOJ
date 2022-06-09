/*작성자 : 이준표
 *      백준 그리디 알고리즘
 *      실버 5
 *      1439번 뒤집기
 *      created: 2022.06.09
 */

#include <iostream>

using namespace std;

int main() {
    string str;
    cin >> str;
    int first = str[0] - '0', count = 0;
    int temp = str[0] - '0';
    for (int j = 1; j < str.length(); ++j) {
        if (temp != str[j] - '0') {
            temp = str[j] - '0';
            count ++;
        }
    }
    if(temp == first){
        count = count / 2;
    } else {
        count = (count + 1) / 2;
    }
    cout << count;
}