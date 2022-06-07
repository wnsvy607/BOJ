#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void) {
    int t;
    vector<pair<int,int>> v;
    vector<int> result;
    cin >> t;
    for (int i = 0; i < t; ++i) {
        int n;
        cin >> n;
        for (int j = 0; j < n; ++j) {
            int a, b;
            cin >> a >> b;
            v.emplace_back(a , b);
        }
        sort(v.begin(),v.end());
//        for (auto i: v) {             //auto는 for each와 같은 것
//            cout << i.first << ' ' << i.second << "\n";
//        }
        int min = v[0].second, count = n;
        for (int j = 1; j < n; ++j) {
            if(min < v[j].second){
               count --;
            } else {
                min = v[j].second;
            }
        }
        v.clear();
        result.push_back(count);
    }
    for(auto k: result){
        cout << k << endl;
    }
}