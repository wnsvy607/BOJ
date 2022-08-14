/*      작성자 : 이준표
 *      백준 문자열
 *      실버 4
 *      1620번 나는야 포켓몬 마스터 이디솜
 *      created: 2022.08.14
 */

#include <iostream>
#include <vector>
#include <map>

using namespace std;
map<string, int> poke1;
map<int, string> poke2;

int main(void) {
    int n, m;
    cin >> n >> m;
    for (int i = 0; i < n; ++i) {
        string name;
        cin >> name;
        poke1.insert({name, i + 1});
        poke2.insert({i + 1, name});
    }

    vector<string> prob;
    for (int i = 0; i < m; ++i) {
        string temp;
        cin >> temp;
        prob.push_back(temp);
    }

    for (int i = 0; i < m; ++i) {
        if (prob[i][0] <= '9') {
            int num = stoi(prob[i]);
            cout << poke2[num] << '\n';
        } else {
            cout << poke1[prob[i]] << '\n';
        }
    }
}