/*      작성자 : 이준표
 *      백준 자료구조, 스택
 *      실버 2
 *      1874번 스택 수열
 *      created: 2022.07.07
 */
#include <iostream>
#include <queue>
#include <stack>

using namespace std;

int list[100001];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int n;
    cin >> n;
    stack<int> s, result;
    int idx;

    queue<char> q;
    for (int i = 1; i < n + 1; ++i) {
        cin >> list[i];
    }

    int order = 1;
    for (int i = 1; i < n+1; ++i) {
        for (int j = order; j < list[i] + 1; ++j) {
            s.push(order++);
            q.push('+');
        }
        result.push(s.top());
        s.pop();
        q.push('-');
    }

    for (int i = n; i > 0; --i) {
        if(result.top() != list[i]){
            cout << "NO";
            return 0;
        }
        result.pop();
    }

    while (!q.empty()){
        cout << q.front() << '\n';
        q.pop();
    }
}