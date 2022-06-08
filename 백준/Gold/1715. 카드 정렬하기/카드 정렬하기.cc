#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int main() {
    int n;
    cin >> n;
    priority_queue<int,vector<int>,greater<>> pq;
    for (int i = 0; i < n; ++i) {
        int a;
        cin >> a;
        pq.push(a);
    }
    int total = 0;
    for (int i = 0; i < n - 1; ++i) {
        int a, b;
        a = pq.top();
        pq.pop();
        b = pq.top();
        pq.pop();
        pq.push(a + b);
        total += a + b;
    }
    cout << total;
}