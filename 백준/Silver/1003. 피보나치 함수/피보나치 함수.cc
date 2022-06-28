/*작성자 : 이준표
 *      백준 다이나믹 프로그래밍
 *      실버 3
 *      1003번 피보나치 함수
 *      created: 2022.06.28
 */
#include <iostream>
#include <vector>

using namespace std;

pair<int,int> result[42];
pair<int,int> fibo(pair<int,int> *result,int n);

int main() {
    int t;
    cin >> t;
    result[0] = {1,0};
    result[1] = {0,1};
    vector<int> testcase;
    for (int i = 0; i < t; ++i) {
        int n;
        cin >> n;
        testcase.push_back(n);
    }
    for (int i = 0; i < t; ++i) {
        pair<int,int> temp;
        temp = fibo(result,testcase[i]);
        cout << temp.first << ' ' << temp.second << endl;
    }
}

pair<int,int> fibo(pair<int,int> *result,int n){
    if(result[n].second != 0 || result[n].first != 0){
        return {result[n].first,result[n].second};
    } else{
        pair<int,int> temp1, temp2, plus;
        temp1 = fibo(result,n-1);
        temp2 = fibo(result, n-2);
        plus = {temp1.first+temp2.first,temp1.second+temp2.second};
        result[n] = plus;
        return plus;
    }
}