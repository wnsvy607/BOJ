/*      작성자 : 이준표
 *      백준
 *      실버 1
 *      1992번 쿼드트리
 *      created: 2022.08.21
 */

#include <iostream>
#include <vector>

using namespace std;
int graph[66][66];

string s;

string solve(int y, int x, int size) {
    if (size == 1) return string(1, graph[y][x]);
    char start = graph[y][x];
    string res = "";
    for (int i = y; i < y + size; ++i) {
        for (int j = x; j < x + size; ++j) {
            if (start != graph[i][j]) {
                res += '(';
                res += solve(y, x, size / 2);
                res += solve(y, x + size / 2, size / 2);
                res += solve(y + size / 2, x, size / 2);
                res += solve(y + size / 2, x + size / 2, size / 2);
                res += ')';
                return res;
            }
        }
    }

    return string(1, graph[y][x]);
}

int main(void) {
    int n;
    cin >> n;
    for (int y = 0; y < n; ++y) {
        cin >> s;
        for (int x = 0; x < n; ++x) {
            graph[y][x] = s[x];
        }
    }

    cout << solve(0, 0, n);
}
