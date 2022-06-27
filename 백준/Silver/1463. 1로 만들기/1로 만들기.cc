/*작성자 : 이준표
 *      백준 다이나믹 프로그래밍
 *      실버 3
 *      1463번 1로 만들기
 *      created: 2022.06.27
 */
#include <iostream>
#include <algorithm>

using namespace std;

int result[1000001];

int make_one(int *result, int num);

int main() {
    int n, count;
    cin >> n;
    count = make_one(result, n);
    cout << count;
}

int make_one(int *result, int num) {
    if (num == 1)
        return 0;
    if (num < 4)
        return 1;
    if (result[num] != 0)    // 저장된 값 불러오기
        return result[num];
    else {
        int count;
        if (num % 6 == 0)
            count = min(make_one(result, num / 3) + 1, make_one(result, num / 2) + 1);
        else if (num % 6 == 3)
            count = min(make_one(result, num / 3) + 1, make_one(result, num - 1) + 1);
        else if (num % 2 == 0)
            count = min(make_one(result, num / 2) + 1, make_one(result, num - 1) + 1);
        else
            count = make_one(result, num - 1) + 1;

        result[num] = count;
        return count;
    }
}