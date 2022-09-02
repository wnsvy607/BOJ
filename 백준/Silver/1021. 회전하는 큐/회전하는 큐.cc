/*      작성자 : 이준표
 *      백준
 *      실버 4
 *      1021번 회전하는 큐
 *      created: 2022.09.02
 */

#include <iostream>
#include <deque>
#include <vector>

using namespace std;
int cnt;

int main(void) {
    int n, m;
    cin >> n >> m;
    vector<int> v;
    for (int i = 0; i < m; ++i) {
        int temp;
        cin >> temp;
        v.push_back(temp);
    }

    deque<int> dq;
    for (int i = 1; i < n + 1; ++i) {
        dq.push_back(i);
    }
    for (int i = 0; i < m; ++i) {
        int idx, target = v[i];
        for (int j = 0; j < dq.size(); ++j) {
            if (dq[j] != target) continue;
            else idx = j;
        }
        if (idx < dq.size() - idx) {
            while (dq.front() != target) {
                int f = dq.front();
                dq.pop_front();
                dq.push_back(f);
                cnt++;
            }
        } else {
            while (dq.front() != target) {
                int b = dq.back();
                dq.pop_back();
                dq.push_front(b);
                cnt++;
            }
        }
        dq.pop_front();
    }
    cout << cnt;
}