/*작성자 : 이준표
 *      백준 그래프 이론
 *      실버 3
 *      2606번 바이러스
 *      created: 2022.07.03
 */
#include <iostream>
#include <queue>

using namespace std;

int graph[101][101];
int color[101];
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int n, e;
    cin >> n >> e;
    for (int i = 0; i < e; ++i) {
        int n1, n2;
        cin >> n1 >> n2;
        graph[n1 - 1][n2 - 1] = 1;
        graph[n2 - 1][n1 - 1] = 1;
    }
    queue<int> nodes;
    nodes.push(0);
    int count = 0;
    color[0] = 1;
    while (!nodes.empty()){
        int cur = nodes.front();
        nodes.pop();
        count++;
        for (int i = 0; i < n; ++i) {
            if(graph[cur][i] == 1 && color[i] == 0){
                nodes.push(i);
                color[i] = 1;
            }
        }
        color[cur] = 2;
    }
    cout << count - 1;
}