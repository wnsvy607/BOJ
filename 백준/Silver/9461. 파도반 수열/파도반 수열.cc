/*      작성자 : 이준표
 *      백준 DP
 *      실버 3
 *      9461번 파도반 수열
 *      created: 2022.07.19
 */

#include <iostream>
#include <vector>

using namespace std;

long result[101];

int main() {
    int t;
    cin >> t;
    vector<int> v;
    for (int i = 0; i < t; ++i) {
        int temp;
        cin >> temp;
        v.push_back(temp);
    }
    result[0] = 1;
    result[1] = 1;
    result[2] = 1;
    result[3] = 2;
    result[4] = 2;



    for (int i = 0; i < t; ++i) {
        int n  = v[i];
        for (int j = 5; j < n; ++j) {
            result[j] = result[j - 1] + result[j - 5];
        } //10 = 9 + 5
        cout << result[n - 1] << '\n';
    }
}