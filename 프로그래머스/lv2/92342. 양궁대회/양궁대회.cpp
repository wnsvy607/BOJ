#include <string>
#include <vector>

using namespace std;
vector<vector<int>> con;

void logic(vector<int> v, vector<int> info, int n) {
    int cnt = 0, dif = 0;
    vector<int> a(11,0);
    for (int i : v) {
        cnt += info[i] + 1;
        a[i] = info[i] + 1;
    }
    
    if(cnt > n) {
        return;
    } else {
        a[10] += n - cnt;
        for(int i = 0; i < 10; i++){
            if(a[i] > 0) 
                dif += 10 - i;
            else if(info[i] != 0)
                dif -= 10 - i;
        }
        a.push_back(dif);
    }    
    con.push_back(a);
}

void comb(int start, vector<int> v, int r, vector<int> info, int n) {
    if(v.size() == r){
        // logic
        logic(v, info, n);
        return;
    }
    
    for(int i = start + 1; i < 11; i++) {
        v.push_back(i);
        comb(i, v, r, info, n);
        v.pop_back();
    }
}

vector<int> solution(int n, vector<int> info) {
    vector<int> answer, b;
    for(int i = 0; i < 10 ; i++) comb(-1 ,b ,i ,info, n);
    vector<int> best = con[0];
    
    
    // 경우의 수 점수 비교
    for(int i = 1; i < con.size() ; i++) {
        int dif = con[i][11];
        if(best[11] > dif) continue;
        else if(best[11] == dif)
            for(int j = 10; j > 0; j--){
                if(con[i][j] == best[j]) continue;
                else if(con[i][j] < best[j]) break;
                else best = con[i];
            }
        else
            best = con[i];
    }
    
    if(best[11] <= 0) {
        answer.push_back(-1);
    }
    else {
        best.pop_back();
        answer = best;
    }
    
    return answer;
}