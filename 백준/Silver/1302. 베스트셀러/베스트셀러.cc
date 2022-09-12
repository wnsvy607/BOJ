/*      작성자 : 이준표
 *      백준 문자열
 *      실버 4
 *      1302번 베스트셀러
 *      created: 2022.09.12
 */

#include <iostream>
#include <vector>
#include <map>

using namespace std;

int main(void) {
    int n;
    cin >> n;
    map<string, int> books;
    for (int i = 0; i < n; ++i) {
        string s;
        cin >> s;
        if(books.find(s) == books.end()){
            books[s] = 1;
        } else {
            books[s]++;
        }
    }
    int best = 0;
    vector<string> res;
    for(auto i : books){
        if(i.second > best){
            best = i.second;
            res.clear();
            res.push_back(i.first);
        } else if(i.second == best){
            res.push_back(i.first);
        }
    }
    cout << res[0];
}