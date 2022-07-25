/*      작성자 : 이준표
 *      백준 그리디 알고리즘
 *      골드 2
 *      1202번 보석 도둑
 *      created: 2022.07.25
 */

#include <iostream>
#include <algorithm>
#include <vector>
#include <set>

using namespace std;

int main() {
    int n, k;
    cin >> n >> k;
    vector<pair<long, long>> jewel(n);
    for (int i = 0; i < n; ++i) {
        cin >> jewel[i].second >> jewel[i].first;
    }
    sort(jewel.begin(), jewel.end(),greater<>());

    multiset<long> bag;
    for (int i = 0; i < k; ++i) {
        long temp;
        cin >> temp;
        bag.insert(temp);
    }
    long total = 0;
    multiset<long>::iterator iter;

    for (int i = 0; i < n; ++i) {
        int value = jewel[i].first;
        int weight = jewel[i].second;
        iter = bag.lower_bound(weight);
        if(iter != bag.end()){
            total += value;
            bag.erase(iter);
        }
    }
    cout << total;
}