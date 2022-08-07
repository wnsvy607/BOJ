/*      작성자 : 이준표
 *      백준
 *      브론즈 2
 *      2979번 트럭주차
 *      created: 2022.08.07
 */

#include <iostream>

using namespace std;
int parking_time[102];


int main() {
    int a, b, c;
    cin >> a >> b >> c;
    for (int i = 0; i < 3; ++i) {
        int start, end;
        cin >> start >> end;
        for (int j = start; j < end; ++j) {
            parking_time[j]++;
        }
    }
    int cost = 0;
    for (int i = 1; i < 101; ++i) {
        int car = parking_time[i];
        if(car == 1)
            cost += a;
         else if(car == 2)
            cost += b * 2;
         else if(car == 3)
            cost += c * 3;
    }
    cout << cost;

}