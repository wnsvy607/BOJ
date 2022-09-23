#include <string>
#include <vector>
#include <algorithm>

using namespace std;
int res = 200000001;

int solution(vector<int> stones, int k) {
    
    
    int answer = 0;
    int begin = *min_element(stones.begin(), stones.end());
    int end = *max_element(stones.begin(), stones.end());
    int mid;
    while (begin <= end) {
        mid = (begin + end) / 2;

        int skip = 0;
        int max_skip = 0;
        vector<int> tmp(stones);
        for (int i = 0; i < tmp.size(); ++i) {
            tmp[i] -= mid;
            if (tmp[i] < 0)
                skip++;
            else
                skip = 0;
            max_skip = max(max_skip, skip);
        }
        
        if(max_skip < k){
            answer = max(answer, mid);
            begin = mid + 1;
        } else {
            end = mid - 1;
        }
    }
    return answer;
}