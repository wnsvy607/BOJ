/*      작성자 : 이준표
 *      백준 DP
 *      실버 2
 *      1912번 연속합
 *      created: 2022.07.17
 */

#include <iostream>

using namespace std;

int main() {
    int n;
    cin >> n;
    int first;
    cin >> first;
    int total = first; int candidate = first; int checker = 0;
    if(first < 0){
       total = 0;
    }
    for (int i = 1; i < n; ++i) {
        int temp;
        cin >> temp;
        total += temp;
        checker++;
        if(total < 0){
            if(checker == 1 && temp > candidate){
                candidate = temp;
            }
            total = 0;
            checker = 0;
        } else {
            if(total > candidate){
                candidate = total;
            }
        }
    }
    cout << candidate;
}