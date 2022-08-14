/*      작성자 : 이준표
 *      백준 수학
 *      실버 3
 *      9375번 패션왕 신해빈
 *      created: 2022.08.14
 */

#include <iostream>
#include <vector>
#include <map>

using namespace std;

int main(void) {
    int t;
    cin >> t;
    vector<int> result;
    for (int test = 0; test < t; ++test) {
        int n;
        cin >> n;
        map<string, int> clothes;
        for (int i = 0; i < n; ++i) {
            string name, category;
            cin >> name >> category;
            //없으면
            if (clothes.find(category) == clothes.end()) {
                clothes[category] = 1;
            } else {
                clothes[category] += 1;
            }
        }
        int total = 1;
        for (auto i: clothes) {
            total *= (i.second + 1);
        }
        result.push_back(total - 1);
    }
    for (int i = 0; i < t; ++i) {
        cout << result[i] << '\n';
    }
}