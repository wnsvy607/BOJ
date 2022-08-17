/*      작성자 : 이준표
 *      백준
 *      실버 4
 *      3986번 좋은 단어
 *      created: 2022.08.17
 */

#include <iostream>
#include <stack>

using namespace std;
int cnt;

int main(void) {
    int n;
    cin >> n;
    for (int i = 0; i < n; ++i) {
        string word;
        cin >> word;
        stack<char> stk;
        for (char a: word) {
            if (!stk.empty() && stk.top() == a){
                stk.pop();
            }
            else
                stk.push(a);
        }
        if(stk.empty())
            cnt++;
    }
    cout << cnt;
}