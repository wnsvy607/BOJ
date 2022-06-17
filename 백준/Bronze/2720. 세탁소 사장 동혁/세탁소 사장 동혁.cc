/*작성자 : 이준표
 *      백준 그리디 알고리즘
 *      브론즈 3
 *      2720번 세탁소 사장 동혁
 *      created: 2022.06.17
 */
#include <iostream>

using namespace std;


int main() {
    int n;
    cin >> n;

    for (int i = 0; i < n; ++i) {
        int num;
        int change[] = {0,0,0,0};
        cin >> num;
        while (num > 0){
            if(num > 24){
                change[0]++;
                num -= 25;

            } else if(num > 9) {
                change[1]++;
                num -= 10;
            } else if(num > 4){
                change[2]++;
                num -= 5;
            } else{
                change[3]++;
                num -= 1;
            }
        }
        for (int j : change) {
            cout << j << ' ';
        }
        cout << endl;
    }
}