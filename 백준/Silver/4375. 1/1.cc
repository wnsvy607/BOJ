/*      작성자 : 이준표
 *      백준
 *      실버 3
 *      4375번 1
 *      created: 2022.08.18
 */

#include <iostream>
#include <vector>

using namespace std;
typedef unsigned long long ull;


int main(void) {
    int n;
    vector<int> v;
    while (scanf("%d", &n) != EOF) {
        ull num = 1;
        int cnt = 1;
        while (1){
            if (num % n == 0) {
                v.push_back(cnt);
                break;
            } else {
                num = num * 10 + 1;
                num = num % n;
                cnt++;
            }

        }
    }

    for (int i = 0; i < v.size(); ++i) {
        cout << v[i] << '\n';
    }

}