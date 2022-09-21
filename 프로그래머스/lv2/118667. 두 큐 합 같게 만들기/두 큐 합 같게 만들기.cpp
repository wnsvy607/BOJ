#include <string>
#include <vector>

using namespace std;
long tot, a, b, c, d, cnt;
int solution(vector<int> queue1, vector<int> queue2) {
    vector<int> v = queue1;
    for(int i = 0 ; i < queue1.size() ; i++){
        v.push_back(queue2[i]);
        a += queue1[i];
        b += queue2[i];
    }

    if((a + b) % 2 == 1)
        return -1;
    
    int i = 0, j = queue1.size();
    while (a != b){
        if(a > b){
            a -= v[i];
            b += v[i++];
        } else if(a < b) {
            b -= v[j];
            a += v[j++];
        } else
            break;
        if(j == queue1.size() * 2)
            j = 0;
        
        cnt++;
        if(cnt > queue1.size() * 2 + 2){
            cnt = -1;
            break;
        }
    }   
    

    int answer = cnt;
    return answer;
}