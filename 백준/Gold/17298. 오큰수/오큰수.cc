/*      작성자 : 이준표
 *      백준
 *      골드 4
 *      17298번 오큰
 *      created: 2022.09.03
 */

#include <iostream>
#include <deque>

using namespace std;

int res[1000003];

int main(void) {
    int n;
    cin >> n;
    deque<int> v;
    for (int i = 0; i < n; ++i) {
        int temp;
        cin >> temp;
        v.push_back(temp);
    }
    deque<pair<int, int>> stk;
    stk.emplace_back(0, v[0]);
    for (int i = 1; i < n; ++i) {
        if (!stk.empty() && stk.back().second < v[i]) {
            while (!stk.empty() && stk.back().second < v[i]) {
                res[stk.back().first] = v[i];
                stk.pop_back();
            }
        }
        stk.emplace_back(i, v[i]);
    }

    for (int i = 0; i < n; ++i) {
        if(res[i] == 0)
            cout << -1;
        else
            cout << res[i];
        cout << ' ';
    }
}