/*      작성자 : 이준표
 *      백준 자료구조
 *      실버 4
 *      9012번 괄호
 *      created: 2022.08.30
 */

#include <iostream>
#include <vector>
#include <stack>

using namespace std;

int main(void) {
    int t;
    cin >> t;
    vector<string> vps;
    for (int i = 0; i < t; ++i) {
        string temp;
        cin >> temp;
        vps.push_back(temp);
    }

    for (int i = 0; i < t; ++i) {
        stack<char> stk;
        for (int j = 0; j < vps[i].length(); ++j) {
            if(vps[i][j] == ')' && !stk.empty() && stk.top() == '(' ){
                stk.pop();
            } else
                stk.push(vps[i][j]);
        }
        if(!stk.empty())
            cout << "NO";
        else
            cout << "YES";
        cout << '\n';
    }
}