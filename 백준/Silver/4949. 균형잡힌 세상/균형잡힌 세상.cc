/*      작성자 : 이준표
 *      백준
 *      실버 4
 *      4949번 균형잡힌 세상
 *      created: 2022.08.18
 */

#include <iostream>
#include <vector>

using namespace std;

int main(void) {
    vector<string> answer;
    vector<string> str;
    while (1) {
        string m;
        getline(cin, m);
        if (m == ".")
            break;
        str.push_back(m);
    }
    for (int i = 0; i < str.size(); ++i) {
        vector<char> brace;
        for (int j = 0; j < str[i].length(); ++j) {
            if (str[i][j] == '(')
                brace.push_back('(');
            else if (str[i][j] == '[')
                brace.push_back('[');
            else if (str[i][j] == ')') {
                if (!brace.empty() && brace.back() == '(')
                    brace.pop_back();
                else
                    brace.push_back(str[i][j]);
            } else if (str[i][j] == ']') {
                if (!brace.empty() && brace.back() == '[')
                    brace.pop_back();
                else
                    brace.push_back(str[i][j]);
            }
        }


        if (brace.size() == 0)
            answer.push_back("yes");
        else
            answer.push_back("no");
    }

    for (int i = 0; i < answer.size(); ++i) {
        cout << answer[i] << endl;
    }
}