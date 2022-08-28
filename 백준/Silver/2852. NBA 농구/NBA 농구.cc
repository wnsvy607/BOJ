/*      작성자 : 이준표
 *      백준
 *      실버 3
 *      2852번 NBA 농구
 *      created: 2022.08.28
 */

#include <iostream>
#include <vector>

using namespace std;

typedef pair<int, int> pi;
int scores[3];
int opposite[3] = {0, 2, 1};
pi winningTime[3];
pi previous;
pi firstTime;
int checker;
int team, minutes, seconds;

int main(void) {
    int n;
    cin >> n;
    vector<int> result;
    //분, 초
    for (int i = 0; i < n; ++i) {
        scanf("%d %d:%d", &team, &minutes, &seconds);
        if (i == 0) {
            //승부가 바뀌지 않을 때
            winningTime[0].first = minutes;
            winningTime[0].second = seconds;
        }
        if (++scores[team] == scores[opposite[team]]) {
            //승리 시간 조정
            int m = minutes - firstTime.first, s = seconds - firstTime.second;
            if (s < 0) {
                s += 60;
                m -= 1;
            }
            winningTime[opposite[team]].first += m;
            winningTime[opposite[team]].second += s;
            scores[0]++;
            checker = 0;
        } else if(checker == 0) {
            checker = 1;
            firstTime = {minutes, seconds};
        }

    }


    int m, s;
    if (scores[0] == 0) {
        m = 47 - winningTime[0].first, s = 60 - winningTime[0].second;
    } else {
        m = 47 - firstTime.first, s = 60 - firstTime.second;
    }

    if (s == 60) {
        s -= 60;
        m += 1;
    }
    int winner;
    if (scores[1] > scores[2])
        winner = 1;
     else if (scores[1] < scores[2])
        winner = 2;
    else
        winner = 0;
    winningTime[winner].first += m;
    winningTime[winner].second += s;
    for (int i = 1; i < 3; ++i) {
        while (winningTime[i].second > 59){
            winningTime[i].first++;
            winningTime[i].second -= 60;
        }
    }

    printf("%02d:%02d\n", winningTime[1].first, winningTime[1].second);
    printf("%02d:%02d\n", winningTime[2].first, winningTime[2].second);
}