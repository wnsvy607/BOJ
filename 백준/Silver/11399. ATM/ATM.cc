#include <iostream>
#include <vector>

using namespace std;

int main(void) {
    int n;
    cin >> n;
    vector<int> p, order;
    for (int i = 0; i < n; i++) {
        int temp;
        cin >> temp;
        p.push_back(temp);
    }
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < n - i; j++) {
            if (p[j] > p[j + 1]) {
                int temp = p[j];
                p[j] = p[j + 1];
                p[j + 1] = temp;
            }
        }
    }
    for (int j = 0; j < 2; j++) {
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += p[i];
            p[i] = total;
        }
    }
    cout << p[n-1];
}
