#include <string>
#include <vector>
#include <map>


using namespace std;
char s[8] = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};

string solution(vector<string> survey, vector<int> choices) {
        map<char, int> m;
    for (int i = 0; i < 8; ++i) {
        m.insert({s[i], 0});
    }
    for (int i = 0; i < survey.size(); ++i) {
        int num = choices[i];
        char f = survey[i][0];
        char r = survey[i][1];
        if (num < 4) {
            m[f] += 4 - num;
        } else if (num > 4) {
            m[r] += num - 4;
        }
    }
    string answer = "";
        for (int i = 0; i < 4; i++) {
        int a = 2 * i, b = a + 1;
        if(m[s[a]] > m[s[b]])
            answer += s[a];
        else if(m[s[a]] < m[s[b]])
            answer += s[b];
        else
            answer += s[a] > s[b] ? s[b] : s[a];
    }
    
    return answer;
    
}