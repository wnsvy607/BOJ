/*작성자 : 이준표
 *      백준 그리디 알고리즘
 *      실버 4
 *      1758번 알바생 강호
 *      created: 2022.06.22
 */
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    long n;
    cin >> n;
    vector<long> tips;
    for (int i = 0; i < n; ++i) {
        long a;
        cin >> a;
        tips.push_back(a);
    }
    sort(tips.begin(), tips.end(),greater<int>());
    long total = 0;
    for (int i = 0; i < n; ++i) {
        long tip = tips[i]- i;
        if(tip > 0){
            total += tip;
        } else
            break;
    }
    cout << total;
}