#include <iostream>
#include <vector>

using namespace std;
int main() {
    int n, k, num = 0;
    cin >> n;
    cin >> k;
    vector<int> v;
    for (int i = 0; i < n; i++) {
        int temp;
        cin >> temp;
        v.push_back(temp);
    }

    while (k != 0){
        for (int i = n - 1; i >= 0; i--) {
            if(k >= v[i]){
                k -= v[i];
                num ++;
                break;
            }
        }
    }
    cout << num;
}
