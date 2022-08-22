/*      작성자 : 이준표
 *      백준
 *      실버 5
 *      2828번 사과 담기 게임
 *      created: 2022.08.22
 */

#include <iostream>
#include <vector>

using namespace std;

int main(void) {
    int n, m, j;
    cin >> n >> m >> j;

    vector<int> v;
    for (int i = 0; i < j; ++i) {
        int temp;
        cin >> temp;
        v.push_back(temp);
    }

    int left = 1;
    int right = m;
    int distance = 0;
    for (int i = 0; i < j; ++i) {
        int dif;
        if(v[i] > right){
            dif = v[i] - right;
            right = v[i];
            left += dif;
            distance += dif;
        } else if(v[i] < left){
            dif = left - v[i];
            left = v[i];
            right -= dif;
            distance += dif;
        }
    }
    cout << distance;
}