/*      작성자 : 이준표
 *      백준
 *      실버 5
 *      16435번 스네이크버드
 *      created: 2022.09.05
 */

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void) {
    int n, l;
    cin >> n >> l;
    vector<int> v;
    for (int i = 0; i < n; ++i) {
        int temp;
        cin >> temp;
        v.push_back(temp);
    }
    sort(v.begin(), v.end());
    for (int i = 0; i < n; ++i) {
        if(l < v[i]) break;
         else l++;
    }
    cout << l;
}