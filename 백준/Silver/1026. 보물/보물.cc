#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(int a, int b) {
    return a > b;
}

int main(void) {
    int n;
    cin >> n;
    vector<int> A, B;
    for (int i = 0; i < n; ++i) {
        int a;
        cin >> a;
        A.push_back(a);
    }
    for (int i = 0; i < n; ++i) {
        int b;
        cin >> b;
        B.push_back(b);
    }
    sort(A.begin(), A.end(), compare);
    sort(B.begin(), B.end());
    int result = 0;
    for (int i = 0; i < n; ++i) {
        result += A[i]*B[i];
    }
    cout << result;
}