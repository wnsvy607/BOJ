/*작성자 : 이준표
 *      백준 다이나믹 프로그래밍
 *      실버 3
 *      9095번 1,2,3 더하기
 *      created: 2022.06.29
 *
 *      A(N) = A(N-1) + A(N-2) + A(N-3)
 */
#include <iostream>
#include <vector>

using namespace std;

int result[20];

int main() {
    int t;
    cin >> t;
    result[1] = 1;
    result[2] = 2;
    result[3] = 4;
    vector<int> testcase;
    for (int i = 0; i < t; ++i) {
        int n;
        cin >> n;
        testcase.push_back(n);
    }
    for (int i = 0; i < t; ++i) {
        int temp;
        temp = testcase[i];
        for (int j = 4; j < temp + 1; ++j) {
            if (result[j] != 0)
                continue;
            else {
                result[j] = result[j - 1] + result[j - 2] + result[j - 3];
            }
        }
        cout << result[temp] << endl;
    }
}