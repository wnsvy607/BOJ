/*작성자 : 이준표
 *      백준 그리디 알고리즘
 *      실버 5
 *      4796번 캠핑
 *      created: 2022.06.12
 */
#include <iostream>
#include <vector>

using namespace std;

int main() {
    int p, l, v, count = 0;
    vector<int> test;
    cin >> l >> p >> v;
    while (v != 0) {
        count++;
        int vacation = l * (v / p) + min(v % p, l);     //날짜
        test.push_back(vacation);
        cin >> l >> p >> v;
    }

    for (int i = 1; i < count + 1; ++i) {
        cout << "Case " << i << ": " << test[i - 1] << endl;
    }
}