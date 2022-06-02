#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void) {
    int n;
    cin >> n;
    vector<int> v, result;

    for (int i = 0; i < n; ++i) {
        int temp;
        cin >> temp;
        v.push_back(temp);
    }

    sort(v.begin(), v.end());

    int max = 0;

    for (int i = 0; i < n; ++i) {
        if (max < v[i] * (n - i)) {
            max = v[i] * (n - i);
        }
    }
    cout << max;
}