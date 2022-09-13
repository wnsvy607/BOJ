/*      작성자 : 이준표
 *      백준 문자열
 *      실버 5
 *      1969번 DNA
 *      created: 2022.09.13
 */

#include <iostream>
#include <vector>
#include <map>

using namespace std;
map<char, int> wordmap = {
        {'A', 0},
        {'T', 1},
        {'G', 2},
        {'C', 3}
};

char intmap[4] = {'A', 'T', 'G', 'C'};

int main(void) {
    int n, m;
    cin >> n >> m;
    vector<string> v;
    for (int i = 0; i < n; ++i) {
        string s;
        cin >> s;
        v.push_back(s);
    }
    int res = 0;
    string ans = "";
    for (int i = 0; i < m; ++i) {
        int dif[4] = {0, 0, 0, 0};
        for (auto word: v) {
            int idx = wordmap[word[i]];
            dif[idx]++;
        }
        int most = 0;
        int idx = 0;
        for (int j = 0; j < 4; ++j) {
            if (most < dif[j]) {
                most = dif[j];
                idx = j;
            } else if(most == dif[j] && intmap[idx] > intmap[j]){
                idx = j;
            }
        }
        char ap = intmap[idx];
        int cnt = n - most;
        res += cnt;
        ans += ap;
    }
    cout << ans << endl;
    cout << res;

}