/*      작성자 : 이준표
 *      백준
 *      실버 5
 *      9655번 돌 게임
 *      created: 2022.09.04
 */

#include <iostream>

using namespace std;
int dp[1003][2];


int main(void) {
    int n;
    cin >> n;
    if(n % 2 == 1)
        cout << "SK";
    else
        cout << "CY";
}