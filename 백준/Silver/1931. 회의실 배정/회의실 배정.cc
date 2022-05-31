#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n, time;
    cin >> n;
    vector<pair<int, int>> v;
    for (int i = 0; i < n; ++i) {
        int a, b;
        cin >> a >> b;
        v.emplace_back(b, a);
    }

    sort(v.begin(), v.end());
//    for(auto i : v) {
//        cout << i.first << ' ' << i.second << "\n";
//    }
    int cnt = 1;
    int min = v[0].first;
    for(int i = 1; i < v.size(); i++) {
        if(min <= v[i].second) {
            min = v[i].first;
            cnt++;
        }
    }
    cout << cnt << "\n";

}
