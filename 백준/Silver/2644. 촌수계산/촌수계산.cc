/*      작성자 : 이준표
 *      백준 BFS
 *      실버 2
 *      2644번 촌수계산
 *      created: 2022.08.06
 */

#include <iostream>
#include <queue>

using namespace std;

int graph[102][102];    //사람들 간의 촌수 그래프
int visited[102];   //방문 여부 기록 배열 
int chonsu[102];    //촌수 기록 배열

int main() {
    int n, a, b, m; //n은 노드의 개수, m은 엣지의 갯수, a는 사람1, b는 사람2
    cin >> n >> a >> b >> m;
    for (int i = 0; i < m; ++i) {   //undirected graph
        int p1, p2;
        cin >> p1 >> p2;
        graph[p1][p2] = 1;
        graph[p2][p1] = 1;
    }

    queue<int> q;  //BFS 탐색을 위한 큐
    q.push(a);  //탐색을 시작할 노드 세팅
    chonsu[a] = 0;
    visited[a] = 1;

    while (!q.empty()) {
        int cur = q.front();
        q.pop();
        for (int i = 1; i < n + 1; ++i) {
            if(graph[cur][i] == 1 && visited[i] == 0){
                q.push(i);
                chonsu[i] = chonsu[cur] + 1;
                visited[cur] = 1;
            }
        }
    }
    if(chonsu[b] == 0)
        cout << -1;
    else
        cout << chonsu[b];
}