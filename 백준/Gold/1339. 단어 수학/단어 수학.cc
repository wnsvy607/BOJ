/*작성자 : 이준표
 *      백준 그리디 알고리즘
 *      골드 4
 *      1339번 단어 수학
 *      created: 2022.06.24
 */
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n;
    cin >> n;
    int digit = 0;
    vector<string> words;

    for (int i = 0; i < n; ++i) {
        string temp;
        cin >> temp;
        words.push_back(temp);
    }
    int count[27] = {0,};
    for (int i = 0; i < n; ++i) {
        int power = 1;
        for (int j = words[i].length() - 1; j > -1; --j) {
            int temp = words[i][j] - 'A';
            count[temp] += power;
            power *= 10;
        }
        if(words[i].length()>digit)
            digit = words[i].length();
    }
    int number = 9, total = 0;
    for (int i = 0; i < 10; ++i) {
        int index, max = 0;
        for (int j = 0; j < 26; ++j) {
            if(count[j] > max) {
                max = count[j];
                index = j;
            }
        }
        if(max == 0)
            break;
        total += count[index] * number;
        count[index] = 0;
        number --;
    }
    cout << total;
}