/*작성자 : 이준표
 *      백준 그리디 알고리즘
 *      브론즈 3
 *      14720번 우유 축제
 *      created: 2022.06.15
 */
#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n, order = 0;
    cin >> n;
    vector<int> street;
    for (int i = 0; i < n; ++i) {
        int a;
        cin >> a;
        street.push_back(a);
    }
    int count = 0;
    for (int i = 0; i < n; ++i) {
        if(order == street[i]){
            if(order == 2)
                order = 0;
            else
                order++;
            count++;
        }
    }
    cout << count;
}