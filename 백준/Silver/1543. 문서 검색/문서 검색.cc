/*작성자 : 이준표
 *      백준 그리디 알고리즘
 *      실버 4
 *      1543번 문서 검색
 *      created: 2022.06.19
 */
#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main() {
    string str, target;
    getline(cin, str);
    getline(cin,target);
    int number = 0;
    int i = 0;
    if(str.length() == 0 || target.length() > str.length()){
        cout << number;
    } else{
    while (i < str.length() - target.length() + 1) {
        if (str[i] == target[0]) {
            int count = 0;
            for (int j = 0; j < target.length(); ++j) {
                if (str[i + j] != target[j]) {
                    count++;
                    break;
                }
            }
            if (count == 0) {
                number++;
                i += (int) target.length() - 1;
            }
        }
        i++;
    }
    cout << number;}
}