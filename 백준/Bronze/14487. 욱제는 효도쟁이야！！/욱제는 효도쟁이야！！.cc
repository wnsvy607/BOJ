/*작성자 : 이준표
 *      백준 그리디 알고리즘
 *      브론즈 2
 *      14487번 욱제는 효도쟁이야!!
 *      created: 2022.06.23
 */
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void) {
    int n;
    cin >> n;
    vector<int> v;
    for (int i = 0; i < n; ++i) {
        int temp;
        cin >> temp;
        v.push_back(temp);
    }
    std::sort(v.begin(), v.end());

    int total = 0;
    for (int i = 0; i < v.size() - 1; ++i) {
        total += v[i];
    }
    cout << total;
}