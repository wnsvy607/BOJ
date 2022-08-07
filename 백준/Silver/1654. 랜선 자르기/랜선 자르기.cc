/*      작성자 : 이준표
 *      백준
 *      실버 2
 *      1654번 랜선 자르기
 *      created: 2022.08.07
 */

#include <iostream>
#include <vector>

using namespace std;
long long mid, high, low;


int main() {
    int k, n;   //k는 이미 가진 랜선의 개수 n은 필요한 랜선의 개수
    cin >> k >> n;
    int maxlength = 0;
    vector<int> wire;
    for (int i = 0; i < k; ++i) {
        int temp;
        cin >> temp;
        wire.push_back(temp);
        if (maxlength < temp)
            maxlength = temp;
    }
    low = 1;
    high = maxlength;
    int answer = 0;
    while (low <= high){            //low = 최소 길이, high = 최대 길이
        mid = (low + high) / 2;
        int num = 0;                //mid 로 얻을 수 있는 선의 개수 = num
        for (int i = 0; i < k; ++i)
            num += wire[i] / mid;

        if(num >= n){               //num >= n 이면 가능한 길이 
            low = mid + 1;          //더 큰 값을 찾기 위해 (mid+1,high) 범위내에서 탐색(더 긴 길이 탐색)
            if(mid > answer)
                answer = mid;
        } else                      //조건을 충족하지 않으면 (low,mid-1) 범위내에서 탐색 (더 짧은 길이 탐색)
            high = mid - 1;
    }

    cout << answer;
}