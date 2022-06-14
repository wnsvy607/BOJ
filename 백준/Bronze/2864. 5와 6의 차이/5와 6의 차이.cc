/*작성자 : 이준표
 *      백준 그리디 알고리즘
 *      브론즈 2
 *      2864번 5와 6의 차이
 *      created: 2022.06.14
 */
#include <iostream>

using namespace std;

int main() {
    int a, b, min, max;
    string input1, input2;
    cin >> a >> b;          //n은 끊어진 기타줄 개수, m은 브랜드 개수
    input1 = to_string(a);      //to_string으로 int를 문자열로 전환
    input2 = to_string(b);
    for (int i = 0; i < input1.length(); ++i) { // 최소값을 찾는 과정
        if (input1[i] == '6')           //6을 5로
            input1[i] = '5';
    }
    for (int i = 0; i < input2.length(); ++i) {
        if (input2[i] == '6')
            input2[i] = '5';
    }
    min = stoi(input1) + stoi(input2);
    
    for (int i = 0; i < input1.length(); ++i) { // 최댓값을 찾는 과정 어차피 모든 5를 6으로 바꿔야 하기때문에
                                                // 다시 할당할 필요가 없다.
        if (input1[i] == '5')           //5를 6으로
            input1[i] = '6';
    }
    for (int i = 0; i < input2.length(); ++i) {
        if (input2[i] == '5')
            input2[i] = '6';
    }
    max = stoi(input1) + stoi(input2); //stoi로 string to int

    cout << min << ' ' << max;      // 출력
}