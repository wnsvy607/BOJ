/*      작성자 : 이준표
 *      백준 문자열
 *      실버 5
 *      1181번 단어 정렬
 *      created: 2022.09.07
 */

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool stringCompare(string a, string b);

int main(void) {
    int n;
    cin >> n;
    vector<string> v;
    for (int i = 0; i < n; ++i) {
        string temp;
        cin >> temp;
        v.push_back(temp);
    }
    sort(v.begin(), v.end(), stringCompare);
    for (int i = 0; i < n; ++i) {
        if (i < n - 1 && v[i] == v[i + 1])
            continue;
        else
            cout << v[i] << endl;
    }
}

bool stringCompare(string a, string b) {
    if (a.length() > b.length())
        return false;
    else if (a.length() == b.length()) {
        for (int i = 0; i < a.length(); ++i) {
            if (a[i] == b[i])
                continue;
            else if (a[i] > b[i])
                return false;
            else
                return true;
        }
        return false;
    } else
        return true;
}