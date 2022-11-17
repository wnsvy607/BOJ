/*작성자 : 이준표
 *      백준 이분 탐색
 *      실버 5
 *      10815번 숫자 카드
 *      created: 2022.11.17
 */
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void) {
    int n, m;
    vector<int> card, res;
    cin >> n;
    for (int i = 0; i < n; ++i) {
        int temp;
        cin >> temp;
        card.push_back(temp);
    }
    sort(card.begin(), card.end());

    cin >> m;
    for (int i = 0; i < m; ++i) {
        int target;
        cin >> target;

        int start = 0, end = n - 1, mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if(target > card[mid])
                start = mid + 1;
             else if(target < card[mid])
                 end = mid - 1;
             else
                break;
        }
        if(start <= end)
            res.push_back(1);
        else
            res.push_back(0);
    }

    for (int i = 0; i < m; ++i) {
        cout << res[i] << ' ';
    }
}