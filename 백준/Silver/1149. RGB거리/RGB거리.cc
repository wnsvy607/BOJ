/*작성자 : 이준표
 *      백준 다이나믹 프로그래밍
 *      실버 1
 *      1149번 RGB거리
 *      created: 2022.06.30
 */
#include <iostream>
#include <algorithm>

using namespace std;

int find_cost(int n, int color, int **cost, int **total);


int main() {
    int **cost = (int **) malloc(sizeof(int *) * 1001);
    for (int i = 0; i < 1001; ++i) {
        cost[i] = (int *) malloc(sizeof(int) * 3);
    }
    int **total = (int **) malloc(sizeof(int *) * 1001);
    for (int i = 0; i < 1001; ++i) {
        total[i] = (int *) malloc(sizeof(int *) * 3);
        for (int j = 0; j < 3; ++j) {
            total[i][j] = 0;
        }
    }
    int n;
    cin >> n;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < 3; ++j) {
            cin >> cost[i][j];
        }
    }

    cout << min({find_cost(n, 0, cost, total), find_cost(n, 1, cost, total), find_cost(n, 2, cost, total)});
}

int find_cost(int n, int color, int **cost, int **total) {
    int smaller;
    if (n == 1)
        return cost[0][color];
    if (total[n][color] != 0)
        return total[n][color];
    if (color == 0)
        smaller = min(find_cost(n - 1, 1, cost, total), find_cost(n - 1, 2, cost, total));
    else if (color == 1)
        smaller = min(find_cost(n - 1, 0, cost, total), find_cost(n - 1, 2, cost, total));
    else
        smaller = min(find_cost(n - 1, 1, cost, total), find_cost(n - 1, 0, cost, total));
    total[n][color] = smaller + cost[n-1][color];
    return total[n][color];
}