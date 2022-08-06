/*      작성자 : 이준표
 *      백준
 *      브론즈 1
 *      2309번 일곱 난쟁이
 *      created: 2022.08.06
 */

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
    vector<int> nan;
    int total = 0;
    for (int i = 0; i < 9; ++i) {
        int temp;
        cin >> temp;
        total += temp;
        nan.push_back(temp);
    }

    for (int i = 0; i < 9; ++i) {
        for (int j = 0; j < i; ++j) {
            int num = total - nan[i] - nan[j];
            if (num == 100) {
                nan[i] = 0;
                nan[j] = 0;
                sort(nan.begin(), nan.end());
                for (int l = 2; l < 9; ++l) {
                    cout << nan[l] << '\n';
                }
                return 0;
            }
        }
    }
}