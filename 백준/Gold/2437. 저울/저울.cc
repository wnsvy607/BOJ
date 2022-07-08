/*      작성자 : 이준표
 *      백준 그리디 알고리즘
 *      골드 2
 *      2437번 저울
 *      created: 2022.07.08
 */
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int n;
    cin >> n;
    vector<int> weight;
    for (int i = 0; i < n; ++i) {
        int temp;
        cin >> temp;
        weight.push_back(temp);
    }

    sort(weight.begin(), weight.end());
    int sum = weight[0];
    for (int i = 1; i < n; ++i) {
        if (sum + 1 < weight[i]) {
            break;
        }
        sum += weight[i];
    }
    if(weight[0] != 1)
        cout << 1;
     else
        cout << sum + 1;
}