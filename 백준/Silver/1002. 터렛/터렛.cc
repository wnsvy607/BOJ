/*작성자 : 이준표
 *      백준
 *      실버 3
 *      1002번 기하학
 *      created: 2022.06.30
 */
#include <iostream>
#include <vector>

using namespace std;


int main() {
    int t;
    vector<int> result;
    cin >> t;
    for (int i = 0; i < t; ++i) {
        int x1, y1, x2, y2, r1, r2;
        cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;
        int d = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
        int radd = (r1 + r2) * (r1 + r2);
        int rsub = (r1 - r2) * (r1 - r2);
        if(d == 0 && rsub == 0)
            result.push_back(-1);
        else if(d == radd || d == rsub)
            result.push_back(1);
        else if(d > rsub && d < radd)
            result.push_back(2);
        else
            result.push_back(0);
    }
    for (int i = 0; i < t; ++i) {
        cout << result[i] << endl;
    }
}
