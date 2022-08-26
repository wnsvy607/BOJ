/*      작성자 : 이준표
 *      백준
 *      실버 4
 *      2870번 수학숙제
 *      created: 2022.08.26
 */

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int compString(string a, string b);

int main(void) {
    int n;
    cin >> n;
    vector<string> words;
    vector<string> answer;
    for (int i = 0; i < n; ++i) {
        string temp;
        cin >> temp;
        words.push_back(temp);
    }
//
    for (int i = 0; i < words.size(); ++i) {
        string num;
        for (int j = 0; j < words[i].length(); ++j) {
            if (isdigit(words[i][j])) {
                //'0' 하나만 존재하는 경우
                if (words[i][j] == '0' && num.empty()){
                    if (j == words[i].length() - 1 ||
                    (j < words[i].length() - 1 && !isdigit(words[i][j + 1]))){
                        answer.push_back("0");
                    } else {
                        continue;
                    }
                } else {//그 외의 경우
                    num += words[i][j];
                }
            } else if (!num.empty()) {
                answer.push_back(num);
                num = "";
            }
        }
        if (!num.empty()) {
            answer.push_back(num);
        }
    }

    sort(answer.begin(), answer.end(), compString);
    for (int i = 0; i < answer.size(); ++i) {
        cout << answer[i] << '\n';
    }
}

int compString(string a, string b){
    if(a.length() > b.length())
        return 0;
    else if(a.length() == b.length()){
        for (int i = 0; i < a.length(); ++i) {
            if(a[i] == b[i])
                continue;
            if (a[i] > b[i])
                return 0;
            else
                return 1;
        }
        return 0;
    } else
        return 1;
}