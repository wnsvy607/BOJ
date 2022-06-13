/*작성자 : 이준표
 *      백준 그리디 알고리즘
 *      실버 4
 *      1049번 기타줄
 *      created: 2022.06.13
 */
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n, m;
    cin >> n >> m;          //n은 끊어진 기타줄 개수, m은 브랜드 개수
    vector<int> package, piece;

    for (int i = 0; i < m; ++i) {
        int pr1, pr2;
        cin >> pr1 >> pr2;
        package.push_back(pr1);
        piece.push_back(pr2);
    }
    sort(package.begin(), package.end());
    sort(piece.begin(), piece.end());
    int min = 0;
    while (n > 0) {
        int minprice;
        if (n > 5) {
            if (package[0] > piece[0] * 6)
                minprice = piece[0] * 6;
            else
                minprice = package[0];
            min += minprice;
            n -= 6;
        } else {
            if(package[0] > piece[0] * n)
                minprice = piece[0] * n;
            else
                minprice = package[0];
            min += minprice;
            n = 0;
        }
    }
    cout << min;
}