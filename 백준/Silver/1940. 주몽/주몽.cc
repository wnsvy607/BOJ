/*      작성자 : 이준표
 *      백준
 *      실버 4
 *      1940번 주몽
 *      created: 2022.08.16
 */

#include <iostream>
#include <map>

int cnt;
using namespace std;

int main(void) {
    int n, m;
    cin >> n >> m;
    map<int, int> item;
    for (int i = 0; i < n; ++i) {
        int temp;
        cin >> temp;
        item.insert({temp, 1});
    }
    for (auto iter = item.begin(); iter != item.end(); iter++) {
        int other = m - iter->first;
        auto other_item = item.find(other);
        if(iter->first != other_item->first && iter->second == 1 && other_item != item.end()
        && other_item->second == 1) {
            iter->second = 0;
            other_item->second = 0;
            cnt++;
        }
    }

    cout << cnt;
}