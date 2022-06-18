/*작성자 : 이준표
 *      백준 그리디 알고리즘
 *      브론즈 1
 *      2810번 컵홀더
 *      created: 2022.06.18
 */
#include <iostream>

using namespace std;

int main() {
    int n;
    cin >> n;
    string seat_order;
    cin >> seat_order;
    float cup_holder = 0;
    for (char i : seat_order){
        if(i == 'S'){
            cup_holder++;
        } else {
            cup_holder += 0.5;
        }
    }
    cup_holder++;
    if(cup_holder > (float) n)
        cup_holder = (float) n;
    cout << cup_holder;
}