/*작성자 : 이준표
 *      백준 그래프 이론
 *      실버 2
 *      1260번 DFS와 BFS
 *      created: 2022.06.24
 */
#include <iostream>
#include <stack>

using namespace std;

int main() {
    int n, m, v;
    cin >> n >> m >> v;
    int graph[1002][1002] = {0,};
    for (int i = 0; i < m; ++i) {
        int node1, node2;
        cin >> node1 >> node2;
        graph[node1][node2] = 1;
        graph[node2][node1] = 1;
    }

    int checker[1002] = {0,};
    stack<int> st;
    st.push(v);
    cout << v << ' ';
    checker[v] = 1;
    while (!st.empty())   //DFS
    {
        int cur = st.top();
        st.pop();
        if(checker[cur] == 0)
            cout << cur << ' ';
        checker[cur] = 1;
        for (int i = n; i > 0; --i) {
            if(graph[cur][i] == 1 && checker[i] != 1){
                st.push(i);
            }
        }
    }

    int checker2[1002] = {0,};
    checker2[v] = 1;
    int queue2[1000];
    int head = 0, tail = 0;
    queue2[tail++] = v;
    cout << '\n' << v << ' ';
    while (head != tail)   //BFS
    {
        int cur = queue2[head++];
        for (int i = 1; i < n + 1; ++i) {
            if(graph[cur][i] == 1 && checker2[i] == 0){
                cout << i << ' ';
                checker2[i] = 1;
                queue2[tail++] = i;
            }
        }
    }
}