/*      작성자 : 이준표
 *      백준 문자열
 *      브론즈 2
 *      8958번 OX퀴즈
 *      created: 2022.09.15
 */

#include <iostream>
#include <vector>

using namespace std;

int main(void) {
    int t;
    cin >> t;
    vector<int> res;
    for (int i = 0; i < t; ++i) {
        int cnt = 0;
        string temp;
        cin >> temp;
        int score = 0;
        for (int i = 0; i < temp.length(); i++) {
            if(temp[i] == 'O'){
                cnt += ++score;
            } else {
                score = 0;
            }
        }


        res.push_back(cnt);
    }
    for (int i = 0 ; i < res.size(); i++){
        cout << res[i] << '\n';
    }
}