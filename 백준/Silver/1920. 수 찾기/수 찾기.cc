/*작성자 : 이준표
 *      백준 이분탐색
 *      실버 4
 *      1920번 수 찾기
 *      created: 2022.07.03
 */
#include <iostream>
#include <algorithm>

using namespace std;

int A[100001];

int main() {
    ios_base::sync_with_stdio(false); cin.tie(0);
    int n, m;
    cin >> n;
    for (int i = 0; i < n; ++i) {
        cin >> A[i];
    }
    sort(A, A + n);

    cin >> m;
    for (int i = 0; i < m; ++i) {
        int temp;
        cin >> temp;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (A[mid] == temp) {
                cout << 1 << '\n';
                break;
            } else if (temp > A[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        if(start > end)
            cout << 0 << '\n';
    }
}