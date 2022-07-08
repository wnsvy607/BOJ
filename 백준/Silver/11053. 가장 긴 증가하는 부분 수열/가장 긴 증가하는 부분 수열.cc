/*      작성자 : 이준표
 *      백준 DP
 *      실버 2
 *      11053번 가장 긴 증가하는 부분 수열
 *      created: 2022.07.08
 */
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int result[1001]; // 0은 부분 수열의 길이, 1은 부분 수열의 최대 값

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int n;
    cin >> n;
    vector<int> sequence;
    for (int i = 0; i < n; ++i) {
        int temp;
        cin >> temp;
        sequence.push_back(temp);
        result[i] = 1;
    }
    int maximum = 1;
    for (int i = 1; i < n; ++i) {
        for (int j = 0; j < i; ++j) {
            if(sequence[j] < sequence[i])
                result[i] = max(result[i], result[j] + 1);
        }
        maximum = max(maximum, result[i]);
    }
    cout << maximum;
}