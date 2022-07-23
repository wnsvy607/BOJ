/*      작성자 : 이준표
 *      백준 DP
 *      실버 1
 *      11052번 카드 구매하기
 *      created: 2022.07.23
 */

#include <iostream>
#include <vector>

using namespace std;

long result[1001];  //X번째 까지의 최댓값

int main() {
    int n;
    cin >> n;

    vector<int> v;      //카드 팩의 값
    for (int i = 0; i < n; ++i) {
        int temp;
        cin >> temp;
        v.push_back(temp);
    }
    result[0] = v[0];
    for (int i = 1; i < n; ++i) {
        int temp = v[i];
        for (int j = 0; j < (i + 1) / 2; ++j) {
            if (result[j] + result[i - j - 1] > temp)
                temp = result[j] + result[i - j - 1];
        }
        result[i] = temp;
    }

    cout << result[n - 1];
}