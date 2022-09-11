/*      작성자 : 이준표
 *      백준 문자열
 *      실버 4
 *      1764번 듣보잡
 *      created: 2022.09.11
 */

#include <iostream>
#include <vector>
#include <map>

using namespace std;
map<string, int> hear;
map<string, int> watch;

int main(void) {
    int n, m;
    cin >> n >> m;
    for (int i = 0; i < n; ++i) {
        string s;
        cin >> s;
        hear[s] = 1;
    }
    vector<string> res;
    for (int i = 0; i < m; ++i) {
        string s;
        cin >> s;
        watch[s] = 1;
    }

    for (auto i : hear){
        string s = i.first;
        //없을 경우
        if(watch.find(s) == watch.end())
            continue;
        else
            res.push_back(s);
    }
    cout << res.size() << '\n';
    for (int i = 0; i < res.size(); ++i) {
        cout << res[i] << '\n';
    }
}