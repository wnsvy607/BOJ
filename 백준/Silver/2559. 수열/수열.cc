/*      작성자 : 이준표
 *      백준 문자열
 *      실버 3
 *      9996번 수열
 *      created: 2022.08.13
 */

#include <iostream>
#include <vector>

using namespace std;

int main(void) {
    int n, k;
    cin >> n >> k;
    vector<int> day;
    for (int i = 0; i < n; ++i) {
        int temp;
        cin >> temp;
        day.push_back(temp);
    }
    int total = 0;
    for (int i = 0; i < k; ++i) {
        total += day[i];
    }
    int answer = total;
    for (int i = 0; i < n - k; ++i) {
        total = total + day[i + k] - day[i];
        if(total > answer)
            answer = total;
    }
    cout << answer;
}