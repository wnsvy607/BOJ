/*      작성자 : 이준표
 *      백준 그래프 이론, BFS
 *      실버 1
 *      1697번 토마토
 *      created: 2022.07.07
 */
#include <iostream>
#include <queue>

using namespace std;

int dist[100001];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int n, k;
    cin >> n >> k;
    dist[n] = 1;
    queue<int> q;
    q.push(n);
    while (1) {
        int cur = q.front();
        q.pop();
        if(cur == k){
            cout << dist[cur] - 1;
            break;
        }
        if (cur > 0 && dist[cur - 1] == 0) {
            q.push(cur - 1);
            dist[cur - 1] = dist[cur] + 1;
        }

        if (cur < 100000 && dist[cur + 1] == 0) {
            q.push(cur + 1);
            dist[cur + 1] = dist[cur] + 1;
        }
        if (cur < 50001 && dist[2 * cur] == 0){
            q.push(2 * cur);
            dist[2 * cur] = dist[cur] + 1;
        }
    }
}