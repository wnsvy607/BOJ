/*작성자 : 이준표
 *      백준 그리디 알고리즘
 *      실버 3
 *      1449번 수리공 항승
 *      created: 2022.06.20
 */
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n, l;
    string str, temp;
    cin >> n >> l;
    vector<int> loc;
    for (int i = 0; i < n; ++i) {
        int a;
        cin >> a;
        loc.push_back(a);
    }
    sort(loc.begin(), loc.end());
    int count = 0, start = 0;
    for (int i = 0; i < n; ++i) {
        if (loc[i] - loc[start] + 1 > l) {
            count++;
            start = i;
        }
    }
    count++;
    cout << count;
}