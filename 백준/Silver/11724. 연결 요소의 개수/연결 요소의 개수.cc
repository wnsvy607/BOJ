/*      작성자 : 이준표
 *      백준 그래프
 *      실버 2
 *      11724번 연결 요소의 개수
 *      created: 2022.07.09
 */
#include <iostream>
#include <queue>

using namespace std;

int graph[1001][1001];
int visited[1001][1001];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int n, m;
    cin >> n >> m;
    vector<int> sequence;
    for (int i = 0; i < m; ++i) {
        int u, v;
        cin >> u >> v;
        graph[u-1][v-1] = 1;
        graph[v-1][u-1] = 1;
    }

    int count = 0;
    for (int i = 0; i < n; ++i) {
        int checker = 0;
        for (int j = 0; j < n; ++j) {
            if (graph[i][j] == 1 && visited[i][j] == 0){
                queue<int> q;
                q.push(i);
                while (!q.empty()){
                    int cur = q.front();
                    q.pop();
                    for (int k = 0; k < n; ++k) {
                        if(graph[cur][k] == 1 && visited[cur][k] == 0){
                            q.push(k);
                            visited[cur][k] = 1;
                            visited[k][cur] = 1;
                        }
                    }
                }
                count++;
            } else if(graph[i][j] == 0){
                checker++;
            }
        }
        if(checker == n)
            count++;
    }

    cout << count;
}