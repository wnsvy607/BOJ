/*작성자 : 이준표
 *      백준 그리디 알고리즘
 *      골드 4
 *      1744번 수 묶기
 *      created: 2022.06.25
 */
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n;
    cin >> n;
    vector<int> sequence;
    for (int i = 0; i < n; ++i) {
        int temp;
        cin >> temp;
        sequence.push_back(temp);
    }
    int index = n;
    long long total = 0;
    if (n != 1) {
        sort(sequence.begin(), sequence.end());
        for (int i = 0; i < n; ++i) {
            if (i == n - 1)
                total += sequence[i];
            else if (sequence[i] > 0) {
                index = i;
                break;
            } else {
                if (sequence[i + 1] <= 0) {
                    total += sequence[i] * sequence[i + 1];
                    i++;
                } else {
                    total += sequence[i];
                    index = i+1;
                    break;
                }
            }
        }
        sort(sequence.begin(), sequence.end(), greater<>());
        index = n - index - 1;
        for (int i = 0; i <= index; ++i) {
          if(i == index || sequence[i] == 1 || sequence[i+1] == 1)
              total += sequence[i];
          else {
              total += sequence[i] * sequence[i + 1];
              i++;
          }
        }
        cout << total;
    } else
        cout << sequence[0];
}