// 작성자 : 이준표
// 프로그래머스
// 2021 Dev-Matching 로또의 최고 순위와 최저 순위
// created: 2022.07.12

#include <string>
#include <vector>

using namespace std;

    int ranking[7] = {6, 6, 5, 4, 3, 2, 1};     //인덱스는 맞은 갯수 밸류는 순위


vector<int> solution(vector<int> lottos, vector<int> win_nums) {
    int right = 0, doodle = 0;      //right는 맞은 개수 doodle은 낙서의 개수
    for(int i = 0 ; i < 6 ; i++){
        if(lottos[i] == 0)
            doodle++;
        else {
            for(int j = 0 ; j < 6 ; j++){
                if(lottos[i] == win_nums[j]){
                    right++;
                    break;
                }
            }
        }
    }
    vector<int> answer;
    answer.push_back(ranking[right+doodle]);    //최저 순위 (낙서가 하나도 맞지 않을 경우)
    answer.push_back(ranking[right]);           //최고 순위 (낙서가 전부 맞을 경우)
   
    return answer;
}