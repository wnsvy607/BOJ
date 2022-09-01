/*작성자 : 이준표
 *      백준
 *      실버 1
 *      1325번 효율적인 해킹
 *      created: 2022.09.01
 */
#include <iostream>
#include <vector>


using namespace std;

vector<int> v[10001];
int hacked[10001], visited[10001];

int solve(int here) {
    visited[here] = 1;
    int ret = 1;
    for(int there : v[here]){
        if(visited[there])
            continue;
        ret += solve(there);
    }
    return ret;
}

int main(void) {
    int n, m;
    cin >> n >> m;
    for (int i = 0; i < m; ++i) {
        int a, b;
        cin >> a >> b;
        v[b].push_back(a);
    }

    int mx = 0;
    for (int i = 1; i <= n; i++) {
        for (int j = 0; j < 10002; ++j) {
            visited[j] = 0;
        }
        hacked[i] = solve(i);
        mx = max(hacked[i], mx);
    }
    for (int i = 1; i <= n; i++)
        if (mx == hacked[i]) cout << i << " ";
}